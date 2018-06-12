package com.tiwarithetiger11gmail.quizapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question4 extends Activity {
    ImageButton imageButton;
    RadioGroup rg;
     String value ;
    SharedPreferences preferences;

    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);
        preferences = getSharedPreferences("MyPrefs",MODE_PRIVATE);

        imageButton = (ImageButton) findViewById(R.id.button4);
        rg = (RadioGroup) findViewById(R.id.radioGroup4);
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

                imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("add", value);
                editor.putString("aName", "");
                editor.putString("aPhone", "");
                editor.putString("aAddress", "");

                editor.commit();

                if(value.equals("A. हाँ")) {
                    Intent intent = new Intent(Question4.this, Popup2.class);
                    startActivity(intent);
                    finish();

                }else {
                  new MyAsyncTask1().execute();
                }

            }
        });
    }

    private class  MyAsyncTask1 extends AsyncTask<Void,Void,Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            String s = preferences.getString("Ride", "");
            String s1 = preferences.getString("model", "");
            String s2 = preferences.getString("satisfied", "");
            String s3 = preferences.getString("Name", "");
            String s4 = preferences.getString("Phone", "");
            String s5 = preferences.getString("Address", "");
            String s6 = preferences.getString("Day", "");
            String s7 = preferences.getString("add", "");
            SQLiteDatabase db = openOrCreateDatabase("mydatabase", MODE_PRIVATE, null);
            String sql = "INSERT INTO record1 (test_ride,model,satisfied,name,m_number,address,further_cont, sugg_to_someone)" +
                    "VALUES (?,?,?,?,?,?,?,?)";
            db.execSQL(sql, new String[]{s, s1, s2, s3, s4, s5, s6, s7});
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

            // set dialog message
            alertDialogBuilder
                    .setMessage("Congratulations!")
                    .setCancelable(false)
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {


                            finish();
                        }
                    });

            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();
        }
    }
        public void onBackPressed() {
        // super.onBackPressed(); commented this line in order to disable back press
        Toast.makeText(getApplicationContext(), "Back press disabled!", Toast.LENGTH_SHORT).show();
    }
}
