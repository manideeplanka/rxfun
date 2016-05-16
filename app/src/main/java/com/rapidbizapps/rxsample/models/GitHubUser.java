package com.rapidbizapps.rxsample.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mlanka on 16-05-2016.
 */
public class GitHubUser {

    String login;
    @SerializedName("html_url")
    String url;
    String type;
    String name;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


