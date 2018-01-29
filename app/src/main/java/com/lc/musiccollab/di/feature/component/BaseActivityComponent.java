package com.lc.musiccollab.di.feature.component;

import com.lc.musiccollab.di.feature.module.BaseActivityModule;
import com.lc.musiccollab.ui.base.BaseActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by topher on 1/29/2018.
 */

@Subcomponent(modules = BaseActivityModule.class)
public interface BaseActivityComponent extends AndroidInjector<BaseActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<BaseActivity>{}
}
