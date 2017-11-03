package com.michael.bookmall.ui.adapter;

import android.content.Context;
import android.view.View;

import com.michael.bookmall.R;
import com.michael.bookmall.bean.FindBean;
import com.michael.bookmall.common.OnRvItemClickListener;
import com.yuyh.easyadapter.recyclerview.EasyRVAdapter;
import com.yuyh.easyadapter.recyclerview.EasyRVHolder;

import java.util.List;

/**
 * Created by Michael on 2017/11/3.
 */

public class FindAdapter extends EasyRVAdapter<FindBean> {

    private OnRvItemClickListener listener;

    public FindAdapter(Context context, List list, OnRvItemClickListener listener) {
        super(context, list, R.layout.item_find);
        this.listener = listener;
    }

    @Override
    protected void onBindData(final EasyRVHolder holder, final int position, final FindBean item) {
        holder.setText(R.id.tvTitle, item.getTitle());
        holder.setImageResource(R.id.ivIcon, item.getIconResId());

        holder.setOnItemViewClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(holder.getItemView(), position, item);
            }
        });
    }
}
