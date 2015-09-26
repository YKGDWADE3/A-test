package com.example.administrator.servicetest;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.webkit.DownloadListener;

/**
 * Created by Administrator on 2015/9/24.
 */
public class Myservice extends Service {
    private DownloadBinder mBinder = new DownloadBinder();
    class DownloadBinder extends Binder{
        public void startDownload(){
            Log.d("MyService","startDownload excuted");
        }
        public int getProgress(){
            Log.d("MyService","getProgress executed");
            return 0;
        }
    }
    @Override
    public IBinder onBind(Intent intent){
        return mBinder;
    }
    @Override
    public void onCreate(){
        super.onCreate();

        Intent notificationIntent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,notificationIntent,0);
        Notification notification = new Notification.Builder(getApplicationContext())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("This is title")
                .setWhen(System.currentTimeMillis())
                .setTicker("Notificition comes")
                .setContentIntent(pendingIntent)
                .setContentText("This is a content").build();
        startForeground(1,notification);

        Log.d("MyService", "onCreate executed");
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId ){
        Log.d("MyService", "onStartCommand executed");
        return super.onStartCommand(intent,flags,startId);
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("MyService", "onDestroy executed");
    }
}
