package com.example.a300858525.ass3haojiang;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

public class Ex1Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ImageView reusableImageView;
    TextView textView;

    //
    int startx = 100;
    int starty = 500;
    int endx=100;
    int endy=500;
    //
    Paint paint;
    Bitmap bitmap;
    Canvas canvas;
    //
    Handler mHandler = new Handler();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex1);

        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(20);

        // Spinner element
        //creating a bitmap as content view for the canvas
        bitmap = Bitmap.createBitmap((int) getWindowManager()
               .getDefaultDisplay().getWidth(), (int) getWindowManager()
               .getDefaultDisplay().getHeight()/2, Bitmap.Config.ARGB_8888);

        //bitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);


        //
        reusableImageView = (ImageView)findViewById(R.id.ImageViewForDrawing);
        //setting a bitmap as content view for the image
        reusableImageView.setImageBitmap(bitmap);

        //canvas.drawColor(Color.BLACK);
        //canvas.drawCircle(canvas.getWidth()/2,canvas.getHeight()/2,canvas.getWidth()/3,paint);

        textView = (TextView) findViewById(R.id.showY);


        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        String[] thickness  =getResources().getStringArray(R.array.thickness);//new ArrayList<String>();

        //thickness.add("5");
        //thickness.add("10");
        //thickness.add("15");
        //thickness.add("20");
        //thickness.add("25");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, thickness);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);



    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        paint.setStrokeWidth(Integer.valueOf(item));

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_red:
                if (checked)
                    // Pirates are the best
                    paint.setColor(Color.RED);
                    break;
            case R.id.radio_yellow:
                if (checked)
                    paint.setColor(Color.YELLOW);
                    break;
            case R.id.radio_cyan:
                if (checked)
                    paint.setColor(Color.CYAN);
                    break;
        }
    }


    public void clearCanvas(View v)
    {
        canvas.drawColor(Color.WHITE);
        textView.setText("clear");
        //canvas.drawCircle(canvas.getWidth()/2,canvas.getHeight()/2,canvas.getWidth()/3,paint);
    }
    //
    public void moveRect(Canvas canvas)
    {
        //canvas.translate(endx-startx, endy-starty);
        reusableImageView.setTranslationX(endx - startx);
        reusableImageView.setTranslationY(endy - starty);
        reusableImageView.setColorFilter(Color.GREEN);

    }

    public void drawLine(int keyCode, Canvas canvas)
    {
        textView.setText("y="+String.valueOf(endy));
        //canvas.drawLine(100,100,1000,1000,paint);
        canvas.drawLine(startx, starty, endx, endy, paint);
        startx=endx;
        starty=endy;

    }
    //Activate the DPAD on emulator:
    //change the settings in config.ini file in .android folder
    //hw.dPad=yes
    //hw.mainKeys=yes
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        switch(keyCode)
        {
            case KeyEvent.KEYCODE_DPAD_DOWN:
                //reusableImageView.setVisibility(View.VISIBLE);
                //reusableImageView.setFocusable(true);
                //reusableImageView.requestFocus();
                endy=endy+5;
                drawLine( keyCode,canvas);
                //moveRect(canvas);
                reusableImageView.invalidate();

                return true;

            case KeyEvent.KEYCODE_DPAD_UP:
                //reusableImageView.setVisibility(View.VISIBLE);
                reusableImageView.setFocusable(true);
                reusableImageView.requestFocus();
                endy=endy-5;
                drawLine( keyCode,canvas);
                //moveRect(canvas);
                reusableImageView.invalidate();

                return true;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                //reusableImageView.setVisibility(View.VISIBLE);
                reusableImageView.setFocusable(true);
                reusableImageView.requestFocus();
                endx=endx+5;
                drawLine( keyCode,canvas);
                //moveRect(canvas);
                reusableImageView.invalidate();

                return true;

            case KeyEvent.KEYCODE_DPAD_LEFT:
                //reusableImageView.setVisibility(View.VISIBLE);
                reusableImageView.setFocusable(true);
                reusableImageView.requestFocus();
                endx=endx-5;
                drawLine( keyCode,canvas);
                //moveRect(canvas);
                reusableImageView.invalidate();

                return true;

        }
        return false;
    }
}
