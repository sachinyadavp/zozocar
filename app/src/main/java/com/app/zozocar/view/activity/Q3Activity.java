package com.app.zozocar.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.app.zozocar.R;

public class Q3Activity extends AppCompatActivity implements View.OnClickListener {
    TextView tv_sure, tv_no;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ride_q3);
        init();
    }
    public void init() {
        tv_no = findViewById(R.id.tv_no);
        tv_sure = findViewById(R.id.tv_sure);
        tv_no.setOnClickListener(this);
        tv_sure.setOnClickListener(this);

        Log.e("set listener","yes");
    }
    @Override
    public void onClick(View v) {
Log.e("select data","some on click");
        Intent intent = new Intent(this, Recommended_PriceActivity.class);
        startActivity(intent);
    }
}
