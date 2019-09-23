package com.app.zozocar.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.app.zozocar.R;
import com.app.zozocar.utils.UpdateInform;
import com.app.zozocar.view.adapter.CarColourAdapter;

public class SelectCarColourActivity extends AppCompatActivity implements UpdateInform {
RecyclerView rv_cara_color_names;
String  list[]={"Red","Green","Blue","Pink","Yellow"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_car_colour);
        init();
    }
    public void init()
    {
        rv_cara_color_names=findViewById(R.id.rv_car_color_name);
        rv_cara_color_names.setLayoutManager(new LinearLayoutManager(this));
        rv_cara_color_names.setAdapter(new CarColourAdapter(list,this));
    }
    @Override
    public void inform(int position) {
        Intent intent=new Intent(this,AddCarRegisterDate.class);
        startActivity(intent);
    }
}
