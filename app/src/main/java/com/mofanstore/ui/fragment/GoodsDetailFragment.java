package com.mofanstore.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.mofanstore.R;
import com.mofanstore.base.BaseFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class GoodsDetailFragment extends BaseFragment {
    @InjectView(R.id.wv_goods_detailed)
    WebView tvContext;

    @Override
    protected int intiLayout() {
        return R.layout.fragment_gooddetail;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

        WebSettings webSettings = tvContext.getSettings();

        /*与js交互*/
        webSettings.setJavaScriptEnabled(true);


        tvContext.getSettings().setSavePassword(false);
        tvContext.setVerticalScrollBarEnabled(false);
        tvContext.setHorizontalScrollBarEnabled(false);
// 设置可以支持缩放
        tvContext.getSettings().setSupportZoom(true);
// 扩大比例的缩放
        tvContext.getSettings().setUseWideViewPort(true);
        tvContext.getSettings().setDisplayZoomControls(false);
// 自适应屏幕
        tvContext.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        tvContext.getSettings().setLoadWithOverviewMode(true);
        tvContext.getSettings().setDomStorageEnabled(true);

        /*细节操作*/
        webSettings.setBuiltInZoomControls(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持js弹窗
        tvContext.setWebViewClient(new WebViewClient());
        tvContext.loadUrl("https://www.baidu.com/");
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
