package com.lc.musiccollab.di.module;

import android.app.Application;
import android.content.Context;

import com.lc.musiccollab.data.SessionManager;
import com.lc.musiccollab.data.SessionManager_;
import com.lc.musiccollab.di.subcomponent.component.BaseActivityComponent;
import com.lc.musiccollab.di.subcomponent.component.HomeActivityComponent;
import com.lc.musiccollab.di.subcomponent.component.LoginActivityComponent;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by topher on 1/25/2018.
 */

@Module(
        subcomponents = {
                BaseActivityComponent.class,
                HomeActivityComponent.class,
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
    SessionManager provideSessionManager(Context context)
    {
        return SessionManager_.getInstance_(context);
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
