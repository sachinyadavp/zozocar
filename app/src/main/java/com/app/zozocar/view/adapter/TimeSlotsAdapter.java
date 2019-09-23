package com.app.zozocar.view.adapter;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.app.zozocar.R;
import com.app.zozocar.view.activity.SelectDateActivity;
public class TimeSlotsAdapter  extends RecyclerView.Adapter<TimeSlotsAdapter.Holder> {
    Context mcontext;
    boolean list[];
    public TimeSlotsAdapter(Context mcontext,boolean list[])
    {
        this.mcontext=mcontext;
        this.list=list;
    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View  view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_time, viewGroup, false);
       Holder holder=new Holder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull final Holder holder,final int i) {
        if (list[i])
        {
          holder.ll_main.setBackgroundResource(R.drawable.action_bg);
            holder.tv_time.setTextColor(Color.parseColor("#ffffff"));
        }
        else {
            holder.ll_main.setBackgroundColor(Color.parseColor("#ffffff"));
            holder.tv_time.setTextColor(Color.parseColor("#000000"));
        }
        holder.ll_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectDateActivity obj=(SelectDateActivity)mcontext;
                obj.inform(i);
            }
        });
    }
    @Override
    public int getItemCount() {
        return list.length;
    }
    class Holder extends  RecyclerView.ViewHolder
    {
        LinearLayout ll_main;
        TextView  tv_time;
        Holder(View view)
        {
            super(view);
            ll_main=view.findViewById(R.id.ll_main);
            tv_time=view.findViewById(R.id.tv_time);
        }
    }
}
