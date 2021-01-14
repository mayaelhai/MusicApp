package com.example.musicapp.BroadcastReceiversPackage;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import com.example.musicapp.PagesPackage.AlarmActivity;
import com.example.musicapp.R;

import java.util.Calendar;
import java.util.Date;

public class BroadcastReceiverAlarm extends BroadcastReceiver {

    private NotificationManager notificationManager;
    private NotificationCompat.Builder builder;
    private static PendingIntent pendingIntentSnooze, pendingIntent;
    private static AlarmManager alarmManagerSnooze;

    @Override
    public void onReceive(Context context, Intent intent) {
        final int NOTIFY_ID = 1;
        String id = "1";
        String title = "Playlist";
        if (notificationManager == null) {
            notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = notificationManager.getNotificationChannel(id);
            if (mChannel == null) {
                mChannel = new NotificationChannel(id, title, importance);
                mChannel.enableVibration(true);
                mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
                notificationManager.createNotificationChannel(mChannel);
            }
            getBuilder(context, id);
        } else {
            getBuilder(context, id);
        }
        Notification notification = builder.build();
        notificationManager.notify(NOTIFY_ID, notification);

        Intent intentSnooze = new Intent(context, BroadcastReceiverAlarm.class);
        pendingIntentSnooze = PendingIntent.getBroadcast(context, 1, intentSnooze, 0);
        alarmManagerSnooze = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 1440);
        Date date = calendar.getTime();
        alarmManagerSnooze.set(AlarmManager.RTC_WAKEUP, date.getTime(), pendingIntentSnooze);
    }

    private void getBuilder(Context context, String id) {
        builder = new NotificationCompat.Builder(context, id);
        Intent intent = new Intent(context, AlarmActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        pendingIntent = PendingIntent.getActivity(context, 1, intent, 0);
        builder.setContentTitle("Playlist")
                .setContentText("It's time to play playlist")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setDefaults(Notification.DEFAULT_ALL)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setTicker("תפילה")
                .setVibrate(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400})
                .setPriority(Notification.PRIORITY_HIGH)
                .addAction(R.mipmap.ic_launcher, "It's time to play playlist", pendingIntentSnooze);
    }

}
