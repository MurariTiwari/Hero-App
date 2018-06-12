package com.tiwarithetiger11gmail.quizapp;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ScrollingActivity extends Activity {
    SharedPreferences preferences;
    TextView text1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    String s,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10;
    SQLiteDatabase db;
    Cursor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        setTitle("Hero");
        db=openOrCreateDatabase(MainActivity.D_NAME,MODE_PRIVATE,null);
        text1= (TextView) findViewById(R.id.mt1);
        t2= (TextView) findViewById(R.id.mt4);
        t3= (TextView) findViewById(R.id.mt6);
        t4= (TextView) findViewById(R.id.mt8);
        t5= (TextView) findViewById(R.id.mt10);
        t6= (TextView) findViewById(R.id.mt12);
        t7= (TextView) findViewById(R.id.mt14);
        t8= (TextView) findViewById(R.id.mt16);
        t9= (TextView) findViewById(R.id.mt18);
        t10= (TextView) findViewById(R.id.mt20);
        t11= (TextView) findViewById(R.id.mt22);




        c=db.rawQuery("select * from record1;",null);
        if(c.moveToFirst())
        {
             setText();

        }
        else{
            Toast.makeText(getApplicationContext(),"No Data yet",Toast.LENGTH_SHORT).show();
        }

    }
    public void btClick(View v)
    {
        if(c.moveToNext())
        {
            setText();
        }
        else{
            Toast.makeText(getApplicationContext(),"No more Data",Toast.LENGTH_SHORT).show();
        }
    }
    private void setText()
    {
        s=c.getString(1);
        s1=c.getString(2);
        s2=c.getString(3);
        s3=c.getString(4);
        s4=c.getString(5);
        s5=c.getString(6);
        s6=c.getString(7);
        s7=c.getString(8);
        s8=c.getString(9);
        s9=c.getString(10);
        s10=c.getString(11);
        text1.setText(s);
        t2.setText(s1);
        t3.setText(s2);
        t4.setText(s3);
        t5.setText(s4);
        t6.setText(s5);
        t7.setText(s6);
        t8.setText(s7);
        t9.setText(s8);
        t10.setText(s9);
        t11.setText(s10);

    }
}
