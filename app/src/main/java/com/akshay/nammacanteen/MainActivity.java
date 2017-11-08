package com.akshay.nammacanteen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    //Time for Animation
    private static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //To make your app Fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        imageView=(ImageView)findViewById(R.id.logo);

        //Setting Animation for the First page of the App
        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.welcome_animation);
        imageView.setAnimation(animation);
        new Handler().postDelayed(new Runnable(){
            @Override
                    public void run(){
                Intent homeIntent=new Intent(MainActivity.this, homeActivity.class);
                startActivity(homeIntent);
                finish();

            }
        },SPLASH_TIME_OUT);

    }
}
