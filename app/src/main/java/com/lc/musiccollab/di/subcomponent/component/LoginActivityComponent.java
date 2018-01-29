package com.lc.musiccollab.di.subcomponent.component;

import com.lc.musiccollab.di.subcomponent.module.LoginActivityModule;
import com.lc.musiccollab.ui.login.LoginActivity_;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by topher on 1/29/2018.
 */

@Subcomponent(modules = LoginActivityModule.class)
public interface LoginActivityComponent extends AndroidInjector<LoginActivity_> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<LoginActivity_>{}
}
