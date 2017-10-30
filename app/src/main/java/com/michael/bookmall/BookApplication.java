package com.michael.bookmall;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

/**
 * Created by chenyao on 2017/10/30.
 */

public class BookApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Utils.init(this);
    }
}
