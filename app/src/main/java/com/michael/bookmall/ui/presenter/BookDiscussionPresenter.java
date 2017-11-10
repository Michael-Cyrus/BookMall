package com.michael.bookmall.ui.presenter;

import com.blankj.utilcode.util.LogUtils;
import com.michael.bookmall.api.BookApi;
import com.michael.bookmall.base.RxPresenter;
import com.michael.bookmall.bean.DiscussionList;
import com.michael.bookmall.ui.contract.BookDiscussionContract;
import com.michael.bookmall.utils.RxUtil;
import com.michael.bookmall.utils.StringUtils;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by Michael on 2017/11/7.
 */

public class BookDiscussionPresenter extends RxPresenter<BookDiscussionContract.View> implements BookDiscussionContract.Presenter {

//    @Inject
    private BookApi bookApi;

    @Inject
    public BookDiscussionPresenter(BookApi bookApi) {
        this.bookApi = bookApi;
    }

    @Override
    public void getBookDisscussionList(String block, String sort, String distillate, final int start, int limit) {
        String key = StringUtils.creatAcacheKey("book-discussion-list", block, "all", sort, "all", start + "", limit + "", distillate);

        Observable<DiscussionList> fromNetWork = bookApi.getBookDisscussionList(block, "all", sort, "all", start + "", limit + "", distillate)
                .compose(RxUtil.<DiscussionList>rxCacheListHelper(key));

        Subscription subscribe = Observable.concat(RxUtil.rxCreateDiskObservable(key, DiscussionList.class), fromNetWork)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DiscussionList>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }
                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getBookDisscussionList:" + e.toString());
                        mView.showError();
                    }
                    @Override
                    public void onNext(DiscussionList list) {
                        boolean isRefresh = start == 0 ? true : false;
                        mView.showBookDisscussionList(list.posts, isRefresh);
                    }
                });
        addSubscrebe(subscribe);
    }
}
