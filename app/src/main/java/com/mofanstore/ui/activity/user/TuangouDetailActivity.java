package com.mofanstore.ui.activity.user;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mofanstore.R;
import com.mofanstore.base.BaseActivity;
import com.mofanstore.ui.activity.Adater.MyorderAdater;
import com.mofanstore.util.Ipd_Mylistview;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class TuangouDetailActivity extends BaseActivity {
    @InjectView(R.id.back)
    FrameLayout back;
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.tv_commiy)
    TextView tvCommiy;
    @InjectView(R.id.commit)
    FrameLayout commit;
    @InjectView(R.id.detaikname)
    TextView detaikname;
    @InjectView(R.id.cart_shop)
    ImageView cartShop;
    @InjectView(R.id.nametelee)
    TextView nametelee;
    @InjectView(R.id.nameadd)
    TextView nameadd;
    @InjectView(R.id.name_number)
    TextView nameNumber;
    @InjectView(R.id.cart_zuo)
    ImageView cartZuo;
    @InjectView(R.id.detail_adder)
    RelativeLayout detailAdder;
    @InjectView(R.id.lv_adder_ll)
    LinearLayout lvAdderLl;
    @InjectView(R.id.rltuanname)
    TextView rltuanname;
    @InjectView(R.id.hours_tv)
    TextView hoursTv;
    @InjectView(R.id.minutes_tv)
    TextView minutesTv;
    @InjectView(R.id.miao_tv)
    TextView miaoTv;
    @InjectView(R.id.cart_list)
    Ipd_Mylistview cartList;
    @InjectView(R.id.ci_tv)
    TextView ciTv;
    @InjectView(R.id.tv_yuanfei)
    TextView tvYuanfei;
    @InjectView(R.id.shifuk_tv)
    TextView shifukTv;
    @InjectView(R.id.tv_orderprice)
    TextView tvOrderprice;
    @InjectView(R.id.detial_shouhou)
    TextView detialShouhou;
    @InjectView(R.id.order_num)
    TextView orderNum;
    @InjectView(R.id.chakan_tv)
    TextView chakanTv;
    @InjectView(R.id.chaunjiantime)
    TextView chaunjiantime;
    @InjectView(R.id.cj_time)
    RelativeLayout cjTime;
    @InjectView(R.id.fukuantime)
    TextView fukuantime;
    @InjectView(R.id.fk_time)
    RelativeLayout fkTime;
    @InjectView(R.id.fhuotime)
    TextView fhuotime;
    @InjectView(R.id.fh_time)
    RelativeLayout fhTime;

    @Override
    public int intiLayout() {
        return R.layout.activit_tuangoudetail;
    }

    @Override
    public void initView() {
        tvName.setText("团购详情");
        MyorderAdater myorderAdater=new MyorderAdater(TuangouDetailActivity.this);
        cartList.setAdapter(myorderAdater);
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
