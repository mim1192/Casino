package com.casino.slo.tsovervi.ewourfa.ns;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity_ extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent mainIntent = new Intent(SplashActivity_.this, MainActivity.class);
                SplashActivity_.this.startActivity(mainIntent);
                SplashActivity_.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

}