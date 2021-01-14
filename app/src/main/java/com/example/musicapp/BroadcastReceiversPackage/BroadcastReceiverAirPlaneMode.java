package com.example.musicapp.BroadcastReceiversPackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BroadcastReceiverAirPlaneMode extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        assert action != null;
        if (Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(action)) {
            Toast.makeText(context, "The plane mode is changed", Toast.LENGTH_LONG).show();
        }
    }

}
