package com.mofanstore.ui.activity.user;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mofanstore.R;
import com.mofanstore.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class AdderActivty extends BaseActivity {
    @InjectView(R.id.back)
    FrameLayout back;
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.tv_commiy)
    TextView tvCommiy;
    @InjectView(R.id.commit)
    FrameLayout commit;
    @InjectView(R.id.adder_name)
    TextView adderName;
    @InjectView(R.id.adder_name_et)
    EditText adderNameEt;
    @InjectView(R.id.adder_xinzeng)
    RelativeLayout adderXinzeng;
    @InjectView(R.id.adder_phone_tv)
    TextView adderPhoneTv;
    @InjectView(R.id.adder_phone_et)
    EditText adderPhoneEt;
    @InjectView(R.id.adder_phone)
    RelativeLayout adderPhone;
    @InjectView(R.id.adder_phone_tv2)
    TextView adderPhoneTv2;
    @InjectView(R.id.adder_phone_et2)
    EditText adderPhoneEt2;
    @InjectView(R.id.adder_phone_tv3)
    TextView adderPhoneTv3;
    @InjectView(R.id.adder_phone_et3)
    EditText adderPhoneEt3;
    @InjectView(R.id.adder_diqu_tv2)
    TextView adderDiquTv2;
    @InjectView(R.id.adder_diqu_et2)
    TextView adderDiquEt2;
    @InjectView(R.id.adder_diqu2)
    RelativeLayout adderDiqu2;
    @InjectView(R.id.adder_diqu_tv)
    TextView adderDiquTv;
    @InjectView(R.id.adder_diqu_et)
    TextView adderDiquEt;
    @InjectView(R.id.adder_diqu)
    RelativeLayout adderDiqu;
    @InjectView(R.id.adder_detiail_et)
    EditText adderDetiailEt;
    @InjectView(R.id.cb_agree)
    CheckBox cbAgree;
    @InjectView(R.id.adder_baocun)
    Button adderBaocun;
    @InjectView(R.id.rl_youbian)
    RelativeLayout rlYoubian;
    private int flag;

    @Override
    public int intiLayout() {
        return R.layout.activit_adder;
    }

    @Override
    public void initView() {
        tvName.setText("添加收货地址");
        flag = getIntent().getExtras().getInt("flag");
        Drawable drawable = getResources().getDrawable(
                R.mipmap.icon_next2);
        // / 这一步必须要做,否则不会显示.
        drawable.setBounds(0, 0, drawable.getMinimumWidth(),
                drawable.getMinimumHeight());

        if (flag == 0) {
            adderDiqu.setVisibility(View.VISIBLE);
            rlYoubian.setVisibility(View.VISIBLE);
            adderDiquEt2.setText("中国");
            adderDiquEt2.setCompoundDrawables(null, null, null, null);
        } else {
            adderDiqu.setVisibility(View.GONE);
            rlYoubian.setVisibility(View.GONE);
            adderDiquEt2.setText("韩国");
            adderDiquEt2.setCompoundDrawables(null, null, drawable, null);
        }
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

    @OnClick({R.id.back, R.id.adder_diqu2, R.id.adder_diqu, R.id.adder_baocun})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.adder_diqu2:
                break;
            case R.id.adder_diqu:
                break;
            case R.id.adder_baocun:
                break;
        }
    }
}
