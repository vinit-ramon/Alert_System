package com.example.alert_system;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompat.BigTextStyle;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.NotificationCompat.WearableExtender;
import androidx.core.app.RemoteInput;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static String id = "My_channel";
    int notificationID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.findViewById(R.id.simple_noti).setOnClickListener((v)->{
            SimpleNoti();
        });
        this.findViewById(R.id.Bignoti).setOnClickListener((v)->{
            BigNoti();
        });
        this.findViewById(R.id.action_noti).setOnClickListener((v)->{
            Actionnoti();
        });

        Createchannel();

    }

    void SimpleNoti() {
        Intent viewIntent = new Intent(this, Simplenoti.class);
        // viewIntent.putExtra("NotiID :", "Notification ID is " + notificationID);
        viewIntent.putExtra("hello","hellllllllo");
        PendingIntent viewPendingIntent =
                PendingIntent.getActivity(this, 0, viewIntent, 0);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this, id)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle("Simple Noti")
                        .setContentText("This is a simple notification")
                        .setChannelId(id);
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(this);
        notificationManager.notify(notificationID, notificationBuilder.build());
        notificationID++;
    }
    void BigNoti() {
        Log.i("main", "Big notification");
        Intent viewIntent = new Intent(this, Bignoti.class);
        viewIntent.putExtra("NotiID", "Notification ID is " + notificationID);

        PendingIntent viewPendingIntent =
                PendingIntent.getActivity(this, 0, viewIntent, 0);

        NotificationCompat.Action.WearableExtender inlineActionForWear2 =
                new NotificationCompat.Action.WearableExtender()
                        .setHintDisplayActionInline(true)
                        .setHintLaunchesActivity(true);
       NotificationCompat.Action bignotiaction =
                new NotificationCompat.Action.Builder(
                        R.drawable.ic_action_time,
                        "Tap to watch on mobile",
                        viewPendingIntent)
                        .extend(inlineActionForWear2)
                        .build();
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this, id)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle("Big Noti")
                        .setContentText("This notification contain big text please click to view on mobile........")
                        .setChannelId(id)
                        .addAction(bignotiaction);
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(this);
        notificationManager.notify(notificationID, notificationBuilder.build());
        notificationID++;

    }
    void Actionnoti() {
        Log.i("main", "Action notification");
        Intent viewIntent = new Intent(this, Action_noti.class);
        //viewIntent.putExtra("NotiID", "Notification ID is " + notificationID);
        Intent viewIntent2 = new Intent(this, Simplenoti.class);

        PendingIntent viewPendingIntent =
                PendingIntent.getActivity(this, 0, viewIntent, 0);
        PendingIntent viewPendingIntent2 =
                PendingIntent.getActivity(this, 0, viewIntent2, 0);

        NotificationCompat.Action.WearableExtender inlineActionForWear2 =
                new NotificationCompat.Action.WearableExtender()
                        .setHintDisplayActionInline(true)
                        .setHintLaunchesActivity(true);
        NotificationCompat.Action action_noti_action =
                new NotificationCompat.Action.Builder(
                        R.drawable.ic_action_time,
                        "Send Alert ",
                        viewPendingIntent)
                        .extend(inlineActionForWear2)
                        .build();
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this, id)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle("Action noti")
                        .setContentText("Notification can be a simple notification but with action component")
                        .setContentIntent(viewPendingIntent2)
                        .setChannelId(id)
                        .addAction(action_noti_action);
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(this);
        notificationManager.notify(notificationID, notificationBuilder.build());
        notificationID++;

    }



    private void Createchannel() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            NotificationChannel mChannel = new NotificationChannel(id,
                    "My_channel",
                    NotificationManager.IMPORTANCE_DEFAULT);
            mChannel.setDescription("this is a test channel");
            mChannel.enableLights(true);
            mChannel.setLightColor(Color.RED);
            mChannel.enableVibration(true);
            mChannel.setShowBadge(true);
            mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            nm.createNotificationChannel(mChannel);

        }
    }
}