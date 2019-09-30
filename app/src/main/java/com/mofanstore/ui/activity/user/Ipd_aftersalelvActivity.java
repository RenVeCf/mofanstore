package com.mofanstore.ui.activity.user;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.mofanstore.R;
import com.mofanstore.base.BaseActivity;
import com.mofanstore.ui.activity.Adater.Ipd_aftersalelvAdater;
import com.mofanstore.util.Ipd_Mylistview;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class Ipd_aftersalelvActivity extends BaseActivity {

    Ipd_aftersalelvAdater ipd_aftersalelvAdater;
    @InjectView(R.id.back)
    FrameLayout back;
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.tv_commiy)
    TextView tvCommiy;
    @InjectView(R.id.commit)
    FrameLayout commit;
    @InjectView(R.id.lvcar)
    Ipd_Mylistview lvcar;
    @InjectView(R.id.comnit)
    Button comnit;

    @Override
    public int intiLayout() {
        return R.layout.activit_aftersalelv;
    }

    @Override
    public void initView() {
        tvName.setText("添加商品");
        ipd_aftersalelvAdater = new Ipd_aftersalelvAdater(Ipd_aftersalelvActivity.this);
        lvcar.setAdapter(ipd_aftersalelvAdater);
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

    @OnClick({R.id.back, R.id.comnit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.comnit:
                break;
        }
    }
}
