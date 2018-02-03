package com.lc.musiccollab.ui.base;

import android.support.annotation.StringRes;

/**
 * Created by topher on 1/29/2018.
 */

public interface MvpView
{

    void showLoading();

    void hideLoading();

    void openActivityOnTokenExpire();

    void onError(@StringRes int resId);

    void onError(String message);

    void showMessage(String message);

    void showMessage(@StringRes int resId);

    boolean isNetworkConnected();

    void hideKeyboard();

}
