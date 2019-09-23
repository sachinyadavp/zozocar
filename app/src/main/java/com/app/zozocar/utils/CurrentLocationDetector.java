package com.app.zozocar.utils;

import android.content.Context;
import android.location.Location;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class CurrentLocationDetector {
    Location location;
    public void  getlocation(Context context)
    {

        FusedLocationProviderClient locationClient = LocationServices.getFusedLocationProviderClient(context);
        locationClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
               CurrentLocationDetector.this.location=location;
            }
        });
    }

}
