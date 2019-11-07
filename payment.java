package com.example.ksb.testlog;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class payment extends AppCompatActivity implements View.OnClickListener {
    EditText Amount;
    Button insert;
    SQLiteDatabase db;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Amount = (EditText) findViewById(R.id.editText);
        insert = (Button) findViewById(R.id.button9);
        checkBox=(CheckBox)findViewById(R.id.checkbox);
        insert.setOnClickListener(this);
        db = openOrCreateDatabase("payment", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS payment(Amount VARCHAR);");
    }

    public void onClick(View view) {


        if (view == insert) {
            if (Amount.getText().toString().trim().length() == 0)
            {
                Toast.makeText(payment.this,"please Enter Amount!",Toast.LENGTH_SHORT).show();
            }
            else
            {
                db.execSQL("INSERT INTO payment VALUES('"+ Amount.getText()+"');");

                Toast.makeText(payment.this,"Payment Successfull!",Toast.LENGTH_SHORT).show();
            }


        }}}

