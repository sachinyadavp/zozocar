package com.app.zozocar.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.app.zozocar.R;

public class Recommended_PriceActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv_continue,tv_not_agree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommended__price);
        init();
    }
    public  void init()
    {
        tv_continue=findViewById(R.id.tv_continue);
        tv_not_agree=findViewById(R.id.tv_not_agree);
        tv_continue.setOnClickListener(this);
        tv_not_agree.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent =new Intent(this,PublishReturnTripActivity.class);
        startActivity(intent);

    }
}
