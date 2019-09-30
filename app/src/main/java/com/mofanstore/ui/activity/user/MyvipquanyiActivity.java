package com.mofanstore.ui.activity.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mofanstore.R;
import com.mofanstore.base.BaseActivity;
import com.mofanstore.ui.activity.Adater.ShopbootAdater;
import com.mofanstore.util.Ipd_Gridview;
import com.mofanstore.util.RoundAngleImageView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MyvipquanyiActivity extends BaseActivity {

    ShopbootAdater shopbootAdater;
    @InjectView(R.id.back)
    FrameLayout back;
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.tv_commiy)
    TextView tvCommiy;
    @InjectView(R.id.commit)
    FrameLayout commit;
    @InjectView(R.id.userphoto)
    RoundAngleImageView userphoto;
    @InjectView(R.id.tv_username)
    TextView tvUsername;
    @InjectView(R.id.tv_userconnect)
    TextView tvUserconnect;
    @InjectView(R.id.tv_userphone)
    TextView tvUserphone;
    @InjectView(R.id.rl_userinfo)
    RelativeLayout rlUserinfo;
    @InjectView(R.id.tv_userjifen)
    TextView tvUserjifen;
    @InjectView(R.id.mingxilist)
    TextView mingxilist;
    @InjectView(R.id.ipd_pay_grid_view)
    Ipd_Gridview ipdPayGridView;
    @InjectView(R.id.ipd_pay_ll)
    LinearLayout ipdPayLl;

    @Override
    public int intiLayout() {
        return R.layout.activit_myvipquanyi;
    }

    @Override
    public void initView() {
        tvName.setText("会员等级");
        shopbootAdater = new ShopbootAdater(MyvipquanyiActivity.this);
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

    @OnClick({R.id.back, R.id.mingxilist})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.mingxilist:
                Intent intent = new Intent(MyvipquanyiActivity.this, MyvipmxiLvActivity.class);
                startActivity(intent);
                break;
        }
    }
}
