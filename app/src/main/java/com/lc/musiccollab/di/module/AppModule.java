package com.lc.musiccollab.di.module;

import android.app.Application;
import android.content.Context;

import com.lc.musiccollab.R;
import com.lc.musiccollab.di.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by topher on 1/25/2018.
 */

@Module
public class AppModule {

    public AppModule(Application application)
    {
        this.APPLICATION = application;
    }

    private final Application APPLICATION;

    @Provides
    @ApplicationContext
    Context getContext()
    {
        return APPLICATION.getApplicationContext();
    }

    @Provides
    Application getAPPLICATION()
    {
        return APPLICATION;
    }

    @Provides
    @Singleton
    CalligraphyConfig getCalligraphyConfig()
    {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Pacifico-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }
}
