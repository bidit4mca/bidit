package com.example.ksb.testlog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class buying extends AppCompatActivity implements View.OnClickListener {
     Button Ok,Exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buying);
        Ok=(Button)findViewById(R.id.button2);
        Exit=(Button)findViewById(R.id.button);
        Exit.setOnClickListener(this);
        Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClickMe();
                {
                    Toast.makeText(buying.this,"Buying Successfully", Toast.LENGTH_LONG).show();}
                Intent intent = new Intent(buying.this, payment.class);
                startActivity(intent);
            }

            private void ClickMe() {
               // Toast.makeText(buying.this,"Buying Successfully", Toast.LENGTH_LONG).show();
               // Intent intent = new Intent(buying.this, payment.class);
              //  startActivity(intent);
            }


        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(buying.this, usrhome.class);
        startActivity(intent);


    }
}
