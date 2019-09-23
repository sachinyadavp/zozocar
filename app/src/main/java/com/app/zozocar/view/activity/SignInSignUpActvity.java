package com.app.zozocar.view.activity;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.app.zozocar.R;
import com.app.zozocar.view.adapter.LoginSignUpPAgeAdapter;
public class SignInSignUpActvity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_sign_up_actvity);
        TabLayout tabLayout =  findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("Login"));
        tabLayout.addTab(tabLayout.newTab().setText("SignUp"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final LoginSignUpPAgeAdapter adapter = new LoginSignUpPAgeAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //  tab.setTabTextColors(getResources().getColor(R.color.blue_200), getResources().getColor(R.color.white));
                //tab.setCustomView(LayoutInflater.from(SigninSignUpActivity.this).inflate(R.layout.tab_background,null));
                //   tab.setIcon(R.drawable.back_icon);
                tab.getPosition();
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
}
