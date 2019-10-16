package com.example.ksb.myapplication000;

import android.content.Intent;
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
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity1 extends Activity implements OnClickListener
{
    EditText name,age,phone,email,username,password;
    Button register;
    SQLiteDatabase db;
    String st;


  
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        name=(EditText)findViewById(R.id.editText);
        age=(EditText)findViewById(R.id.editText2);
        phone=(EditText) findViewById(R.id.editText4);
        email=(EditText) findViewById(R.id.editText5);
        username=(EditText) findViewById(R.id.editText6);
        password=(EditText)findViewById(R.id.editText7);
        register=(Button)findViewById(R.id.button);


        register.setOnClickListener(this);

        db=openOrCreateDatabase("UserDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS user(name VARCHAR,age INTEGER,phone INTEGER,email VARCHAR,username VARCHAR,password VARCHAR);");
    }
    public void onClick(View view)
    {
        Intent i=new Intent(MainActivity1.this,MainActivity2.class);
        st=register.getText().toString();
       i.putExtra("value",st);
        startActivity(i);
       finish();

        if(view==register)
        {

            if(name.getText().toString().trim().length()==0||
                    age.getText().toString().trim().length()==0||phone.getText().toString().trim().length()==0||email.getText().toString().trim().length()==0||username.getText().toString().trim().length()==0||password.getText().toString().trim().length()==0)
            {
                showMessage("Error", "Please enter all values");
                return;
            }
            db.execSQL("INSERT INTO user VALUES('"+name.getText()+"','"+age.getText()+
                    "','"+phone.getText()+"','"+email.getText()+"','"+username.getText()+"','"+password.getText()+"');");
            showMessage("Success", "Registration successful");
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
        name.setText("");
        age.setText("");
        phone.setText("");
        email.setText("");
        username.setText("");
        password.setText("");
        name.requestFocus();
    }
}
