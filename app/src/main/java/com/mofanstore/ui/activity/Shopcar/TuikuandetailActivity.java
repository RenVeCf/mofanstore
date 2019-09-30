package com.mofanstore.ui.activity.Shopcar;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mofanstore.R;
import com.mofanstore.base.BaseActivity;
import com.mofanstore.ui.activity.Adater.MyorderlvAdater;
import com.mofanstore.ui.activity.Adater.TuikuanAadater;
import com.mofanstore.util.Ipd_Gridview;
import com.mofanstore.util.Ipd_Mylistview;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class TuikuandetailActivity extends BaseActivity {
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
    @InjectView(R.id.cart_list)
    Ipd_Mylistview cartList;
    @InjectView(R.id.order_num)
    TextView orderNum;
    @InjectView(R.id.chakan_tv)
    TextView chakanTv;
    @InjectView(R.id.price)
    TextView price;
    @InjectView(R.id.statues)
    TextView statues;
    @InjectView(R.id.chaunjiantime)
    TextView chaunjiantime;
    @InjectView(R.id.cj_time)
    RelativeLayout cjTime;
    @InjectView(R.id.fukuantime)
    TextView fukuantime;
    @InjectView(R.id.fk_time)
    RelativeLayout fkTime;
    @InjectView(R.id.qianshoutime)
    TextView qianshoutime;
    @InjectView(R.id.qs_time)
    RelativeLayout qsTime;
    @InjectView(R.id.shouhuotime)
    TextView shouhuotime;
    @InjectView(R.id.detial_shouhou)
    TextView detialShouhou;
    @InjectView(R.id.detial_shouhoutime)
    TextView detialShouhoutime;
    @InjectView(R.id.detial_shouhou2)
    TextView detialShouhou2;
    @InjectView(R.id.ipd_pay_grid_view)
    Ipd_Gridview ipdPayGridView;
    @InjectView(R.id.ipd_pay_ll)
    LinearLayout ipdPayLl;
    TuikuanAadater tuikuanAadater;
    @Override
    public int intiLayout() {
        return R.layout.activit_tuikuandetail;
    }

    @Override
    public void initView() {
        tvName.setText("退款详情");
        tuikuanAadater=new TuikuanAadater(TuikuandetailActivity.this);
        ipdPayGridView.setAdapter(tuikuanAadater);
        MyorderlvAdater myorderlvAdater=new MyorderlvAdater(TuikuandetailActivity.this);
        cartList.setAdapter(myorderlvAdater);
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
