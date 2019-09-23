package com.app.zozocar.session;

import android.content.Context;
import android.content.SharedPreferences;

public class ZozoCar {
    public static String perfName="Zozocar";
    public static String isFirstTime="firstTime";
    public static  String USER="name";
    public static String UID="uid";
    public static  String PURL="profile";
    public static  String ISLOGIN="islogin";
    public static  String CART="cart";
    public SharedPreferences mPref;
    public SharedPreferences.Editor editor;
    public  ZozoCar(Context mContext)

    {
        mPref=mContext.getSharedPreferences(perfName,0);
        editor=mPref.edit();

    }
    public  void setFistopen()
    {
        editor.putBoolean(isFirstTime,false);
        editor.commit();
    }
    public boolean isFirstTime()
    {
        return mPref.getBoolean(isFirstTime,true);
    }
    public boolean isLogin()
    {
        return mPref.getBoolean(ISLOGIN,false);
    }
    public void setLogin()
    {
        editor.putBoolean(ISLOGIN,true);
        editor.commit();
    }
    public void setString(String key,String value)
    {
        editor.putString(key,value);
        editor.commit();
    }
    public void setMobile_verification_status(boolean status)
    {
        editor.putBoolean("m_n_v",status);
        editor.commit();
    }
    public void setmail_verification_status(boolean status)
    {
        editor.putBoolean("m_v",status);
        editor.commit();
    }

    public String getString(String key)

    {
        return  mPref.getString(key,null);
    }
    public boolean getStatus(String name)
    {
        return  mPref.getBoolean(name,false);
    }
    public void setLogout()
    {
        editor.putBoolean(ISLOGIN,false);
        editor.commit();
    }
    public  void deletSession()
    {
        mPref.edit().clear().commit();
    }

}
