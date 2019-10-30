package com.example.ksb.myapplication000;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog.Builder;
import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Addcategory extends AppCompatActivity implements OnClickListener
{

    EditText categoryname, description;
    Button Add, Cancel;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcategory);
        categoryname = (EditText)findViewById(R.id.editText9);
        description = (EditText)findViewById(R.id.editText10);

        Add = (Button) findViewById(R.id.button3);
        Cancel = (Button) findViewById(R.id.button23);
        Add.setOnClickListener(this);

        db = openOrCreateDatabase("UserDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Cat(categoryname VARCHAR,description VARCHAR);");
    }

    public void onClick(View view)
    {

        if (view == Add)
        {

            if (categoryname.getText().toString().trim().length() == 0 || description.getText().toString().trim().length() == 0) {

                showMessage("Error", "Please enter all values");
                return;

            }
            db.execSQL("INSERT INTO Cat VALUES('" + categoryname.getText() + "','" + description.getText() + "');");
            showMessage("Success", "CategoryAdded successfully");
            clearText();
        }
    }


    public void showMessage(String title, String message)
    {
        Builder builder = new Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void clearText()
    {
        categoryname.setText("");
        description.setText("");

    }
}


