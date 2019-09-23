package com.app.zozocar.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.zozocar.R;
import com.app.zozocar.view.activity.SearchBrandActivity;
import com.app.zozocar.view.activity.SelectCarBrandActivity;
import com.app.zozocar.view.activity.SelectCarTypeActivity;
import com.app.zozocar.view.activity.SelectModelActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class CarBrandAdapter extends RecyclerView.Adapter<CarBrandAdapter.Holder> {
    ArrayList<String> list;
    Context mcontext;
     public CarBrandAdapter(ArrayList<String> list, Context mcontext)
    {
        this.mcontext=mcontext;
        this.list=list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_car_brand,viewGroup,false);
        Holder holder=new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder,  final int i) {
        holder.tv_name.setText(list.get(i));
        holder.tv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mcontext instanceof SelectCarBrandActivity) {
                    SelectCarBrandActivity selectCarBrandActivity = (SelectCarBrandActivity) mcontext;
                    selectCarBrandActivity.inform(i);
                }
                else {
                   SelectModelActivity selectCarBrandActivity = (SelectModelActivity) mcontext;
                    selectCarBrandActivity.inform(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class   Holder extends  RecyclerView.ViewHolder
    {
        TextView tv_name;
        Holder(View view)
        {
            super(view);
            tv_name=view.findViewById(R.id.tv_brand);
        }

    }

}
