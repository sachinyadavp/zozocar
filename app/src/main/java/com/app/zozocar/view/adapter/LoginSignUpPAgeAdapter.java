package com.app.zozocar.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.app.zozocar.view.fragment.LoginFragment;
import com.app.zozocar.view.fragment.SignUpFragment;

public class LoginSignUpPAgeAdapter extends FragmentPagerAdapter {
    int mNumOfTabs;
    public LoginSignUpPAgeAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }
    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
               LoginFragment tab1 = new LoginFragment();
                return tab1;
            case 1:
                SignUpFragment tab2 = new SignUpFragment();
                return tab2;

            default:
                return  null;
        }
    }
    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
