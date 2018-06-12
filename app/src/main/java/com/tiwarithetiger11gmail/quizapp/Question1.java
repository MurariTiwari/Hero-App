package com.tiwarithetiger11gmail.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by amit on 31/5/18.
 */

public class Question1 extends Activity {
ImageButton imageButton;
    RadioGroup rg;String value;
    SharedPreferences preferences;
    TextView textView;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.layout_question1);
            preferences = getSharedPreferences("MyPrefs",MODE_PRIVATE);
            textView = (TextView) findViewById(R.id.question1);

            rg = (RadioGroup) findViewById(R.id.radioGroup1);
            value =
                    ((RadioButton)findViewById(rg.getCheckedRadioButtonId()))
                            .getText().toString();
            rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    value =
                            ((RadioButton)findViewById(rg.getCheckedRadioButtonId()))
                                    .getText().toString();

                }
            });

            imageButton = (ImageButton) findViewById(R.id.button1);
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View view) {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("Ride",value);

                    editor.commit();

                    Intent intent = new Intent(Question1.this,Question2.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
    public void onBackPressed() {
        // super.onBackPressed(); commented this line in order to disable back press
        Toast.makeText(getApplicationContext(), "Back press disabled!", Toast.LENGTH_SHORT).show();
    }
}

