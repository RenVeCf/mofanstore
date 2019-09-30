package com.mofanstore.ui.activity.Shopcar;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.mofanstore.R;
import com.mofanstore.base.BaseActivity;
import com.mofanstore.ui.activity.Adater.WuliuAdater;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class WuliulvActivity extends BaseActivity {
    @InjectView(R.id.back)
    FrameLayout back;
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.tv_commiy)
    TextView tvCommiy;
    @InjectView(R.id.commit)
    FrameLayout commit;
    @InjectView(R.id.wuliulv)
    ListView wuliulv;
    WuliuAdater wuliuAdater;
    @Override
    public int intiLayout() {
        return R.layout.activit_wuliulv;
    }

    @Override
    public void initView() {
        tvName.setText("选择物流");
        wuliuAdater=new WuliuAdater(WuliulvActivity.this);
        wuliulv.setAdapter(wuliuAdater);
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

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
