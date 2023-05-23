package com.example.vrvedio;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;

import java.io.IOException;

public class secondActivity extends AppCompatActivity implements View.OnClickListener{

    private MediaPlayer mediaplayer;
    private SurfaceView sv;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initvideo();

    }

    private void initvideo()  {
        //添加权限
        ActivityCompat.requestPermissions(this,new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
        //资源地址
        String uri="android.resource://"+getPackageName()+"/"+R.raw.airg1;
        //创建SurfaceView，视频播放在SurfaceView容器内部
        sv= findViewById(R.id.view);
        ////设置显示视频显示在SurfaceView上
        mediaplayer=new MediaPlayer();
        try {
            mediaplayer.setDataSource(this,Uri.parse(uri));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ////异步方式播放视频
        mediaplayer.prepareAsync();
        mediaplayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mediaplayer.setDisplay(sv.getHolder());
                mediaplayer.start();
            }
        });
        btn = findViewById(R.id.btn2);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(secondActivity.this,MainActivity.class);
        startActivity(intent);//完成跳转
    }
}