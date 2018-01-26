package com.lc.musiccollab.di.component;

import android.app.Application;
import android.content.Context;

import com.lc.musiccollab.MainApp;
import com.lc.musiccollab.MainApp_;
import com.lc.musiccollab.di.ApplicationContext;
import com.lc.musiccollab.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by topher on 1/25/2018.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(MainApp mainApp);

    @ApplicationContext
    Context context();

    Application application();

}
