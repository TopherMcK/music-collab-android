package com.lc.musiccollab.di.subcomponent.component;

import com.lc.musiccollab.di.subcomponent.module.HomeActivityModule;
import com.lc.musiccollab.ui.home.HomeActivity_;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by topher on 1/29/2018.
 */

@Subcomponent(modules = HomeActivityModule.class)
public interface HomeActivityComponent extends AndroidInjector<HomeActivity_> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<HomeActivity_>{}
}
