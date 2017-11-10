package com.michael.bookmall.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.michael.bookmall.R;
import com.michael.bookmall.base.BaseFragment;
import com.michael.bookmall.bean.FindBean;
import com.michael.bookmall.common.OnRvItemClickListener;
import com.michael.bookmall.component.AppComponent;
import com.michael.bookmall.ui.adapter.FindAdapter;
import com.michael.bookmall.view.SupportDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/** 发现
 * Created by chenyao on 2017/10/31.
 */

public class FindFragment extends BaseFragment implements OnRvItemClickListener<FindBean> {
    @Bind(R.id.recyclerview)
    RecyclerView mRecyclerView;

    private FindAdapter mAdapter;
    private List<FindBean> mList = new ArrayList<>();

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_find;
    }

    @Override
    public void initData() {
        mList.clear();
        mList.add(new FindBean("排行榜", R.mipmap.home_find_rank));
        mList.add(new FindBean("主题书单", R.mipmap.home_find_topic));
        mList.add(new FindBean("分类", R.mipmap.home_find_category));
        mList.add(new FindBean("官方QQ群", R.mipmap.home_find_listen));
    }

    @Override
    public void configView() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new SupportDividerItemDecoration(mContext, LinearLayoutManager.VERTICAL, true));

        mAdapter = new FindAdapter(mContext, mList, this);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void attachView() {

    }

    @Override
    public void onItemClick(View view, int position, FindBean data) {

    }
}
