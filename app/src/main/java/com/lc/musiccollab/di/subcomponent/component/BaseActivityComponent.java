package com.lc.musiccollab.di.subcomponent.component;

import com.lc.musiccollab.di.subcomponent.module.BaseActivityModule;
import com.lc.musiccollab.ui.BaseActivity;

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
