package com.app.zozocar.view.adapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.app.zozocar.view.fragment.AccountFragment;
import com.app.zozocar.view.fragment.LoginFragment;
import com.app.zozocar.view.fragment.SignUpFragment;
import com.app.zozocar.view.fragment.UserDetailsFragment;
public class UserPageAdapter  extends FragmentPagerAdapter {
    int mNumOfTabs;
    public UserPageAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }
    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                UserDetailsFragment tab1 = new UserDetailsFragment();
                return tab1;
            case 1:
                AccountFragment tab2 = new AccountFragment();
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
