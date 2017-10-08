package com.example.hnonhaaa.whatyourgrade;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText inputName , inputScore ;
    private Button findGrade , exit ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputName = (EditText) findViewById(R.id.inputName);
        inputScore = (EditText) findViewById(R.id.inputScore);
        findGrade = (Button) findViewById(R.id.button_findGrade) ;
        exit =(Button) findViewById(R.id.button_Exit) ;

        findGrade.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String  name = inputName.getText().toString() ;
                String score = inputScore.getText().toString() ;
                if(name.equals("")|| score.equals("")){
                    //Toast ; ยังกรอกข้อมูลไม่ครบ
                    if(name.equals("")){inputName.setError("yourName?");}
                    if(score.equals(""))inputScore.setError("yourScore?");
                }else{
                    Intent intent = new Intent(MainActivity.this , Main2Activity.class) ;
                    intent.putExtra("nameValues" , name);
                    intent.putExtra("scoreValues" , score) ;
                    startActivity(intent); // start
                }
            }
        });

        exit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                AlertDialog.Builder dialog = new  AlertDialog.Builder(MainActivity.this) ;
                dialog.setTitle("Confirm Exit");
                dialog.setMessage("Sure??") ;
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish() ;
                    }
                });
                dialog.setNegativeButton("cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       //
                    }
                });

                dialog.show() ;
            }
        });

    }
}
