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
import com.app.zozocar.session.ZozoCar;
import com.app.zozocar.view.activity.ChangePasswordActivity;
import com.app.zozocar.view.activity.SplashActivity;

import java.nio.channels.InterruptedByTimeoutException;

public class AccountFragment extends Fragment implements View.OnClickListener {
    TextView tv_logout,tv_change_password;
    ZozoCar zozoCar;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=LayoutInflater.from(getContext()).inflate(R.layout.fragment_user_account,container,false);
        zozoCar=new ZozoCar(getContext());
        init(view);
        return view;
    }
    public void init(View view)
    {
        tv_logout=view.findViewById(R.id.tv_logout);
        tv_logout.setOnClickListener(this);
        tv_change_password=view.findViewById(R.id.tv_change_password);
        tv_change_password.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
if (v.getId()==R.id.tv_logout)
{
            Intent in = new Intent(getContext(), SplashActivity.class);
            zozoCar.deletSession();
            in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(in);
            getActivity().finish();
            try {
                this.finalize();
            } catch (Exception e) {
            } catch (Throwable throwable) {

            }
        }
        if (v.getId()==R.id.tv_change_password)
        {
            Intent intent=new Intent(getContext(),ChangePasswordActivity.class);
            startActivity(intent);
        }
    }
}
