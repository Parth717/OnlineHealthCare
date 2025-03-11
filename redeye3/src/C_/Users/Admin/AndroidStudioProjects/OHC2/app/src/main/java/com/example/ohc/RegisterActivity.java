package com.example.ohc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

public class RegisterActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    EditText e1,e2,e3;
    Button register;
    TextView t1;
    FirebaseAuth mAuth;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


            e1=findViewById(R.id.editTextRegisterEmailAddress);
            e2=findViewById(R.id.editTextRegisterPassword);
            e3=findViewById(R.id.editTextConfirmPassword);
            register=findViewById(R.id.buttonRegister);
            t1=findViewById(R.id.textView2);
            mAuth=FirebaseAuth.getInstance();



            t1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(RegisterActivity.this,LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                    finish();
                }
            });

            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String email,pass,confirm;
                    email=e1.getText().toString();
                    pass=e2.getText().toString();
                    confirm=e3.getText().toString();
                    if (TextUtils.isEmpty(email)||TextUtils.isEmpty(pass)||TextUtils.isEmpty(confirm)){
                        Toast.makeText(RegisterActivity.this, "Please Fill all information...", Toast.LENGTH_SHORT).show();
                    }
                    else if(!pass.equals(confirm)){
                        Toast.makeText(RegisterActivity.this,"Password and confirm password not match...",Toast.LENGTH_SHORT).show();
                    }

                    else{
                    mAuth.createUserWithEmailAndPassword(email,pass)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(RegisterActivity.this,"Registration successful",Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(RegisterActivity.this,LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                                        finish();
                                    }
                                    else {
                                        Toast.makeText(RegisterActivity.this, "Registration Failed,Try Again...", Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });
                    }
                }
            });


        }
}