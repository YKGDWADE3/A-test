package com.example.administrator.activitytest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;


/**
 * Created by Administrator on 2015/9/10.
 */
public class SecondActivity extends BaseActivity {
    public static  void actionStart(Context context,String data1,String data2){
        Intent intent = new Intent(context,SecondActivity.class);
        intent.putExtra("param1",data1);
        intent.putExtra("param2",data2);
        context.startActivity(intent);

    }
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        Log.d("SecondActivity","Task is" + getTaskId());
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.second_layout);
        Button button2 =(Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(intent);
                //String data = intent.getStringExtra("extra_data");
                //Log.d("SecondActivity",data);
                //intent.putExtra("data_return","Hello FirstActivity");
                //setResult(RESULT_OK,intent);
                //finish();
                //Toast.makeText(SecondActivity.this,"you click button2",Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("SecondActivity","SecondActivity destroy");
    }
}
