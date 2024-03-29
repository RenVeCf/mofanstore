package com.mofanstore.http;


import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by jumpbox on 16/5/2.
 */
public class RxHttp<T> {
    public void send(Observable<T> observable, Subscriber<T> subscription) {
        observable.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).unsubscribeOn(Schedulers.io()).subscribe(subscription);
    }
}
