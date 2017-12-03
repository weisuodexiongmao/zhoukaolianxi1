package com.bawei.zhoukaolianxi1.M;

import com.bawei.zhoukaolianxi1.bean.Bean;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 猥琐的熊猫 on 2017/12/2.
 */

public class Mod {
public void Data(final getData data){
    //得到网络请求数据源
    Retrofit retrofit=new Retrofit.Builder().baseUrl(Api.HOST).addConverterFactory(GsonConverterFactory.create())
            //支持Rxjava
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build();
    DataApi dataApi = retrofit.create(DataApi.class);
    //得到Observable被观察者      生产时间 得到数据源
    Observable<Bean> observable = dataApi.getData(10,1);
    //被观察者订阅观察者  默认在同一个线程
    observable
            //指定io线程做耗时操作
            .subscribeOn(Schedulers.io())
            //指定更新UI在主线程
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Observer<Bean>() {
                @Override
                public void onCompleted() {//完成

                }

                @Override
                public void onError(Throwable e) {//失败

                }

                @Override
                public void onNext(Bean bean) {
                    data.Datas(bean);
                }



            });

}
public interface getData{
    void Datas(Bean bean);
}
}

