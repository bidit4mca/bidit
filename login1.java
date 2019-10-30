package com.example.ksb.myapplication000;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class login1 extends Activity {

    EditText uname,pswd;
    Button login;
    DbHandler db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        uname=(EditText)findViewById(R.id.uname);
        pswd=(EditText)findViewById(R.id.password);
        login=(Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String name=uname.getText().toString();
                String password=pswd.getText().toString();
                int id= checkUser(new User(name,password));
                if(id==-1)
                {
                    Toast.makeText(login1.this,"Invalid Login Credentials!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(login1.this,"Login Success! "+name,Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(login1.this,Userhome.class);
                    startActivity(intent);
                }

            }});
        db=new DbHandler(login1.this);
//inserting dummy users
        db.addUser(new User("Admin", "Admin"));
        db.addUser(new User("User", "User"));

    }
    public int checkUser(User user)
    {
        return db.checkUser(user);
    }
}
