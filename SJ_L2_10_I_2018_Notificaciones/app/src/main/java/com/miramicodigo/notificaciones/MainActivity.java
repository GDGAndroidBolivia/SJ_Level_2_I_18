package com.miramicodigo.notificaciones;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static NotificationManager mNotificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initUI();


    }

    private void initUI () {
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnNotificacionSimple).setOnClickListener(this);
        findViewById(R.id.btnNotificacionGrande).setOnClickListener(this);
        findViewById(R.id.btnNotificacionImagenGrande).setOnClickListener(this);
        findViewById(R.id.btnNotificacionProgreso).setOnClickListener(this);
        findViewById(R.id.btnNotificacionAcciones).setOnClickListener(this);
    }

    @Override
    public void onClick (View v) {
        switch (v.getId()) {
            case R.id.btnNotificacionSimple:
                createSimpleNotification(this);
                break;
            case R.id.btnNotificacionGrande:
                createExpandableNotification(this);
                break;
            case R.id.btnNotificacionImagenGrande:
                createBigImageNotification(this);
                break;
            case R.id.btnNotificacionProgreso:
                createProgressNotification(this);
                break;
            case R.id.btnNotificacionAcciones:
                createButtonNotification(this);
                break;
        }
    }

    public void createSimpleNotification(Context context) {

    }

    public void createExpandableNotification (Context context) {

    }

    public void createBigImageNotification(Context context) {

    }

    public void createProgressNotification (final Context context) {
        final int progresID = new Random().nextInt(1000);

        AsyncTask<Integer, Integer, Integer> downloadTask = new AsyncTask<Integer, Integer, Integer>() {
            @Override
            protected void onPreExecute () {
                super.onPreExecute();

            }

            @Override
            protected Integer doInBackground (Integer... params) {
                try {
                    Thread.sleep(5000);
                    for (int i = 0; i < 101; i+=5) {



                        Thread.sleep(500);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute (Integer integer) {
                super.onPostExecute(integer);


            }
        };
        downloadTask.execute();
    }

    public void createButtonNotification (Context context) {

    }

}
