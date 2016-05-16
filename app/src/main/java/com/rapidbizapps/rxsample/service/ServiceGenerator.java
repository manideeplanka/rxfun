package com.rapidbizapps.rxsample.service;

import com.rapidbizapps.rxsample.service.GitHubService;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mlanka on 16-05-2016.
 */
public class ServiceGenerator {
    static String BASE_URL = "https://api.github.com";

    static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create());

    public static GitHubService createService() {
        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(GitHubService.class);
    }
}
