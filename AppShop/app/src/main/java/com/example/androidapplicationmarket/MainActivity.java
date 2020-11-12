package com.example.androidapplicationmarket;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private String[] names = {"淘宝","京东","天猫","苏宁","微信","QQ","UC浏览器","QQ浏览器"};
    private String[] names2 ={" "," "," "," "," "," "," "," "};
    private int[] icons = {R.drawable.tb,R.drawable.jd,R.drawable.tm,R.drawable.sn,R.drawable.wx,R.drawable.qq,R.drawable.uc,R.drawable.ql};
    private int[] the_icon = {R.drawable.download,R.drawable.download,R.drawable.download,R.drawable.download,R.drawable.download,R.drawable.download,R.drawable.download,R.drawable.download};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.lv);
        MyBaseAdapter mAdapter = new MyBaseAdapter();
        mListView.setAdapter(mAdapter);
    }
    class  MyBaseAdapter extends BaseAdapter{
        @Override
        public int getCount(){
            return  names.length;
        }
        @Override
        public Object getItem(int position){
            return names[position];
        }
        @Override
        public long getItemId(int position){
            return position;
        }
        @Override
        public View getView(int position,View convertView,ViewGroup parent){
            View view = View.inflate(MainActivity.this,R.layout.list_item,null);
            TextView mTextView = (TextView) view.findViewById(R.id.item_tv);
            mTextView.setText(names[position]);
            TextView mTextView2 = (TextView) view.findViewById(R.id.item_t);
            mTextView2.setText(names2[position]);
            ImageView imageView = (ImageView) view.findViewById(R.id.item_image);
            imageView.setBackgroundResource(icons[position]);
            ImageView imageView2 = (ImageView) view.findViewById(R.id.item_image2);
            imageView2.setBackgroundResource(the_icon[position]);
            return view;
        }
    }
}