package com.example.ohc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MedicineActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private String[][] packages ={
            {"Uprise-D3 1000IU Capsule","","","", "50"},
            {"HealthVit Chromium Picolinate 200mcg Capsule", "","","", "350"},
            {"Vitamin B complex Capsule", "","","", "450"},
            {"Inflite Vitamin E wheat germ oil capsule", "","","", "350"},
            {"Dolo 650 Tablet", "","","", "30" },
            {"Crocin 650 Advance Tablet", "","","", "30"},
            {"Strepsils Medicated Lozenges for Sore Throat","","","", "40"},
            {"Tata 1ng Calcium + Vitamin D3","","","", "40"},
            {"Feronia -XT Tablet", "","","", "130"}};

    private String[] package_details = {
            "Building and keeping the bones & teeth strong\n"+
                    "Reducing Fatigue/stress and muscular pains\n"+
                    "Boosting immunity and increasing resistance against infection",
            "Chromium is an essential trace mineral that plays an important role in helping insulin regulat\n" ,
            "Provides relief from vitamin B deficiencies\n" +
                    "Helps in formation of red blood cells\n"+
                    "Maintains healthy nervous system\n",
            "It promotes health as well as skin benefit.\n"+
                    "It helps reduce skin blemish and pigmentation.\n" +
                    "It act as safeguard the skin from the harsh UVA and UVB sun rays.\n",
            "Dolo 650 Tablet helps relieve pain and fever by blocking the release of certain chemical messenger responsible for fever and pain.",
            "Helps relieve fever and bring down high a high temperature\n"+
                    "Suitable for pepole heart condition or high blood pressure",
            "Relieves the symptoms of a bacterial throat infection and soothes the recovery process\n" +
                    "Provides a warm and comforting feeling during sore throat",
            "Reduces the risk of calcium deficiency, Rickets, and Osteoporosis\n" +
                    "Promotes mobility and flexibility of joints.\n",
            "Helps to reduce the iron deficiency due to chronic blood loss or low intake of iron"};

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack,btnCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);

        lst=findViewById(R.id.listViewBM);
        btnBack=findViewById(R.id.buttonBMback);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MedicineActivity.this,HomeActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        list=new ArrayList();
        for (int i=0;i<packages.length;i++) {
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Cons Fees:" + packages[i][4] + "/-");
            list.add(item);
        }

        sa=new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        ListView lst=findViewById(R.id.listViewBM);
        lst.setAdapter(sa);lst.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView,View view,int i,long l){
                Intent it=new Intent(MedicineActivity.this,BuyMedicineActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });

    }
}