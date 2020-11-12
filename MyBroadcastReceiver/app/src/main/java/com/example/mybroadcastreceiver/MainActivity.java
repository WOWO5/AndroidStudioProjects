package com.example.mybroadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MyBroadcastReceiver receiver1=new MyBroadcastReceiver();
    String action="com.example.MybroadcastReceiver.hellow";
    IntentFilter intentFilter1=new IntentFilter(action);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerReceiver(receiver1,intentFilter1);
    }
    public void send(View view){
        Intent intent = new Intent();
        intent.setAction("com.example.MybroadcastReceiver.hellow");
        intent.putExtra("msg","hellow");
        sendBroadcast(intent);
    }
}