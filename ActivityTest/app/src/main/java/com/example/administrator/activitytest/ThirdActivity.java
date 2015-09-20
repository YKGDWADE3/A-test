package com.example.administrator.activitytest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;


/**
 * Created by Administrator on 2015/9/10.
 */
public class ThirdActivity extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d("ThirdActivity", "Task is" + getTaskId());
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.third_activity);
        Button button3 = (Button) findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCollector.finishAll();
            }
        });
    }
}
