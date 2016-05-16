package com.rapidbizapps.rxsample.models;

import com.google.gson.annotations.SerializedName;
import com.rapidbizapps.rxsample.models.GitHubUser;

/**
 * Created by mlanka on 16-05-2016.
 */
public class GitHubRepo {

    String name;
    @SerializedName("owner")
    GitHubUser owner;
    String description;
    @SerializedName("stargazers_count")
    int starsCount;
    @SerializedName("watchers_count")
    int watchersCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GitHubUser getOwner() {
        return owner;
    }

    public void setOwner(GitHubUser owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStarsCount() {
        return starsCount;
    }

    public void setStarsCount(int starsCount) {
        this.starsCount = starsCount;
    }

    public int getWatchersCount() {
        return watchersCount;
    }

    public void setWatchersCount(int watchersCount) {
        this.watchersCount = watchersCount;
    }
}
