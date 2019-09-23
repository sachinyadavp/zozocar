package com.app.zozocar.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.Holder> {
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class Holder extends  RecyclerView.ViewHolder
    {
        Holder(View view)
        {
            super(view);
        }

    }
}
