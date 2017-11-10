package com.michael.bookmall.ui.activity;

import android.content.Context;
import android.content.Intent;

import com.michael.bookmall.R;
import com.michael.bookmall.base.BaseCommuniteActivity;
import com.michael.bookmall.component.AppComponent;
import com.michael.bookmall.ui.fragment.BookDiscussionFragment;

import java.util.List;

/**
 * Created by Michael on 2017/11/6.
 */

public class BookDiscussionActivity extends BaseCommuniteActivity {

    private static final String INTENT_DIS = "isDis";
    private boolean mIsDiscussion;

    public static void startActivity(Context context, boolean isDiscussion) {
        Intent intent = new Intent(context, BookDiscussionActivity.class);
        intent.putExtra(INTENT_DIS, isDiscussion);
        context.startActivity(intent);
    }

    @Override
    protected List<List<String>> getTabList() {
        return list1;
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
        mIsDiscussion = getIntent().getBooleanExtra(INTENT_DIS, false);
        if (mIsDiscussion) {
            mCommonToolbar.setTitle("综合讨论区");
        } else {
            mCommonToolbar.setTitle("原创区");
        }
        mCommonToolbar.setNavigationIcon(R.mipmap.ab_back);
    }

    @Override
    public void initView() {
        BookDiscussionFragment fragment = BookDiscussionFragment.newInstance(mIsDiscussion ? "ramble" : "original");
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentCO, fragment).commit();
    }
}
