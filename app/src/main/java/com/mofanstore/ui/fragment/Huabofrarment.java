package com.mofanstore.ui.fragment;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.mofanstore.R;
import com.mofanstore.base.BaseFragment;
import com.mofanstore.ui.activity.hulan.IssueActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

public class Huabofrarment extends BaseFragment {

    public String[] str = new String[]{"精选", "推荐", "最新", "女装", "男装", "时尚"};
    @InjectView(R.id.tab)
    TabLayout tablayout;
    @InjectView(R.id.viewpager)
    ViewPager viewpager;
    @InjectView(R.id.tv_huidu)
    TextView tvHuidu;
    private TabAdapter adapter;
    private HuboitemFragment huboitemFragment;
    TextView tab_text;

    @Override
    protected int intiLayout() {
        return R.layout.framet_huabo;
    }

    @Override
    protected void initView() {
        tvHuidu.setVisibility(View.VISIBLE);
        tvHuidu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), IssueActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {
        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            fragments.add(huboitemFragment.newInstance(""));
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

}
