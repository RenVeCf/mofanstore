package com.mofanstore.ui.activity.user;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mofanstore.R;
import com.mofanstore.base.BaseActivity;
import com.mofanstore.util.DataCleanManager;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MysettingActivity extends BaseActivity {

    @InjectView(R.id.back)
    FrameLayout back;
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.tv_commiy)
    TextView tvCommiy;
    @InjectView(R.id.commit)
    FrameLayout commit;
    @InjectView(R.id.user_forget)
    RelativeLayout userForget;
    @InjectView(R.id.user_phone)
    RelativeLayout userPhone;
    @InjectView(R.id.tv_apphunc)
    TextView tvApphunc;
    @InjectView(R.id.im_qchu)
    ImageView imQchu;
    @InjectView(R.id.user_qchu)
    RelativeLayout userQchu;
    @InjectView(R.id.user_renzhen)
    RelativeLayout userRenzhen;
    @InjectView(R.id.comnitBTM)
    TextView comnitBTM;
    @InjectView(R.id.llbooton)
    LinearLayout llbooton;

    @Override
    public int intiLayout() {
        return R.layout.activity_mysetting;
    }

    @Override
    public void initView() {
        tvName.setText("设置");
    }

    @Override
    public void initData() {
        try {
            tvApphunc.setText(DataCleanManager.getTotalCacheSize(MysettingActivity.this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnClick({R.id.back, R.id.user_forget, R.id.user_phone, R.id.user_qchu, R.id.comnitBTM})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.user_forget:
                intent = new Intent(MysettingActivity.this, YijfkActivity.class);
                startActivity(intent);
                break;
            case R.id.user_phone:

                break;
            case R.id.user_qchu:
                TOS();
                break;

            case R.id.comnitBTM:
                tologin();
                break;
        }
    }

    private SharedPreferences sp;

    public void tologin() {
        final Dialog dl = new Dialog(MysettingActivity.this, R.style.dialog);
        View view = LayoutInflater.from(MysettingActivity.this).inflate(
                R.layout.layout_call, null);
        TextView commit = (TextView) view.findViewById(R.id.commit);
        TextView tv_message = (TextView) view.findViewById(R.id.tv_message);
        TextView qchu = (TextView) view.findViewById(R.id.qchu);
        tv_message.setText("                 是否确认退出登录                  ");
        dl.setCanceledOnTouchOutside(false);
        dl.setContentView(view);
        dl.show();
        qchu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                dl.dismiss();

            }
        });
        commit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                dl.dismiss();
                sp = getSharedPreferences("CmUserInfo", MODE_PRIVATE);
                sp.edit().remove("APPUSER_ID").commit();
                finish();
            }
        });

    }


    public void TOS() {
        final Dialog dl = new Dialog(MysettingActivity.this, R.style.dialog);
        View view = LayoutInflater.from(MysettingActivity.this).inflate(
                R.layout.layout_call, null);
        TextView commit = (TextView) view.findViewById(R.id.commit);
        TextView tv_message = (TextView) view.findViewById(R.id.tv_message);
        TextView qchu = (TextView) view.findViewById(R.id.qchu);
        tv_message.setText("                    确认清除缓存吗？                    ");
        dl.setCanceledOnTouchOutside(false);
        dl.setContentView(view);
        dl.show();
        qchu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                dl.dismiss();

            }
        });
        commit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                dl.dismiss();
                try {
                    DataCleanManager.clearAllCache(MysettingActivity.this);
                    tvApphunc.setText("0k");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.inject(this);
    }
}
