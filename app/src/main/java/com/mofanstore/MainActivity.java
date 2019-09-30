package com.mofanstore;

import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mofanstore.base.BaseActivity;
import com.mofanstore.ui.fragment.HuaBaoFragemnt;
import com.mofanstore.ui.fragment.MassageFrament;
import com.mofanstore.ui.fragment.NewHomeFragmnet;
import com.mofanstore.ui.fragment.ShopcatFragment;
import com.mofanstore.ui.fragment.UserinfoFragment;

import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @InjectView(R.id.fl_container)
    FrameLayout flContainer;
    @InjectView(R.id.iv_home)
    ImageView ivHome;
    @InjectView(R.id.tv_home)
    TextView tvHome;
    @InjectView(R.id.ll_home)
    LinearLayout llHome;
    @InjectView(R.id.iv_zixuan)
    ImageView ivZixuan;
    @InjectView(R.id.tv_zixuan)
    TextView tvZixuan;
    @InjectView(R.id.ll_zixuan)
    LinearLayout llZixuan;
    @InjectView(R.id.iv_hangqing)
    ImageView ivHangqing;
    @InjectView(R.id.tv_hangqing)
    TextView tvHangqing;
    @InjectView(R.id.ll_hangqing)
    LinearLayout llHangqing;
    @InjectView(R.id.iv_fax)
    ImageView ivFax;
    @InjectView(R.id.tv_fax)
    TextView tvFax;
    @InjectView(R.id.ll_fax)
    LinearLayout llFax;
    @InjectView(R.id.iv_my)
    ImageView ivMy;
    @InjectView(R.id.tv_dianpu)
    TextView tvDianpu;
    @InjectView(R.id.ll_my)
    LinearLayout llMy;
    private FragmentManager fragmentManager;
    NewHomeFragmnet homeFragment;
    UserinfoFragment userinfoFragment;
    HuaBaoFragemnt huaBaoFragemnt;
    MassageFrament massageFrament;
    ShopcatFragment shopcatFragment;

    @Override
    public int intiLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        fragmentManager = getSupportFragmentManager();
        setTabSelection(0);
    }

    @Override
    public void initData() {

    }

    private void setTabSelection(int position) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragments(transaction);
        switch (position) {
            case 0:
                if (homeFragment == null) {
                    homeFragment = new NewHomeFragmnet();
                    transaction.add(R.id.fl_container, homeFragment);
                } else {
                    transaction.show(homeFragment);
                }
                break;
            case 1:
                if (huaBaoFragemnt == null) {
                    huaBaoFragemnt = new HuaBaoFragemnt();
                    transaction.add(R.id.fl_container, huaBaoFragemnt);
                } else {
                    transaction.show(huaBaoFragemnt);
                }
                break;

            case 2:
                if (shopcatFragment == null) {
                    shopcatFragment = new ShopcatFragment();
                    transaction.add(R.id.fl_container, shopcatFragment);
                } else {
                    transaction.show(shopcatFragment);
                }

                break;
            case 3:

                if (massageFrament == null) {
                    massageFrament = new MassageFrament();
                    transaction.add(R.id.fl_container, massageFrament);
                } else {
                    transaction.show(massageFrament);
                }

                break;
            case 4:

                if (userinfoFragment == null) {
                    userinfoFragment = new UserinfoFragment();
                    transaction.add(R.id.fl_container, userinfoFragment);
                } else {
                    transaction.show(userinfoFragment);
                }

                break;
        }
        transaction.commitAllowingStateLoss();
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (homeFragment != null) {

            transaction.hide(homeFragment);
        }
        if (userinfoFragment != null) {
            transaction.hide(userinfoFragment);
        }
        if (massageFrament != null) {
            transaction.hide(massageFrament);
        }
        if (shopcatFragment != null) {
            transaction.hide(shopcatFragment);
        }
        if (huaBaoFragemnt != null) {
            transaction.hide(huaBaoFragemnt);
        }
    }
    private SharedPreferences sp;
    @OnClick({R.id.ll_home, R.id.ll_fax, R.id.ll_my, R.id.ll_hangqing, R.id.ll_zixuan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_home:
                ivHome.setImageResource(R.mipmap.icon_home2);
                ivFax.setImageResource(R.mipmap.tabbar_optional_icon);
                ivMy.setImageResource(R.mipmap.icon_mine);
                ivZixuan.setImageResource(R.mipmap.tabbar_market_icon);
                ivHangqing.setImageResource(R.mipmap.tabbar_market_icon2);

                tvHome.setTextColor(0xff555555);
                tvFax.setTextColor(0xff999999);
                tvDianpu.setTextColor(0xff999999);
                tvZixuan.setTextColor(0xff999999);
                tvHangqing.setTextColor(0xff999999);
                setTabSelection(0);
                break;
            case R.id.ll_zixuan:
                ivHome.setImageResource(R.mipmap.icon_home);
                ivFax.setImageResource(R.mipmap.tabbar_optional_icon);
                ivMy.setImageResource(R.mipmap.icon_mine);
                ivZixuan.setImageResource(R.mipmap.tabbar_optional_click_icon);
                ivHangqing.setImageResource(R.mipmap.tabbar_market_icon2);

                tvHome.setTextColor(0xff999999);
                tvFax.setTextColor(0xff999999);
                tvDianpu.setTextColor(0xff999999);
                tvZixuan.setTextColor(0xff555555);
                tvHangqing.setTextColor(0xff999999);
                setTabSelection(1);

                break;
            case R.id.ll_hangqing:
                ivHome.setImageResource(R.mipmap.icon_home);
                ivFax.setImageResource(R.mipmap.tabbar_optional_icon);
                ivMy.setImageResource(R.mipmap.icon_mine);
                ivZixuan.setImageResource(R.mipmap.tabbar_market_icon);
                ivHangqing.setImageResource(R.mipmap.tabbar_market_click_icon);

                tvHome.setTextColor(0xff999999);
                tvFax.setTextColor(0xff999999);
                tvDianpu.setTextColor(0xff999999);
                tvZixuan.setTextColor(0xff999999);
                tvHangqing.setTextColor(0xff555555);
                setTabSelection(2);

                break;
            case R.id.ll_fax:
                    ivHome.setImageResource(R.mipmap.icon_home);
                    ivFax.setImageResource(R.mipmap.icon_crystal_selected3);
                    ivMy.setImageResource(R.mipmap.icon_mine);
                    ivZixuan.setImageResource(R.mipmap.tabbar_market_icon);
                    ivHangqing.setImageResource(R.mipmap.tabbar_market_icon2);
                    tvHome.setTextColor(0xff999999);
                    tvFax.setTextColor(0xff555555);
                    tvDianpu.setTextColor(0xff999999);
                    tvZixuan.setTextColor(0xff999999);
                    tvHangqing.setTextColor(0xff999999);
                    setTabSelection(3);



                break;
            case R.id.ll_my:
                ivHome.setImageResource(R.mipmap.icon_home);
                ivFax.setImageResource(R.mipmap.tabbar_optional_icon);
                ivMy.setImageResource(R.mipmap.icon_mine_selected2);
                ivZixuan.setImageResource(R.mipmap.tabbar_market_icon);
                ivHangqing.setImageResource(R.mipmap.tabbar_market_icon2);

                tvHome.setTextColor(0xff999999);
                tvFax.setTextColor(0xff999999);
                tvDianpu.setTextColor(0xff555555);
                tvZixuan.setTextColor(0xff999999);
                tvHangqing.setTextColor(0xff999999);
                setTabSelection(4);
                break;
        }
    }


}

