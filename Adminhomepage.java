package com.example.ksb.myapplication000;

import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Adminhomepage extends AppCompatActivity implements View.OnClickListener {
    Button viewuser,viewfeedback,viewwinner;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminhomepage);
        viewuser=(Button)findViewById(R.id.button16);
        viewfeedback=(Button)findViewById(R.id.button13);
        viewwinner=(Button)findViewById(R.id.button14);
        viewuser.setOnClickListener(this);
        viewfeedback.setOnClickListener(this);
        viewwinner.setOnClickListener(this);
        db=openOrCreateDatabase("UserDB", Context.MODE_PRIVATE, null);

    }

    @Override
    public void onClick(View v) {


        if (v== viewuser)
        {
            Cursor g = db.rawQuery("SELECT * FROM  Registration", null);
            if (g.getCount() == 0)
            {

                showMessage("Error", "No record found");
                return;
            }
            StringBuffer buffer = new StringBuffer();
            while (g.moveToNext()) {
                buffer.append("Name:" + g.getString(0) + "\n");
                buffer.append("Age:" + g.getString(1) + "\n");

                buffer.append("Phoneno:" + g.getString(2) + "\n");
                buffer.append("Email:" + g.getString(3) + "\n");
                buffer.append("Username:" + g.getString(4) + "\n");
                buffer.append("Password:" + g.getString(5) + "\n");
            }
            showMessage("Registration form", buffer.toString());

        }



        if (v== viewfeedback)
        {
            Cursor g = db.rawQuery("SELECT * FROM  Feedback", null);
            if (g.getCount() == 0)
            {

                showMessage("Error", "No record found");
                return;
            }
            StringBuffer buffer = new StringBuffer();
            while (g.moveToNext()) {
                buffer.append("Subject:" + g.getString(0) + "\n");
                buffer.append("Message:" + g.getString(1) + "\n");


            }

        }

    }

    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}




