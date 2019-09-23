package com.app.zozocar.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.zozocar.R;
import com.app.zozocar.view.activity.AddEmailActivity;
import com.app.zozocar.view.activity.AddMobileActivity;
import com.app.zozocar.view.activity.AddMyCarActivity;
import com.app.zozocar.view.activity.EditPreferencesActivity;
import com.app.zozocar.view.activity.EditProfileActivity;

public class UserDetailsFragment extends Fragment implements View.OnClickListener {
    TextView tv_addcar,tv_addbio,tv_preferences,tv_verify_email,tv_verify_mobile,tv_verify_id;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=LayoutInflater.from(getContext()).inflate(R.layout.fragment_user_deatails,container,false);
init(view);
        return view;
    }
    public void init(View view)
    {

        tv_addbio=view.findViewById(R.id.tv_bio);
        tv_preferences=view.findViewById(R.id.tv_preferences);
        tv_preferences.setOnClickListener(this);
        tv_addbio.setOnClickListener(this);
        tv_verify_email=view.findViewById(R.id.tv_email_verify);
        tv_verify_email.setOnClickListener(this);
        tv_verify_mobile=view.findViewById(R.id.tv_verify_mobile);
        tv_verify_mobile.setOnClickListener(this);
        tv_verify_id=view.findViewById(R.id.tv_verify_id);
        tv_addcar=view.findViewById(R.id.tv_addcar);
        tv_addcar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.tv_addcar)
        {
            Intent intent=new Intent(getContext(), AddMyCarActivity.class);
            startActivity(intent);

        }
        if (v.getId()==R.id.tv_email_verify)
        {
Intent intent=new Intent(getContext(), AddEmailActivity.class);
startActivity(intent);
        }
        if (v.getId()==R.id.tv_verify_mobile)
        {
Intent intent=new Intent(getContext(), AddMobileActivity.class);
startActivity(intent);
        }
        if (v.getId()==R.id.tv_verify_id)
        {

        }
        if (v.getId()==R.id.tv_preferences)
        {
            Intent intent=new Intent(getContext(), EditPreferencesActivity.class);
            startActivity(intent);
        }
        if (v.getId()==R.id.tv_bio)
        {
            Intent intent =new Intent(getContext(), EditProfileActivity.class);
            startActivity(intent);
        }
    }
}
