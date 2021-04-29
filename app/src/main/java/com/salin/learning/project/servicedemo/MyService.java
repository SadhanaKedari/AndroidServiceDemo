package com.salin.learning.project.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService extends Service {

    String logStr = "ServiceDemo";
    MediaPlayer mMediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(logStr, "Inside onStartCommand");
        Log.i(logStr, "Id: " + Thread.currentThread().getName());

        mMediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ringtone);
        mMediaPlayer.setLooping(true);
        mMediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        Log.i(logStr, "Inside onDestroy");
        super.onDestroy();

        mMediaPlayer.stop();
    }
}
