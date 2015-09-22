package com.example.administrator.notificationtest;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    private Button sendNotice;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendNotice = (Button) findViewById(R.id.notification);
        context = this;

        sendNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.notification:
                        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        Intent intent = new Intent(MainActivity.this,NotificationActivity.class);
                        //新建一个intent，希望能触发一个活动
                        PendingIntent pi = PendingIntent.getActivity(MainActivity.this,0,intent,PendingIntent.FLAG_CANCEL_CURRENT);
                        //新建一个PendingIntent
                        //下面是更新后的notification新建对象方法
                        Notification notification = new Notification.Builder(MainActivity.this)
                                .setAutoCancel(true)//能否拒绝，就是滑动消除
                                .setWhen(System.currentTimeMillis())//触发时间
                                .setContentTitle("This is contentFile")//下拉通知栏标题
                                .setContentText("This is contentText")//下拉通知栏内容
                                .setSmallIcon(R.mipmap.ic_launcher)//状态栏的小图标
                                .setTicker("This is ticker")//状态栏内容
                                .setContentIntent(pi)//点击通知栏触发事件
                                .build();

                        manager.notify(1,notification);
                        break;
                    default:
                        break;



                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
