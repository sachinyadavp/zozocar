package com.app.zozocar.view.fragment;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.zozocar.R;
import com.app.zozocar.model.Model;
import com.app.zozocar.utils.ConnectionDetector;
import com.app.zozocar.view.activity.PickUpActivity;
import com.app.zozocar.view.activity.RideListForYouActivity;
import com.app.zozocar.view.activity.SelectDateActivity;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class FindRideFragment extends Fragment implements View.OnClickListener ,Animation.AnimationListener{
    ImageView iv_find_ride,iv_current_location;
    Animation anim;
    EditText et_pick_point;
    TextView tv_date_time;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=LayoutInflater.from(getContext()).inflate(R.layout.fragment_find_a_ride,container,false);
       init(view);
       return view;
    }
    public void init(View view)
    {
        tv_date_time= view.findViewById(R.id.date_time);
        tv_date_time.setOnClickListener(this);
        iv_current_location=view.findViewById(R.id.iv_current_location);
        iv_current_location.setOnClickListener(this);
        et_pick_point=view.findViewById(R.id.et_pick_point);
        iv_find_ride=view.findViewById(R.id.iv_find_ride);
        iv_find_ride.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.iv_current_location)
        {
            ConnectionDetector connectionDetector=new ConnectionDetector(getContext());
            if (connectionDetector.isConnectingToInternet()) {
                anim = AnimationUtils.loadAnimation(getContext(), R.anim.rotaion_anim);
                anim.setAnimationListener(this);
                iv_current_location.startAnimation(anim);
            }
            else {
             ConnectionDetector.showAlertDialog(getContext(),"No Internet","Please on the internet",true);
            }
        }
        if (v.getId()==R.id.iv_find_ride){
            Intent intent = new Intent(getContext(), RideListForYouActivity.class);
            startActivity(intent);
        }
        if (v.getId()==R.id.date_time)
        {
            Intent intent = new Intent(getContext(), SelectDateActivity.class);
intent.putExtra("flag",1);
           startActivityForResult(intent,200);

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==200)
        {

            Model model=(Model) data.getExtras().get("data");
           setadata(model);

        }
        Log.e("hello 2  frag request c","hi"+requestCode);
    }

    public void getLastLocation() {
        // Get last known recent location using new Google Play Services SDK (v11+)
        FusedLocationProviderClient locationClient = LocationServices.getFusedLocationProviderClient(getActivity());
        locationClient.getLastLocation()
                .addOnSuccessListener(new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location != null) {
                            String cityName = null;
                            String state = null;
                            Geocoder gcd = new Geocoder(getContext(), Locale.getDefault());
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
                                    iv_current_location.clearAnimation();
                                   et_pick_point.setText(cityName+", "+state);
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
    @Override
    public void onAnimationStart(Animation animation) {
    }
    @Override
    public void onAnimationEnd(Animation animation) {
        getLastLocation();
    }
    @Override
    public void onAnimationRepeat(Animation animation) {
    }
    public  void setadata(Model model)
    {
        tv_date_time.setText(model.getDate()+"f"+model.getTime());
    }
}
