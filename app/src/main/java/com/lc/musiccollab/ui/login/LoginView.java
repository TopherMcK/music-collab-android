package com.lc.musiccollab.ui.login;

import com.lc.musiccollab.ui.base.MvpView;

import org.androidannotations.annotations.EBean;

import de.nenick.androidannotations.plugin.mvp.EMvpView;

/**
 * Created by topher on 1/27/2018.
 */

public interface LoginView
{
    void showInvalidUserErrorMessage();
    void showInvalidSubmitionErrorMessage();
    void startMainActivity();
}
