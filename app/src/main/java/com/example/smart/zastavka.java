package com.example.smart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class zastavka extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zastavka);

        int secondsDelayed = 1;new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(zastavka.this, Onboard.class));        finish();    }
        }, secondsDelayed * 1000);
    }
}