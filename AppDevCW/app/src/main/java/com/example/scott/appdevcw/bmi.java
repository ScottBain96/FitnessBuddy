package com.example.scott.appdevcw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class bmi extends AppCompatActivity {

    TextView txtResults, txtResults2, txtDisplayW, txtDisplayH, txtDisplayi;
    EditText txtWeight, txtHeight, txtHeight2;
    Button btnCalculate;
    Spinner spinnerSystem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        txtResults = (TextView) findViewById(R.id.txtResults);
        txtHeight = (EditText) findViewById(R.id.txtHeight);
        txtWeight = (EditText) findViewById(R.id.txtWeight);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        txtResults2 = (TextView) findViewById(R.id.txtResult2);


        txtDisplayW = (TextView) findViewById(R.id.txtDisplayW);
        txtDisplayH = (TextView) findViewById(R.id.txtDisplayH);
        txtDisplayi = (TextView) findViewById(R.id.txtDisplayi);
        txtHeight2 = (EditText) findViewById(R.id.txtHeight2);
        spinnerSystem = (Spinner) findViewById(R.id.spinnerSystem);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.system_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSystem.setAdapter(adapter);






        spinnerSystem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (spinnerSystem.getSelectedItem().toString().equals("Metric")){
                    txtHeight2.setEnabled(false);
                    txtHeight2.setVisibility(View.GONE);
                    txtDisplayi.setVisibility(View.GONE);
                    txtDisplayW.setText("Weight (kg)");
                    txtDisplayH.setText("Height (cm)");
                    txtHeight.setText("");
                    txtWeight.setText("");
                    txtResults.setText("");
                    txtResults2.setText("");



                }

                else{

                    txtHeight2.setEnabled(true);
                    txtHeight2.setVisibility(View.VISIBLE);
                    txtDisplayi.setVisibility(View.VISIBLE);
                    txtDisplayW.setText("Weight (lbs)");
                    txtDisplayH.setText("feet");
                    txtHeight.setText("");
                    txtWeight.setText("");
                    txtHeight2.setText("");
                    txtResults.setText("");
                    txtResults2.setText("");




                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





        btnCalculate.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double bmi;
                double weight;
                double height;
                double roundNumber;

                        try {
                            if (!txtHeight.getText().toString().equals("") || !txtWeight.getText().toString().equals("") ||!txtHeight2.getText().toString().equals("")) {

                                if (spinnerSystem.getSelectedItem().toString().equals("Metric")){

                                    weight = Double.parseDouble(txtWeight.getText().toString());
                                    //Converting cm into meters so value is divided by 100
                                    height = Double.parseDouble(txtHeight.getText().toString()) / 100;

                                    //bmi calculation



                                }
                                    else{

                                    height = Double.parseDouble(txtHeight2.getText().toString()) * 2.54;
                                    height = height + Double.parseDouble(txtHeight.getText().toString()) * 30.48;
                                    height = height /100;
                                    weight = Double.parseDouble(txtWeight.getText().toString())/ 2.20;



                                }


                                bmi = weight / height;
                                bmi = bmi / height;
                                roundNumber = Math.round(bmi* 100)/100D;



                                if (bmi < 18.5) {

                                    txtResults2.setText("You are in the Underweight range");
                                }
                                if (bmi > 18.5 && bmi < 25) {

                                    txtResults2.setText("You are in the Normal range");
                                }

                                if (bmi > 25) {

                                    txtResults2.setText("You are in the Overweight range");
                                }


                                txtResults.setText(String.valueOf(roundNumber));


                            }

                        }
                        catch (Exception e) {
                            toastMessage("Missing details!");

                        }




            }

        });


    }
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}
