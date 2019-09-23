package com.app.zozocar.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.app.zozocar.R;
import com.app.zozocar.view.activity.RideDetailActivity;

public class FindesRidesAdapter extends RecyclerView.Adapter<FindesRidesAdapter.Holder> {
    Context mcontext;
    public FindesRidesAdapter(Context mcontext)
    {
        this.mcontext=mcontext;

    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_search_ride,viewGroup,false);
        Holder holder=new Holder(view);

        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull final Holder holder, int i) {
        holder.ll_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(mcontext, RideDetailActivity.class);
                mcontext.startActivity(in);
            }
        });

    }
    @Override
    public int getItemCount() {
        return 10;
    }
    class  Holder extends RecyclerView.ViewHolder
     {
         LinearLayout ll_main;
         Holder(View view)
         {
             super(view);
             ll_main=view.findViewById(R.id.ll_main);
         }
     }
}
