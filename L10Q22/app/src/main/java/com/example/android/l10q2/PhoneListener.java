package com.example.android.l10q2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class PhoneListener extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Log.d("PhoneListener","Phone Call Received");
        Toast.makeText(context,"Phone Call Received",Toast.LENGTH_LONG);
        throw new UnsupportedOperationException("Not yet implemented");
    }
}