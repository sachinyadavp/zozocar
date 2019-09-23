package com.app.zozocar.view.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.app.zozocar.AppConstant;
import com.app.zozocar.R;
import com.app.zozocar.model.Model;
import com.app.zozocar.view.fragment.FindRideFragment;
import com.app.zozocar.view.fragment.NotificationFragment;
import com.app.zozocar.view.fragment.SelectRideFragment;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
//import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.sdsmdg.harjot.materialshadows.MaterialShadowViewWrapper;
//mport com.sdsmdg.harjot.materialshadows.MaterialShadowViewWrapper;i
import java.io.IOException;
import java.util.List;
import java.util.Locale;
//import com.shivtechs.maplocationpicker.LocationPickerActivity;
//import com.shivtechs.maplocationpicker.MapUtility;
public class HomeActivity extends AppCompatActivity {
    private TextView mTextMessage;
    LocationRequest mLocationRequest;
    MaterialShadowViewWrapper shdow;
    int old_id=1;
    BottomNavigationView navigationView;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_ride:
                    AppConstant.count=1;
                    old_id=1;
loadfragment("SelectRide");
                    return true;
                case R.id.nav_search_ride:
                    AppConstant.count=2;
                    old_id=2;
                    loadfragment("FindRide");
                   // mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.nav_post_ride:
                    AppConstant.count=3;
                    Intent in=new Intent(HomeActivity.this, PickUpActivity.class);
                    startActivity(in);
                    return true;
                    case R.id.nav_notification:
                        AppConstant.count=4;
                        old_id=4;
                        loadfragment("Notification");
                        return true;
                 //   mTextMessage.setText(R.string.title_notifications);
                case R.id.nav_user:
                    AppConstant.count=5;
                    Intent in1=new Intent(HomeActivity.this, UserActivity.class);
                    startActivity(in1);
                    //   mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        chekPermissions();
       // shdow=findViewById(R.id.shadow);
FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
SelectRideFragment fragment=new SelectRideFragment();
        ft.add(R.id.container, fragment, "SelectRide");
        ft.addToBackStack("SelectRide");
        ft.commit();
        //MapUtility.apiKey = getResources().getString(R.string.api_key);
      //  mTextMessage = (TextView) findViewById(R.id.message);
         navigationView = (BottomNavigationView) findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//        SupportMapFragment frag = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
//        frag.getMapAsync(new OnMapReadyCallback() {
//            @Override
//            public void onMapReady(final GoogleMap googleMap) {
//                LatLng barcelona = new LatLng(28.4669, 77.0665);
//             //   googleMap.addMarker(new MarkerOptions().position(barcelona));
//                // map.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(list.get(0).latitude, list.get(0).longitude), 16f));
//                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(barcelona,14f));
//                googleMap.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() {
//                    @Override
//                    public void onCameraMove() {
//                    }
//                });
//                googleMap.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() {
//                    @Override
//                    public void onCameraIdle() {
//                        LatLng latLng=googleMap.getCameraPosition().target;
//                        Geocoder gcd = new Geocoder(HomeActivity.this, Locale.getDefault());
//                        try {
//                            Geocoder geocoder = new Geocoder(HomeActivity.this, Locale.getDefault());
//                            List<Address> addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
//                            if (addresses != null && addresses.size() > 0) {
//                                String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
//                                String city = addresses.get(0).getLocality();
//                                String state = addresses.get(0).getAdminArea();
//                                String country = addresses.get(0).getCountryName();
//                                String postalCode = addresses.get(0).getPostalCode();
//                                String knownName = addresses.get(0).getFeatureName(); // Only if available else return NULL
//
//                              mTextMessage.setText(address);
//                            }
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                        Log.e("Location is",latLng.latitude+" and "+latLng.longitude);
//                    }
//                });
//            }
//        });
        addBadgeView();
    }
    public void loadfragment(String name)
    {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(name);
        if (fragment == null) {
            switch (name) {
                case "SelectRide": {
                    fragment = new SelectRideFragment();
                    break;
                }
                case "FindRide": {
                    fragment = new FindRideFragment();
                    break;
                }
                case "Notification":{
                    fragment=new NotificationFragment();
                    break;
                }
            }
            ft.replace(R.id.container, fragment, name);
            ft.addToBackStack(name);
            ft.commit();
        } else {
            ft.replace(R.id.container, fragment, name);
            ft.commit();
        }
    }
    public void loadfragment1(String name)
    {
        AppConstant.count=2;
        old_id=2;
        navigationView.getMenu().findItem(R.id.nav_search_ride).setChecked(true);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(name);
        if (fragment == null) {
            switch (name) {
                case "SelectRide": {
                    fragment = new SelectRideFragment();
                    break;
                }
                case "FindRide": {
                    fragment = new FindRideFragment();
                    break;
                }
            }
            ft.replace(R.id.container, fragment, name);
            ft.addToBackStack(name);
            ft.commit();
        } else {
            ft.replace(R.id.container, fragment, name);
            ft.commit();
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (AppConstant.count==1)
        {
            navigationView.getMenu().findItem(R.id.nav_ride).setChecked(true);

            AppConstant.count=0;
        }
        else {
            finish();
        }
    }
    public  void  chekPermissions() {
        Dexter.withActivity(this)
                .withPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        startLocationUpdates();
                    }
                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {
                        if (response.isPermanentlyDenied()) {
                        }
                    }
                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest
                                                                           permission, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();
    }
    protected void startLocationUpdates() {
        // Create the location request to start receiving updates
        mLocationRequest = new LocationRequest();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        // Create LocationSettingsRequest object using location request
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder();
        builder.addLocationRequest(mLocationRequest);
        builder.setAlwaysShow(true);
        LocationSettingsRequest locationSettingsRequest = builder.build();
        // Check whether location settings are satisfied
        // https://developers.google.com/android/reference/com/google/android/gms/location/SettingsClient
        SettingsClient settingsClient = LocationServices.getSettingsClient(this);
        settingsClient.checkLocationSettings(locationSettingsRequest);
        settingsClient
                .checkLocationSettings(locationSettingsRequest)
                .addOnSuccessListener(this, new OnSuccessListener<LocationSettingsResponse>() {
                    @SuppressLint("MissingPermission")
                    @Override
                    public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
                        // gpsService.startTracking();
                        // getLastLocation();
                    }
                })
                .addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        int statusCode = ((ApiException) e).getStatusCode();
                        switch (statusCode) {
                            case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                                try {
                                    // Show the dialog by calling startResolutionForResult(), and check the
                                    // result in onActivityResult().
                                    ResolvableApiException rae = (ResolvableApiException) e;
                                    rae.startResolutionForResult(HomeActivity.this, 100);
                                } catch (IntentSender.SendIntentException sie) {
                                    // Log.i(TAG, "PendingIntent unable to execute request.");
                                }
                                break;
                            case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                                String errorMessage = "Location settings are inadequate, and cannot be " +
                                        "fixed here. Fix in Settings.";
                                //Log.e(TAG, errorMessage);

                                Toast.makeText(HomeActivity.this, errorMessage, Toast.LENGTH_LONG).show();
                        }
                        //updateLocationUI();
                    }
                });
        // new Google API SDK v11 uses getFusedLocationProviderClient(this
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length>0)
        {
            Log.e("hello 4","hi");
            startLocationUpdates();
        }
        if (requestCode==100)
        {
            Log.e("hello 3","hi");
            startLocationUpdates();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==102) {
            startLocationUpdates();
            Location location = (Location) data.getExtras().get("location");
            if (location != null) {
                String cityName = null;
                String state = null;
                Geocoder gcd = new Geocoder(this, Locale.getDefault());
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
                       // tv_current_city.setText(cityName + ", " + state);
                        Log.e("the city name", cityName + " and state " + state);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (requestCode==200)
        {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
          FindRideFragment fragment = (FindRideFragment) getSupportFragmentManager().findFragmentByTag("FindRide");
            Model model=(Model) data.getExtras().get("data");
            fragment.setadata(model);

        }
        Log.e("hello 2 request c","hi"+requestCode);

    }
    private void addBadgeView() {
        try {
            BottomNavigationMenuView menuView = (BottomNavigationMenuView)navigationView.getChildAt(0);
            BottomNavigationItemView itemView = (BottomNavigationItemView) menuView.getChildAt(3); //set this to 0, 1, 2, or 3.. accordingly which menu item of the bottom bar you want to show badge
           View notificationBadge = LayoutInflater.from(HomeActivity.this).inflate(R.layout.notification_badge_view, menuView, false);
            itemView.addView(notificationBadge);
           // notificationBadge.setVisibility(View.GONE);// initially badge will be invisible
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.e("print da",old_id+" and "+AppConstant.count);
        if (AppConstant.count==5)
        {
            Log.e("print da",old_id+" and "+AppConstant.count);
            if (old_id==1)
            {
                navigationView.getMenu().findItem(R.id.nav_ride).setChecked(true);
            }
            else   if (old_id==2)
                navigationView.getMenu().findItem(R.id.nav_search_ride).setChecked(true);
            else
                navigationView.getMenu().findItem(R.id.nav_notification).setChecked(true);

            AppConstant.count=1;
        }
        else  if (AppConstant.count==3)
        {
            Log.e("print da",old_id+" and "+AppConstant.count);
            if (old_id==1)
            {
                navigationView.getMenu().findItem(R.id.nav_ride).setChecked(true);
            }
            else
                if (old_id==2)
                    navigationView.getMenu().findItem(R.id.nav_search_ride).setChecked(true);
                else
                    navigationView.getMenu().findItem(R.id.nav_notification).setChecked(true);
            AppConstant.count=1;
        }
    }
}
