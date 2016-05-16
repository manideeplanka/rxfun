package com.rapidbizapps.rxsample.service;

import com.rapidbizapps.rxsample.models.GitHubRepo;
import com.rapidbizapps.rxsample.models.GitHubUser;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by mlanka on 16-05-2016.
 */
public interface GitHubService {

    @GET("/users/{user}")
    Observable<GitHubUser> getUser(@Path("user") String user);

    @GET("/users/{user}/repos")
    Observable<GitHubRepo[]> getUserRepos(@Path("user") String user);

}
