package com.example.orderedbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiverTwo extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Toast.makeText(context,"自定义的广播接收者Two，接收到了求救广播事件",Toast.LENGTH_SHORT).show();
        Log.i("MyBroadcastReceiverTwo","自定义的广播接收者Two，接收到了求救广播事件");
        abortBroadcast();
        Toast.makeText(context,"我是广播接收者Two，广播被我终结了",Toast.LENGTH_LONG).show();
    }
}
