package com.lc.musiccollab.model.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Created by topher on 2/3/2018.
 */

@JsonRootName("userValidation")
public class LoginModel
{
    @JsonProperty("userFound")
    private String userFound;

    @JsonProperty("userFound")
    public void setUserFound(String userFound)
    {
        this.userFound = userFound;
    }

    @JsonProperty("userFound")
    public String getUserFound()
    {

        return userFound;
    }

    @Override
    public String toString()
    {
        return "LoginModel{" +
                "userFound='" + userFound + '\'' +
                '}';
    }
}
