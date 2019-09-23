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
import com.app.zozocar.view.activity.HomeActivity;
public class SignUpFragment extends Fragment implements View.OnClickListener {
    LinearLayout ll_signup;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=LayoutInflater.from(getContext()).inflate(R.layout.fragment_signup,container,false);
        init(view);
        return view;
    }
    public void init(View view)
    {
        ll_signup=view.findViewById(R.id.ll_sign_up);
        ll_signup.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(getContext(), HomeActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}
