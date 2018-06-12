package com.tiwarithetiger11gmail.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Survey2 extends Activity {
    SharedPreferences preferences;
    RadioGroup rg;String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey2);
        preferences = getSharedPreferences("MyPrefs1",MODE_PRIVATE);

        rg = (RadioGroup) findViewById(R.id.radioGroup2);
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
    }
    public void btClick(View v)
    {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("company",value);

        editor.commit();
        Intent intent = new Intent(Survey2.this,Survey3.class);
        startActivity(intent);
        finish();
    }
    public void onBackPressed() {
        // super.onBackPressed(); commented this line in order to disable back press
        Toast.makeText(getApplicationContext(), "Back press disabled!", Toast.LENGTH_SHORT).show();
    }

}
