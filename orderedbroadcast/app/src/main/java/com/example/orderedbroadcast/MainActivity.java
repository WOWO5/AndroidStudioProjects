package com.example.orderedbroadcast;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MyBroadcastReceiverTwo receiver=new MyBroadcastReceiverTwo();
    String action="com.example.MybroadcastReceiver.hellow";
    IntentFilter intentFilter=new IntentFilter(action);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerReceiver(receiver,intentFilter);
    }
    public void send(View view){
        Intent intent = new Intent();
        intent.setAction("com.example.MybroadcastReceiver.hellow");
      //  intent.putExtra("msg","hellow");
        sendOrderedBroadcast(intent,null);
    }
}
