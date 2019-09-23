package com.app.zozocar.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.app.zozocar.R;

public class AddMyCarActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout ll_continue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_my_car);
        init();
    }
    public void init()
    {
        ll_continue=findViewById(R.id.ll_continue);
        ll_continue.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this,SelectCarBrandActivity.class);
        startActivity(intent);
    }
}
