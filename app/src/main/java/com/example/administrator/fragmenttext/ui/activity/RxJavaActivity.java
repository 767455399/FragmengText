package com.example.administrator.fragmenttext.ui.activity;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.fragmenttext.R;
import com.example.administrator.fragmenttext.base.BaseActivity;
import com.example.administrator.fragmenttext.toast.ToastUtil;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


public class RxJavaActivity extends BaseActivity implements View.OnClickListener {
private Button button;
    private int sum;
    int i=0;


    @Override
    protected void initView() {
        setContentView(R.layout.activity_rx_java);
        button=(Button)findViewById(R.id.button);
      /*  button.setOnClickListener(this);*/
        log();
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void loadDate() {

    }

    @Override
    protected void mobclickAgentStart() {

    }

    @Override
    protected void mobclickAgentEnd() {

    }

   /* @Override
    public void loadDate() {
       *//* Observable<String> myObservable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("wang qing");
                subscriber.onCompleted();
            }
        });*//*
       *//* Observable<String>myObservable=Observable.just("wwwwwwwwwww");
        Action1<String>onNextAction= new Action1<String>() {
            @Override
            public void call(String s) {
                ToastUtil.showSuccessToast(s,RxJavaActivity.this);
            }
        };*//*

       *//* Subscriber<String>mySubscriber=new Subscriber<String>() {
            @Override
            public void onCompleted() {


            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                ToastUtil.showSuccessToast(s,RxJavaActivity.this);
            }
        };*//*
       *//* myObservable.subscribe(onNextAction);*//*
        Observable.just("wqwqwq").map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                return s+"@@@@@@";
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<String>() {
                         @Override
                         public void onCompleted() {

                         }

                         @Override
                         public void onError(Throwable e) {

                         }

                         @Override
                         public void onNext(String s) {
                             ToastUtil.showSuccessToast(s,RxJavaActivity.this);
                         }
                     }
        );


        Observable.just("123", "456")
               *//* .flatMap(new Func1<String, Observable<String>>() {
            @Override
            public Observable<String> call(String s) {
                return Observable.from(new String[]{"456"});
            }
        })*//*
                .subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).
                map(new Func1<String, Integer>() {
                    @Override
                    public Integer call(String s) {
                        return getAbc(s);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Integer>() {


                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Integer o) {
                        ToastUtil.showSuccessToast(o.toString(), RxJavaActivity.this);
                    }
                });
      *//* Observable observable=Observable.create(new Observable.OnSubscribe<String>() {
           @Override
           public void call(Subscriber<? super String> subscriber) {

           }
       });*//*


    }*/



    public int getAbc(String a) {
        return sum += Integer.valueOf(a);
    }


    public void log(){
           /*Observable.just("1", "2", "3", "4").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                android.util.Log.d("ljx",s);
                ToastUtil.showSuccessToast(s, RxJavaActivity.this);
            }
        });*/
       /* Observable.just("1","2","3").flatMap(new Func1<String, Observable<String>>() {
            @Override
            public Observable<String> call(String s) {
                return Observable.from(s.split(","));
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String o) {
                System.out.println("<<<<<<<<<wangqing>>>>>>>"+o);
                ToastUtil.showSuccessToast(o,RxJavaActivity.this);

            }
        });*/
        Observable.just("25","15","17").map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                return s;
            }
        }).subscribeOn(AndroidSchedulers.mainThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("<<<<<<<<wangqing>>>>>>>"+s);
                ToastUtil.showSuccessToast(s,RxJavaActivity.this);

            }
        });
       /* Observable observable=Observable.just("1","2");
        observable.observeOn(AndroidSchedulers.mainThread()).observeOn(Schedulers.io()).subscribe(new Subscriber() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {

            }
        });*/

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                         // RxBinding 代码，后面的文章有解释
                Observable.create(new Observable.OnSubscribe<Void>() {
                    @Override
                    public void call(Subscriber<? super Void> observer) {
                        observer.onNext(null);
                        observer.onCompleted();
                    }
                } ).throttleFirst(5000, TimeUnit.MILLISECONDS) // 设置防抖间隔为 500ms
                        .subscribe(new Subscriber<Void>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(Void aVoid) {
                               i++;
                                ToastUtil.showSuccessToast(i+"",RxJavaActivity.this);
                            }
                        });
                break;
        }
    }
}
