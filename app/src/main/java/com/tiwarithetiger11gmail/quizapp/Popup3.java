package com.tiwarithetiger11gmail.quizapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Popup3 extends Activity {
   EditText e1,e2,e3,e4,e5;
    ImageButton imageButton;
    SharedPreferences preferences;
    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup3);
        e1= (EditText) findViewById(R.id.name);
        e2= (EditText) findViewById(R.id.age);
        e3= (EditText) findViewById(R.id.prof);
        e4= (EditText) findViewById(R.id.city);
        e5= (EditText) findViewById(R.id.locality);
        imageButton= (ImageButton) findViewById(R.id.submit);
        preferences = getSharedPreferences("MyPrefs1",MODE_PRIVATE);

        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String name = e1.getText().toString();
                String age = e2.getText().toString();
                String prof = e3.getText().toString();
                String city=e4.getText().toString();
                String locality=e5.getText().toString();
                if(name.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Name can't be Empty",Toast.LENGTH_SHORT).show();
                }
                else if(age.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Age No not Valid",Toast.LENGTH_SHORT).show();
                }
                else if(prof.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Profession can't be Empty",Toast.LENGTH_SHORT).show();
                }
                else if(city.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"City can't be Empty",Toast.LENGTH_SHORT).show();
                }
                else if(locality.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Locality can't be Empty",Toast.LENGTH_SHORT).show();

                }
                else {

                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("Name", name);
                    editor.putString("Age", age);
                    editor.putString("Profession", prof);
                    editor.putString("City", city);
                    editor.putString("Locality", locality);

                    editor.commit();


                    new MyAsyncTask1().execute();
                }}
        });
    }
    public class MyAsyncTask1 extends AsyncTask<Void,Void,Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            SharedPreferences preferences = getSharedPreferences("MyPrefs1",MODE_PRIVATE);
            String s=preferences.getString("twowheeler","");
            String s1=preferences.getString("company","");
            String s2=preferences.getString("scooter","");
            String s3=preferences.getString("metric","");
            String s4=preferences.getString("schemes","");
            String s5=preferences.getString("Name","");
            String s6=preferences.getString("Age","");
            String s7=preferences.getString("Profession","");
            String s8=preferences.getString("City","");
            String s9=preferences.getString("Locality","");

            SQLiteDatabase db=openOrCreateDatabase("mydatabase",MODE_PRIVATE,null);
            String sql="INSERT INTO survey  (twowheeler,company,scooter,metric,schemes,Name,Age, Profession,City,Locality)"+
                   "VALUES (?,?,?,?,?,?,?,?,?,?)";
           db.execSQL(sql,new String[] {s,s1,s2,s3,s4,s5,s6,s7,s8,s9});
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
