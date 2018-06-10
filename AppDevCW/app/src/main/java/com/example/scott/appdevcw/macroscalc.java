package com.example.scott.appdevcw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class macroscalc extends AppCompatActivity {


    Spinner spinnerMacro;
    Button btnCalculateMacro;
    EditText txtMacro;
    TextView txtValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macroscalc);

        btnCalculateMacro = (Button) findViewById(R.id.btnCalculateMacro);
        txtMacro = (EditText) findViewById(R.id.txtMacro);
        txtValues = (TextView) findViewById(R.id.txtValues);
        spinnerMacro = (Spinner) findViewById(R.id.spinnerMacro);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.split_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMacro.setAdapter(adapter);

        btnCalculateMacro.setOnClickListener(new View.OnClickListener() {


            @Override


            public void onClick(View view) {

                int protein;
                int carbs;
                int fats;
                try {

                    if (!txtMacro.getText().toString().equals("")) {

                        int calories = Integer.parseInt(txtMacro.getText().toString());

                        if (spinnerMacro.getSelectedItem().toString().equals("50/30/20(Moderate)")) {
                            //Calculating the % of the calorie value and then dividing it
                            //by how many calories there are in 1g of carbs(4), proteins(4), or fats(9)

                            carbs = calories * 50 / 100 / 4;
                            protein = calories * 30 / 100 / 4;
                            fats = calories * 20 / 100 / 9;
                        } else {
                            carbs = 0;
                            protein = 0;
                            fats = 0;
                        }


                        if (spinnerMacro.getSelectedItem().toString().equals("60/25/15(High Carb)")) {
                            carbs = calories * 60 / 100 / 4;
                            protein = calories * 25 / 100 / 4;
                            fats = calories * 15 / 100 / 9;


                        }

                        if (spinnerMacro.getSelectedItem().toString().equals("40/30/30(Zone Diet)")) {
                            carbs = calories * 40 / 100 / 4;
                            protein = calories * 30 / 100 / 4;
                            fats = calories * 30 / 100 / 9;


                        }


                        if (spinnerMacro.getSelectedItem().toString().equals("25/45/30(Low Carb)")) {
                            carbs = calories * 25 / 100 / 4;
                            protein = calories * 45 / 100 / 4;
                            fats = calories * 30 / 100 / 9;


                        }


                        txtValues.setText("You Require \n" + carbs + " grams of carbs\n" + protein + " grams of protein\n" + fats + " grams of fat");

                    }
                }catch (Exception e){
                    toastMessage("Missing calorie value!");
                }

            }

        });


    }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}
