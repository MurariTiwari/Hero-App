package com.tiwarithetiger11gmail.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import at.markushi.ui.CircleButton;

public class MainActivity extends Activity {
    CircleButton button1;
    CircleButton button2;
    CircleButton button3;
    CircleButton button4;
    CircleButton button5;
    CircleButton button6;
    TextView tv;
    SQLiteDatabase db;
    public static  final String D_NAME="mydatabase";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=openOrCreateDatabase(D_NAME,MODE_PRIVATE,null);
        createTable();
        button1 = (CircleButton) findViewById(R.id.quiz);
        button2 = (CircleButton) findViewById(R.id.puzzle);
        button3 = (CircleButton) findViewById(R.id.record);
        button4=(CircleButton)findViewById(R.id.quizdata);
        button5=(CircleButton)findViewById(R.id.surveydata);
        button6=(CircleButton)findViewById(R.id.exportcsv);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Question1.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,PuzzleGroup.class);
                startActivity(i);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Survey1.class);
                startActivity(i);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,ScrollingActivity.class);
                startActivity(i);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Survey.class);
                startActivity(i);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,CSVGuid.class);
                startActivity(i);
            }
        });

    }

    private void createTable() {
        db.execSQL(
                "CREATE TABLE IF NOT EXISTS record1 (\n" +
                        "    id INTEGER NOT NULL CONSTRAINT employees_pk PRIMARY KEY AUTOINCREMENT,\n" +
                        "    test_ride varchar(200) NOT NULL,\n" +
                        "    model  varchar(200) NOT NULL,\n" +
                        "    satisfied varchar(200) NOT NULL,\n" +
                        "    name  varchar(200) NOT NULL,\n" +
                        "    m_number varchar(200) NOT NULL,\n" +
                        "    address  varchar(2000) NOT NULL,\n" +
                        "    further_cont varchar(200) NOT NULL,\n" +
                        "    sugg_to_someone  varchar(200) NOT NULL,\n" +
                        "    s_name varchar(200),\n" +
                        "    s_mob_no  varchar(200) ,\n" +
                        "    s_city varchar(200) \n" +
                        ");"
        );
        db.execSQL(
                "CREATE TABLE IF NOT EXISTS survey (\n" +
                        "    id INTEGER NOT NULL CONSTRAINT employees_pk PRIMARY KEY AUTOINCREMENT,\n" +
                        "    twowheeler varchar(200) NOT NULL,\n" +
                        "    company  varchar(200) NOT NULL,\n" +
                        "    scooter varchar(200) NOT NULL,\n" +
                        "    metric  varchar(200) NOT NULL,\n" +
                        "    schemes varchar(200) NOT NULL,\n" +
                        "    Name  varchar(2000) NOT NULL,\n" +
                        "    Age varchar(200) NOT NULL,\n" +
                        "    Profession  varchar(200) NOT NULL,\n" +
                        "    City varchar(200) NOT NULL,\n" +
                        "    Locality  varchar(200) NOT NULL \n" +
                        ");"
        );
    }
}
