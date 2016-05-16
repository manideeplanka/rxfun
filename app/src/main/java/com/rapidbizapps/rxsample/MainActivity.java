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

        Observable.just(names)
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(Observable::from)
                .reduce((s, s2) -> s + "\n" + s2)
                .subscribe(message -> Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show());
    }
}

