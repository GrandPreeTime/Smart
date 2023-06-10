package com.example.smart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ViewFlipper;

public class Onboard1 extends AppCompatActivity {

    Button btn_propusk;
    ViewFlipper flipper;
    Button prev_Button, next_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboard1);
        //переход по кнопке
        btn_propusk = findViewById(R.id.button);
        btn_propusk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Onboard1.this, SignUp.class);
                startActivity(intent);
            }
        });

        flipper = findViewById(R.id.viewflipper1);
        prev_Button = findViewById(R.id.prev_button);
        next_Button = findViewById(R.id.next_button);

        flipper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Onboard1.this, Onboard2.class);
                startActivity(intent);
            }
        });

        prev_Button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {

                        // It is used to set the in and out
                        // animation of View flipper.
                        flipper.setInAnimation(Onboard1.this,
                                R.anim.right_swipe);
                        flipper.setOutAnimation(Onboard1.this,
                                R.anim.left_swipe);

                        // It shows previous item.
                        flipper.showPrevious();
                    }
                });

        next_Button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        // It is used to set the in and out
                        // animation of View flipper.
                        flipper.setInAnimation(Onboard1.this,
                                R.anim.left_swipe);
                        flipper.setOutAnimation(Onboard1.this,
                                R.anim.right_swipe);

                        // It shows next item.
                        flipper.showNext();
                        Intent intent = new Intent(Onboard1.this, Onboard2.class);
                        startActivity(intent);
                    }
                });
    }
}
