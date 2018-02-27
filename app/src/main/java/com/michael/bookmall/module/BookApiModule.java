package com.michael.bookmall.module;

import com.michael.bookmall.api.BookApi;
import com.michael.bookmall.api.LoggingInterceptor;
import com.michael.bookmall.utils.LogUtils;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by Michael on 2017/11/7.
 */

@Module
public class BookApiModule {

    @Provides
    public OkHttpClient provideOkHttpClient(){

        LoggingInterceptor interceptor = new LoggingInterceptor(new LoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                LogUtils.i("http : " + message);
            }
        });
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(20 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(20 * 1000, TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true)     // 失败重发
                .addInterceptor(interceptor);
        return builder.build();
    }

    @Provides
    public BookApi provideBookService(OkHttpClient okHttpClient){
        return BookApi.getInstance(okHttpClient);
    }
}
