package com.example.a300858525.ass3haojiang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Ex2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex2);
    }


    private void startAnimation()
    {
        ImageView img = (ImageView)findViewById(R.id.ImageViewForDrawing);
    }
}
