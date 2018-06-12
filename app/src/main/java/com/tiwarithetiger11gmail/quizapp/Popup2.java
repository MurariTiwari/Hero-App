package com.tiwarithetiger11gmail.quizapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by amit on 3/6/18.
 */

public class Popup2 extends Activity {
    EditText e1, e2, e3;
    ImageButton imageButton;
    final Context context = this;

    SharedPreferences preferences;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup2);


        preferences = getSharedPreferences("MyPrefs",MODE_PRIVATE);

        e1 = (EditText) findViewById(R.id.name);
        e2 = (EditText)findViewById(R.id.phone);
        e3 = (EditText) findViewById(R.id.city);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;


        imageButton = (ImageButton) findViewById(R.id.submit);

        // add button listener
           imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
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
                    editor.putString("aName", name);
                    editor.putString("aPhone", phone);
                    editor.putString("aAddress", address);

                    editor.commit();
                    new MyAsyncTask1().execute();

                }}
        });
    }

    public class MyAsyncTask1 extends AsyncTask<Void,Void,Void>{
        @Override
        protected Void doInBackground(Void... voids) {
           SharedPreferences preferences = getSharedPreferences("MyPrefs",MODE_PRIVATE);
            String s=preferences.getString("Ride","");
            String s1=preferences.getString("model","");
            String s2=preferences.getString("satisfied","");
            String s3=preferences.getString("Name","");
            String s4=preferences.getString("Phone","");
            String s5=preferences.getString("Address","");
            String s6=preferences.getString("Day","");
            String s7=preferences.getString("add","");
            String s8=preferences.getString("aName","");
            String s9=preferences.getString("aPhone","");
            String s10=preferences.getString("aAddress","");
            SQLiteDatabase db=openOrCreateDatabase("mydatabase",MODE_PRIVATE,null);
            String sql="INSERT INTO record1 (test_ride,model,satisfied,name,m_number,address,further_cont, sugg_to_someone,s_name, s_mob_no, s_city)"+
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            db.execSQL(sql,new String[] {s,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10});
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    context);

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
