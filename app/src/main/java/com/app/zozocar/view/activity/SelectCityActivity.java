package com.app.zozocar.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.app.zozocar.R;
import com.app.zozocar.utils.UpdateInform;

public class SelectCityActivity extends AppCompatActivity implements UpdateInform {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_city);
    }

    @Override
    public void inform(int position) {

    }
}
