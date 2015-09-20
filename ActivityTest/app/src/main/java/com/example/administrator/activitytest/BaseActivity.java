package com.example.administrator.activitytest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Administrator on 2015/9/12.
 */
public class BaseActivity extends Activity {
    @Override
    protected void  onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d("BaseActivity", getClass().getSimpleName());
        ActivityCollector.addActivity(this);
    }
    @Override
    protected  void onDestroy(){
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
