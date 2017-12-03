package com.bawei.zhoukaolianxi1.M;

import com.bawei.zhoukaolianxi1.bean.Bean;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by 猥琐的熊猫 on 2017/12/2.
 */

public interface DataApi {
    @GET("Android/{size}/{page}")
    Observable<Bean>getData(@Path("size") int size, @Path("page") int page);

}
