package com.app.zozocar.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.app.zozocar.R;
import com.app.zozocar.utils.UpdateInform;
import com.app.zozocar.view.adapter.CarBrandAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class SelectModelActivity extends AppCompatActivity implements UpdateInform {
    String bran[]={"Honda","Ford","Tata","Hyundai","Maruti"};
    ArrayList<String> brands=new ArrayList<String>(Arrays.asList(bran));
    RecyclerView rv_brand_list;
    EditText et_brand;
    ArrayList<String> filter_list;
    String query;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_model);
        init();
    }
    public void init()
    {
        et_brand=findViewById(R.id.et_brand);
        CarBrandAdapter adapter=new CarBrandAdapter(brands,this);
        rv_brand_list=findViewById(R.id.rv_brand_list);
        rv_brand_list.setLayoutManager(new LinearLayoutManager(this));
        rv_brand_list.setAdapter(adapter);
        et_brand.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length()>0)
                {
                    if (brands!=null)
                    {
                        query=et_brand.getText().toString().toLowerCase();
                        filter_list=new ArrayList<>();
                        for (int i=0;i<brands.size();i++)
                        {
                            if (brands.get(i).toLowerCase().contains(query))
                            {
                                filter_list.add(brands.get(i));
                            }
                        }
                        CarBrandAdapter adapter=new CarBrandAdapter(filter_list,SelectModelActivity.this);
                        rv_brand_list.setLayoutManager(new LinearLayoutManager(SelectModelActivity.this));
                        rv_brand_list.setAdapter(adapter);
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
    @Override
    public void inform(int position) {
        et_brand.setText(brands.get(position));
        Intent intent=new Intent(this,SelectCarTypeActivity.class);
        startActivity(intent);
    }
}
