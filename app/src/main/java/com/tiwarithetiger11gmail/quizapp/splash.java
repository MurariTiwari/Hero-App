package com.tiwarithetiger11gmail.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by amit on 28/5/18.
 */

public class splash extends Activity{
    private ImageView imageView;
    private static int SPLASH_TIME_OUT = 4000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_splash);
        imageView =(ImageView) findViewById(R.id.hero);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        imageView.startAnimation(myanim);
        new Handler().postDelayed(new Runnable() {


                                      public void run() {
                                          Intent i = new Intent(splash.this, MainActivity.class);
                                          startActivity(i);

                                          // close this activity
                                          finish();
                                      }
                                  },
                SPLASH_TIME_OUT);
    }

}
