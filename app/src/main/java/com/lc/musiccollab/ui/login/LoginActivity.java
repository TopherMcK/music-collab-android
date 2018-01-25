package com.lc.musiccollab.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lc.musiccollab.MainActivity_;
import com.lc.musiccollab.R;
import com.lc.musiccollab.data.SessionManager;
import com.lc.musiccollab.utils.CONSTANTS;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

/**
 * Created by topher on 1/22/2018.
 */

@EActivity(R.layout.activity_login)
public class LoginActivity extends AppCompatActivity {

    private boolean isValidUser;

    private String username;
    private String password;

    @Bean
    SessionManager sessionManager;

    // uncomment when implementing activity_login rest service
//    @RestService
//    LoginService loginService;

    @ViewById
    EditText loginUnInput;

    @ViewById
    EditText loginPwInput;

    @ViewById
    TextView loginTitleTextView;

    @AfterViews
    void setTitleFontFace()
    {
        loginTitleTextView = (TextView) findViewById(R.id.loginTitleTextView);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Pacifico-Regular.ttf");
        loginTitleTextView.setTypeface(font);
    }

    @Click({R.id.loginSubmitBtn})
    void loginUser()
    {
        username = loginUnInput.getText().toString();
        password = loginPwInput.getText().toString();
        checkIsValidUser();
    }

    @Background
    public void checkIsValidUser() {
        // change to false when api functionality in implemented
        isValidUser = true;
        // uncomment when api is up for testing
//        isValidUser = loginService.submitLogin(username, password);

        if (isValidUser) {
            sessionManager.createLoginSession(getApplicationContext(), "placeholder name", "placeholder email");

            startMainActvity();
        } else {
            Toast.makeText(LoginActivity.this, "Invalid Username or Password", Toast.LENGTH_LONG).show();
        }
    }

    @UiThread
    public void startMainActvity()
    {
        MainActivity_.intent(getApplicationContext())
                .flags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                .flags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .start();

        LoginActivity.this.finish();
    }
}
