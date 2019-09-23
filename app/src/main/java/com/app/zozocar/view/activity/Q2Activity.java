package com.app.zozocar.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.zozocar.R;

public class Q2Activity extends AppCompatActivity  implements View.OnClickListener {
    ImageView iv_proceed, iv_add,iv_sub;
    TextView tv_no_pass;
    int count=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ride_q1);
        init();
    }
    public  void init()
    {
        tv_no_pass=findViewById(R.id.tv_no_pass);
        count=Integer.parseInt(tv_no_pass.getText().toString());
        iv_add=findViewById(R.id.iv_add);
        iv_sub=findViewById(R.id.iv_sub);
        iv_sub.setOnClickListener(this);
        iv_add.setOnClickListener(this);
        iv_proceed=findViewById(R.id.iv_proceed);
        iv_proceed.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
if (v.getId()==R.id.iv_proceed) {
    Intent intent = new Intent(this, Q3Activity.class);
    startActivity(intent);
}
if (v.getId()==R.id.iv_add)
{

    count=Integer.parseInt(tv_no_pass.getText().toString());
    if (count<4) {
        count++;
        tv_no_pass.setText(count + "");
    }
}
if (v.getId()==R.id.iv_sub)
{
    count=Integer.parseInt(tv_no_pass.getText().toString());
    if (count!=0)
    count--;
    tv_no_pass.setText(count+"");
}
    }
}
