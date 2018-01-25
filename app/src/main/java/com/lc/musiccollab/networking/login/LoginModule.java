package com.lc.musiccollab.networking.login;

import org.androidannotations.rest.spring.annotations.Get;
import org.androidannotations.rest.spring.annotations.Rest;

/**
 * Created by topher on 1/22/2018.
 */

@Rest(rootUrl = "", converters = String.class)
public class LoginModule implements LoginService{

    @Get("")
    public boolean submitLogin(String username, String password)
    {
        return true;
    }

}
