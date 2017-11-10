package com.michael.bookmall.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.michael.bookmall.R;
import com.michael.bookmall.base.BaseFragment;
import com.michael.bookmall.bean.FindBean;
import com.michael.bookmall.common.OnRvItemClickListener;
import com.michael.bookmall.component.AppComponent;
import com.michael.bookmall.ui.activity.BookDiscussionActivity;
import com.michael.bookmall.ui.adapter.FindAdapter;
import com.michael.bookmall.view.SupportDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/** 社区
 * Created by chenyao on 2017/10/31.
 */

public class CommunityFragment extends BaseFragment implements OnRvItemClickListener<FindBean> {

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
        mList.add(new FindBean("综合讨论区", R.mipmap.discuss_section));
        mList.add(new FindBean("书评区", R.mipmap.comment_section));
        mList.add(new FindBean("书荒互助区", R.mipmap.helper_section));
        mList.add(new FindBean("女生区", R.mipmap.girl_section));
        mList.add(new FindBean("原创区",R.mipmap.yuanchuang));
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
        switch (position){
            case 0:
                BookDiscussionActivity.startActivity(activity, true);
                break;
        }
    }
}
