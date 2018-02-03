package com.lc.musiccollab.ui.login;

import com.lc.musiccollab.data.user_session.SessionManager;
import com.lc.musiccollab.data.user_session.SessionManagerImpl;
import com.lc.musiccollab.model.login.LoginModel;
import com.lc.musiccollab.service.login.LoginClient;
import com.lc.musiccollab.utils.CONSTANTS;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.rest.spring.annotations.RestService;

/**
 * Created by topher on 1/22/2018.
 */

@EBean
public class LoginPresenterImpl implements LoginPresenter
{

    @RestService
    LoginClient loginClient;

    @Bean(SessionManagerImpl.class)
    SessionManager sessionManager;

    public boolean callLoginService(String username, String password)
    {
//        LoginModel loginModel = loginClient.submitLogin(username, password);

            if ("Y".equals(CONSTANTS.LOGIN_USER_FOUND)) {
                sessionManager.createLoginSession("placeholder name", "placeholder email");
                return true;
            } else
            {
                return false;
            }
    }
}
