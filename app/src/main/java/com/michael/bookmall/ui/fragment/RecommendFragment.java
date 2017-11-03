package com.michael.bookmall.ui.fragment;

import com.michael.bookmall.R;
import com.michael.bookmall.base.BaseRVFragment;
import com.michael.bookmall.bean.BookMixAToc;
import com.michael.bookmall.bean.Recommend;
import com.michael.bookmall.ui.contract.RecommendContract;
import com.michael.bookmall.ui.presenter.RecommendPresenter;
import com.michael.bookmall.view.recyclerview.RecyclerArrayAdapter;

import java.util.List;

/** 书架
 * Created by chenyao on 2017/10/31.
 */

public class RecommendFragment extends BaseRVFragment<RecommendPresenter, Recommend.RecommendBooks>
        implements RecommendContract.View, RecyclerArrayAdapter.OnItemLongClickListener {

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void configView() {

    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void showError() {

    }

    @Override
    public void complete() {

    }

    @Override
    public void showRecommendList(List<Recommend.RecommendBooks> list) {

    }

    @Override
    public void showBookToc(String bookId, List<BookMixAToc.mixToc.Chapters> list) {

    }

    @Override
    public boolean onItemLongClick(int position) {
        return false;
    }
}
