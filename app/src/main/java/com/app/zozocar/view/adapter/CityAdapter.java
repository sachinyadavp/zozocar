package com.app.zozocar.view.adapter;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.app.zozocar.R;
public class CityAdapter extends RecyclerView.Adapter<CityAdapter.Holder> {
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_city, viewGroup, false);
        Holder holder=new Holder(view);
        return holder;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }


    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        holder.ll_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
    @Override
    public int getItemCount() {
        return 0;
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
