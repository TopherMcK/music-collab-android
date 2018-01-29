package com.lc.musiccollab.di.subcomponent.module;

import com.lc.musiccollab.R;
import com.lc.musiccollab.utils.CONSTANTS;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by topher on 1/29/2018.
 */

@Module
public class BaseActivityModule {

    @Provides
    CalligraphyConfig provideCalligraphyConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath(CONSTANTS.FONT_PATH)
                .setFontAttrId(R.attr.fontPath)
                .build();
    }

}
