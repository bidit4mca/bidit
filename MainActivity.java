package com.example.ksb.bidding;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ksb.bidding.DbHandler;
import com.example.ksb.bidding.R;
import com.example.ksb.bidding.User;


public class MainActivity extends Activity {

    EditText uname,pswd;
    Button login;
    DbHandler db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                    Toast.makeText(MainActivity.this,"Invalid Login Credentials!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Login Success! "+name,Toast.LENGTH_LONG).show();
                }
            }});
        db=new DbHandler(MainActivity.this);
//inserting dummy users
        db.addUser(new User("Admin", "Admin"));
        db.addUser(new User("User", "User"));

    }
    public int checkUser(User user)
    {
        return db.checkUser(user);
    }
}