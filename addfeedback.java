package com.example.ksb.testlog;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class addfeedback extends Activity implements OnClickListener
{
    EditText subject,message;
    Button submit;
    SQLiteDatabase db;



    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addfeedback);

        subject=(EditText) findViewById(R.id.subject);
        message=(EditText)findViewById(R.id.message);

        submit=(Button) findViewById(R.id.submit);


        submit.setOnClickListener(this);


        db=openOrCreateDatabase("UserDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Feedback(subject VARCHAR,message VARCHAR);");
    }
    public void onClick(View view) {

        if (view == submit) {

            if (subject.getText().toString().trim().length() == 0 ||
                    message.getText().toString().trim().length() == 0)
            {

                showMessage("Error", "Please enter all values");
                return;
            }
            db.execSQL("INSERT INTO Feedback VALUES('" + subject.getText() + "','" + message.getText() + "');");
            showMessage("Success", "Added successful");
            clearText();
        }
    }



    public void showMessage(String title,String message)
    {
        Builder builder=new Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void clearText()
    {
        subject.setText("");
        message.setText("");

    }
}