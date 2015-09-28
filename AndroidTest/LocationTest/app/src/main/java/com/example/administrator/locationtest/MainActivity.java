package com.example.administrator.locationtest;

import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.security.Provider;
import java.util.List;

public class MainActivity extends Activity {
    private TextView positionTextView;
    private LocationManager locationManager;
    private String provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        positionTextView = (TextView) findViewById(R.id.position_text_view);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        List<String> providerList = locationManager.getProviders(true);
        if (providerList.contains(LocationManager.GPS_PROVIDER) && providerList.contains(LocationManager.NETWORK_PROVIDER)){
            provider = LocationManager.GPS_PROVIDER;
        }else if (providerList.contains(LocationManager.NETWORK_PROVIDER)){
            provider = LocationManager.NETWORK_PROVIDER;
        }else{
            Toast.makeText(this,"No location provider to use",Toast.LENGTH_SHORT).show();
            return;
        }
        try{
            Location location = locationManager.getLastKnownLocation(provider);
            if (location !=null){
                showLocation(location);

            }
            locationManager.requestLocationUpdates(provider,5000,1,locationListener);
        }catch(Exception e){
            e.printStackTrace();
        }



    }
    protected void onDestroy(){
        super.onDestroy();
        try{
            if(locationManager!=null){
                locationManager.removeUpdates(locationListener);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            showLocation(location);
        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }
    };
    private void showLocation(Location location){
        String currentPosition = "latitude is " +location.getLatitude()+"\n"
                +"longitude is "+location.getLongitude();
        positionTextView.setText(currentPosition);
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
