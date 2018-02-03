package com.lc.musiccollab.data.user_session;

import org.androidannotations.annotations.EBean;

import java.util.HashMap;

/**
 * Created by topher on 1/31/2018.
 */

public interface SessionManager
{
    void createLoginSession(String name, String email);
    void checkLogin();
    HashMap<String, String> getUserDetails();
    void logoutUser();
}
