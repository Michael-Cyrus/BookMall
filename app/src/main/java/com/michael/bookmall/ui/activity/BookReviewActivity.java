package com.michael.bookmall.ui.activity;

import android.content.Context;
import android.content.Intent;

import com.michael.bookmall.R;
import com.michael.bookmall.base.BaseCommuniteActivity;
import com.michael.bookmall.component.AppComponent;

import java.util.List;

/**
 * Created by Michael on 2017/11/30.
 */

public class BookReviewActivity extends BaseCommuniteActivity {

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, BookReviewActivity.class));
    }

    @Override
    protected List<List<String>> getTabList() {
        return list2;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_community_book_discussion;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public void initToolBar() {

    }

    @Override
    public void initView() {

    }
}
