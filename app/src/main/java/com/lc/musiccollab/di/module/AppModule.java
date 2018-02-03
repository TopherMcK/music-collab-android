package com.lc.musiccollab.di.module;

import android.app.Application;
import android.content.Context;

import com.lc.musiccollab.data.user_session.SessionManagerImpl;
import com.lc.musiccollab.data.user_session.SessionManagerImpl_;
import com.lc.musiccollab.di.feature.component.BaseActivityComponent;
import com.lc.musiccollab.di.feature.component.LoginActivityComponent;
import com.lc.musiccollab.di.feature.component.MainActivityComponent;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by topher on 1/25/2018.
 */

@Module(
        subcomponents = {
                BaseActivityComponent.class,
                MainActivityComponent.class,
                LoginActivityComponent.class
        }
)
public class AppModule {

//    public AppModule(Context context) {
//        CONTEXT = context;
//    }
//
//    private final Context CONTEXT;

//    @Provides
//    Context provideContext(Application application)
//    {
//        return application;
//    }

//    @Provides
//    @Singleton
//    public Context provideContext(Application application) {
//        return application;
//    }
    @Provides
    @Singleton
    Context provideContext(Application application)
    {
        return application;
    }

    @Provides
    SessionManagerImpl provideSessionManager(Context context)
    {
        return SessionManagerImpl_.getInstance_(context);
    }

//    @Binds
//    @Singleton
//    Application application(App app);
//
//    @Provides
//    @AppContext
//    Context provideContext()
//    {
//        return APPLICATION.getApplicationContext();
//    }
//
//    @Provides
//    Application provideAPPLICATION()
//    {
//        return APPLICATION;
//    }
//
////    @Provides
////    @Singleton
////    CalligraphyConfig provideCalligraphyConfig()
////    {
////        return new CalligraphyConfig.Builder()
////                .setDefaultFontPath("fonts")
////                .setFontAttrId(R.attr.fontPath)
////                .build();
////    }
//
//    @Provides
//    @Singleton
//    CalligraphyManger provideCalligraphyManager(Context context)
//    {
//        return new CalligraphyManagerImpl(context, CONSTANTS.);
//    }


}
