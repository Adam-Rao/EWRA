package com.kareh.ewraapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.HashMap;

public class TransactionReceiver extends BroadcastReceiver {
    String confirmationCode, balance;
    public TransactionReceiver(){

    }
    @Override
    public void onReceive(Context context, Intent intent) {
        String uuid = intent.getStringExtra("uuid");
       // String confirmationCode, balance;
        if (intent.hasExtra("parsed_variables")) {
            HashMap<String, String> parsed_variables = (HashMap<String, String>) intent.getSerializableExtra("parsed_variables");
            if (parsed_variables.containsKey("confirmCode"))
                confirmationCode = parsed_variables.get("confirmCode");
            if (parsed_variables.containsKey("balance"))
                balance = parsed_variables.get("balance");
            successfulTranscations(context);
    }}
   private void successfulTranscations(Context context){
        if (balance.isEmpty()){
            return;
        }
        // TODO: SEND A NOTIFICATION TO A USER WITH THE CONFIRMATION DETAILS

        }
}
