package com.lc.musiccollab.di.component;

import android.app.Application;
import android.content.Context;

import com.lc.musiccollab.MainApp;
import com.lc.musiccollab.data.user_session.SessionManagerImpl;
import com.lc.musiccollab.di.builder.ActivityBuilder;
import com.lc.musiccollab.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * Created by topher on 1/25/2018.
 */

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        ActivityBuilder.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    Context provideContext();

    SessionManagerImpl provideSessionManager();

    void inject(MainApp app);

    void inject(SessionManagerImpl sessionManager);

    @Override
    void inject(DaggerApplication instance);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }


//    @AppContext
//    Context context();

//    void inject(MainApp app);
//    void inject(BaseActivity baseActivity);
//    void inject(MainActivity homeActivity);
//    void inject(LoginActivity loginActivity);
}
