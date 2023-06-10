package com.example.smart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Onboard2 extends AppCompatActivity {

    Button btn_propusk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboard2);

        //переход по кнопке
        btn_propusk = findViewById(R.id.button);
        btn_propusk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Onboard2.this, SignUp.class);
                startActivity(intent);
            }
        });
    }
}