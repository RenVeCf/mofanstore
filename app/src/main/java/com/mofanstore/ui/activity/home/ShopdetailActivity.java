package com.mofanstore.ui.activity.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.gxz.PagerSlidingTabStrip;
import com.mofanstore.R;
import com.mofanstore.base.BaseActivity;
import com.mofanstore.ui.activity.Adater.ItemTitlePagerAdapter;
import com.mofanstore.ui.fragment.GoodsCommentFragment;
import com.mofanstore.ui.fragment.GoodsDetailFragment;
import com.mofanstore.ui.fragment.GoodsInfoFragment;
import com.mofanstore.ui.fragment.GoodsTuijFragment;
import com.mofanstore.util.widget.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class ShopdetailActivity extends BaseActivity {
    @InjectView(R.id.iv_back)
    ImageView ivBack;
    @InjectView(R.id.ll_back)
    LinearLayout llBack;
    @InjectView(R.id.psts_tabs)
    PagerSlidingTabStrip psts_tabs;
    @InjectView(R.id.ll_title_root)
    LinearLayout llTitleRoot;
    @InjectView(R.id.vp_content)
    NoScrollViewPager vp_content;
    private List<Fragment> fragmentList = new ArrayList<>();
    private GoodsInfoFragment goodsInfoFragment;
    private GoodsDetailFragment goodsDetailFragment;
    private GoodsCommentFragment goodsCommentFragment;
    private GoodsTuijFragment goodsTuijFragment;
    @Override
    public int intiLayout() {
        return R.layout.activit_shopdetail;
    }

    @Override
    public void initView() {
        fragmentList.add(goodsInfoFragment = new GoodsInfoFragment());
        fragmentList.add(goodsDetailFragment = new GoodsDetailFragment());
        fragmentList.add(goodsCommentFragment = new GoodsCommentFragment());
        fragmentList.add(goodsTuijFragment = new GoodsTuijFragment());
        vp_content.setAdapter(new ItemTitlePagerAdapter(getSupportFragmentManager(),
                fragmentList, new String[]{"商品", "详情", "评价", "推荐"}));
        vp_content.setOffscreenPageLimit(4);
        psts_tabs.setViewPager(vp_content);
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

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
