package com.app.zozocar.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.app.zozocar.R;

public class Q1Activity extends AppCompatActivity implements View.OnClickListener {
    TextView tv_sure,tv_no;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ride_q2);
        init();
    }
    public  void init()
    {
        tv_no=findViewById(R.id.tv_no);
        tv_sure=findViewById(R.id.tv_sure);
        tv_no.setOnClickListener(this);
        tv_sure.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {

        Intent intent=new Intent(this,Q2Activity.class);
        startActivity(intent);
    }
}
