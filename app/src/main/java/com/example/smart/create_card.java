package com.example.smart;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class create_card extends AppCompatActivity {


    private String[] gender = { "Мужской", "Женский" };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_card);



        Spinner spinner = findViewById(R.id.spinner);
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

        spinner.setSelection(adapter.getCount());


    }
}