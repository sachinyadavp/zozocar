package com.app.zozocar.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.app.zozocar.R;
import com.app.zozocar.utils.UpdateInform;
import com.app.zozocar.view.adapter.CarTypeAdapter;

public class SelectCarTypeActivity extends AppCompatActivity implements UpdateInform {
    RecyclerView rv_cartype;
    String list[]={"Scoda","Sedan","Van","Minivan","SUv","Estate","Hatchback"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_car_type);
        init();
    }
    public void init()
    {
        rv_cartype=findViewById(R.id.rv_cartype);
        rv_cartype.setLayoutManager(new LinearLayoutManager(this));
        rv_cartype.setAdapter(new CarTypeAdapter(list,this));

    }

    @Override
    public void inform(int position) {
        Intent intent =new Intent(this,SelectCarColourActivity.class);
        startActivity(intent);
    }
}
