package com.rapidbizapps.rxsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.rapidbizapps.rxsample.models.GitHubUser;
import com.rapidbizapps.rxsample.service.GitHubService;
import com.rapidbizapps.rxsample.service.ServiceGenerator;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    List<String> names = new ArrayList<>();

    RecyclerView users_rv;
    GitHubUsersAdapter adapter;
    GitHubService service;
    Subscription subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        users_rv = (RecyclerView) findViewById(R.id.recycler_view);

        names.add("ajaykoppisetty");
        names.add("kkunam");
        names.add("pmaganti");
        names.add("kumarkalluri");
        names.add("mdkarim");
        names.add("chandana1212");
        names.add("neeli");
        names.add("manideeplanka");

        service = ServiceGenerator.createService();
        adapter = new GitHubUsersAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        users_rv.setLayoutManager(linearLayoutManager);

        users_rv.setAdapter(adapter);

        subscription = Observable.from(names)
                .flatMap(s -> service.getUser(s))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<GitHubUser>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(LOG_TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(GitHubUser gitHubUser) {
                        adapter.addUser(gitHubUser);
                    }
                });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        subscription.unsubscribe();
    }
}

