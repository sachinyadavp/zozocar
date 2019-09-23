package com.app.zozocar.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.app.zozocar.R;
import com.app.zozocar.view.adapter.FindesRidesAdapter;

public class RideListForYouActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView rv_rides_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_list_for_you);
        init();
    }
    public void init()
    {
        rv_rides_list=findViewById(R.id.rv_rides_list);
        rv_rides_list.setLayoutManager(new LinearLayoutManager(this));
        rv_rides_list.setAdapter(new FindesRidesAdapter(this));
    }


    @Override
    public void onClick(View v) {

    }
}
