package com.example.a20140550.sharemenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity implements View.OnClickListener {
    private Button sendbutton, clearbutton;
    private EditText nameEdit, messageEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        sendbutton = (Button) findViewById(R.id.sendButtonID);
        clearbutton = (Button) findViewById(R.id.ClearButtonID);

        nameEdit = (EditText) findViewById(R.id.nameEditTextID);
        messageEdit = (EditText) findViewById(R.id.messageEditTextID);

        sendbutton.setOnClickListener(this);
        clearbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
try{
    String name = nameEdit.getText().toString();
    String message = messageEdit.getText().toString();

    if (v.getId() == R.id.sendButtonID) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/email");

        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"bidit4mca@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback From Apps");
        intent.putExtra(Intent.EXTRA_TEXT, "Name :" + name + "\n Message :" + message);
        startActivity(Intent.createChooser(intent, "Feedback With"));


    } else if (v.getId() == R.id.ClearButtonID) {
        nameEdit.setText("");
        messageEdit.setText("");
    }
}
catch (Exception e)
{
    Toast.makeText(getApplicationContext(),"Exception"+e,Toast.LENGTH_SHORT).show();
}


    }
}
