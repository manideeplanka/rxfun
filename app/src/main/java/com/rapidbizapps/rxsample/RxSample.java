package com.rapidbizapps.rxsample;

import android.util.Log;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by mlanka on 12-05-2016.
 */
public class RxSample {

    public static void main(String[] args) {
        //emits data only when it has an observer - Cold Observable
        //TODO how to make this 'hot'?
        Observable<String> myObservable = Observable.just("Takishima Kei");

        Observer<String> myObserver = new Observer<String>() {
            @Override
            public void onCompleted() {
                //runs when the stream completes
            }

            @Override
            public void onError(Throwable e) {
                //runs when the stream ends abruptly
            }

            @Override
            public void onNext(String o) {
                //runs each time the observable emits data
                System.out.print(o);
            }
        };

        Subscription mySubscription = myObservable.subscribe(myObserver);

    }
}
