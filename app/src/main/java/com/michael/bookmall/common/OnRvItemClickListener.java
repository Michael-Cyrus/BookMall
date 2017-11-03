package com.michael.bookmall.common;

import android.view.View;

/**
 * Created by Michael on 2017/11/3.
 */

public interface OnRvItemClickListener<T> {

    void onItemClick(View view, int position, T data);

}
