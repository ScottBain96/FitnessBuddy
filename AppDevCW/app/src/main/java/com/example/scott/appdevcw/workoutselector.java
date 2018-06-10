package com.example.scott.appdevcw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class workoutselector extends AppCompatActivity {


    ListView listViewExercises;

    Button btnStartWorkout;
    Spinner spinnerWorkout;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workoutselector);


        btnStartWorkout =(Button) findViewById(R.id.btnStartWorkout);



        spinnerWorkout = (Spinner) findViewById(R.id.spinnerWorkout);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Workout_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerWorkout.setAdapter(adapter);
        listViewExercises = (ListView) findViewById(R.id.listViewExercises);


        //TO DO  display Workout exercises info

     spinnerWorkout.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
         @Override
         public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

             if (spinnerWorkout.getSelectedItem().toString().equals("Workout A")) {
                 ArrayAdapter<String> adapter = new ArrayAdapter<String>(workoutselector.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Exercises1_array));
                 listViewExercises.setAdapter(adapter);

             } if (spinnerWorkout.getSelectedItem().toString().equals("Workout B")) {
                 ArrayAdapter<String> adapter = new ArrayAdapter<String>(workoutselector.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Exercises2_array));
                 listViewExercises.setAdapter(adapter);

             }

             if (spinnerWorkout.getSelectedItem().toString().equals("Workout 100 reps")){

                 ArrayAdapter<String> adapter = new ArrayAdapter<String>(workoutselector.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Exercises3_array));
                 listViewExercises.setAdapter(adapter);


             }



         }

         @Override
         public void onNothingSelected(AdapterView<?> adapterView) {

         }
     });




        btnStartWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String spinnerValue = spinnerWorkout.getSelectedItem().toString();
                Intent intent = new Intent(getApplicationContext(), workout.class);
                intent.putExtra ("mySelection", spinnerValue);
                startActivity(intent);



            }
        });


    }


    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }


}
