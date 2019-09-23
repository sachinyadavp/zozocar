package com.app.zozocar.view.fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.app.zozocar.R;
import com.app.zozocar.view.activity.HomeActivity;
import com.app.zozocar.view.activity.PickUpActivity;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

public class SelectRideFragment extends Fragment implements View.OnClickListener {
    TextView tv_offer_ride,tv_find_ride;
    LocationRequest mLocationRequest;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View  view=LayoutInflater.from(getContext()).inflate(R.layout.fragment_ride,container,false);
      init(view);
      return view;
    }
    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.tv_find_ride)
        {
            HomeActivity homeActivity=(HomeActivity) getActivity();
            homeActivity.loadfragment1("FindRide");
        }
        if (v.getId()==R.id.tv_offer_ride)
        {
            Intent in=new Intent(getContext(), PickUpActivity.class);
            startActivity(in);
        }
    }
    public void init(View view)
    {
        tv_find_ride=view.findViewById(R.id.tv_find_ride);
        tv_offer_ride=view.findViewById(R.id.tv_offer_ride);
        tv_offer_ride.setOnClickListener(this);
        tv_find_ride.setOnClickListener(this);
    }
}
