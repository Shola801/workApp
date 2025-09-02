package com.example.work;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        initView();
    }

    private void initView() {
        Window myWindow = this.getWindow();
        myWindow.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        myWindow.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        myWindow.setNavigationBarColor(getResources().getColor(R.color.white));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent myIntent = new Intent(SplashScreenActivity.this, ChoiceActivity.class);
                startActivity(myIntent);
            }
        }, 2000);

    }
}