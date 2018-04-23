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

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static NotificationManager mNotificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initUI();

        mNotificationManager = (NotificationManager)
                getApplicationContext().getSystemService(NOTIFICATION_SERVICE);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("channel", "channel",
                    NotificationManager.IMPORTANCE_DEFAULT);
            mNotificationManager.createNotificationChannel(channel);
        }
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
        NotificationCompat.Builder notification =
                new NotificationCompat.Builder(context, "");

        Intent intent = new Intent(context, ResultadoActivity.class);
        PendingIntent pendingIntent =
                PendingIntent.getActivity(
                        context, 0, intent, 0);

        long[] v = {0, 400, 100, 300, 200, 300};
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        notification.setContentTitle("Notificacion simple");
        notification.setContentText("Esta es una notificacion de ejemplo");
        notification.setSubText("Mensajito subtext");
        notification.setSmallIcon(R.drawable.ic_android_black_24dp);
        notification.setLargeIcon(
                BitmapFactory.decodeResource(context.getResources(),
                        R.drawable.ic_android_black_24dp));
        notification.setContentIntent(pendingIntent);
        //notification.setAutoCancel(true);
        notification.setOngoing(true);
        notification.setVibrate(v);
        notification.setSound(uri);

        mNotificationManager.notify(1, notification.build());
    }

    public void createExpandableNotification (Context context) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            NotificationCompat.Builder notification =
                    new NotificationCompat.Builder(context, "");
            notification.setSmallIcon(R.drawable.ic_android_black_24dp);
            notification.setLargeIcon(
                    BitmapFactory.decodeResource(context.getResources(),
                            R.drawable.ic_android_black_24dp));
            notification.setContentTitle("Notificacion expandible");
            notification.setContentText("Contenido notificacion");

            NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
            String lorem = context.getResources().getString(R.string.long_lorem);
            String []content = lorem.split("\\.");
            for(String line : content) {
                inboxStyle.addLine(line);
            }
            inboxStyle.setBigContentTitle("Titulo Inbox Style");

            notification.setSubText("Contenido subtext");
            notification.setStyle(inboxStyle);

            mNotificationManager.notify(2, notification.build());

        } else {
            createSimpleNotification(this);
        }
    }

    public void createBigImageNotification(Context context) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            NotificationCompat.Builder notification =
                    new NotificationCompat.Builder(context, "");
            notification.setContentTitle("Titulo Big Image Notification");
            notification.setContentText("Contenido notificacion");

            NotificationCompat.BigPictureStyle bigPictureStyle =
                    new NotificationCompat.BigPictureStyle();
            bigPictureStyle.bigPicture(BitmapFactory.decodeResource(
                    getResources(), R.drawable.banner));

            notification.setStyle(bigPictureStyle);
            notification.setSmallIcon(R.drawable.ic_android_black_24dp);

            mNotificationManager.notify(3, notification.build());

        } else {
            createSimpleNotification(this);
        }
    }

    public void createProgressNotification (final Context context) {
        final int progresID = new Random().nextInt(1000);

        final NotificationCompat.Builder notification =
                new NotificationCompat.Builder(context, "");
        notification.setSmallIcon(R.drawable.ic_android_black_24dp);
        notification.setContentTitle("Titulo de la notificacion");
        notification.setContentText("Contenido de la notificacion");
        notification.setTicker("Notificacion de progreso creada");
        notification.setUsesChronometer(true);
        notification.setProgress(100, 0, true);

        AsyncTask<Integer, Integer, Integer> downloadTask = new AsyncTask<Integer, Integer, Integer>() {
            @Override
            protected void onPreExecute () {
                super.onPreExecute();
                mNotificationManager.notify(progresID, notification.build());
            }

            @Override
            protected Integer doInBackground (Integer... params) {
                try {
                    Thread.sleep(5000);
                    for (int i = 0; i < 101; i+=5) {

                        notification.setContentTitle("En progreso...");
                        notification.setContentText("Se esta ejecutando un proceso...");
                        notification.setProgress(100, i, false);
                        notification.setSmallIcon(R.drawable.ic_android_black_24dp);
                        notification.setContentInfo(i + "%");

                        mNotificationManager.notify(progresID, notification.build());

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
                notification.setContentTitle("Progreso terminado");
                notification.setContentText("El progreso de carga termino.");
                notification.setSmallIcon(R.drawable.ic_android_black_24dp);
                notification.setTicker("El progreso termino");
                notification.setUsesChronometer(false);
                notification.setProgress(0, 0, false);

                mNotificationManager.notify(progresID, notification.build());
            }
        };
        downloadTask.execute();
    }

    public void createButtonNotification (Context context) {
        if (Build.VERSION.SDK_INT >+ Build.VERSION_CODES.JELLY_BEAN) {
            Intent intent = new Intent(context, ResultadoActivity.class);
            PendingIntent pendingIntent =
                    PendingIntent.getActivity(context, 0, intent, 0);

            NotificationCompat.Builder notification =
                    new NotificationCompat.Builder(context, "");
            notification.setSmallIcon(R.drawable.ic_android_black_24dp);
            notification.setContentTitle("Notificacion con botones");
            notification.setContentText("Contenido de la notificacion");
            notification.addAction(android.R.drawable.ic_menu_call, "Llamar", pendingIntent);
            notification.addAction(android.R.drawable.ic_menu_camera, "Camara", pendingIntent);

            mNotificationManager.notify(1, notification.build());


        } else {

        }
    }



}
