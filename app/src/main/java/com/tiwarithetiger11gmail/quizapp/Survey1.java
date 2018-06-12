package com.tiwarithetiger11gmail.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Survey1 extends Activity {
    ImageButton imageButton; Intent intent;
    SharedPreferences preferences;
    RadioGroup rg;String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey1);
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

        imageButton = (ImageButton) findViewById(R.id.button2);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("twowheeler",value);

                editor.commit();

                intent = new Intent(Survey1.this,Survey2.class);
                startActivity(intent);
                finish();
            }});
    }
    public void onBackPressed() {
        // super.onBackPressed(); commented this line in order to disable back press
        Toast.makeText(getApplicationContext(), "Back press disabled!", Toast.LENGTH_SHORT).show();
    }

}
