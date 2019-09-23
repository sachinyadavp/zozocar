package com.app.zozocar.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.app.zozocar.R;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
public class RideDetailActivity extends AppCompatActivity {
    MaterialCalendarView materialCalendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ride_detail);
    }
}
