package com.lc.musiccollab.data;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.lc.musiccollab.MainActivity_;
import com.lc.musiccollab.ui.login.LoginActivity_;

import org.androidannotations.annotations.EBean;

import java.util.HashMap;

@EBean
public class SessionManager {

    public SessionManager(Context context)
    {
        this._context = context;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    SharedPreferences pref;
    Editor editor;
    Context _context;

    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "UserPref";
    private static final String IS_LOGIN = "IsLoggedIn";

    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL = "email";

    public void createLoginSession(String name, String email)
    {
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_EMAIL, email);
        editor.commit();
    }

    public void checkLogin()
    {
        if(!this.isLoggedIn())
        {
            LoginActivity_.intent(_context).flags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    .flags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    .start();
        } else
        {
            MainActivity_.intent(_context).start();
        }
    }

    public HashMap<String, String> getUserDetails()
    {
        HashMap<String, String> user = new HashMap<String, String>();

        return user;
    }

    public void logoutUser()
    {
        editor.clear();
        editor.commit();

        LoginActivity_.intent(_context).flags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                .flags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .start();
    }

    public boolean isLoggedIn()
    {
        return pref.getBoolean(IS_LOGIN, false);
    }
}
