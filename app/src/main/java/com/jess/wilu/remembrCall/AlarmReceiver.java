package com.jess.wilu.remembrCall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class AlarmReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        String tittle = intent.getStringExtra("tittle");
        String message = intent.getStringExtra("message");
        int id = Integer.parseInt(intent.getStringExtra("id"));
        String phoneNumber = intent.getStringExtra("phoneNumber");
        new CallNotification().showNotification(message,tittle,context, id, phoneNumber);

    }



}