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

public class HealthArticleActivity extends AppCompatActivity {
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    private String[][] health_details=
            {
                    {"Walking Daily", "", "", "", "Click More details"},
                    {"Home care of covid", "", "", "", "Click More details"},
                    {"Stop smoking", "", "", "", "Click More details"},
                    {"Menstrual Cramps", "", "", "", "Click More details"},
                    {"Healthy Gut", "", "", "", "Click More details"}
            };

    private String[] image={
            "1] Walking for 30 minutes a day or more on most days of the week is a great way to improve or maintain your overall health.\n" +
                    "2] If you can’t manage 30 minutes a day, remember even short walks more frequently can be beneficial."+"increased cardiovascular and pulmonary (heart and lung) fitness\n" +
                    "3] reduced risk of heart disease and stroke\n" +
                    "4] improved management of conditions such as hypertension (high blood pressure), high cholesterol, joint and muscular pain or stiffness, and diabetes\n" +
                    "5] stronger bones and improved balance\n" +
                    "6] increased muscle strength and endurance\n" +
                    "7] reduced body fat.",
            "1] Stay home from work, school and public areas unless it's to get medical care.\n" +
                    "2] Avoid using public transportation, ride-sharing services or taxis."+
                    "3] Stay isolated in one room, away from your family, others and pets, as much as you can. Eat in your room. Open windows to keep air moving. Fans can help direct air out of windows.\n" +
                    "4] If you can't open windows, consider using air filters. And turn on exhaust fans in your bathroom and kitchen. You might also consider a portable air cleaner. Use a separate bathroom if you can.\n" +
                    "5] Avoid shared space in your home as much as you can. When using shared spaces, limit your movements. Make sure your kitchen and other shared spaces have good airflow.\n" +
                    "6] Clean often-touched surfaces in your separate room and bathroom, such as doorknobs, light switches, electronics and counters, every day.",
            "1] List your reasons to quit.\n" +
                    "2] Tell people you're quitting.\n" +
                    "3] If you have tried to quit before, remember what worked.\n" +
                    "4] Use stop smoking aids.\n" +
                    "5] Have a plan if you are tempted to smoke.\n" +
                    "6] List your smoking triggers and how to avoid them.",
            "1] Rest when you need it.\n" +
                    "2] Avoid foods with caffeine and salt.\n" +
                    "3] Avoid tobacco and alcohol.\n" +
                    "4] Massage your lower back and abdomen.\n" +
                    "5] Take dietary supplements.\n" +
                    "6] Try to manage your stress.\n" +
                    "7] Try acupuncture or acupressure.\n" +
                    "8] Ask your doctor about herbal medicines.",
            "1] Prebiotic foods such as garlic, onion, chickpeas, beans, artichoke, banana, and leeks are special fibres that good gut bacteria love to feed on.\n"+
                    "2] The live bacteria in foods such as sauerkraut, live yoghurt, kombucha, kefir, and tempeh contribute to a healthy gut microbiome.\n"+
                    "3] Apple cider vinegar is a popular non-medicinal approach to help reduce indigestion, gas, bloating or heartburn. Commonly, patients self-treat themselves by mixing 1 tablespoon of raw, unfiltered apple cider vinegar with 1 cup of warm water and a dash of honey."

    };

    HashMap<String,String> item;
    ArrayList list1;
    SimpleAdapter sa;
    Button btnBack;
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_article);

        lst=findViewById(R.id.listViewHA);
        btnBack=findViewById(R.id.buttonADback);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HealthArticleActivity.this,HomeActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                finish();
            }
        });

        list1 = new ArrayList();
        for(int i=0;i<health_details.length;i++){
            item=new HashMap<String,String>();
            item.put("line1",health_details[i][0]);
            item.put("line2",health_details[i][1]);
            item.put("line3",health_details[i][2]);
            item.put("line4",health_details[i][3]);
            item.put("line5",health_details[i][4]);
            list1.add( item );
        }

        sa=new SimpleAdapter(this,list1,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);

       lst.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView,View view,int i,long l){
                Intent it=new Intent(HealthArticleActivity.this,ArticleDetailActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                it.putExtra("text1",health_details[i][0]);
                it.putExtra("text2",image[i]);
                startActivity(it);
                finish();
            }
        });
    }
}