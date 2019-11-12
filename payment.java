package com.example.ksb.testlog;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.app.NotificationManager;
import android.widget.Toast;

public class payment extends AppCompatActivity  {

    Button button;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        checkBox=(CheckBox)findViewById(R.id.checkbox);

        button=(Button)findViewById(R.id.button9);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClickMe();
                {Toast.makeText(payment.this,"Payment Successfully", Toast.LENGTH_LONG).show();}
            }



        });
    }

    private void ClickMe() {
        Bitmap icon1= BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher_round);
        NotificationCompat.BigTextStyle bigText=new NotificationCompat.BigTextStyle();
        bigText.bigText("  Congratulations  on your  remarkable  achievement!     Your  Bidding is Succesfull.     Thank You.");
        bigText.setBigContentTitle(" BID-IT  Notification");
        //build notification
        NotificationCompat.Builder mBuilder=(NotificationCompat.Builder)new NotificationCompat.Builder(this).setSmallIcon(R.mipmap.ic_launcher_round).setContentTitle("BID-IT Notification").setLargeIcon(icon1).setStyle(bigText);
        NotificationManager mNotificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(0,mBuilder.build());
    }
}


