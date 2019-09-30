package com.mofanstore.ui.activity.user;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mofanstore.R;
import com.mofanstore.base.BaseActivity;
import com.mofanstore.ui.activity.Adater.Myyaoqin2Aadater;
import com.mofanstore.ui.activity.Adater.MyyaoqinAadater;
import com.mofanstore.util.Ipd_Mylistview;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MyyaoqinActivity extends BaseActivity {
    @InjectView(R.id.back)
    FrameLayout back;
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.tv_commiy)
    TextView tvCommiy;
    @InjectView(R.id.commit)
    FrameLayout commit;
    @InjectView(R.id.price)
    TextView price;
    @InjectView(R.id.userimg)
    ImageView userimg;
    @InjectView(R.id.tv_username)
    TextView tvUsername;
    @InjectView(R.id.tv_username2)
    TextView tvUsername2;
    @InjectView(R.id.userimg4)
    ImageView userimg4;
    @InjectView(R.id.tv_username4)
    TextView tvUsername4;
    @InjectView(R.id.tv_username5)
    TextView tvUsername5;
    @InjectView(R.id.cart_youhuijuan_tv)
    TextView cartYouhuijuanTv;
    @InjectView(R.id.cart_disname_tv)
    TextView cartDisnameTv;
    @InjectView(R.id.dis_img)
    TextView disImg;
    @InjectView(R.id.xuanz_youhui)
    RelativeLayout xuanzYouhui;
    @InjectView(R.id.tv_numren)
    TextView tvNumren;
    @InjectView(R.id.tv_numren2)
    TextView tvNumren2;
    @InjectView(R.id.lv_num)
    Ipd_Mylistview lvNum;
    @InjectView(R.id.comnit)
    Button comnit;
    MyyaoqinAadater myyaoqinAadater;
    Myyaoqin2Aadater myyaoqin2Aadater;
    @Override
    public int intiLayout() {
        return R.layout.activit_myyaoqin;
    }

    @Override
    public void initView() {
        tvName.setText("邀请有礼");
        myyaoqinAadater=new MyyaoqinAadater(MyyaoqinActivity.this);
        lvNum.setAdapter(myyaoqinAadater);
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

    @OnClick({R.id.back, R.id.tv_numren, R.id.tv_numren2, R.id.comnit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.tv_numren:
                tvNumren.setTextColor(0xff333333);
                tvNumren2.setTextColor(0xff999999);
                myyaoqinAadater=new MyyaoqinAadater(MyyaoqinActivity.this);
                lvNum.setAdapter(myyaoqinAadater);
                break;
            case R.id.tv_numren2:
                tvNumren2.setTextColor(0xff333333);
                tvNumren.setTextColor(0xff999999);
                myyaoqin2Aadater=new Myyaoqin2Aadater(MyyaoqinActivity.this);
                lvNum.setAdapter(myyaoqin2Aadater);
                break;
            case R.id.comnit:
                break;
        }
    }
}
