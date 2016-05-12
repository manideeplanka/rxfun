package com.rapidbizapps.rxsample;

import android.util.Log;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by mlanka on 12-05-2016.
 */
public class RxSample {

    public static void main(String[] args) {
        //emits data only when it has an observer - Cold Observable
        //TODO how to make this 'hot'?
        Observable.from(new String[]{
                "Arthur", "Molly", "Bill", "Charlie", "Percy", "Fred", "George", "Ron", "Ginny"
                })  //emits each item from the array
                .skip(2) //skips the first two items
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        return s + " Weasley";
                    }
                }) //maps each item to a string attached with Weasley to the original item
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println(s);
                    }
                });

    }
}
