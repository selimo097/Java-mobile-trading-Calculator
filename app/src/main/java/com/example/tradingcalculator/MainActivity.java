package com.example.tradingcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    private EditText anzahlEditText;
    private EditText moneyEditText;
    private EditText percentageEditText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anzahlEditText = findViewById(R.id.anzahl);
        moneyEditText = findViewById(R.id.money);
        percentageEditText = findViewById(R.id.percentage);
        submitButton = findViewById(R.id.submit);

    }

        public void sumbission(View v) {
            // Retrieve the inputted values from the EditText widgets
            String anzahlValue = anzahlEditText.getText().toString();
            String moneyValue = moneyEditText.getText().toString();
            String percentageValue = percentageEditText.getText().toString();
            Intent a =  new Intent(this,Results.class);
            a.putExtra("anzahlKey", anzahlValue);
            a.putExtra("moneyKey", moneyValue);
            a.putExtra("percentageKey", percentageValue);
            startActivity(a);


        }
    }

