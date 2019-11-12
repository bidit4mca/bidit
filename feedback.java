package com.example.userview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class feedback extends AppCompatActivity {
    Button BACK,CONFIRM;
    EditText feed;
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        BACK=(Button)findViewById(R.id.button14);
        CONFIRM=(Button)findViewById(R.id.button13);
        feed=(EditText)findViewById(R.id.editText);


        db=openOrCreateDatabase("FEEDBACK_DB",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS FEEDBACK_DB(feed VARCHAR)");
        BACK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(feedback.this,MainActivity.class);
                startActivity(i);
            }
        });
        CONFIRM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(feed.getText().toString().trim().length()==0)
                {
                    Toast.makeText(feedback.this,"please enter your feedback",Toast.LENGTH_LONG).show();
                }
                else {
                    db.execSQL(("INSERT INTO FEEDBACK_DB VALUES('" + feed.getText() + "')"));
                    Toast.makeText(feedback.this, "saved", Toast.LENGTH_LONG).show();

                   Intent i = new Intent(feedback.this, ViewFeedback.class);
                    startActivity(i);
                }




            }
        });
    }


}
