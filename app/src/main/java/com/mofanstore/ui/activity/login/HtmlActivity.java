package com.mofanstore.ui.activity.login;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.mofanstore.R;
import com.mofanstore.base.BaseActivity;

import butterknife.InjectView;
import butterknife.OnClick;


public class HtmlActivity extends BaseActivity {
    @InjectView(R.id.back)
    FrameLayout back;
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.tv_commiy)
    TextView tvCommiy;
    @InjectView(R.id.commit)
    FrameLayout commit;
    @InjectView(R.id.tv_context)
    WebView tvContext;
    String name;
    String url;
    @Override
    public int intiLayout() {
        return R.layout.activit_h5;
    }

    @Override
    public void initView() {
        name=getIntent().getExtras().getString("name");
        url=getIntent().getExtras().getString("url");
        tvName.setText(name);
    }

    @Override
    public void initData() {
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

        tvContext.loadUrl(url);

    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
