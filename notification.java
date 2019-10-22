package com.example.ksb.bidding;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.view.View;
import android.widget.Button;


public class notification extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        button=(Button)findViewById(R.id.button13);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClickMe();
            }
        });
    }

    private void ClickMe() {
        Bitmap icon1= BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher_round);
        NotificationCompat.BigTextStyle bigText=new NotificationCompat.BigTextStyle();
        bigText.bigText("  Congratulations on your remarkable achievement!     Your  bidding is succesfull and also give the payment amount correctly Thank you.");
        bigText.setBigContentTitle(" BID-IT  Notification");
        //build notification
        NotificationCompat.Builder mBuilder=(NotificationCompat.Builder)new NotificationCompat.Builder(this).setSmallIcon(R.mipmap.ic_launcher_round).setContentTitle("BID-IT Notification").setLargeIcon(icon1).setStyle(bigText);
        NotificationManager mNotificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(0,mBuilder.build());
    }
}
