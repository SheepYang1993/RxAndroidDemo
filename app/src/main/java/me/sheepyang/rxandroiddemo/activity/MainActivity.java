package me.sheepyang.rxandroiddemo.activity;

import android.os.Bundle;

import me.sheepyang.rxandroiddemo.R;
import rx.Observable;
import rx.Subscriber;

public class MainActivity extends BaseActivity {


    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Subscriber subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String msg) {
                log(msg);
            }
        };
        String[] words = {"Hello", "Hi", "Aloha"};
//        Observable observable = Observable.just(words);
        Observable observable = Observable.from(words);
        observable.subscribe(subscriber);
    }
}
