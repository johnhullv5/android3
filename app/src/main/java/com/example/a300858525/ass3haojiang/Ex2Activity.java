package com.example.a300858525.ass3haojiang;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Ex2Activity extends AppCompatActivity {

    AnimationDrawable mframeAnimation = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex2);

        final Button onButton = (Button) findViewById(R.id.start);
        onButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startAnimation();
            }
        });

        // Handle Stop Button
        final Button offButton = (Button) findViewById(R.id.stop);
        offButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stopAnimation();
            }
        });
    }


    private void startAnimation()
    {
        ImageView img = (ImageView)findViewById(R.id.ImageViewForDrawing);

        BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.capture);
        BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.capture1);
        BitmapDrawable frame3 = (BitmapDrawable)getResources().getDrawable(R.drawable.capture2);
        BitmapDrawable frame4 = (BitmapDrawable)getResources().getDrawable(R.drawable.capture3);
        BitmapDrawable frame5 = (BitmapDrawable)getResources().getDrawable(R.drawable.capture4);
        BitmapDrawable frame6 = (BitmapDrawable)getResources().getDrawable(R.drawable.capture5);
        BitmapDrawable frame7 = (BitmapDrawable)getResources().getDrawable(R.drawable.capture6);
        BitmapDrawable frame8 = (BitmapDrawable)getResources().getDrawable(R.drawable.capture7);
        BitmapDrawable frame9 = (BitmapDrawable)getResources().getDrawable(R.drawable.capture8);
        BitmapDrawable frame10 = (BitmapDrawable)getResources().getDrawable(R.drawable.capture9);
        BitmapDrawable frame11 = (BitmapDrawable)getResources().getDrawable(R.drawable.capture10);
        BitmapDrawable frame12 = (BitmapDrawable)getResources().getDrawable(R.drawable.capture11);
        BitmapDrawable frame13 = (BitmapDrawable)getResources().getDrawable(R.drawable.capture12);
        BitmapDrawable frame14 = (BitmapDrawable)getResources().getDrawable(R.drawable.capture13);
        BitmapDrawable frame15 = (BitmapDrawable)getResources().getDrawable(R.drawable.capture14);
        BitmapDrawable frame16 = (BitmapDrawable)getResources().getDrawable(R.drawable.capture15);


        // Get the background, which has been compiled to an AnimationDrawable object.
        int reasonableDuration = 150;
        mframeAnimation = new AnimationDrawable();
        mframeAnimation.setOneShot(false);	// loop continuously
        mframeAnimation.addFrame(frame1, reasonableDuration);
        mframeAnimation.addFrame(frame2, reasonableDuration);
        mframeAnimation.addFrame(frame3, reasonableDuration);
        mframeAnimation.addFrame(frame4, reasonableDuration);
        mframeAnimation.addFrame(frame5, reasonableDuration);
        mframeAnimation.addFrame(frame6, reasonableDuration);
        mframeAnimation.addFrame(frame7, reasonableDuration);
        mframeAnimation.addFrame(frame8, reasonableDuration);
        mframeAnimation.addFrame(frame9, reasonableDuration);
        mframeAnimation.addFrame(frame10, reasonableDuration);
        mframeAnimation.addFrame(frame11, reasonableDuration);
        mframeAnimation.addFrame(frame12, reasonableDuration);
        mframeAnimation.addFrame(frame13, reasonableDuration);
        mframeAnimation.addFrame(frame14, reasonableDuration);
        mframeAnimation.addFrame(frame15, reasonableDuration);
        mframeAnimation.addFrame(frame16, reasonableDuration);


        img.setBackgroundDrawable(mframeAnimation);

        mframeAnimation.setVisible(true,true);
        mframeAnimation.start();
    }

    private void stopAnimation()
    {
        mframeAnimation.stop();
        mframeAnimation.setVisible(false,false);
    }
}
