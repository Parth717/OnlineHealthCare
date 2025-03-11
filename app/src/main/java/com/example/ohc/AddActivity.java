package com.example.ohc;

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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class AddActivity extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11;
    Button add;
    DatabaseReference ref;
    FirebaseAuth mAuth;
    FirebaseUser user;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        e1=findViewById(R.id.editTextTextPersonName1);
        e2=findViewById(R.id.editTextTextPersonName2);
        e3=findViewById(R.id.editTextTextPersonName3);
        e4=findViewById(R.id.editTextTextPersonName4);
        e5=findViewById(R.id.editTextTextPersonName5);
        e6=findViewById(R.id.editTextTextPersonName6);
        e7=findViewById(R.id.editTextTextPersonName7);
        e8=findViewById(R.id.editTextTextPersonName8);
        e9=findViewById(R.id.editTextTextPersonName9);
        e10=findViewById(R.id.editTextTextPersonName10);
        e11=findViewById(R.id.editTextTextPersonName11);


        mAuth=FirebaseAuth.getInstance();
        user=mAuth.getCurrentUser();
        ref= FirebaseDatabase.getInstance().getReference().child("Details");

        add=findViewById(R.id.button_add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                insertDetails();

            }
        });
    }

    private void insertDetails() {

        String date,name,age,dob,weight,height,temp,pulse,spo,bp,sugar;
        date=e11.getText().toString();
        name=e1.getText().toString();
        age=e2.getText().toString();
        dob=e3.getText().toString();
        weight=e4.getText().toString();
        height=e5.getText().toString();
        temp=e6.getText().toString();
        pulse=e7.getText().toString();
        spo=e8.getText().toString();
        bp=e9.getText().toString();
        sugar=e10.getText().toString();

        Details details=new Details(date,name,age,dob,weight,height,temp,pulse,spo,bp,sugar);
        ref.child(user.getUid()).push().setValue(details);

        startActivity(new Intent(AddActivity.this,HomeActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
        Toast.makeText(AddActivity.this,"Details added",Toast.LENGTH_SHORT).show();
        finish();


    }
}