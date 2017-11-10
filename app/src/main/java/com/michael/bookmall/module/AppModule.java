package com.michael.bookmall.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Michael on 2017/11/7.
 */

@Module
public class AppModule {

    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext(){
        return context;
    }
}
