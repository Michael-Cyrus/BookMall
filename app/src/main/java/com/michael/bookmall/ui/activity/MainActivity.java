package com.michael.bookmall.ui.activity;

import android.support.v4.view.ViewPager;
import android.view.Menu;

import com.michael.bookmall.R;
import com.michael.bookmall.base.BaseActivity;
import com.michael.bookmall.component.AppComponent;
import com.michael.bookmall.ui.fragment.CommunityFragment;
import com.michael.bookmall.ui.fragment.FindFragment;
import com.michael.bookmall.ui.fragment.RecommendFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import butterknife.Bind;

public class MainActivity extends BaseActivity {

    @Bind(R.id.viewpagertab)
    SmartTabLayout viewpagertab;
    @Bind(R.id.viewpager)
    ViewPager viewpager;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setLogo(R.mipmap.logo);
        setTitle("");
    }

    @Override
    public void initData() {
    }

    @Override
    public void initView() {
        FragmentPagerItems pages = new FragmentPagerItems(this);
        pages.add(FragmentPagerItem.of("书架", RecommendFragment.class));
        pages.add(FragmentPagerItem.of("社区", CommunityFragment.class));
        pages.add(FragmentPagerItem.of("发现", FindFragment.class));
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(getSupportFragmentManager(), pages);
        viewpager.setAdapter(adapter);
        viewpagertab.setViewPager(viewpager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
