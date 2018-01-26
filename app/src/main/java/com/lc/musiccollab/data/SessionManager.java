package com.lc.musiccollab.data;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.lc.musiccollab.ui.home.HomeActivity_;
import com.lc.musiccollab.ui.login.LoginActivity_;
import com.lc.musiccollab.utils.CONSTANTS;

import org.androidannotations.annotations.EBean;

import java.util.HashMap;

@EBean
public class SessionManager {

    public SessionManager(){}

    SharedPreferences pref;
    Editor editor;
    Context _context;

    int PRIVATE_MODE = 0;

    public void setContext(Context _startupContext)
    {
        this._context = _startupContext;
        pref = _context.getSharedPreferences(CONSTANTS.PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createLoginSession(Context _loginViewContext, String name, String email)
    {
        setContext(_loginViewContext);

        editor.putBoolean(CONSTANTS.IS_LOGGED_IN, true);
        editor.putString(CONSTANTS.KEY_NAME, name);
        editor.putString(CONSTANTS.KEY_EMAIL, email);
        editor.commit();
    }

    public void checkLogin(Context _startupContext)
    {
        setContext(_startupContext);

        if(!this.isLoggedIn())
        {
            LoginActivity_.intent(_context).flags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    .flags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    .start();
        } else
        {
            HomeActivity_.intent(_context).start();
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
        return pref.getBoolean(CONSTANTS.IS_LOGGED_IN, false);
    }
}
