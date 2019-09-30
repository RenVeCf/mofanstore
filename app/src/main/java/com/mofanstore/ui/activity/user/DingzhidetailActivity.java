package com.mofanstore.ui.activity.user;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mofanstore.R;
import com.mofanstore.base.BaseActivity;
import com.mofanstore.ui.activity.Adater.MyorderAdater;
import com.mofanstore.ui.activity.Adater.TuikuanAadater;
import com.mofanstore.util.Ipd_Mylistview;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class DingzhidetailActivity extends BaseActivity {
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
    @InjectView(R.id.tv_dinname)
    TextView tvDinname;
    @InjectView(R.id.tv_dinname1)
    TextView tvDinname1;
    @InjectView(R.id.tv_dinname2)
    TextView tvDinname2;
    @InjectView(R.id.tv_dinname3)
    TextView tvDinname3;
    @InjectView(R.id.tv_dinname4)
    TextView tvDinname4;
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
    @InjectView(R.id.qianshoutime)
    TextView qianshoutime;
    @InjectView(R.id.qs_time)
    RelativeLayout qsTime;
    @InjectView(R.id.chakan_wuliu)
    TextView chakanWuliu;
    @InjectView(R.id.shfw_shouhuo)
    TextView shfwShouhuo;
    @InjectView(R.id.rl_detail3)
    RelativeLayout rlDetail3;
    TuikuanAadater tuikuanAadater;
    @Override
    public int intiLayout() {
        return R.layout.activit_dingzhidetail;
    }

    @Override
    public void initView() {
        tvName.setText("订单详情");
        MyorderAdater myorderAdater=new MyorderAdater(DingzhidetailActivity.this);
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

    @OnClick({R.id.back, R.id.chakan_wuliu, R.id.shfw_shouhuo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                break;
            case R.id.chakan_wuliu:
                break;
            case R.id.shfw_shouhuo:
                break;
        }
    }
}
