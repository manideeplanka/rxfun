package com.rapidbizapps.rxsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    Button button;
    List<String> names = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);

        names.add("Sorcerer's Stone");
        names.add("Chamber of Secrets");
        names.add("Prisoner of Askaban");
        names.add("Goblet tof Fire");
        names.add("Order of the Pheonix");
        names.add("Half-blood Prince");
        names.add("Deathly Hallows");


        Func1<List<String>, Observable<String>> getUrls = new Func1<List<String>, Observable<String>>() {
            @Override
            public Observable<String> call(List<String> strings) {
                return Observable.from(strings);
            }
        };

        //crashes when there are no elements in stream
        Action1<String> toastOnNextAction = new Action1<String>() {
            @Override
            public void call(String s) {
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        };

        //does not crash. error handling
       /* Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.d(LOG_TAG, "onError: " + e.getMessage());
            }

            @Override
            public void onNext(String s) {
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        };*/

        Func2<String, String, String> mergeRoutine = new Func2<String, String, String>() {
            @Override
            public String call(String s, String s2) {
                return s + "\n" + s2;
            }
        };


        Observable.just(names)
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(getUrls)
                .reduce(mergeRoutine)
                .subscribe(toastOnNextAction);
    }
}

