package com.example.scott.appdevcw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class informationtext extends AppCompatActivity {

    TextView txtMacros, txtBMI, txtCalories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informationtext);

        txtMacros = (TextView) findViewById(R.id.txtMacros);
        txtBMI = (TextView) findViewById(R.id.txtBMI);
        txtCalories = (TextView) findViewById(R.id.txtCalories);

        txtMacros.setText("Depending on the % split selected, the percentages of the total daily calories are calculated and then divided by 4 to calculate grams of protein and carbohydrates and by 9 for fats");
        txtCalories.setText("This Calorie Calculator is based on the Mifflin - St Jeor equation.");
        txtBMI.setText("Your BMI is a measurement of your body weight based on your height and weight it is a useful tool to estimate a healthy body weight based on your height.");
    }
}
