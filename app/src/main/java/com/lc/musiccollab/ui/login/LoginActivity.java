package com.lc.musiccollab.ui.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
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
import org.androidannotations.annotations.FocusChange;
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

    @Bean(LoginPresenterImpl.class)
    LoginPresenter loginPresenter;

    @ViewById
    EditText loginUnInput;

    @ViewById
    EditText loginPwInput;

    @ViewById
    TextView loginTitleTextView;

    Toast customToast;

    View toastView;

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

    @FocusChange(R.id.loginPwInput)
    public void focusChangedPasswordInput(boolean hasFocus)
    {
        if(hasFocus)
        {
            loginPwInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            loginPwInput.setSelection(loginPwInput.getText().length());
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
        Log.d("invalidInputError", "** showInvalidInputErrorMessage called");
        LayoutInflater inflater = getLayoutInflater();
        toastView = inflater.inflate(R.layout.toast_invalid_user_error, null);
        customToast = new Toast(this);
        customToast.setView(toastView);
        customToast.makeText(this,"Please provide a Username and Password", Toast.LENGTH_LONG);
        customToast.show();
    }

    @UiThread
    public void showInvalidInputErrorMessage()
    {
        Log.d("** Log Activity", "** showInvalidUserErrorMessage called");
        LayoutInflater inflater = getLayoutInflater();
        toastView = inflater.inflate(R.layout.toast_warning, null);
        customToast = new Toast(this);
        customToast.setView(toastView);
        customToast.show();
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
