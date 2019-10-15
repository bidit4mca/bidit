package com.example.ksb.bid_it;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;



public class Registrationform extends AppCompatActivity {

    EditText Name;
    EditText Age;
    RadioGroup Gender;
    EditText Phoneno;
    EditText Email;
    EditText Username;
    EditText Password ;
    Button Register;
    String NameHolder, EmailHolder,AgeHolder, PasswordHolder,PassworddHolder,a,b;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    Boolean EditTextEmptyHolder,f,g;
    SQLiteDatabase sqLiteDatabaseObj;
    String SQLiteDataBaseQueryHolder ;
    SQLiteHelper sqLiteHelper;
    Cursor cursor;
    String F_Result = "Not_Found";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrationform);

      Register = (Button)findViewById(R.id.button);
        Name=(EditText) findViewById(R.id.editText);
        Age=(EditText) findViewById(R.id.editText2);
        Gender=(RadioGroup)findViewById(R.id.radioGroup);
        Phoneno=(EditText) findViewById(R.id.editText4);
        Email=(EditText) findViewById(R.id.editText5);
        Username=(EditText) findViewById(R.id.editText6);
        Password = (EditText)findViewById(R.id.editText7);
        Register = (Button)findViewById(R.id.button);

        sqLiteHelper = new SQLiteHelper(this);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Creating SQLite database if dose n't exists
                SQLiteDataBaseBuild();

                // Creating SQLite table if dose n't exists.
                SQLiteTableBuild();

                // Checking EditText is empty or Not.
               // CheckEditTextStatus();
                CheckEmailValidation();

                passwordvalidation();

                // Method to check Email is already exists or not.
                CheckingEmailAlreadyExistsOrNot();


                // Empty EditText After done inserting process.
                // EmptyEditTextAfterDataInsert();


            }
        });

    }

    // SQLite database build method.
    public void SQLiteDataBaseBuild(){

        sqLiteDatabaseObj = openOrCreateDatabase(SQLiteHelper.DATABASE_NAME, Context.MODE_PRIVATE, null);

    }


    // SQLite table build method.
    public void SQLiteTableBuild() {

        sqLiteDatabaseObj.execSQL("CREATE TABLE IF NOT EXISTS " + SQLiteHelper.TABLE_NAME + "(" + SQLiteHelper.Table_Column_ID + " PRIMARY KEY AUTOINCREMENT NOT NULL, " + SQLiteHelper.Table_Column_Name + " VARCHAR, " + SQLiteHelper.Table_Column_1_Age + " VARCHAR,  " + SQLiteHelper.Table_Column_2_Gender + " INTEGER, " + SQLiteHelper.Table_Column_3_Phoneno + " INTEGER,  " + SQLiteHelper.Table_Column_4_Email + " VARCHAR, "+ SQLiteHelper.Table_Column_5_Username + " VARCHAR, " + SQLiteHelper.Table_Column_6_Password + " VARCHAR);");

    }

    // Insert data into SQLite database method.
    public void InsertDataIntoSQLiteDatabase(){

        // If editText is not empty then this block will executed.
        if((EditTextEmptyHolder == true)&&(f)&&(g))
        {

            // SQLite query to insert data into table.
            SQLiteDataBaseQueryHolder = "INSERT INTO "+SQLiteHelper.TABLE_NAME+" (name,age,gender,phoneno,email,username,password) VALUES('"+Name.getText()+"', '"+Age.getText()+"','"+Gender+"','"+Phoneno.getText()+"','"+EmailHolder+"','"+Username.getText()+"', '"+PasswordHolder+"');";

            // Executing query.
            sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder);

            // Closing SQLite database object.
            sqLiteDatabaseObj.close();

            // Printing toast message after done inserting.
            Toast.makeText(Registrationform.this,"User Registered Successfully", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Registrationform.this,Homepage .class);
            startActivity(intent);

        }
        // This block will execute if any of the registration EditText is empty.
        else {
            if(EditTextEmptyHolder==false)
            {

                // Printing toast message if any of EditText is empty.
                Toast.makeText(Registrationform.this,"Please Fill All The Required Fields.", Toast.LENGTH_LONG).show();

            }
            else if(f==false)
            {
                Toast.makeText(Registrationform.this,"Invalid email.", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(Registrationform.this," Password Mismatch.", Toast.LENGTH_LONG).show();
            }
        }


    }

    // Empty edittext after done inserting process method.
//    public void EmptyEditTextAfterDataInsert(){
//
//        Name.getText().clear();
//
//        Email.getText().clear();
//        Age.getText().clear();
//
//        Password.getText().clear();
//        passwordd.getText().clear();
//
//    }

    // Method to check EditText is empty or Not.
  //  public void CheckEditTextStatus(){

        // Getting value from All EditText and storing into String Variables.
       // NameHolder = Name.getText().toString() ;
      //  AgeHolder = Age.getText().toString() ;
        //GenderHolder = Gender.getText().toString() ;
      //  PhonenoHolder = Phoneno.getText().toString();
      //  EmailHolder = Email.getText().toString() ;
       // UsernameHolder = Username.getText().toString();
       // PassworddHolder=Password.getText().toString();



      //  if(TextUtils.isEmpty(NameHolder) || TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(AgeHolder)|| TextUtils.isEmpty(GenderHolder)|| TextUtils.isEmpty(PhonenoHolder)|| TextUtils.isEmpty(EmailHolder)|| TextUtils.isEmpty(UsernameHolder)||TextUtils.isEmpty(PasswordHolder)|| TextUtils.isEmpty(PassworddHolder)){

       //     EditTextEmptyHolder = false ;

      //  }
      //  else {

       //     EditTextEmptyHolder = true ;
       // }
  //  }

    // Checking Email is already exists or not.
    public void CheckingEmailAlreadyExistsOrNot(){

        // Opening SQLite database write permission.
        sqLiteDatabaseObj = sqLiteHelper.getWritableDatabase();

        // Adding search email query to cursor.
        cursor = sqLiteDatabaseObj.query(SQLiteHelper.TABLE_NAME, null, " " + SQLiteHelper.Table_Column_4_Email + "=?", new String[]{EmailHolder}, null, null, null);

        while (cursor.moveToNext()) {

            if (cursor.isFirst()) {

                cursor.moveToFirst();

                // If Email is already exists then Result variable value set as Email Found.
                F_Result = "Email Found";

                // Closing cursor.
                cursor.close();
            }
        }

        // Calling method to check final result and insert data into SQLite database.
        CheckFinalResult();

    }


    // Checking result
    public void CheckFinalResult(){

        // Checking whether email is already exists or not.
        if(F_Result.equalsIgnoreCase("Email Found"))
        {

            // If email is exists then toast msg will display.
            Toast.makeText(Registrationform.this,"Email Already Exists",Toast.LENGTH_LONG).show();

        }
        else {

            // If email already dose n't exists then user registration details will entered to SQLite database.
            InsertDataIntoSQLiteDatabase();

        }

        F_Result = "Not_Found" ;

    }
    public void CheckEmailValidation()
    {
        if (EmailHolder.matches(emailPattern))
        {
            f=true;
        }
        else
        {
            f=false;


        }
    }
    public void passwordvalidation()
    {

        if(PasswordHolder.equals(PassworddHolder))
        {
            g=true;
        }
        else
        {
            g=false;
        }
    }


}
