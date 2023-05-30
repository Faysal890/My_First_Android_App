package com.example.myfirstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

enum Currency{
    BDT(107.34), USD(1), INR(82.77), CAD(1.35), KWD(0.31), PKR(285.75), CNY(7.04), SAR(3.75);
    double value;
    private Currency(double value){
        this.value = value;
    }
}

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText text1, text2, text3;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        text1 = findViewById(R.id.editTextText);
        text2 = findViewById(R.id.editTextText2);
        text3 = findViewById(R.id.editTextText3);
        text = findViewById(R.id.textView5);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String  s = text1.getText().toString().toUpperCase();
              String   s1 = text2.getText().toString().toUpperCase();
              String  amount = text3.getText().toString();
                double dollar = 0.0, cur2 = 0, cur1 = 0, x = 0;
              try {
                   x = Double.parseDouble(amount);
                   cur1 = Currency.valueOf(s).value;
                   cur2 = Currency.valueOf(s1).value;

              }
              catch(ArithmeticException e){
                  Toast.makeText(MainActivity.this, "Currency is not valid", Toast.LENGTH_SHORT).show();
              }
              catch(Exception e){
                  Toast.makeText(MainActivity.this, "Wrong ISO Code", Toast.LENGTH_SHORT).show();
              }
                dollar = x / cur1;
                double convertedCurrency = dollar*cur2;
                String converted = String.valueOf(convertedCurrency);
                text.setText(converted);
            }
        });

    }
}