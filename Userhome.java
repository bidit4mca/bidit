package com.example.ksb.myapplication000;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;



public class Userhome extends AppCompatActivity implements OnClickListener {
    Button sell,feedback,exit,home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userhome);
        sell=(Button)findViewById(R.id.button3);
        feedback=(Button)findViewById(R.id.button4);
        exit=(Button)findViewById(R.id.button5);
        home=(Button)findViewById(R.id.button13);
        sell.setOnClickListener(this);
        feedback.setOnClickListener(this);
        exit.setOnClickListener(this);
        home.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v==sell)
        {
            Intent intent=new Intent(Userhome.this,selling.class);
            startActivity(intent);

        }

        if (v==feedback)
        {
            Intent intent=new Intent(Userhome.this,Addfeedback.class);
            startActivity(intent);

        }

    }
}
