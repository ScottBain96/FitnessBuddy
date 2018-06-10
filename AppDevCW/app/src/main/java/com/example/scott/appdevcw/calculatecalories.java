package com.example.scott.appdevcw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class calculatecalories extends AppCompatActivity {

    EditText txtAgeNumber, txtWeightNumber, txtHeightNumber, txtHeightNumber2;
    Button btnCalculate;
    TextView DisplayH, DisplayW, Displayi;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculatecalories);

        txtWeightNumber = (EditText) findViewById(R.id.txtWeightNumber);
        txtAgeNumber = (EditText) findViewById(R.id.txtAgeNumber);
        txtHeightNumber = (EditText) findViewById(R.id.txtHeightNumber);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        txtHeightNumber2 = (EditText) findViewById(R.id.txtHeightNumber2);
        DisplayH = (TextView) findViewById(R.id.DisplayH);
        Displayi = (TextView) findViewById(R.id.Displayi);
        DisplayW = (TextView) findViewById(R.id.DisplayW);


        //Displaying array values on Spinners

        Spinner spinnerLevel = (Spinner) findViewById(R.id.spinnerLevel);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.level_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLevel.setAdapter(adapter);

        Spinner spinnerGender = (Spinner) findViewById(R.id.spinnerGender);
        ArrayAdapter<CharSequence> adapterGender = ArrayAdapter.createFromResource(this, R.array.gender_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGender.setAdapter(adapterGender);

        final Spinner spinnerSystem = (Spinner) findViewById(R.id.spinnerSystem);
        ArrayAdapter<CharSequence> adapterSystem = ArrayAdapter.createFromResource(this, R.array.system_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSystem.setAdapter(adapterSystem);


        spinnerSystem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                if (spinnerSystem.getSelectedItem().toString().equals("Metric")){

                    txtHeightNumber2.setEnabled(false);
                    txtHeightNumber2.setVisibility(View.GONE);
                    Displayi.setVisibility(View.GONE);
                    DisplayW.setText("Weight (kg)");
                    DisplayH.setText("Height (cm)");
                    txtHeightNumber.setText("");
                    txtWeightNumber.setText("");



                }

                else{

                    txtHeightNumber2.setEnabled(true);
                    txtHeightNumber2.setVisibility(View.VISIBLE);
                    Displayi.setVisibility(View.VISIBLE);
                    DisplayW.setText("Weight (lbs)");
                    DisplayH.setText("feet");
                    txtHeightNumber.setText("");
                    txtWeightNumber.setText("");
                    txtHeightNumber2.setText("");





                }











            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





        btnCalculate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            try {
                if (!txtAgeNumber.getText().toString().equals("") || !txtHeightNumber.getText().toString().equals("") || !txtWeightNumber.getText().toString().equals("")) {


                    double weight;// = Double.parseDouble(txtWeightNumber.getText().toString());
                    int age = Integer.parseInt(txtAgeNumber.getText().toString());
                    double height;// = Integer.parseInt(txtHeightNumber.getText().toString());
                    int results;

                    Spinner spinnerLevel = (Spinner) findViewById(R.id.spinnerLevel);
                    Spinner spinnerGender = (Spinner) findViewById(R.id.spinnerGender);
                    int gender;
                    double intensity;



                    //Setting values of each gender

                    if (spinnerGender.getSelectedItem().toString().equals("Male")) {
                        gender = 5;
                    } else {
                        gender = -161;;
                    }


                    if (spinnerLevel.getSelectedItem().toString().equals("Little to no exercise")) {
                        intensity = 1.2;
                    } else {
                        intensity = 0;
                    }

                    if (spinnerLevel.getSelectedItem().toString().equals("1–3 days per week")) {
                        intensity = 1.375;
                    }

                    if (spinnerLevel.getSelectedItem().toString().equals("3–5 days per week")) {
                        intensity = 1.55;
                    }

                    if (spinnerLevel.getSelectedItem().toString().equals("6–7 days per week")) {
                        intensity = 1.725;
                    }

                    if (spinnerSystem.getSelectedItem().toString().equals("Metric")){

                        weight = Double.parseDouble(txtWeightNumber.getText().toString());
                        height = Double.parseDouble(txtHeightNumber.getText().toString());


                    }
                    else{

                        height = Double.parseDouble(txtHeightNumber2.getText().toString()) * 2.54;
                        height = height + Double.parseDouble(txtHeightNumber.getText().toString()) * 30.48;
                        weight = Double.parseDouble(txtWeightNumber.getText().toString())/ 2.20;



                    }


                    results = (int) ((10 * weight + 6.25 * height - 5 * age + gender) * intensity);

                    //Displaying calorie displaycalorie in new activity

                    Intent intent = new Intent(getApplicationContext(), displaycalorie.class);
                    intent.putExtra("initial", results);
                    startActivityForResult(intent, results);

                }



            } catch (Exception e) {
                toastMessage("Fill in all details please!");
            }




        }
    });


    }
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }


}
