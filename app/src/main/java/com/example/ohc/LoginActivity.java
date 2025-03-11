package com.example.ohc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    EditText e1,e2;
    Button login;
    TextView t1;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e1=findViewById(R.id.editTextLoginEmailAddress);
        e2=findViewById(R.id.editTextLoginPassword);
        login=findViewById(R.id.buttonLogin);
        t1=findViewById(R.id.textView2);
        mAuth=FirebaseAuth.getInstance();


        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                finish();
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email,pass;
                email=e1.getText().toString();
                pass=e2.getText().toString();
                if (TextUtils.isEmpty(email)||TextUtils.isEmpty(pass)){
                    Toast.makeText(LoginActivity.this, "Empty Credentials,Please Fill All Information...", Toast.LENGTH_SHORT).show();

                }
                else{
                mAuth.signInWithEmailAndPassword(email,pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(LoginActivity.this,"Login successful...",Toast.LENGTH_SHORT).show();
                                    Toast.makeText(LoginActivity.this,"Welcome,Thanks for login...",Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(LoginActivity.this,HomeActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                                    finish();
                                }
                                else {
                                    Toast.makeText(LoginActivity.this, "Something Went Wrong,Please Try Again...", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
                }
            }
        });

    }
}