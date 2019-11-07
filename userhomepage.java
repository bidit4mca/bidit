package com.example.ksb.biddings5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class userhomepage extends AppCompatActivity implements OnClickListener {
    Button sell,feedback,exit,home,buy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userhomepage);
        sell=(Button)findViewById(R.id.button4);
        feedback=(Button)findViewById(R.id.button5);
        exit=(Button)findViewById(R.id.button13);
        home=(Button)findViewById(R.id.button3);
        buy=(Button)findViewById(R.id.button11);
        sell.setOnClickListener((OnClickListener) this);
        feedback.setOnClickListener(this);
        exit.setOnClickListener(this);
        home.setOnClickListener(this);
buy.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v==sell)
        {
            Intent intent=new Intent(userhomepage.this,selling.class);
            startActivity(intent);

        }

       if (v==feedback)
       {
           Intent intent=new Intent(userhomepage.this,Addfeedback.class);
           startActivity(intent);

        }
        if (v==exit)
        {
            Intent intent=new Intent(userhomepage.this,logo.class);
            startActivity(intent);

        }

        if (v==buy)
        {
            Intent intent=new Intent(userhomepage.this,payment.class);
            startActivity(intent);

        }
    }
}
