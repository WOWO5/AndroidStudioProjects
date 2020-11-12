package com.example.weather;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvCity;
    private TextView tvWeather;
    private TextView tvTemp;
    private TextView tvPm;
    private ImageView ivIcon;
    private TextView tvWind;
    private Map<String,String> map;
    private List<Map<String,String>> list;
    private String temp;
    private String name;
    private String pm;
    private String wind;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        try {
            //InputStream is = this.getResources().openRawResource(R.raw.weather1);
            InputStream is = this.getResources().openRawResource(R.raw.weather);
            //List<WeatherInfo> weatherInfos = WeatherService.getInfosFromXML(is);
            List<WeatherInfo> weatherInfos = WeatherService.getInfosFromJson(is);
            list = new ArrayList<Map<String, String>>();
            for (WeatherInfo info:weatherInfos){
                map = new HashMap<String, String>();
                map.put("temp",info.getTemp());
                map.put("weather",info.getWeather());
                map.put("name",info.getName());
                map.put("pm",info.getPm());
                map.put("wind",info.getWind());
                list.add(map);
            }
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this,"解析信息失败",Toast.LENGTH_SHORT).show();
        }
        getMap(1,R.drawable.sun);
    }
    private void initView(){
        tvCity = (TextView) findViewById(R.id.tv_city);
        tvWeather = (TextView) findViewById(R.id.tv_weather);
        tvTemp = (TextView) findViewById(R.id.tv_temp);
        tvPm = (TextView) findViewById(R.id.tv_pm);
        ivIcon = (ImageView) findViewById(R.id.iv_icon);
        tvWind=(TextView)findViewById(R.id.tv_wind);
        findViewById(R.id.btn_sh).setOnClickListener(this);
        findViewById(R.id.btn_bj).setOnClickListener(this);
        findViewById(R.id.btn_gz).setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_sh:
                getMap(0,R.drawable.cloud_sun);
                break;
            case R.id.btn_bj:
                getMap(1,R.drawable.sun);
                break;
            case R.id.btn_gz:
                getMap(2,R.drawable.clouds);
                break;
        }
    }
    private void getMap(int number,int iconNumber){
        Map<String,String> cityMap = list.get(number);
        temp = cityMap.get("temp");
        pm = cityMap.get("pm");
        name = cityMap.get("name");
        wind = cityMap.get("wind");
        String weather = cityMap.get("weather");
        tvCity.setText(name);
        tvWeather.setText(""+weather);
        tvTemp.setText(temp);
        tvPm.setText("pm:"+pm);
        tvWind.setText("风力:"+wind);
        ivIcon.setImageResource(iconNumber);
    }
}