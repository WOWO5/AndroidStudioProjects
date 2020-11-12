package com.example.registerinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String yonghuming=bundle.getString("yonghuming");
                String mima=bundle.getString("mima");
        TextView show_yonghuming=(TextView)findViewById(R.id.yonghuming);
                TextView show_mima=(TextView)findViewById(R.id.mima);
                show_yonghuming.setText(yonghuming);
                show_mima.setText(mima);
    }
}
