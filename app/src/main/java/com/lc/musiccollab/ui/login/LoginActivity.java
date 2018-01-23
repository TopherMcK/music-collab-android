package com.lc.musiccollab.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lc.musiccollab.MainActivity;
import com.lc.musiccollab.R;
import com.lc.musiccollab.data.SessionManager;
import com.lc.musiccollab.networking.login.LoginModule;
import com.lc.musiccollab.networking.login.LoginService;

/**
 * Created by topher on 1/22/2018.
 */

public class LoginActivity extends Activity {

    SessionManager sessionManager;
    LoginService loginService;

    Button login;
    EditText usernameEditText, passwordEditText;
    TextView loginTitleTextView;

    private boolean isValidUser;

    public static final int CONNECTION_TIMEOUT = 10000;
    public static final int READ_TIMEOUT = 10000;

    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        sessionManager = new SessionManager(getApplicationContext());

        loginTitleTextView = (TextView) findViewById(R.id.loginTitleTextView);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Pacifico-Regular.ttf");
        loginTitleTextView.setTypeface(font);

        login = (Button) findViewById(R.id.button);
        usernameEditText = (EditText) findViewById(R.id.editUn);
        passwordEditText = (EditText) findViewById(R.id.editPw);

        username = usernameEditText.getText().toString();
        password = passwordEditText.getText().toString();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginService = new LoginModule();
                isValidUser = loginService.submitLogin(username, password);
                checkIsValidUser();
            }
        });
    }

    private void checkIsValidUser() {
        if (isValidUser) {
            sessionManager.createLoginSession("", "");

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);

            LoginActivity.this.finish();
        } else {
            Toast.makeText(LoginActivity.this, "Invalid User Name or Password", Toast.LENGTH_LONG).show();
        }
    }
}
