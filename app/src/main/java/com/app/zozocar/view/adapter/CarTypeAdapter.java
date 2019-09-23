package com.app.zozocar.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.zozocar.R;
import com.app.zozocar.view.activity.SelectCarTypeActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class CarTypeAdapter extends RecyclerView.Adapter <CarTypeAdapter.Holder>
{
    String list[];
    Context mcontext;

    public CarTypeAdapter(String list[], Context mcontext)
    {
        this.list=list;
        this.mcontext=mcontext;

    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_car_type, viewGroup, false);
        Holder holder=new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, final int i) {
        holder.tv_type_name.setText(list[i]);
        holder.tv_type_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
holder.iv_circular.setImageResource(R.color.colorPrimary);
holder.iv_circular.setBackgroundResource(R.drawable.selected_car_type_bg);
                SelectCarTypeActivity selectCarTypeActivity=(SelectCarTypeActivity)mcontext;
                selectCarTypeActivity.inform(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.length;
    }

    class  Holder extends RecyclerView.ViewHolder
     {
         CircleImageView iv_circular;
         TextView tv_type_name;
         Holder(View view)
         {
             super(view);
             iv_circular=view.findViewById(R.id.iv_select);
             tv_type_name=view.findViewById(R.id.tv_type_name);

         }

     }

}
