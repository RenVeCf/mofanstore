package com.mofanstore.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mofanstore.R;
import com.mofanstore.base.BaseFragment;

import butterknife.ButterKnife;

/**
 * item页ViewPager里的商品Fragment
 */
public class GoodsInfoFragment extends BaseFragment {

    @Override
    protected int intiLayout() {
        return R.layout.fragment_detailinfo;
    }

    @Override
    protected void initView() {
        setDetailData();
    }

    @Override
    protected void initData() {

    }

    /**
     * 加载完商品详情执行
     */
    public void setDetailData() {

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
