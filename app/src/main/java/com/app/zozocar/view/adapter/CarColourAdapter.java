package com.app.zozocar.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.zozocar.R;
import com.app.zozocar.view.activity.SelectCarColourActivity;

import org.w3c.dom.Text;

public class CarColourAdapter  extends RecyclerView.Adapter<CarColourAdapter.Holder> {
    String list[];
    Context mcontext;
    public  CarColourAdapter(String list[], Context mcontext)
    {
        this.list=list;
        this.mcontext=mcontext;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_car_colour,viewGroup,false);
        Holder holder=new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder,  final int i) {
        holder.tv_color.setText(list[i]);
        holder.tv_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectCarColourActivity selectCarColourActivity=(SelectCarColourActivity)mcontext;
                selectCarColourActivity.inform(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.length;
    }

    class  Holder extends  RecyclerView.ViewHolder
    {
        TextView tv_color;
        Holder(View view)
        {
            super(view);
            tv_color=view.findViewById(R.id.tv_car_color_name);
        }

    }
}
