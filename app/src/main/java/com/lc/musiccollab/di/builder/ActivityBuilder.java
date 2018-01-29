package com.lc.musiccollab.di.builder;

import com.lc.musiccollab.di.feature.module.BaseActivityModule;
import com.lc.musiccollab.di.feature.module.LoginActivityModule;
import com.lc.musiccollab.di.feature.module.MainActivityModule;
import com.lc.musiccollab.ui.base.BaseActivity;
import com.lc.musiccollab.ui.login.LoginActivity_;
import com.lc.musiccollab.ui.main.MainActivity_;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by topher on 1/28/2018.
 */

@Module
public abstract class ActivityBuilder
{

    @ContributesAndroidInjector(modules = BaseActivityModule.class)
    abstract BaseActivity bindBaseActivity();

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity_ bindMainActivity_();

    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity_ bindLoginActivity_();
}
