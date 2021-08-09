package com.prabhakar.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    public static final int SPLASH_TIME=3000;
    private TextView appName;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splachscreen);
        initViews();
        launchActivity();
    }

    private void initViews() {
        appName = findViewById(R.id.app_name);
        animation = AnimationUtils.loadAnimation(this, R.anim.splash_animation);
        appName.setAnimation(animation);

    }
    private void launchActivity(){
        Handler handler= new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(SplashScreen.this,ItemListActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME);
    }
}