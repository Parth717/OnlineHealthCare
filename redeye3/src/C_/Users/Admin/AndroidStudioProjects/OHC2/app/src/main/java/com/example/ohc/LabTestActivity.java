package com.example.ohc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {
    @Override
    public void onBackPressed() {
            super.onBackPressed();
    }
    private String[][] packages=
            {
                    {"Package 1: Full Body Checkup", "" , "" , "" , "999"},
                    {"Package 2: Blood Glucose Testing", "" , "" , "" , "299"},
                    {"Package 3: COVID-19 Test", "" , "" , "" , "899"},
                    {"Package 4: Thyroid Check", "" , "" , "" , "499"},
                    {"Package 5: Immunity Check", "" , "" , "" , "699"},

            };

    private String[] package_details={
            "Blood Glucose Fasting\n"+
                    " Complete Hemogram\n"+
                    "HbA1c\n"+
                    " Iron Studies\n"+
                    "Kidney Function Test"+
                    "LDH Lactate Dehydrogenase,serum\n"+
                    "Lipid Profile\n"+
                    "Liver Function Test",
            "Blood Glucose Fasting",
            "COVID-19 Antibody",
            "Thyroid Profile-Total(T3,T4 & TSH Ultra-sensitive)",
            "Complete Hemogram\n"+
                    "CRP (C Reactive Protein) Quantitative, Serum\n"+
                    " Iron Studies\n"+
                    "Kidney Function Test\n"+
                    "Vitamin D Total-25 hydroxy\n"+
                    "Liver Function Test\n"+
                    "Lipid Profile"

    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnGoToCart,btnBack;
    ListView listView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnGoToCart=findViewById(R.id.buttonCLCheck);
        btnBack=findViewById(R.id.buttonADback);


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this,HomeActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                finish();
            }
        });

        list=new ArrayList();
        for(int i=0;i<packages.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5","Total Cost:"+packages[i][4]+"/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
         ListView lst=findViewById(R.id.listViewHA);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView,View view,int i,long l){
                Intent it=new Intent(LabTestActivity.this,LabTestDetailsActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);

            }
        });

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this,OrderDetailsActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                finish();
            }
        });


    }
}