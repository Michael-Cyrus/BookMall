package com.michael.bookmall.component;

import com.michael.bookmall.ui.fragment.BookDiscussionFragment;

import dagger.Component;

/**
 * Created by Michael on 2017/11/7.
 */

@Component(dependencies = AppComponent.class)
public interface CommunityComponent {

    BookDiscussionFragment inject(BookDiscussionFragment fragment);
}
