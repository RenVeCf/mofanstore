package com.mofanstore.ui.activity.Shopcar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mofanstore.R;
import com.mofanstore.base.BaseActivity;
import com.mofanstore.ui.activity.Adater.ShopbootAdater;
import com.mofanstore.util.Ipd_Gridview;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class ShopcatpaysuccActivity extends BaseActivity {
    @InjectView(R.id.back)
    FrameLayout back;
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.tv_commiy)
    TextView tvCommiy;
    @InjectView(R.id.commit)
    FrameLayout commit;
    @InjectView(R.id.pay_meassge)
    TextView payMeassge;
    @InjectView(R.id.order_munber)
    TextView orderMunber;
    @InjectView(R.id.ipd_but1)
    Button ipdBut1;
    @InjectView(R.id.ipd_but2)
    Button ipdBut2;
    @InjectView(R.id.ipd_pay_grid_view)
    Ipd_Gridview ipdPayGridView;
    @InjectView(R.id.ipd_pay_ll)
    LinearLayout ipdPayLl;
    ShopbootAdater shopbootAdater;
    @Override
    public int intiLayout() {
        return R.layout.activit_shopcarsucc;
    }

    @Override
    public void initView() {
        tvName.setText("支付成功");
        shopbootAdater = new ShopbootAdater(ShopcatpaysuccActivity.this);
        ipdPayGridView.setAdapter(shopbootAdater);
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

    @OnClick({R.id.back, R.id.ipd_but1, R.id.ipd_but2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.ipd_but1:
                break;
            case R.id.ipd_but2:
                break;
        }
    }
}
