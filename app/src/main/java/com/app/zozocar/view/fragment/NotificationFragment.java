package com.app.zozocar.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.app.zozocar.R;
import com.app.zozocar.view.adapter.NotificationAdapter;
public class NotificationFragment extends Fragment {
    RecyclerView rv_notification;
    ImageView iv_no_notification;
    NotificationAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view=LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_notification, container, false);
      init(view);
      return view;
    }
    public void init(View view)
    {
        rv_notification=view.findViewById(R.id.rv_notification_list);
        rv_notification.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new NotificationAdapter();
        rv_notification.setAdapter(adapter);

    }
}
