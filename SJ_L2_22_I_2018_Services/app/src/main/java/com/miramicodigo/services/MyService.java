package com.miramicodigo.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class MyService extends Service {

    private MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "Servicio creado", Toast.LENGTH_SHORT).show();
        player = MediaPlayer.create(this, R.raw.bon_jovi);
        player.setLooping(true);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Toast.makeText(this, "Servicio iniciado", Toast.LENGTH_SHORT).show();
        player.start();
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Servicio destruido", Toast.LENGTH_SHORT).show();
        player.stop();
    }
}
