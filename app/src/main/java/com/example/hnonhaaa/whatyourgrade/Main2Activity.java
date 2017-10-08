package com.example.hnonhaaa.whatyourgrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView tName ,tGrade ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tName = (TextView) findViewById(R.id.text_showName) ;
        tGrade = (TextView) findViewById(R.id.text_showGrade) ;

        Intent intent = getIntent() ;
        String name = intent.getStringExtra("nameValues") ;
        String score = intent.getStringExtra("scoreValues") ;

        int grade = Integer.valueOf(score) ;
        tName.setText(name);
        if(grade>=80){tGrade.setText("A");}
        else if(grade>=70){tGrade.setText("B");}
        else if(grade>=60){tGrade.setText("C");}
        else if(grade>=50){tGrade.setText("D");}
        else{tGrade.setText("F");}
    }
}
