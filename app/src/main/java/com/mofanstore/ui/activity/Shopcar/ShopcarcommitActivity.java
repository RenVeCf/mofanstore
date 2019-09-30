package com.mofanstore.ui.activity.Shopcar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mofanstore.R;
import com.mofanstore.base.BaseActivity;
import com.mofanstore.ui.activity.Adater.ShopcarcommitlvAadater;
import com.mofanstore.util.Ipd_Mylistview;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class ShopcarcommitActivity extends BaseActivity {
    @InjectView(R.id.back)
    FrameLayout back;
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.tv_commiy)
    TextView tvCommiy;
    @InjectView(R.id.commit)
    FrameLayout commit;
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
    @InjectView(R.id.nameadd1)
    TextView nameadd1;
    @InjectView(R.id.lv_adder_xinzeng)
    LinearLayout lvAdderXinzeng;
    @InjectView(R.id.cart_list)
    Ipd_Mylistview cartList;
    @InjectView(R.id.tv_liyoutui)
    TextView tvLiyoutui;
    @InjectView(R.id.cart_youhuijuan)
    TextView cartYouhuijuan;
    @InjectView(R.id.cart_ems)
    TextView cartEms;
    @InjectView(R.id.cart_emszuo)
    TextView cartEmszuo;
    @InjectView(R.id.cart_youhuijuan_tv)
    TextView cartYouhuijuanTv;
    @InjectView(R.id.cart_disname_tv)
    TextView cartDisnameTv;
    @InjectView(R.id.dis_img)
    ImageView disImg;
    @InjectView(R.id.xuanz_youhui)
    RelativeLayout xuanzYouhui;
    @InjectView(R.id.integral_tv1)
    TextView integralTv1;
    @InjectView(R.id.liuy)
    EditText liuy;
    @InjectView(R.id.integral_tv)
    EditText integralTv;
    @InjectView(R.id.cb_agree)
    CheckBox cbAgree;
    @InjectView(R.id.rl_jifeng)
    RelativeLayout rlJifeng;
    @InjectView(R.id.cart_Count)
    TextView cartCount;
    @InjectView(R.id.ipd_commit)
    TextView ipdCommit;
    ShopcarcommitlvAadater shopitemlvAdater;
    @InjectView(R.id.rl_wuliu)
    RelativeLayout rlWuliu;

    @Override
    public int intiLayout() {
        return R.layout.activit_shopcarcommit;
    }

    @Override
    public void initView() {
        tvName.setText("确认订单");
        shopitemlvAdater = new ShopcarcommitlvAadater(ShopcarcommitActivity.this);
        cartList.setAdapter(shopitemlvAdater);
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

    @OnClick({R.id.rl_wuliu,R.id.back, R.id.lv_adder_ll, R.id.lv_adder_xinzeng, R.id.xuanz_youhui, R.id.rl_jifeng, R.id.ipd_commit})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.lv_adder_ll:
                break;
            case R.id.lv_adder_xinzeng:
                break;
            case R.id.xuanz_youhui:
                break;
            case R.id.rl_jifeng:
                break;
            case R.id.ipd_commit:
                intent = new Intent(ShopcarcommitActivity.this, ShoppayActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_wuliu:
                intent = new Intent(ShopcarcommitActivity.this, WuliulvActivity.class);
                startActivity(intent);
                break;
        }
    }
}
