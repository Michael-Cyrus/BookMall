package com.michael.bookmall.ui.fragment;

import android.os.Bundle;

import com.michael.bookmall.R;
import com.michael.bookmall.base.BaseRVFragment;
import com.michael.bookmall.base.Constant;
import com.michael.bookmall.bean.DiscussionList;
import com.michael.bookmall.component.AppComponent;
import com.michael.bookmall.component.DaggerCommunityComponent;
import com.michael.bookmall.event.SelectionEvent;
import com.michael.bookmall.ui.contract.BookDiscussionContract;
import com.michael.bookmall.ui.easyadapter.BookDiscussionAdapter;
import com.michael.bookmall.ui.presenter.BookDiscussionPresenter;
import com.michael.bookmall.utils.ToastUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * Created by Michael on 2017/11/7.
 */

public class BookDiscussionFragment extends BaseRVFragment<BookDiscussionPresenter, DiscussionList.PostsBean>
        implements BookDiscussionContract.View {

    private static final String BUNDLE_BLOCK = "block";

    private String block = "ramble";
    private String sort = Constant.SortType.DEFAULT;
    private String distillate = Constant.Distillate.ALL;

    public static BookDiscussionFragment newInstance(String block) {
        BookDiscussionFragment fragment = new BookDiscussionFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_BLOCK, block);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerCommunityComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.common_easy_recyclerview;
    }

    @Override
    protected void initData() {
        block = getArguments().getString(BUNDLE_BLOCK);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void configView() {
        initAdapter(BookDiscussionAdapter.class, true, true);
        onRefresh();
    }

    @Override
    public void onRefresh() {
        mPresenter.getBookDisscussionList(block, sort, distillate, 0, limit);
    }

    @Override
    public void onLoadMore() {
        mPresenter.getBookDisscussionList(block, sort, distillate, start, limit);
    }

    @Override
    public void onItemClick(int position) {
        DiscussionList.PostsBean data = mAdapter.getItem(position);
//        BookDiscussionDetailActivity.startActivity(activity, data._id);
        ToastUtils.showToast("跳转到 BookDiscussionDetailActivity");
    }

    @Override
    public void showError() {
        loaddingError();
    }

    @Override
    public void complete() {
        mRecyclerView.setRefreshing(false);
    }

    @Override
    public void showBookDisscussionList(List<DiscussionList.PostsBean> list, boolean isRefresh) {
        if (isRefresh) {
            mAdapter.clear();
            start = 0;
        }
        mAdapter.addAll(list);
        start = start + list.size();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void initCategoryList(SelectionEvent event) {
        mRecyclerView.setRefreshing(true);
        sort = event.sort;
        distillate = event.distillate;
        onRefresh();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }
}
