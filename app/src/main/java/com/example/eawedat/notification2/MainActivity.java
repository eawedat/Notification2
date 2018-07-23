package com.example.eawedat.notification2;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    static final long interval = 1000 * 60 * 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (!prefs.getBoolean("firstTime", false)) {

            Intent alarmIntent = new Intent(this, AlarmReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, 0);

            AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            /*Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.set(Calendar.HOUR_OF_DAY, 3);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 1);*/


           /* manager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                    AlarmManager.INTERVAL_DAY, pendingIntent);*/

            manager.setRepeating(AlarmManager.RTC_WAKEUP, interval,
                    AlarmManager.INTERVAL_DAY, pendingIntent);

            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstTime", true);
            editor.apply();
        }
    }
}
