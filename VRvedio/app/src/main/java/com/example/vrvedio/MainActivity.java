package com.example.vrvedio;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    private Button btn,btn1,btn2;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化方法
        initUI();
    }

    private void initUI() {
        //绑定按钮控件
        btn = findViewById(R.id.btn);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        //设置点击事件的监听器
        btn.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        //初始化视频播放
        String uri="android.resource://"+getPackageName()+"/"+R.raw.airg1;
        videoView = (VideoView)this.findViewById(R.id.video);
        videoView.setMediaController(new MediaController(this));
        videoView.setVideoURI(Uri.parse(uri));
        videoView.start();
        videoView.requestFocus();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn:
                //全屏播放，跳转第二个页面
                Intent intent = new Intent(MainActivity.this,secondActivity.class);
                startActivity(intent);//完成跳转
                break;
            case R.id.btn1:
                //播放视频
                if(videoView.isPlaying()){
                    videoView.pause();
                }
                break;
            case R.id.btn2:
                //暂停视频
                if(!videoView.isPlaying()){
                    videoView.start();
                }
                break;
        }
    }
}