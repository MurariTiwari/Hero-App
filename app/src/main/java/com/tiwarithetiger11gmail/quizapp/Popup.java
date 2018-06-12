package com.tiwarithetiger11gmail.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.jar.Attributes;

/**
 * Created by amit on 3/6/18.
 */

public class Popup extends Activity {
EditText e1,e2,e3;
    RadioGroup rg;String value;
ImageButton imageButton1;
SharedPreferences preferences;
SharedPreferences.Editor editor;
public String Name,Phone,Address;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup);
         e1= (EditText) findViewById(R.id.user_name);
        e2= (EditText) findViewById(R.id.user_phone);
        e3= (EditText) findViewById(R.id.user_address);
     preferences = getSharedPreferences("MyPrefs",MODE_PRIVATE);
     DisplayMetrics dm = new DisplayMetrics();
       getWindowManager().getDefaultDisplay().getMetrics(dm);

       int width = dm.widthPixels;
        int height = dm.heightPixels;

        rg = (RadioGroup) findViewById(R.id.radioGroup);
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

        imageButton1 = (ImageButton) findViewById(R.id.Next);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = e1.getText().toString();
               String phone = e2.getText().toString();
               String address = e3.getText().toString();
                if(name.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Name can't be Empty",Toast.LENGTH_SHORT).show();
                }
                else if(phone.equals("")||phone.length()!=10)
                {
                    Toast.makeText(getApplicationContext(),"Phone No not Valid",Toast.LENGTH_SHORT).show();
                }
                else if(address.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Address can't be Empty",Toast.LENGTH_SHORT).show();
                }
                else {

                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("Name", name);
                    editor.putString("Phone", phone);
                    editor.putString("Address", address);
                    editor.putString("Day",value);
                    editor.commit();
                     Intent intent = new Intent(Popup.this, Question4.class);
                    startActivity(intent);
                    finish();
                }

                           }
        });


}
    public void onBackPressed() {
        // super.onBackPressed(); commented this line in order to disable back press
        Toast.makeText(getApplicationContext(), "Back press disabled!", Toast.LENGTH_SHORT).show();
    }
}
