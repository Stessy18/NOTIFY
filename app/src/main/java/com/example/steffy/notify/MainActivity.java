package com.example.steffy.notify;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void notify(View view)
    {
        EditText et = (EditText) findViewById(R.id.editText1);
        Intent intent = new Intent(this, ResultActivity.class);
        PendingIntent pending = PendingIntent.getActivity(this, 0, intent, 0);
        Notification noti = new Notification.Builder(this)
                .setContentTitle("New Message")
                .setContentText(et.getText().toString())
                .setSmallIcon(R.drawable.mail)
                .setContentIntent(pending).build();
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        noti.flags |= Notification.FLAG_AUTO_CANCEL;
        manager.notify(0, noti);
    }
}


