package com.example.ohc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class BuyMedicineActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    TextView tvpackagename,tvtotalCost;
    TextView ed1;
    Button btnAddToCart,btnBack;
    DatabaseReference ref;
    FirebaseAuth mAuth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);
        tvpackagename=findViewById(R.id.textView7);
        tvtotalCost=findViewById(R.id.textViewBMM);
        ed1=findViewById(R.id.editTextBMM);
        btnAddToCart=findViewById(R.id.buttonBMMCheck);
        btnBack=findViewById(R.id.buttonBMMback);

        ref= FirebaseDatabase.getInstance().getReference().child("Medicine");
        mAuth=FirebaseAuth.getInstance();
        user=mAuth.getCurrentUser();

        Intent intent=getIntent();
        tvpackagename.setText(intent.getStringExtra("text1"));
        ed1.setText(intent.getStringExtra("text2"));
        tvtotalCost.setText("Total cost : "+intent.getStringExtra("text3")+"/-");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this,MedicineActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                finish();
            }
        });
        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertMedicine();
            }
        });


    }

    private void insertMedicine() {

        String name,cost;
        name=tvpackagename.getText().toString();
        cost=tvtotalCost.getText().toString();
        Medicine medicine=new Medicine(name,cost);

        ref.child(user.getUid()).push().setValue( medicine);
        Toast.makeText(BuyMedicineActivity.this,"inserted",Toast.LENGTH_SHORT).show();

        startActivity(new Intent(BuyMedicineActivity.this,MedicineActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
        finish();

    }
}