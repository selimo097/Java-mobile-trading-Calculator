package com.example.tradingcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class listtrades extends AppCompatActivity {
    private ListView tradesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listtrades);
        Intent sum = getIntent();
        tradesListView = findViewById(R.id.Test1);
        double[] karzarar = getIntent().getDoubleArrayExtra("karzararArray");
        if (karzarar != null && karzarar.length > 0) {
            // Create an ArrayAdapter to bind the array to the ListView
            ArrayAdapter<Double> arrayAdapter = new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,
                    toObjectArray(karzarar));

            // Set the ArrayAdapter to the ListView
            tradesListView.setAdapter(arrayAdapter);
        }
    }

    private Double[] toObjectArray(double[] array) {
        Double[] result = new Double[array.length];
        for (int i = 0; i < array.length; i++) {
            // Check if array[i] is not null before parsing
            if (!Double.isNaN(array[i])) {
                result[i] = array[i];

            } else {
                // Handle the case where array[i] is null (e.g., set a default value)
                result[i] = 0.0;
            }
        }
        return result;
    }
}