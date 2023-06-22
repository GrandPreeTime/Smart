package com.example.smart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class create_card extends AppCompatActivity {

    private String[] gender = { "Мужской", "Женский" };
    private static final String MY_SETTINGS = "my_settings";
    public static final String APP_PREFERENCES_CARD_FINISH = "cardFinish";

    Button nextUp;
    EditText name, familiya, otchestvo;
    TextView date, skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_card);

        // привязываем элементы
        nextUp = (Button) findViewById(R.id.button15);
        name = (EditText) findViewById(R.id.editText21);
        familiya = (EditText) findViewById(R.id.editText22);
        otchestvo = (EditText) findViewById(R.id.editText23);
        date = (TextView) findViewById(R.id.editText24);
        skip = (TextView) findViewById(R.id.next);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(v.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date.setText(dayOfMonth + "." + (month + 1) + "." + year);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        // сравнение имени
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkNoEmptyItems();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // сравнение фамилии
        familiya.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkNoEmptyItems();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // сравнение отчества
        otchestvo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkNoEmptyItems();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // сравнение имени
        date.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkNoEmptyItems();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        nextUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences(MY_SETTINGS,
                        Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putBoolean(APP_PREFERENCES_CARD_FINISH, true);
                editor.apply();
                Intent i = new Intent(create_card.this, MainAnalyz.class);
                startActivity(i);
                finishAffinity();
            }
        });


        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences(MY_SETTINGS,
                        Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putBoolean(APP_PREFERENCES_CARD_FINISH, true);
                editor.apply();
                Intent i = new Intent(create_card.this, MainAnalyz.class);
                startActivity(i);
                finishAffinity();
            }
        });



    }

    // изменение цвета кнопки
    private void checkNoEmptyItems(){
        if(name.getText().toString().length() != 0 & familiya.getText().toString().length() != 0 & otchestvo.getText().toString().length() != 0 & date.getText().toString().length() != 0){
            nextUp.setEnabled(true);
        }
        else {
            nextUp.setEnabled(false);
        }
    }

    // настройка даты
    public void dateClick(){
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                date.setText(dayOfMonth + "-" + (month + 1) + "-" + year);
            }
        }, year, month, day);
        datePickerDialog.show();
    }
}