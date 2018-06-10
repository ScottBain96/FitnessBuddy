package com.example.scott.appdevcw;

import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.SystemClock;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Date;

public class workout extends AppCompatActivity {



    DatabaseHelper mDatabaseHelper;
    TextView txtExercise, txtReady;
    ImageView imageView;
    Button btnNext, btnFinish;
    Chronometer timer;
    //Counter for changing image each time button is clicked
    int i = 0;
    //Counter to end workout
    int k = 0;
   // String currentDate = DateFormat.getDateTimeInstance().format(new Date());




    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        mDatabaseHelper = new DatabaseHelper(this);
        txtExercise = (TextView) findViewById(R.id.txtExercise);
        txtReady = (TextView) findViewById(R.id.txtReady);
        imageView = (ImageView) findViewById(R.id.imageView);
        btnNext = (Button) findViewById(R.id.btnNext);
        btnFinish = (Button) findViewById(R.id.btnFinish);
        timer = (Chronometer) findViewById(R.id.timer);
        btnFinish.setEnabled(false);



        Intent intent = getIntent();

        final String spinnerValue =intent.getStringExtra("mySelection");
        //txtTest.setText(String.valueOf(spinnerValue));




        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View view) {


         txtReady.setVisibility(View.GONE);
                i++;
                k++;

                if (k == 1){

                    timer.setBase(SystemClock.elapsedRealtime());
                    timer.start();
                }

                if (spinnerValue.equals("Workout A")) {


                    if (i > 4 ) {

                        i=1;

                    }

                    if ( i == 1) {

                        imageView.setImageResource(R.drawable.pushup);
                        txtExercise.setText("30 repetitions");

                    }


                    if (i == 2 ) {
                        imageView.setImageResource(R.drawable.situps);
                        txtExercise.setText("30 repetitions");

                    }

                        if (i == 3) {
                        imageView.setImageResource(R.drawable.squat);
                        txtExercise.setText("20 repetitions");

                    }

                    if ( i == 4 && k < 13) {
                        imageView.setImageResource(R.drawable.plank);
                        txtExercise.setText("30secs plank!");


                    }


                    if ( k == 12)
                    {
                        btnNext.setEnabled(false);
                        btnFinish.setEnabled(true);
                        imageView.setImageResource(R.drawable.plank);

                    }


                }

                if (spinnerValue.equals("Workout B")){


                    if (i > 4 ) {

                        i=1;

                    }

                    if ( i == 1) {

                        imageView.setImageResource(R.drawable.pushup);
                        txtExercise.setText("10 repetitions");

                    }


                    if (i == 2 ) {
                        imageView.setImageResource(R.drawable.mountainclimbers);
                        txtExercise.setText("20 repetitions");

                    }

                    if (i == 3) {
                        imageView.setImageResource(R.drawable.burpees);
                        txtExercise.setText("10 repetitions");

                    }

                    if ( i == 4 && k < 12) {
                        imageView.setImageResource(R.drawable.squat);
                        txtExercise.setText("10 repetitions!");


                    }


                    if ( k == 11)
                    {
                        btnNext.setEnabled(false);
                        btnFinish.setEnabled(true);
                        imageView.setImageResource(R.drawable.squat);


                    }

                }


                if (spinnerValue.equals("Workout 100 reps")){



                    if ( i == 1) {

                        imageView.setImageResource(R.drawable.pushup);
                        txtExercise.setText("100 repetitions");

                    }


                    if (i == 2 ) {
                        imageView.setImageResource(R.drawable.situps);
                        txtExercise.setText("100 repetitions");

                    }

                    if (i == 3) {
                        imageView.setImageResource(R.drawable.mountainclimbers);
                        txtExercise.setText("100 repetitions");

                    }

                    if ( i == 4 ) {
                        imageView.setImageResource(R.drawable.burpees);
                        txtExercise.setText("100 repetitions!");


                    }
                    if ( i == 5 ) {
                        imageView.setImageResource(R.drawable.squat);
                        txtExercise.setText("100 repetitions!");


                    }



                    if ( k == 5)
                    {
                        btnNext.setEnabled(false);
                        btnFinish.setEnabled(true);
                        imageView.setImageResource(R.drawable.squat);


                    }

                }




            }
        });

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                timer.stop();
                String newEntry = timer.getText().toString();
                addData(newEntry+ " "+ spinnerValue);
                Intent intent = new Intent(getApplicationContext(),savedinfo.class );
                startActivity(intent);


            }
        });

    }

    public void addData (String newEntry){

    boolean insertData = mDatabaseHelper.addData(newEntry);
        if (insertData){
            toastMessage("Data saved");
        }else {

            toastMessage("ERROR saving data");
        }


    }





    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}

