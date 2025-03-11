package com.example.ohc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.StatusBarManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OnBoardingActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    ViewPager viewPager;
    LinearLayout dotsLayout;

    Button button;
    sliderAdapter sliderAdapter;
    TextView[] dots;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);


        getSupportActionBar().hide();


        viewPager=findViewById(R.id.slider);
        dotsLayout=findViewById(R.id.dots);
        button=findViewById(R.id.get_started_btn);

        addDots(0);


        viewPager.addOnPageChangeListener(changeListener);

        sliderAdapter=new sliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OnBoardingActivity.this,LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                finish();


            }
        });

    }

    private  void  addDots(int position){
        dots=new TextView[3];
        dotsLayout.removeAllViews();
        for(int i=0;i<dots.length;i++){
            dots[i]=new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dotsLayout.addView(dots[i]);
        }
        if(dots.length>0){
            dots[position].setTextColor(getResources().getColor(R.color.purple_200));
        }

    }
    ViewPager.OnPageChangeListener changeListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDots(position);

            if(position==0){
                button.setVisibility(View.INVISIBLE);;
            }else if(position==1){
                button.setVisibility(View.INVISIBLE);
            }else{
                animation= AnimationUtils.loadAnimation(OnBoardingActivity.this,R.anim.sliding_animation);
                button.setAnimation(animation);
                button.setVisibility(View.VISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
