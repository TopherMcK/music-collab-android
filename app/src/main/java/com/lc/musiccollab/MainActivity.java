package com.lc.musiccollab;

import android.app.Activity;
import android.os.Bundle;

import com.lc.musiccollab.data.SessionManager;

public class MainActivity extends Activity {

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionManager = new SessionManager(getApplicationContext());
        sessionManager.checkLogin();
    }
}
