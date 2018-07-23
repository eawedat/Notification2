package com.example.eawedat.notification2;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;

/**
 * Created by eawedat on 4/26/2018.
 */

public class DeviceBootReceiver extends BroadcastReceiver {

    static final long interval = 1000 * 60 * 15;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            // on device boot compelete, reset the alarm
            Intent alarmIntent = new Intent(context, AlarmReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, alarmIntent, 0);

            AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

           /* Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.set(Calendar.HOUR_OF_DAY, 3);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 1);*/

            //manager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
            manager.setRepeating(AlarmManager.RTC_WAKEUP, interval, AlarmManager.INTERVAL_DAY, pendingIntent);
        }
    }
}