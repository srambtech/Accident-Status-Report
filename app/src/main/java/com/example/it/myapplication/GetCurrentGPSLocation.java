package com.example.it.myapplication;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;


public class GetCurrentGPSLocation extends AppCompatActivity implements LocationListener {

    LocationManager locationManager;
    String mprovider;

    Bitmap bitmap;
    File fn;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_current_gpslocation);



        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();

        mprovider = locationManager.getBestProvider(criteria, false);

        if (mprovider != null && !mprovider.equals("")) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            Location location = locationManager.getLastKnownLocation(mprovider);
            locationManager.requestLocationUpdates(mprovider, 15000, 1, this);

            if (location != null)
                onLocationChanged(location);
            else
                Toast.makeText(getBaseContext(), "No Location Provider Found Check Your Code", Toast.LENGTH_SHORT).show();
        }






    }







    @Override
    public void onLocationChanged(Location location) {
        TextView longitude = (TextView) findViewById(R.id.textView);
        TextView latitude = (TextView) findViewById(R.id.textView1);

        longitude.setText("Current Longitude:" + location.getLongitude());
        latitude.setText("Current Latitude:" + location.getLatitude());
    }


    public void captureScreen() {
        GoogleMap.SnapshotReadyCallback callback = new GoogleMap.SnapshotReadyCallback() {

            @Override
            public void onSnapshotReady(Bitmap snapshot) {
                // TODO Auto-generated method stub
                bitmap = snapshot;
                File sampleDir = new File(Environment.getExternalStorageDirectory(), "");
                // Created directory if not exist
                if (!sampleDir.exists()) {
                    sampleDir.mkdirs();
                }
                Date d = new Date();
                fn = new File(sampleDir + "/" + "Map" + d.getTime() + ".png");

                //OutputStream fout = null;

                // String filePath = System.currentTimeMillis() + "1.jpeg";

                try {
                    // fout = openFileOutput(filePath,
                    //       MODE_WORLD_READABLE);

                    // Write the string to the file
                    FileOutputStream fout = new FileOutputStream(fn);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fout);
                    fout.flush();
                    fout.close();
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    Log.d("ImageCapture", "FileNotFoundException");
                    Log.d("ImageCapture", e.getMessage());
                    //filePath = "";
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    Log.d("ImageCapture", "IOException");
                    Log.d("ImageCapture", e.getMessage());
                    //filePath = "";
                }


            }
        };


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
}