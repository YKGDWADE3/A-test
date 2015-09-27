package com.example.administrator.networktest;

import android.app.Activity;
import android.net.http.HttpResponseCache;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.xml.parsers.SAXParserFactory;

public class MainActivity extends Activity implements View.OnClickListener{
    public static final int SHOW_RESPONSE = 0;
    private Button sendRequest;
    private TextView responseText;
    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case SHOW_RESPONSE:
                    String response = (String) msg.obj;
                    responseText.setText(response);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendRequest = (Button) findViewById(R.id.send_request);
        responseText = (TextView) findViewById(R.id.response);
        sendRequest.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        if (view.getId()==R.id.send_request){
            sendRequestWithHttpClient();
        }
    }
    private void sendRequestWithHttpClient(){
        new Thread(new Runnable() {
            @Override
            public void run() {

                try{
                    HttpClient httpClient = new DefaultHttpClient();//创建一个client实例
                    HttpGet httpGet = new HttpGet("http://192.168.191.1/get_data.json");//从这个地方拿数据
                    HttpResponse httpResponse = httpClient.execute(httpGet);//使用client实例执行拿数据的地方返回一个response
                    if (httpResponse.getStatusLine().getStatusCode()==200){//如果编码什么的是200
                        HttpEntity entity = httpResponse.getEntity();//创建一个可以搜集数据的实例，通过response
                        String response = EntityUtils.toString(entity,"utf-8");//将搜集的东西按照utf-8转码
                        parseXMLWithGSON(response);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
    private void parseXMLWithGSON(String jsonData){
        try{
            Gson gson = new Gson();
            //TypeToken 将期望解析成的数据类型传入到 fromJson()方法中，下面只针对数组数据
            //如果是一个简单的数据只需 App app = gson.fromJson(jsonData,App.class)
            List<App> appList = gson.fromJson(jsonData,new TypeToken<List<App>>() {}.getType());
            for (App app:appList){
                Log.d("MainActivity","id is "+app.getId());
                Log.d("MainActivity","name is "+app.getName());
                Log.d("MainActivity","version is" +app.getVersion());
            }

        }catch(Exception e){
            e.printStackTrace();
        }
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
