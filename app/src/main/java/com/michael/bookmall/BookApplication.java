package com.michael.bookmall;

import android.app.Application;
import android.content.Context;

import com.michael.bookmall.component.AppComponent;
import com.michael.bookmall.component.DaggerAppComponent;
import com.michael.bookmall.module.AppModule;
import com.michael.bookmall.module.BookApiModule;
import com.michael.bookmall.utils.AppUtils;
import com.michael.bookmall.utils.SharedPreferencesUtil;

/**
 * Created by chenyao on 2017/10/30.
 */

public class BookApplication extends Application {

    private static BookApplication sInstance;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
//        Utils.init(this);
        AppUtils.init(this);
        initCompoent();
        initPrefs();
    }

    public static BookApplication getsInstance() {
        return sInstance;
    }

    private void initCompoent() {
        appComponent = DaggerAppComponent.builder()
                .bookApiModule(new BookApiModule())
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    /**
     * 初始化SharedPreference
     */
    protected void initPrefs() {
        SharedPreferencesUtil.init(getApplicationContext(), getPackageName() + "_preference", Context.MODE_MULTI_PROCESS);
    }
}
