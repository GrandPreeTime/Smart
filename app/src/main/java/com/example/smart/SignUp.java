package com.example.smart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    EditText eEmail;
    Button btnNext;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // убираем уведомления
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        // бинд email и button
        eEmail = (EditText) findViewById(R.id.email);
        btnNext = (Button) findViewById(R.id.button);

        // валидация email
        preferences = getSharedPreferences("UserInfo", 0);
        btnNext.setOnClickListener((v) -> {
            String emailValue = eEmail.getText().toString();
            String emailPattern = "[a-zA-Z0-9._]+@[a-z]+\\.+[a-z]+";

            if ((emailValue.matches(emailPattern))) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("email", emailValue);
                editor.apply();
                Toast.makeText(this, "Успешно!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, sms_email.class);
                startActivity(intent);
            } else if (!emailValue.matches(emailPattern)) {
                Toast.makeText(this, "Неверно введен email!", Toast.LENGTH_SHORT).show();
            }
        });

        // изменение цвета кнопки
        eEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (Patterns.EMAIL_ADDRESS.matcher(eEmail.getText().toString()).matches()){
                    btnNext.setEnabled(true);
                }
                else btnNext.setEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}