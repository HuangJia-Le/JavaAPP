package com.example.vrvedio;

import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.MediaController;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;

public class secondActivity extends AppCompatActivity {

    private VideoView videoView;
    private MediaPlayer mediaplayer;
    private SurfaceView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        try {
            initvideo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initvideo() throws IOException {
        //资源地址
        String uri="android.resource://"+getPackageName()+"/"+R.raw.airg1;
        //创建SurfaceView，视频播放在SurfaceView容器内部
        sv= findViewById(R.id.view);
        //创建MediaPlayer对象，搭配SurfaceHolder进行一系列视频播放操作
        SurfaceHolder holder = sv.getHolder();
        holder.addCallback((SurfaceHolder.Callback) this);
        ////设置显示视频显示在SurfaceView上
        mediaplayer=new MediaPlayer();
        mediaplayer.setDataSource(this,Uri.parse(uri));
        mediaplayer.setDisplay(holder);
        ////异步方式播放视频
        mediaplayer.prepareAsync();
        mediaplayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mediaplayer.start();
            }
        });
    }
}