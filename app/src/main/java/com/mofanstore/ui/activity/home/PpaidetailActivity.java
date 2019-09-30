package com.mofanstore.ui.activity.home;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mofanstore.R;
import com.mofanstore.base.BaseActivity;
import com.mofanstore.ui.fragment.HomeitemFragment;
import com.mofanstore.util.RoundAngleImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class PpaidetailActivity extends BaseActivity {
    @InjectView(R.id.tv_commiy)
    ImageView tvCommiy;
    @InjectView(R.id.back)
    FrameLayout back;
    @InjectView(R.id.ed_keyword)
    TextView edKeyword;
    @InjectView(R.id.llousuo)
    LinearLayout llousuo;
    @InjectView(R.id.userimg)
    RoundAngleImageView userimg;
    @InjectView(R.id.tv_username)
    TextView tvUsername;
    @InjectView(R.id.tv_time)
    TextView tvTime;
    @InjectView(R.id.tv_huidu)
    TextView tvHuidu;
    @InjectView(R.id.tv_shonpame)
    TextView tvShonpame;
    @InjectView(R.id.tv_all)
    TextView tvAll;
    @InjectView(R.id.toolbar)
    LinearLayout toolbar;
    @InjectView(R.id.my_group_quanbu)
    TextView myGroupQuanbu;
    @InjectView(R.id.my_group_quanbu2)
    TextView myGroupQuanbu2;
    @InjectView(R.id.my_group_quanbu3)
    TextView myGroupQuanbu3;
    @InjectView(R.id.my_group_quanbu4)
    TextView myGroupQuanbu4;
    @InjectView(R.id.my_group_quanbu5)
    TextView myGroupQuanbu5;
    @InjectView(R.id.rl_group_quanbu5)
    RelativeLayout rlGroupQuanbu5;
    @InjectView(R.id.appbar)
    AppBarLayout appbar;
    @InjectView(R.id.viewpager)
    ViewPager viewpager;
    @InjectView(R.id.main_content)
    CoordinatorLayout mainContent;
    private TabAdapter adapter;
    private HomeitemFragment homeitemFragment;
    @Override
    public int intiLayout() {
        return R.layout.activit_myppaidetail;
    }

    @Override
    public void initView() {

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(homeitemFragment.newInstance(""));
        adapter = new TabAdapter(getSupportFragmentManager(), fragments);
        //给ViewPager设置适配器
        viewpager.setAdapter(adapter);
        //将TabLayout和ViewPager关联起来。
    }

    @Override
    public void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.inject(this);
    }

    @OnClick({R.id.back, R.id.llousuo, R.id.tv_huidu, R.id.my_group_quanbu, R.id.my_group_quanbu2, R.id.my_group_quanbu3, R.id.my_group_quanbu4, R.id.my_group_quanbu5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.llousuo:
                break;
            case R.id.tv_huidu:
                break;
            case R.id.my_group_quanbu:
                myGroupQuanbu.setTextColor(0xff333333);
                myGroupQuanbu.setTextSize(14);
                myGroupQuanbu2.setTextSize(12);
                myGroupQuanbu3.setTextSize(12);
                myGroupQuanbu4.setTextSize(12);
                myGroupQuanbu5.setTextSize(12);
                myGroupQuanbu2.setTextColor(0xff999999);
                myGroupQuanbu3.setTextColor(0xff999999);
                myGroupQuanbu4.setTextColor(0xff999999);
                myGroupQuanbu5.setTextColor(0xff999999);
                break;
            case R.id.my_group_quanbu2:
                myGroupQuanbu2.setTextColor(0xff333333);
                myGroupQuanbu.setTextColor(0xff999999);
                myGroupQuanbu3.setTextColor(0xff999999);
                myGroupQuanbu4.setTextColor(0xff999999);
                myGroupQuanbu5.setTextColor(0xff999999);
                myGroupQuanbu2.setTextSize(14);
                myGroupQuanbu.setTextSize(12);
                myGroupQuanbu3.setTextSize(12);
                myGroupQuanbu4.setTextSize(12);
                myGroupQuanbu5.setTextSize(12);
                break;
            case R.id.my_group_quanbu3:
                myGroupQuanbu3.setTextColor(0xff333333);
                myGroupQuanbu2.setTextColor(0xff999999);
                myGroupQuanbu.setTextColor(0xff999999);
                myGroupQuanbu4.setTextColor(0xff999999);
                myGroupQuanbu5.setTextColor(0xff999999);
                myGroupQuanbu3.setTextSize(14);
                myGroupQuanbu.setTextSize(12);
                myGroupQuanbu2.setTextSize(12);
                myGroupQuanbu4.setTextSize(12);
                myGroupQuanbu5.setTextSize(12);
                break;
            case R.id.my_group_quanbu4:
                myGroupQuanbu4.setTextColor(0xff333333);
                myGroupQuanbu2.setTextColor(0xff999999);
                myGroupQuanbu3.setTextColor(0xff999999);
                myGroupQuanbu.setTextColor(0xff999999);
                myGroupQuanbu5.setTextColor(0xff999999);
                myGroupQuanbu4.setTextSize(14);
                myGroupQuanbu.setTextSize(12);
                myGroupQuanbu2.setTextSize(12);
                myGroupQuanbu3.setTextSize(12);
                myGroupQuanbu5.setTextSize(12);
                break;
            case R.id.my_group_quanbu5:
                myGroupQuanbu5.setTextColor(0xff333333);
                myGroupQuanbu2.setTextColor(0xff999999);
                myGroupQuanbu3.setTextColor(0xff999999);
                myGroupQuanbu4.setTextColor(0xff999999);
                myGroupQuanbu.setTextColor(0xff999999);
                myGroupQuanbu5.setTextSize(14);
                myGroupQuanbu.setTextSize(12);
                myGroupQuanbu2.setTextSize(12);
                myGroupQuanbu3.setTextSize(12);
                myGroupQuanbu4.setTextSize(12);
                break;
        }
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
