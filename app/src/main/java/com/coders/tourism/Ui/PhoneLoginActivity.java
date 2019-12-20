package com.coders.tourism.Ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.balysv.materialripple.MaterialRippleLayout;
import com.coders.tourism.MainActivity;
import com.coders.tourism.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class PhoneLoginActivity extends AppCompatActivity {
    private MaterialRippleLayout btn_sendverifation, btn_verify;
    private EditText phone_filed, code_filed;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks callsback;
    private String mVerificationId;
    private PhoneAuthProvider.ForceResendingToken mResendToken;
    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;
    private TextView Text_count;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_login);
        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        inatilize();
        sharedPreferences = getSharedPreferences("userLogin", MODE_PRIVATE);
        btn_sendverifation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_sendverifation.setVisibility(View.INVISIBLE);
                phone_filed.setVisibility(View.INVISIBLE);
                btn_verify.setVisibility(View.VISIBLE);
                code_filed.setVisibility(View.VISIBLE);
                String phonnumber = phone_filed.getText().toString().trim();
                if (!TextUtils.isEmpty(phonnumber)) {
                    progressDialog.setTitle("Phone Verification");
                    progressDialog.setMessage("please Waite");
                    progressDialog.setCanceledOnTouchOutside(false);
                    progressDialog.show();
                    PhoneAuthProvider.getInstance().verifyPhoneNumber(
                            phonnumber, 60, TimeUnit.SECONDS, PhoneLoginActivity.this, callsback
                    );


                } else {
                    Toast.makeText(PhoneLoginActivity.this, "All filed Require...", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_sendverifation.setVisibility(View.INVISIBLE);
                phone_filed.setVisibility(View.INVISIBLE);
                String code = code_filed.getText().toString().trim();
                if (!TextUtils.isEmpty(code)) {
                    progressDialog.setTitle("code Verification");
                    progressDialog.setMessage("please Waite");
                    progressDialog.setCanceledOnTouchOutside(false);
                    progressDialog.show();
                    PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, code);
                    signInWithPhoneAuthCredential(credential);


                } else {
                    Toast.makeText(PhoneLoginActivity.this, "please Enter Code...", Toast.LENGTH_SHORT).show();
                }
            }
        });


        callsback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                signInWithPhoneAuthCredential(phoneAuthCredential);

            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                Toast.makeText(PhoneLoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
                btn_sendverifation.setVisibility(View.VISIBLE);
                phone_filed.setVisibility(View.VISIBLE);
                btn_verify.setVisibility(View.INVISIBLE);
                code_filed.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCodeSent(String verificationId,
                                   PhoneAuthProvider.ForceResendingToken token) {
                progressDialog.dismiss();
                // The SMS verification code has been sent to the provided phone number, we
                // now need to ask the user to enter the code and then construct a credential


                // Save verification ID and resending token so we can use them later
                mVerificationId = verificationId;
                mResendToken = token;
                Toast.makeText(PhoneLoginActivity.this, "Code Sent", Toast.LENGTH_SHORT).show();
                btn_sendverifation.setVisibility(View.VISIBLE);
                phone_filed.setVisibility(View.VISIBLE);
                btn_verify.setVisibility(View.VISIBLE);
                code_filed.setVisibility(View.VISIBLE);
                // ...
            }

        };
        new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                Text_count.setText(String.valueOf(millisUntilFinished / 1000));
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                Text_count.setText("00");


            }

        }.start();

    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                progressDialog.dismiss();
                sharedPreferences.edit().putBoolean("login", true).commit();
                Toast.makeText(PhoneLoginActivity.this, "Success......", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(PhoneLoginActivity.this, MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                finish();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                sharedPreferences.edit().putBoolean("login", false).commit();

                progressDialog.dismiss();

            }
        });

    }

    private void inatilize() {
        btn_sendverifation = findViewById(R.id.riple_send_verficationcode);
        btn_verify = findViewById(R.id.riple_verify);
        phone_filed = findViewById(R.id.edit_phone);
        code_filed = findViewById(R.id.edit_code);
        Text_count = findViewById(R.id.text_count_down2);

    }
}
