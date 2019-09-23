package com.app.zozocar.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.app.zozocar.R;
import com.app.zozocar.session.ZozoCar;
import com.app.zozocar.view.activity.HomeActivity;

public class LoginFragment extends Fragment implements View.OnClickListener {
  LinearLayout ll_login;
  ZozoCar zozoCar;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=LayoutInflater.from(getContext()).inflate(R.layout.fragment_login,container,false);
        zozoCar=new ZozoCar(getContext());
        init(view);
        return view;
    }
    public void init(View view)
    {
        ll_login=view.findViewById(R.id.ll_login);
        ll_login.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        zozoCar.setLogin();
        Intent intent=new Intent(getContext(), HomeActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}