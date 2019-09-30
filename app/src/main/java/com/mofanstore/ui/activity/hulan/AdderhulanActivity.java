package com.mofanstore.ui.activity.hulan;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mofanstore.R;
import com.mofanstore.base.BaseActivity;
import com.mofanstore.ui.activity.Adater.AdderhulanAadter;
import com.mofanstore.util.Ipd_Mylistview;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class AdderhulanActivity extends BaseActivity {
    @InjectView(R.id.back)
    FrameLayout back;
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.tv_commiy)
    TextView tvCommiy;
    @InjectView(R.id.commit)
    FrameLayout commit;
    @InjectView(R.id.rl_moren)
    RelativeLayout rlMoren;
    @InjectView(R.id.lv_adder)
    Ipd_Mylistview lvAdder;
    AdderhulanAadter adderhulanAadter;
    @Override
    public int intiLayout() {
        return R.layout.activit_adderhulan;
    }

    @Override
    public void initView() {
        tvName.setText("选择地址");
        adderhulanAadter=new AdderhulanAadter(AdderhulanActivity.this);
        lvAdder.setAdapter(adderhulanAadter);
        lvAdder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                adderhulanAadter.setbg(i);

            }
        });
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

    @OnClick({R.id.back, R.id.rl_moren})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.rl_moren:
                break;
        }
    }
}
