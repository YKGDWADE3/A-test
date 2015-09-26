package com.example.administrator.servicetest;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Administrator on 2015/9/26.
 */
public class MyIntentSercice extends IntentService {
    public MyIntentSercice(){
        super("MyIntentService");
    }
    @Override
    protected void onHandleIntent(Intent intent){
        Log.d("MyIntentService","Thread id is "+Thread.currentThread().getId());
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("MyIntentService","onDestroy executed");
    }
}
