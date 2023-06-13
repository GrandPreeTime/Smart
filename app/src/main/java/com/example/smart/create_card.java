package com.example.smart;

import androidx.appcompat.app.AppCompatActivity;

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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class create_card extends AppCompatActivity {


    private String[] gender = { "Мужской", "Женский" };
    Button nextUp;
    EditText name;
    EditText familiya;
    EditText otchestvo;
    EditText date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_card);

        // убираем уведомления
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        // привязываем элементы
        nextUp = (Button) findViewById(R.id.button15);
        name = (EditText) findViewById(R.id.editText21);
        familiya = (EditText) findViewById(R.id.editText22);
        otchestvo = (EditText) findViewById(R.id.editText23);
        date = (EditText) findViewById(R.id.editText24);

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


        /*Spinner spinner = findViewById(R.id.spinner);
        CustomAdapterSpinner.CustomAdapter adapter = new CustomAdapterSpinner.CustomAdapter(this,
                android.R.layout.simple_spinner_item, gender);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                CustomAdapterSpinner.CustomAdapter.flag = true;
            }
        });
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setSelection(adapter.getCount());*/


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
}