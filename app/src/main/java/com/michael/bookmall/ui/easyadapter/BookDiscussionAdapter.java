package com.michael.bookmall.ui.easyadapter;

import android.content.Context;
import android.view.ViewGroup;

import com.michael.bookmall.R;
import com.michael.bookmall.bean.DiscussionList;
import com.michael.bookmall.view.recyclerview.BaseViewHolder;
import com.michael.bookmall.view.recyclerview.RecyclerArrayAdapter;

/**
 * Created by Michael on 2017/11/7.
 */

public class BookDiscussionAdapter extends RecyclerArrayAdapter<DiscussionList.PostsBean> {


    public BookDiscussionAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseViewHolder<DiscussionList.PostsBean>(parent, R.layout.item_community_book_discussion_list) {
            @Override
            public void setData(DiscussionList.PostsBean item) {
            }
        };
    }
}
