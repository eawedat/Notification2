package com.example.eawedat.notification2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;
import android.os.Vibrator;

/**
 * Created by eawedat on 4/26/2018.
 */

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // show toast
        Toast.makeText(context, "Alarm running", Toast.LENGTH_LONG).show();
        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        // Vibrate for 500 milliseconds

        //deprecated in API 26
        v.vibrate(500);
    }
}