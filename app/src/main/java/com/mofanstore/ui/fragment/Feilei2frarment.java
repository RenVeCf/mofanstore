package com.mofanstore.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mofanstore.R;
import com.mofanstore.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class Feilei2frarment extends BaseFragment {
    @InjectView(R.id.tab)
    TabLayout tablayout;
    @InjectView(R.id.viewpager)
    ViewPager viewpager;
    public String[] str = new String[]{"精选", "推荐", "潮牌", "女装", "男装", "首饰"};
    private TabAdapter adapter;
    private Feileiitemfrarment feileiitemfrarment;
    TextView tab_text;
    @Override
    protected int intiLayout() {
        return R.layout.fragment_feileilayout;
    }

    @Override
    protected void initView() {
        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            fragments.add(feileiitemfrarment.newInstance(""));
        }
        adapter = new TabAdapter(getChildFragmentManager(), fragments);
        //给ViewPager设置适配器
        viewpager.setAdapter(adapter);
        //将TabLayout和ViewPager关联起来。
        tablayout.setupWithViewPager(viewpager);
        tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        for (int i = 0; i < adapter.getCount(); i++) {
            TabLayout.Tab tab = tablayout.getTabAt(i);//获得每一个tab
            tab.setCustomView(R.layout.activity_tab_item);//给每一个tab设置view
            tab_text = (TextView) tab.getCustomView().findViewById(R.id.tab_tex);
            if (i == 0) {
                // 设置第一个tab的TextView是被选择的样式
                ((TextView) tab.getCustomView().findViewById(R.id.tab_tex)).setTextColor(0xff333333);
                ((TextView) tab.getCustomView().findViewById(R.id.tab_tex)).setTextSize(14);

            }
            tab_text.setText(str[i]);//设置tab上的文字
        }

        tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                ((TextView) tab.getCustomView().findViewById(R.id.tab_tex)).setTextColor(0xff333333);
                ((TextView) tab.getCustomView().findViewById(R.id.tab_tex)).setTextSize(14);
                viewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                ((TextView) tab.getCustomView().findViewById(R.id.tab_tex)).setTextColor(0xff999999);
                ((TextView) tab.getCustomView().findViewById(R.id.tab_tex)).setTextSize(12);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }



    @Override
    protected void initData() {

    }


    class TabAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments;


        public TabAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }


        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.inject(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

}
