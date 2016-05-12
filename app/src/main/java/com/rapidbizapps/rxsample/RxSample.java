package com.rapidbizapps.rxsample;

import android.util.Log;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

/**
 * Created by mlanka on 12-05-2016.
 */
public class RxSample {

    public static void main(String[] args) {
        Observable<Integer> myObservable1 = Observable.from(new Integer[]{1, 2, 3, 4, 5, 6});

        Observable<Integer> myObservable2 = Observable.from(new Integer[]{0, 32, 33, 34, 35, 36});

        //do something after two Observables
        Observable<Integer> zipped = Observable.zip(myObservable1, myObservable2, new Func2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) {
                return integer / integer2;
            }
        });


        zipped.subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("Done");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e.getMessage());
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);
            }
        });

        //emit the results one after the other
        Observable<Integer> concatenated = Observable.concat(myObservable1,myObservable2);

        concatenated.subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer + "");
            }
        });
    }
}
