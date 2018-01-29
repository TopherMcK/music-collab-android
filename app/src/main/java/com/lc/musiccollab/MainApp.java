package com.lc.musiccollab;

import android.app.Activity;
import android.app.Application;

import com.lc.musiccollab.data.SessionManager;
import com.lc.musiccollab.di.component.AppComponent;
import com.lc.musiccollab.di.component.DaggerAppComponent;
import com.lc.musiccollab.di.module.AppModule;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EApplication;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by topher on 1/25/2018.
 */

@EApplication
public class MainApp extends DaggerApplication
{//Application implements HasActivityInjector {

    @Inject
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
