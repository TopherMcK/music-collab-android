package com.lc.musiccollab.ui.home;

import dagger.Module;
import dagger.Provides;

/**
 * Created by topher on 1/28/2018.
 */

@Module
public class HomeActivityModule {

    @Provides
    HomeView provideHomeView()
    {
        return new HomeView();
    }
}
