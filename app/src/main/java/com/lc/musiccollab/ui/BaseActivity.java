package com.lc.musiccollab.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.annotation.Nullable;

import dagger.android.AndroidInjection;
import dagger.android.support.AndroidSupportInjection;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by topher on 1/28/2018.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstance)
    {
        performDependencyInjection();
        super.onCreate(savedInstance);
    }

    @Override
    protected void attachBaseContext(Context newBase)
    {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    public void performDependencyInjection()
    {
        AndroidInjection.inject(this);
    }
}
