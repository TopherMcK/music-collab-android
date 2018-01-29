package com.lc.musiccollab.di.feature.component;

import com.lc.musiccollab.di.feature.module.MainActivityModule;
import com.lc.musiccollab.ui.main.MainActivity_;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by topher on 1/29/2018.
 */

@Subcomponent(modules = MainActivityModule.class)
public interface MainActivityComponent extends AndroidInjector<MainActivity_> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity_>{}
}
