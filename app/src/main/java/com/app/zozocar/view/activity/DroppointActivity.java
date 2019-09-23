package com.app.zozocar.view.activity;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.zozocar.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class DroppointActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView iv_next;
    EditText et_city;
    TextView tv_current_location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_droppoint);
        init();
    }
    public  void init()
    {
        iv_next=findViewById(R.id.iv_next);
        et_city=findViewById(R.id.et_city);
        tv_current_location=findViewById(R.id.tv_current_location);
        tv_current_location.setOnClickListener(this);
        iv_next.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.tv_current_location)
        {
            getLastLocation();
        }
        else {
            Intent intent = new Intent(DroppointActivity.this, SelectDateActivity.class);
            startActivity(intent);
        }
    }
    public void getLastLocation() {
        // Get last known recent location using new Google Play Services SDK (v11+)
        FusedLocationProviderClient locationClient = LocationServices.getFusedLocationProviderClient(this);
        locationClient.getLastLocation()
                .addOnSuccessListener(new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location != null) {
                            String cityName = null;
                            String state = null;
                            Geocoder gcd = new Geocoder(DroppointActivity.this, Locale.getDefault());
                            try {

                                List<Address> addresses = gcd.getFromLocation(location.getLatitude(), location.getLongitude(),
                                        10);
                                state = addresses.get(0).getAdminArea();
                                for (Address adrs : addresses) {
                                    if (adrs != null) {

                                        String city = adrs.getLocality();
                                        if (city != null && !city.equals("")) {
                                            cityName = city;
                                            System.out.println("city ::  " + cityName);
                                        } else {

                                        }
                                    }
                                    et_city.setText(cityName+", "+state);
                                    Log.e("the city name", cityName + " and state " + state);
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Log.d("MapDemoActivity", "Error trying to get last GPS location");
                        e.printStackTrace();
                    }
                });}




}
