package com.example.a300858525.ass3haojiang;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Ex3Activity extends AppCompatActivity {
    ImageView img;
    AnimatorSet animatorSet;
    AnimatorSet bothAnimatorSet;
     ImageView reusableImageView;
     ImageView moonview;
    AnimatorSet dogeAnimatorSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex3);

        final Button onButton = (Button) findViewById(R.id.start2);
        onButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                performAnimation(v,R.anim.spin);
            }
        });

        // Handle Stop Button
        final Button offButton = (Button) findViewById(R.id.stop2);
        offButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stopAnimation();
            }
        });

        reusableImageView = (ImageView)findViewById(R.id.earth);
        reusableImageView.setImageResource(R.drawable.earth);
        reusableImageView.setVisibility(View.VISIBLE);

        moonview = (ImageView)findViewById(R.id.moon);
        moonview.setImageResource(R.drawable.moon);
        moonview.setVisibility(View.VISIBLE);

    }

    private void stopAnimation()
    {
        bothAnimatorSet.end();
        moonview.setVisibility(View.INVISIBLE);
        //reusableImageView.setVisibility();

    }

    //unused method to animation
    private void startAnimation()
    {
        img = (ImageView)findViewById(R.id.earth);
        RotateAnimation rotateAnimation = new RotateAnimation(30, 90,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

       // rotateAnimation.setVisible(true,true);
        rotateAnimation.start();
    }



    private void performAnimation(View v,int animationResourceID)
    {



        moonview.setVisibility(View.VISIBLE);

//
//        // Load the appropriate animation
//        Animation an =  AnimationUtils.loadAnimation(this, animationResourceID);
//        // Register a listener, so we can disable and re-enable buttons
//        an.setAnimationListener(new MyAnimationListener());
//        // Start the animation
//        reusableImageView.startAnimation(an);


         dogeAnimatorSet =
                (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.rot);

        dogeAnimatorSet.setTarget(reusableImageView);
        dogeAnimatorSet.setDuration(10000);
//        dogeAnimatorSet.start();




//        ValueAnimator animator = ValueAnimator.ofFloat(0, 1); // values from 0 to 1
//        animator.setDuration(20000); // 5 seconds duration from 0 to 1
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
//        {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                float value = ((Float) (animation.getAnimatedValue()))
//                        .floatValue();
//                // Set translation of your view here. Position can be calculated
//                // out of value. This code should move the view in a half circle.
//                moonview.setTranslationX((float)(300.0 * Math.sin(value*Math.PI)));
//                moonview.setTranslationY((float)(300.0 * Math.cos(value*Math.PI)));
//            }
//        });

        Path p = new Path();
        p.addCircle(540,481,413, Path.Direction.CCW);
        ValueAnimator pathAnimator = ObjectAnimator.ofFloat(moonview, "x", "y", p);
        pathAnimator.setRepeatCount(10);

//        ValueAnimator positionAnimator = ValueAnimator.ofFloat(0, -500);
//

//        positionAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                float value = (float) animation.getAnimatedValue();
//                reusableImageView.setTranslationY(value);
//            }
//        });
//
//
        //ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(reusableImageView, "rotation", 0, 360f);

        animatorSet = new AnimatorSet();

        animatorSet.play(pathAnimator);//.with(rotationAnimator);

        animatorSet.setDuration(10000);

        //animatorSet.start();

        bothAnimatorSet = new AnimatorSet();
        bothAnimatorSet.playTogether(animatorSet, dogeAnimatorSet);
        // 6
        bothAnimatorSet.setDuration(20000);
        bothAnimatorSet.start();


        float centreX=reusableImageView.getX() + reusableImageView.getWidth()  / 2;
        float centreY=reusableImageView.getY() + reusableImageView.getHeight() / 2;

        float centreXm=moonview.getX() + moonview.getWidth()  / 2;
        float centreYm=moonview.getY() + moonview.getHeight() / 2;


        Toast.makeText(v.getContext(), "earth: x " +String.valueOf(centreX), Toast.LENGTH_LONG).show();
        Toast.makeText(v.getContext(), "earth: y " +String.valueOf(centreY), Toast.LENGTH_LONG).show();
        Toast.makeText(v.getContext(), "moon: x " +String.valueOf(centreXm), Toast.LENGTH_LONG).show();
        Toast.makeText(v.getContext(), "moon: y " +String.valueOf(centreYm), Toast.LENGTH_LONG).show();
    }

    class MyAnimationListener implements Animation.AnimationListener {

        public void onAnimationEnd(Animation animation) {
            // Hide our ImageView
            ImageView reusableImageView = (ImageView)findViewById(R.id.earth);
            reusableImageView.setVisibility(View.INVISIBLE);

            //ImageView moonImageView = (ImageView)findViewById(R.id.moon);
            moonview.setVisibility(View.INVISIBLE);

            // Enable all buttons once animation is over
            //toggleButtons(true);

        }

        public void onAnimationRepeat(Animation animation) {
            // what to do when animation loops
        }

        public void onAnimationStart(Animation animation) {
            // Disable all buttons while animation is running
            //toggleButtons(false);

        }

    }
}
