package com.example.ohc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LabTestDetailsActivity extends AppCompatActivity {
    TextView tvpackagename,tvtotalCost;
    EditText ed1;
    Button btnAddToCart,btnBack;
    DatabaseReference ref;
    FirebaseAuth mAuth;
    FirebaseUser user;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);

        tvpackagename=findViewById(R.id.textViewHA_title);
        tvtotalCost=findViewById(R.id.textViewCL);
        ed1=findViewById(R.id.editTextCL);
        btnAddToCart=findViewById(R.id.buttonCLCheck);
        btnBack=findViewById(R.id.buttonADback);

        ref=FirebaseDatabase.getInstance().getReference().child("LabTest");
        mAuth=FirebaseAuth.getInstance();
        user=mAuth.getCurrentUser();


        ed1.setKeyListener(null);

        Intent intent=getIntent();
        tvpackagename.setText(intent.getStringExtra("text1"));
        ed1.setText(intent.getStringExtra("text2"));
        tvtotalCost.setText("Total cost : "+intent.getStringExtra("text3")+"/-");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestDetailsActivity.this,LabTestActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                finish();

            }
        });

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                insertTest();
            }
        });

    }

    private void insertTest() {
        String name,cost;
        name=tvpackagename.getText().toString();
        cost=tvtotalCost.getText().toString();
        LabTest labTest=new LabTest(name,cost);

        ref.child(user.getUid()).push().setValue(labTest);
        Toast.makeText(LabTestDetailsActivity.this,"inserted",Toast.LENGTH_SHORT).show();

        startActivity(new Intent(LabTestDetailsActivity.this,LabTestActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));


    }
}