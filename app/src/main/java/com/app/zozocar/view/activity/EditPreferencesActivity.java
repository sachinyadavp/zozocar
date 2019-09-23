package com.app.zozocar.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.app.zozocar.R;
import com.tooltip.Tooltip;

public class EditPreferencesActivity extends AppCompatActivity implements View.OnClickListener {
ImageView iv_chat1,iv_chat2,iv_chat3,iv_smoking1,iv_smoking2,iv_smoking3,iv_pet1,iv_pet2,iv_pet3,iv_music1,iv_music2,iv_music3;
LinearLayout ll_save;
int chat_s=1;
int smoking_s=1;
int pets_s=1;
int music_s=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_preferences);
        init();
    }
    public void  init()
    {
        ll_save=findViewById(R.id.ll_save);
        ll_save.setOnClickListener(this);
        iv_chat1=findViewById(R.id.iv_chat1);
        iv_chat1.setOnClickListener(this);
        iv_chat2=findViewById(R.id.iv_chat2);
        iv_chat2.setOnClickListener(this);
        iv_chat3=findViewById(R.id.iv_chat3);
        iv_chat3.setOnClickListener(this);
        iv_pet1=findViewById(R.id.iv_pet1);
        iv_pet1.setOnClickListener(this);
        iv_pet2=findViewById(R.id.iv_pet2);
        iv_pet2.setOnClickListener(this);
        iv_pet3 =findViewById(R.id.iv_pet3);
        iv_pet3.setOnClickListener(this);
        iv_music1=findViewById(R.id.iv_music1);
        iv_music1.setOnClickListener(this);
        iv_music2=findViewById(R.id.iv_music2);
        iv_music2.setOnClickListener(this);
        iv_music3=findViewById(R.id.iv_music3);
        iv_music3.setOnClickListener(this);
        iv_smoking1=findViewById(R.id.iv_smoking1);
        iv_smoking1.setOnClickListener(this);
        iv_smoking2=findViewById(R.id.iv_smoking2);
        iv_smoking2.setOnClickListener(this);
        iv_smoking3=findViewById(R.id.iv_smoking3);
        iv_smoking3.setOnClickListener(this);
    }
    public void showToolTip(View view,String mes)
    {
        Tooltip tooltip = new Tooltip.Builder(view)
                .setBackgroundColor(Color.parseColor("#ffffff"))
                .setText(mes)
                .setTextColor(Color.parseColor("#4886e9"))
                .setCancelable(true)
                .setGravity(Gravity.TOP)
                .show();
    }
    @Override
    public void onClick(View v) {
//        iv_smoking2.setBackgroundResource(R.drawable.preference_bg);
//        iv_smoking3.setBackgroundResource(R.drawable.preference_bg);
//        iv_pet1.setBackgroundResource(R.drawable.preference_bg);
//        iv_smoking1.setBackgroundResource(R.drawable.preference_bg);
//        iv_pet2.setBackgroundResource(R.drawable.preference_bg);
//        iv_pet3.setBackgroundResource(R.drawable.preference_bg);
//        iv_music3.setBackgroundResource(R.drawable.preference_bg);
//        iv_music2.setBackgroundResource(R.drawable.preference_bg);
//        iv_music1.setBackgroundResource(R.drawable.preference_bg);
//        iv_chat1.setBackgroundResource(R.drawable.preference_bg);
//        iv_chat2.setBackgroundResource(R.drawable.preference_bg);
//        iv_chat3.setBackgroundResource(R.drawable.preference_bg);
        switch (v.getId())
        {
            case R.id.iv_chat1:
            {
                iv_chat2.setBackgroundResource(R.drawable.preference_bg);
                iv_chat3.setBackgroundResource(R.drawable.preference_bg);
                iv_chat1.setBackgroundResource(R.drawable.select_preferences_bg);
                showToolTip(v,"I'm the quiet type.");
                break;
            }
            case R.id.iv_chat2:
            {
                iv_chat1.setBackgroundResource(R.drawable.preference_bg);
                iv_chat3.setBackgroundResource(R.drawable.preference_bg);
                iv_chat2.setBackgroundResource(R.drawable.select_preferences_bg);
                showToolTip(v,"I talk depending on my mood");
                break;
            }
            case R.id.iv_chat3:
            {
                iv_chat1.setBackgroundResource(R.drawable.preference_bg);
                iv_chat2.setBackgroundResource(R.drawable.preference_bg);
                iv_chat3.setBackgroundResource(R.drawable.select_preferences_bg);
                showToolTip(v,"I love to chat");
                break;
            }
            case R.id.iv_pet1:
            {  iv_pet2.setBackgroundResource(R.drawable.preference_bg);
                iv_pet3.setBackgroundResource(R.drawable.preference_bg);
                iv_pet1.setBackgroundResource(R.drawable.select_preferences_bg);
                showToolTip(v,"No pets in the car please");
                break;
            }
            case R.id.iv_pet2:
            {
                iv_pet1.setBackgroundResource(R.drawable.preference_bg);
                iv_pet3.setBackgroundResource(R.drawable.preference_bg);
                iv_pet2.setBackgroundResource(R.drawable.select_preferences_bg);
                showToolTip(v,"Depends on the animal");
                break;
            }
            case R.id.iv_pet3:
            {
                iv_pet2.setBackgroundResource(R.drawable.preference_bg);
                iv_pet1.setBackgroundResource(R.drawable.preference_bg);
                iv_pet3.setBackgroundResource(R.drawable.select_preferences_bg);
                showToolTip(v,"Smoking in the car doesn't bother me");
                break;
            }
            case R.id.iv_music1:
            {
                iv_music2.setBackgroundResource(R.drawable.preference_bg);
                iv_music3.setBackgroundResource(R.drawable.preference_bg);
                iv_music1.setBackgroundResource(R.drawable.select_preferences_bg);
                showToolTip(v,"Silence is golden");
                break;
            }
            case R.id.iv_music2:
            {  iv_music1.setBackgroundResource(R.drawable.preference_bg);
                iv_music3.setBackgroundResource(R.drawable.preference_bg);

                iv_music2.setBackgroundResource(R.drawable.select_preferences_bg);
                showToolTip(v,"I listen to music if I fancy it");
                break;
            }
            case R.id.iv_music3:
            {
                iv_music2.setBackgroundResource(R.drawable.preference_bg);
                iv_music1.setBackgroundResource(R.drawable.preference_bg);
                iv_music3.setBackgroundResource(R.drawable.select_preferences_bg);
                showToolTip(v,"It's all about the playlist!");
                break;
            }
            case R.id.iv_smoking1:
            {  iv_smoking2.setBackgroundResource(R.drawable.preference_bg);
                iv_smoking3.setBackgroundResource(R.drawable.preference_bg);
                iv_smoking1.setBackgroundResource(R.drawable.select_preferences_bg);
                showToolTip(v,"No smoking in the car please");
                break;
            }
            case R.id.iv_smoking2:
            {
                iv_smoking1.setBackgroundResource(R.drawable.preference_bg);
                iv_smoking3.setBackgroundResource(R.drawable.preference_bg);
                iv_smoking2.setBackgroundResource(R.drawable.select_preferences_bg);
                showToolTip(v,"Smoking in the car is OK sometimes");
                break;
            }
            case R.id.iv_smoking3:
            {
                iv_smoking1.setBackgroundResource(R.drawable.preference_bg);
                iv_smoking2.setBackgroundResource(R.drawable.preference_bg);
                iv_smoking3.setBackgroundResource(R.drawable.select_preferences_bg);
                showToolTip(v,"Smoking in the car doesn't bother me");
                break;
            }

           // showToolTip(v);
        }
        if (v.getId()==R.id.ll_save)
        {
            Intent intent = new Intent(EditPreferencesActivity.this, UserActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}
