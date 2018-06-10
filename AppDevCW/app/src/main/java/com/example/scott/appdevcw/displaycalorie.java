package com.example.scott.appdevcw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class displaycalorie extends AppCompatActivity {


    TextView txtMain, txtLoseHalf, txtGainHalf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displaycalories);
        int results = getIntent().getIntExtra("initial", -1);
        int loseHalf = results -500;
        int gainHalf = results + 500;

        txtMain = (TextView) findViewById(R.id.txtMain);
        txtLoseHalf = (TextView) findViewById(R.id.txtLoseHalf);
        txtGainHalf = (TextView) findViewById(R.id.txtGainHalf);




        txtMain.setText(String.valueOf("You require "+results+" daily calories to maintain your current weight"));
        txtLoseHalf.setText(String.valueOf("You require "+loseHalf+" daily calories to lose 0.5kg per Week"));
        txtGainHalf.setText(String.valueOf("You require "+gainHalf+" daily calories to gain 0.5kg per Week"));



    }

}
