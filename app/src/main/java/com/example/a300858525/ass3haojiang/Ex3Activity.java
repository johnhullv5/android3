package com.example.a300858525.ass3haojiang;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class Ex3Activity extends AppCompatActivity {
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex3);

        final Button onButton = (Button) findViewById(R.id.start2);
        onButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                performAnimation(R.anim.spin);
            }
        });

        // Handle Stop Button
        final Button offButton = (Button) findViewById(R.id.stop2);
        offButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stopAnimation();
            }
        });

    }

    private void startAnimation()
    {
        img = (ImageView)findViewById(R.id.earth);
        RotateAnimation rotateAnimation = new RotateAnimation(30, 90,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

       // rotateAnimation.setVisible(true,true);
        rotateAnimation.start();
    }

    private void stopAnimation()
    {

    }

    private void performAnimation(int animationResourceID)
    {
        // We will animate the imageview
        final ImageView reusableImageView = (ImageView)findViewById(R.id.earth);
        reusableImageView.setImageResource(R.drawable.earth);
        reusableImageView.setVisibility(View.VISIBLE);

        final ImageView moonview = (ImageView)findViewById(R.id.moon);
        moonview.setImageResource(R.drawable.moon);
        moonview.setVisibility(View.VISIBLE);
//
//        // Load the appropriate animation
//        Animation an =  AnimationUtils.loadAnimation(this, animationResourceID);
//        // Register a listener, so we can disable and re-enable buttons
//        an.setAnimationListener(new MyAnimationListener());
//        // Start the animation
//        reusableImageView.startAnimation(an);


//        AnimatorSet dogeAnimatorSet =
//                (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.rot);
//        // 4
//        dogeAnimatorSet.setTarget(reusableImageView);
//        dogeAnimatorSet.setDuration(10000);
//        dogeAnimatorSet.start();


        ValueAnimator animator = ValueAnimator.ofFloat(0, 1); // values from 0 to 1
        animator.setDuration(20000); // 5 seconds duration from 0 to 1
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = ((Float) (animation.getAnimatedValue()))
                        .floatValue();
                // Set translation of your view here. Position can be calculated
                // out of value. This code should move the view in a half circle.
                moonview.setTranslationX((float)(300.0 * Math.sin(value*Math.PI)));
                moonview.setTranslationY((float)(300.0 * Math.cos(value*Math.PI)));
            }
        });

//        ValueAnimator positionAnimator = ValueAnimator.ofFloat(0, -500);
//
//// 2
//        positionAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                float value = (float) animation.getAnimatedValue();
//                reusableImageView.setTranslationY(value);
//            }
//        });
//
//
        ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(reusableImageView, "rotation", 0, 360f);
// 4
        AnimatorSet animatorSet = new AnimatorSet();
// 5
        animatorSet.play(animator).with(rotationAnimator);
// 6
        animatorSet.setDuration(20000);
        animatorSet.start();
    }

    class MyAnimationListener implements Animation.AnimationListener {

        public void onAnimationEnd(Animation animation) {
            // Hide our ImageView
            ImageView reusableImageView = (ImageView)findViewById(R.id.earth);
            reusableImageView.setVisibility(View.INVISIBLE);

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
