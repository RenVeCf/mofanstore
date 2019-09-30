package com.mofanstore.ui.activity.Shopcar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mofanstore.R;
import com.mofanstore.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class ShoppayActivity extends BaseActivity {
    @InjectView(R.id.back)
    FrameLayout back;
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.tv_commiy)
    TextView tvCommiy;
    @InjectView(R.id.commit)
    FrameLayout commit;
    @InjectView(R.id.cart_name)
    TextView cartName;
    @InjectView(R.id.test)
    TextView test;
    @InjectView(R.id.cb_agree_alipay)
    CheckBox cbAgreeAlipay;
    @InjectView(R.id.alipay_rl)
    RelativeLayout alipayRl;
    @InjectView(R.id.cb_agree_wcpay)
    CheckBox cbAgreeWcpay;
    @InjectView(R.id.wchat_rl)
    RelativeLayout wchatRl;
    @InjectView(R.id.ipd_but2)
    Button ipdBut2;

    @Override
    public int intiLayout() {
        return R.layout.activit_shoppay;
    }

    @Override
    public void initView() {
        tvName.setText("支付方式");
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

    @OnClick({R.id.ipd_but2,R.id.back, R.id.alipay_rl, R.id.wchat_rl})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.alipay_rl:
                break;
            case R.id.wchat_rl:
                break;
            case R.id.ipd_but2:
                Intent intent=new Intent(ShoppayActivity.this,ShopcatpaysuccActivity.class);
                startActivity(intent);
                break;
        }
    }
}
