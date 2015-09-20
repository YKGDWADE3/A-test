package com.example.administrator.activitylifecycletest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity {
    public static final String Tag ="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(Tag, "onCreate");
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        if (savedInstanceState!=null){
            String tempData = savedInstanceState.getString("data_key");
            Log.d(Tag,tempData);
        }
        Button startNormalActivity =(Button) findViewById(R.id.start_normal_activity);
        Button startDialogActivity =(Button) findViewById(R.id.start_dialog_activity);
        startNormalActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,NormalActivity.class);
                startActivity(intent);
            }
        });
        startDialogActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,DialogActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected  void onStart(){
        super.onStart();
        Log.d(Tag, "onStart");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(Tag,"onResume");
    }
    @Override
    protected  void onPause(){
        super.onPause();
        Log.d(Tag, "onPause");
    }
    @Override
    protected  void onStop(){
        super.onStop();
        Log.d(Tag, "onStop");
    }
    @Override
    protected  void onDestroy(){
        super.onDestroy();
        Log.d(Tag, "onDestroy");
    }
    @Override
    protected  void onRestart(){
        super.onRestart();
        Log.d(Tag, "onRestart");
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

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        String tempData = "Something you just typed";
        outState.putString("data_key",tempData);
    }
}
