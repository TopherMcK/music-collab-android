package com.lc.musiccollab.data;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.lc.musiccollab.ui.main.MainActivity_;
import com.lc.musiccollab.ui.login.LoginActivity_;
import com.lc.musiccollab.utils.CONSTANTS;

import org.androidannotations.annotations.EBean;

import java.util.HashMap;

import javax.inject.Inject;

@EBean
public class SessionManager {

    @Inject
    public SessionManager(Context context)
    {
        CONTEXT = context;
        pref = CONTEXT.getSharedPreferences(CONSTANTS.PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    final Context CONTEXT;
    Editor editor;
    SharedPreferences pref;

    int PRIVATE_MODE = 0;

    public void createLoginSession(String name, String email)
    {
        editor.putBoolean(CONSTANTS.IS_LOGGED_IN, true);
        editor.putString(CONSTANTS.KEY_NAME, name);
        editor.putString(CONSTANTS.KEY_EMAIL, email);
        editor.commit();
    }

    public void checkLogin()
    {
        if(!this.isLoggedIn())
        {
            LoginActivity_.intent(CONTEXT).flags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    .flags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    .start();
        } else
        {
            MainActivity_.intent(CONTEXT).start();
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

        LoginActivity_.intent(CONTEXT).flags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                .flags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .start();
    }

    public boolean isLoggedIn()
    {
        return pref.getBoolean(CONSTANTS.IS_LOGGED_IN, false);
    }
}
