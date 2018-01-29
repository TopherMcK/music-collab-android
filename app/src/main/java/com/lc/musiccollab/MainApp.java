package com.lc.musiccollab;

import com.lc.musiccollab.data.SessionManager;
import com.lc.musiccollab.di.component.AppComponent;
import com.lc.musiccollab.di.component.DaggerAppComponent;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EApplication;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * Created by topher on 1/25/2018.
 */

@EApplication
public class MainApp extends DaggerApplication
{

    @Bean
    SessionManager sessionManager;

    protected AndroidInjector<? extends DaggerApplication> applicationInjector()
    {
        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();
        appComponent.inject(this);
        return appComponent;
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        sessionManager.checkLogin();
    }
}
