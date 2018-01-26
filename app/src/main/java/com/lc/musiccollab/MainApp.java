package com.lc.musiccollab;

import android.app.Application;

import com.lc.musiccollab.di.component.AppComponent;
import com.lc.musiccollab.di.component.DaggerAppComponent;
import com.lc.musiccollab.di.module.AppModule;
import com.lc.musiccollab.data.SessionManager;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EApplication;

import javax.inject.Inject;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by topher on 1/25/2018.
 */

@EApplication
public class MainApp extends Application {

    @Inject
    CalligraphyConfig calligraphyConfig;

    @Bean
    SessionManager sessionManager;

    private AppComponent mAppComponent;

    @Override
    public void onCreate()
    {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this)).build();

        mAppComponent.inject(this);

        CalligraphyConfig.initDefault(calligraphyConfig);

        sessionManager.checkLogin(getApplicationContext());
    }

    public AppComponent getAppComponent()
    {
        return mAppComponent;
    }

    // for testing
    public void setComponent(AppComponent appComponent)
    {
        mAppComponent = appComponent;
    }
}
