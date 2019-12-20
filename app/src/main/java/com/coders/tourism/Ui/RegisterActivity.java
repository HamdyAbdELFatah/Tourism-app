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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class RegisterActivity extends AppCompatActivity {
    private TextInputLayout email_filed, password_filed;
    private MaterialRippleLayout btn_register;
    private TextView text_login, register_logo;
    private FirebaseAuth auth;
    private ProgressDialog loading;
    private DatabaseReference databaseReference;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initializeFileds();
        sharedPreferences = getSharedPreferences("userLogin", MODE_PRIVATE);
        auth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                submitForm();
                String email = email_filed.getEditText().getText().toString().trim();
                String password = password_filed.getEditText().getText().toString().trim();
                if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
                    CreateUser(email, password);
                } else {
                    Toast.makeText(RegisterActivity.this, "All foiled require...", Toast.LENGTH_SHORT).show();
                }
            }
        });
        text_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
            }
        });
    }
    private void CreateUser(String email, String password) {
        loading.setTitle("Create user account");
        loading.setMessage("Loading....");
        loading.setCanceledOnTouchOutside(true);
        loading.show();
        auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                String userID = auth.getCurrentUser().getUid();
                sharedPreferences.edit().putBoolean("login", true).commit();
                databaseReference.child("user").child(userID).setValue("");
                Toast.makeText(RegisterActivity.this, "Success ...", Toast.LENGTH_SHORT).show();
                loading.dismiss();
                sendusertomainActivity();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                sharedPreferences.edit().putBoolean("login", false).commit();

                Toast.makeText(RegisterActivity.this, "Error .." + e.getMessage(), Toast.LENGTH_SHORT).show();
                loading.dismiss();
            }
        });
    }
    public void initializeFileds() {
        loading = new ProgressDialog(RegisterActivity.this);
        register_logo = findViewById(R.id.logo_signin);
        Typeface typeface = ResourcesCompat.getFont(this, R.font.fontstyle);
        register_logo.setTypeface(typeface);
        email_filed = findViewById(R.id.email_register);
        password_filed = findViewById(R.id.password_register);
        btn_register = findViewById(R.id.riple_register);
        text_login = findViewById(R.id.text_login);
//        email_filed.getEditText().addTextChangedListener(new MyTextMatcher(email_filed));
//        password_filed.getEditText().addTextChangedListener(new MyTextMatcher(password_filed));

    }
    public void sendusertomainActivity() {
        Intent i = new Intent(RegisterActivity.this, MainActivity.class);
        // when user press back button do`nt back to main activity
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
        finish();
    }
}



