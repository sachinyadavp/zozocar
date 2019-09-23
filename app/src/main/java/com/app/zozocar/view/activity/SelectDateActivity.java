package com.app.zozocar.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.LayoutDirection;
import android.view.View;
import android.widget.TextView;

import com.app.zozocar.R;
import com.app.zozocar.model.Model;
import com.app.zozocar.utils.UpdateInform;
import com.app.zozocar.view.adapter.TimeSlotsAdapter;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.Calendar;
import java.util.Date;

public class SelectDateActivity extends AppCompatActivity implements View.OnClickListener , UpdateInform {
    TextView tv_proceed;
    RecyclerView rv_time_slots;
    TimeSlotsAdapter adapter;
    Date date;
    int flag=0;
    MaterialCalendarView materialCalendarView;
    int old_position;
    boolean [] times=new boolean[]{false,false,false,false,false,false,false,false,false,false};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_select_date_time);
        try {
            flag = getIntent().getExtras().getInt("flag");
        }
        catch (Exception e)
        {
        }
        init();
    }
public void init()
{
    materialCalendarView=findViewById(R.id.calendarView);
  MaterialCalendarView.StateBuilder stateBuilder=materialCalendarView.newState();
    Date c = Calendar.getInstance().getTime();
  stateBuilder.setMinimumDate(c);
  stateBuilder.commit();
    materialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
        @Override
        public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
          SelectDateActivity.this.date= date.getDate();
        }
    });
    tv_proceed=findViewById(R.id.tv_proceed);
    tv_proceed.setOnClickListener(this);
    rv_time_slots=findViewById(R.id.rv_time_slots);
    rv_time_slots.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    adapter=new TimeSlotsAdapter(this,times);
    rv_time_slots.setAdapter(adapter);
}
    @Override
    public void onClick(View v) {
        if (flag==0) {
             Intent intent =new Intent(this,Q1Activity.class);
             startActivity(intent);
        }
        else {
            Model model = new Model();
            model.setTime("20:10");
            model.setDate(date);
            Intent intent = new Intent();
            intent.putExtra("data", model);
            setResult(RESULT_OK, intent);
            finish();
            super.onBackPressed();
        }
    }
    @Override
    public void inform(int position) {
        times[old_position]=false;
        times[position]=true;
        adapter.notifyDataSetChanged();
        old_position=position;
    }
}
