package com.example.ohc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ArticleDetailActivity extends AppCompatActivity {
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    TextView tv;
    TextView img;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);
        tv=findViewById(R.id.textView7);
        img=findViewById(R.id.editTextBMM);
        btnBack=findViewById(R.id.buttonADback);

        Intent intent=getIntent();
        tv.setText(intent.getStringExtra("text1"));
        img.setText(intent.getStringExtra("text2"));

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ArticleDetailActivity.this,HealthArticleActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                finish();
            }
        });

    }
}