package com.coders.tourism.Ui;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.balysv.materialripple.MaterialRippleLayout;
import com.coders.tourism.MainActivity;
import com.coders.tourism.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private TextInputLayout email_filed, password_filed;
    private MaterialRippleLayout btn_login, btn_login_phone;
    private TextView logo_login, foret_password_filed, neewNewAccount_filed;
    private ProgressDialog loginprogress;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_login);
        initializeFileds();
        sharedPreferences = getSharedPreferences("userLogin", MODE_PRIVATE);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email_filed.getEditText().getText().toString().trim();
                String password = password_filed.getEditText().getText().toString().trim();
                if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
                    loginuser(email, password);
                } else {
                    Toast.makeText(LoginActivity.this, "All foiled require...", Toast.LENGTH_SHORT).show();
                }
            }
        });
        neewNewAccount_filed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                finish();
            }
        });
        btn_login_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, PhoneLoginActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                finish();
            }
        });
    }
    public void sendusertomainActivity() {
        Intent i = new Intent(LoginActivity.this, MainActivity.class);
        // when user press back button do`nt back to main activity
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
        finish();
    }
    private void loginuser(String email, String password) {
        loginprogress = new ProgressDialog(LoginActivity.this);
        loginprogress.setMessage("please waite....");
        loginprogress.setTitle("Sin In");
        loginprogress.setCanceledOnTouchOutside(true);
        loginprogress.show();
        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                loginprogress.dismiss();
                sharedPreferences.edit().putBoolean("login",true).commit();
                Toast.makeText(LoginActivity.this, "Login Success..", Toast.LENGTH_SHORT).show();
                sendusertomainActivity();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                sharedPreferences.edit().putBoolean("login",false).commit();
                loginprogress.dismiss();
                Toast.makeText(LoginActivity.this, "error " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
    public void initializeFileds() {
        logo_login = findViewById(R.id.logo_login);
        foret_password_filed = findViewById(R.id.text_forgetpassword);
        neewNewAccount_filed = findViewById(R.id.text_resister);
        Typeface typeface = ResourcesCompat.getFont(this, R.font.fontstyle);
        logo_login.setTypeface(typeface);
        email_filed = findViewById(R.id.email);
        password_filed = findViewById(R.id.password);
//        email_filed.getEditText().addTextChangedListener(new MyTextMatcher(email_filed));
//        password_filed.getEditText().addTextChangedListener(new MyTextMatcher(password_filed));
        btn_login = findViewById(R.id.riple_login);
        btn_login_phone = findViewById(R.id.riple_login_phone);
    }
}