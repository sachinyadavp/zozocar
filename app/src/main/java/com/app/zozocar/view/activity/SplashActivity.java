package com.app.zozocar.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import com.app.zozocar.R;
import com.app.zozocar.session.ZozoCar;

public class SplashActivity extends AppCompatActivity implements Animation.AnimationListener {
    Animation anim;
    RelativeLayout main_layout;
    ZozoCar zozoCar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
        main_layout=findViewById(R.id.main_layout);
        anim.setAnimationListener(this);
        main_layout.setVisibility(View.VISIBLE);
        main_layout.startAnimation(anim);
        zozoCar=new ZozoCar(this);
    }
    @Override
    public void onAnimationStart(Animation animation) {
    }
    @Override
    public void onAnimationEnd(Animation animation) {
        if (zozoCar.isLogin())
        {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            Intent intent = new Intent(this, SignInSignUpActvity.class);
            startActivity(intent);
            finish();
        }
    }
    @Override
    public void onAnimationRepeat(Animation animation) {
    }
}