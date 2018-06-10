package com.example.scott.appdevcw;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class savedinfo extends AppCompatActivity {

    private static final String TAG = "savedinfo";
    DatabaseHelper mDatabaseHelper;
    private ListView listViewWorkout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_info);
        listViewWorkout = (ListView) findViewById(R.id.listViewWorkout);
        mDatabaseHelper = new DatabaseHelper(this);
        populateListView();


        

    }

    private void populateListView() {

        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();


        while (data.moveToNext()){

            listData.add(0,data.getString(1));
        }
        ListAdapter  adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listData);
        listViewWorkout.setAdapter(adapter);


    }




    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }


}
