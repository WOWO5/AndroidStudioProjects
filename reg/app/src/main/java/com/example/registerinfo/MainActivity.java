package com.example.registerinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn=(Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String yonghuming=((EditText)findViewById(R.id.et_yonghuming)).getText().toString();
                String mima=((EditText)findViewById(R.id.et_mima)).getText().toString();
                Intent intent=new Intent(MainActivity.this,InfoActivity.class);
                Bundle bundle=new Bundle();
                bundle.putCharSequence("yonghuming",yonghuming);
                bundle.putCharSequence("mima",mima);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
