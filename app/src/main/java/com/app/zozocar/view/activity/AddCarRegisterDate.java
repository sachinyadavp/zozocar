package com.app.zozocar.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.app.zozocar.R;

public class AddCarRegisterDate extends AppCompatActivity implements View.OnClickListener {
LinearLayout ll_submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car_register_date);
        init();
    }
    public void init()
    {
ll_submit=findViewById(R.id.ll_submit);
ll_submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(AddCarRegisterDate.this, UserActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

    }
}
