package com.lc.musiccollab;

import android.app.Activity;
import android.os.Bundle;

import com.lc.musiccollab.data.SessionManager;

public class MainActivity extends Activity {

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sessionManager = new SessionManager(getApplicationContext());
        sessionManager.checkLogin();
    }
}
