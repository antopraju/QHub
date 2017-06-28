package com.google.firebase.udacity.friendlychat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by Anthony Prajwal P on 24-05-2017.
 */

public class MyfirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage){
        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder notificationBuldier = new NotificationCompat.Builder(this);
        notificationBuldier.setContentTitle("FCM NOTIFICATION");
        notificationBuldier.setContentText(remoteMessage.getNotification().getBody());
        notificationBuldier.setAutoCancel(true);
        notificationBuldier.setSmallIcon(R.mipmap.ic_launcher);
        notificationBuldier.setContentIntent(pendingIntent);
        NotificationManager notificationManager =(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notificationBuldier.build());
    }
}
