package com.example.scott.appdevcw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class mainmenu extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mainmenu.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.menu_array));
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

               if ( i == 0){
                   Intent intent = new Intent(view.getContext(),bmi.class);
                   startActivityForResult (intent, 0);
               }
                if (i == 1){
                    Intent intent = new Intent(view.getContext(),calculatecalories.class);
                    startActivityForResult (intent, 1);

                }
                if (i == 2){
                    Intent intent = new Intent(view.getContext(),macroscalc.class);
                    startActivityForResult (intent, 2);

                }
                if (i == 3){
                    Intent intent = new Intent(view.getContext(),workoutselector.class);
                    startActivityForResult (intent, 3);

                }

                if (i == 4){
                    Intent intent = new Intent(view.getContext(),savedinfo.class);
                    startActivityForResult (intent, 4);

                }

                if (i == 5){
                    Intent intent = new Intent(view.getContext(),informationtext.class);
                    startActivityForResult (intent, 5);

                }


            }
        });
    }
}
