package com.example.a300858525.ass3haojiang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView lvSettings=(ListView)findViewById(R.id.listView);
        //handle the item click event
        lvSettings.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent=null;
                String selectedExercises = (String)lvSettings.getItemAtPosition(position);
                //
                switch (position)
                {
                    case 0:
                        intent = new Intent(MainActivity.this,Ex1Activity.class);
                        intent.putExtra("selectedExercises",selectedExercises );

                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this,Ex2Activity.class);
                        intent.putExtra("selectedExercises",selectedExercises );

                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this,Ex3Activity.class);
                        intent.putExtra("selectedExercises",selectedExercises );

                        startActivity(intent);
                        break;
                }


            }
        });

    }
}
