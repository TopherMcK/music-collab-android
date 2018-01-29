package com.lc.musiccollab.di.builder;

import com.lc.musiccollab.di.subcomponent.module.BaseActivityModule;
import com.lc.musiccollab.di.subcomponent.module.HomeActivityModule;
import com.lc.musiccollab.di.subcomponent.module.LoginActivityModule;
import com.lc.musiccollab.ui.BaseActivity;
import com.lc.musiccollab.ui.home.HomeActivity_;
import com.lc.musiccollab.ui.login.LoginActivity_;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by topher on 1/28/2018.
 */

@Module
public abstract class ActivityBuilder {

//    @ContributesAndroidInjector(modules = HomeActivityModule.class)
//    abstract HomeActivity bindHomeActivity();

//    @BindsInstance
//    @IntoMap
//    @ActivityKey(BaseActivity.class)
//    abstract AndroidInjector.Factory<? extends Activity> bindBaseActivity(BaseActivityModule.Builder builder);
//
//    @BindsInstance
//    @IntoMap
//    @ActivityKey(HomeActivity.class)
//    abstract AndroidInjector.Factory<? extends Activity> bindBaseActivity(HomeActivityModule.Builder builder);
//
//    @BindsInstance
//    @IntoMap
//    @ActivityKey(LoginActivity.class)
//    abstract AndroidInjector.Factory<? extends Activity> bindBaseActivity(LoginActivityModule.Builder builder);

    @ContributesAndroidInjector(modules = BaseActivityModule.class)
    abstract BaseActivity bindBaseActivity();

    @ContributesAndroidInjector(modules = HomeActivityModule.class)
    abstract HomeActivity_ bindHomeActivity_();

    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity_ bindLoginActivity_();
}
