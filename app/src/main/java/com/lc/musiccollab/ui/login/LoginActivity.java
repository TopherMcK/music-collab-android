package com.lc.musiccollab.ui.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lc.musiccollab.R;
import com.lc.musiccollab.ui.main.MainActivity_;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 * Created by topher on 1/22/2018.
 */

@EActivity(R.layout.activity_login)
public class LoginActivity extends Activity
{
    @AfterInject
    void onInjectDependencies()
    {
        AndroidInjection.inject(this);
    }

    private boolean isValidUser;

    @Inject
    Context context_;

    @ViewById
    EditText loginUnInput;

    @ViewById
    EditText loginPwInput;

    @Bean(LoginPresenterImpl.class)
    LoginPresenter loginPresenter;

    @ViewById
    TextView loginTitleTextView;

    @AfterViews
    void init()
    {
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Pacifico-Regular.ttf");
        loginTitleTextView.setTypeface(font);
    }

    @Click({R.id.loginSubmitBtn})
    public void loginUser()
    {
        String username = loginUnInput.getText().toString();
        String password = loginPwInput.getText().toString();

        if(validateInputs(username,password))
        {
            submitLogin(username, password);
        } else
        {
            showInvalidInputErrorMessage();
        }
    }

    @Background
    public void submitLogin(String username, String password)
    {
        boolean isUserFound = loginPresenter.callLoginService(username, password);

        if(isUserFound)
        {
            startMainActivity();
        } else
        {
            showInvalidUserErrorMessage();
        }
    }

    @UiThread
    public void showInvalidUserErrorMessage()
    {
        Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_LONG).show();
    }

    @UiThread
    public void showInvalidInputErrorMessage()
    {
        Toast.makeText(this, "Please provide a Username and Password", Toast.LENGTH_LONG).show();
    }

    @UiThread
    public void startMainActivity()
    {
        MainActivity_.intent(getApplicationContext())
                .flags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                .flags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .start();

        LoginActivity.this.finish();
    }

    private boolean validateInputs(String username, String password)
    {
        if (username == null || username.trim().length() == 0
                || password == null || password.trim().length() == 0)
        {
            return false;
        } else
        {
            return true;
        }
    }
}
