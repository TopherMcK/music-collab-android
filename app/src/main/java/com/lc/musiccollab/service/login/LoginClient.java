package com.lc.musiccollab.service.login;

import com.lc.musiccollab.model.login.LoginModel;

import org.androidannotations.rest.spring.annotations.Accept;
import org.androidannotations.rest.spring.annotations.Get;
import org.androidannotations.rest.spring.annotations.Path;
import org.androidannotations.rest.spring.annotations.Rest;
import org.androidannotations.rest.spring.api.MediaType;

/**
 * Created by topher on 1/22/2018.
 */

@Rest(rootUrl = "", converters = {})
public interface LoginClient
{

    @Get("/v1/login/{username}/{password}")
    @Accept(MediaType.APPLICATION_JSON)
    LoginModel submitLogin(@Path String username, @Path String password);
}
