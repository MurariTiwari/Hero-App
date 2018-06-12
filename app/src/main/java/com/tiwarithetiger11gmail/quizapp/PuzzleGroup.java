package com.tiwarithetiger11gmail.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import at.markushi.ui.CircleButton;

public class PuzzleGroup extends Activity {
    CircleButton button1;
    CircleButton button2;
    CircleButton button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_group);

        button1 = (CircleButton) findViewById(R.id.puzzle1);
        button2 = (CircleButton) findViewById(R.id.puzzle2);
        button3 = (CircleButton) findViewById(R.id.puzzle3);
        
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PuzzleGroup.this,Puzzle.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PuzzleGroup.this,Puzzle2.class);
                startActivity(i);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(PuzzleGroup.this,Puzzle3.class);
                startActivity(j);
            }
        });

    }
}
