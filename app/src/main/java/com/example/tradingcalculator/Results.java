package com.example.tradingcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Results extends AppCompatActivity {
    private TextView resultTextView;
    private TextView percentageTextView;
    private TextView moneyTextView;
    private TextView anzahlTextView;
    double karzarar[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Intent a = getIntent();
        anzahlTextView=findViewById(R.id.anzahl);
        percentageTextView=findViewById(R.id.percentage);
        moneyTextView=findViewById(R.id.money);

        resultTextView=findViewById(R.id.endresult);
        String receivedAnzahlValue = a.getStringExtra("anzahlKey");
        String receivedMoneyValue = a.getStringExtra("moneyKey");
        String receivedPercentageValue = a.getStringExtra("percentageKey");

        // Convert the string values to the appropriate data types
        int i= 0;
        double result;
        double placeholder;
        int anzahl = Integer.parseInt(receivedAnzahlValue);
        double money = Double.parseDouble(receivedMoneyValue);
        double percentage = Double.parseDouble(receivedPercentageValue);
        moneyTextView.setText(String.format("Money:"+"%.2f",money));
        percentageTextView.setText(String.valueOf("Percentage:"+percentage +"%"));
        anzahlTextView.setText(String.valueOf("Trades:"+anzahl));
        karzarar = new double[anzahl];
        // Now you can perform calculations with these values
        while(i+1<=anzahl){
            placeholder  = money * (percentage/100);
            money = money + placeholder;
            karzarar[i]=money;
            i++;
        }

        resultTextView.setText(String.format("Result:"+"%.2f", money));





        // For example, you can display the result in a TextView




    }
    public void hareketlerpage(View v){
        Intent sum = new Intent(this, listtrades.class);
        sum.putExtra("karzararArray",karzarar);
        startActivity(sum);
    }
}