package com.example.ksb.myapplication000;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity2 extends AppCompatActivity {
    TextView tv;
    String st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv=(TextView)findViewById(R.id.textView);
        st=getIntent().getExtras().getString("value");
        tv.setText(st);
    }
}
