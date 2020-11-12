package com.example.musicplayer;


import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private File file;
    private EditText path;
    private String pathway;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        path=(EditText)findViewById(R.id.et_inputpath);

        Button btn_play=(Button) findViewById(R.id.btn_play);
        Button btn_pause=(Button)findViewById(R.id.btn_pause);
        btn_play.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                pathway=path.getText().toString().trim();
                File file=new File(pathway);
                if(file.exists()&&file.length()>0) {
                    if(mediaPlayer!=null)
                        mediaPlayer.pause();
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), Uri.parse(file.getAbsolutePath()));
                        mediaPlayer.start();
                }
                else{
                    Toast.makeText(getApplicationContext(),"找不到音乐文件",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_pause.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mediaPlayer.pause();
            }
        });
    }
}