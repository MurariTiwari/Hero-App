package com.tiwarithetiger11gmail.quizapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question3 extends Activity {
    ImageButton imageButton;
    SharedPreferences preferences;
    RadioGroup rg;String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
        preferences = getSharedPreferences("MyPrefs",MODE_PRIVATE);

        rg = (RadioGroup) findViewById(R.id.radioGroup3);
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

        imageButton = (ImageButton) findViewById(R.id.button3);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("satisfied",value);

                editor.commit();

                Intent intent = new Intent(Question3.this, Popup.class);
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



