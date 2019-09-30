package com.mofanstore.ui.activity.home;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.mofanstore.R;
import com.mofanstore.base.BaseActivity;
import com.mofanstore.ui.fragment.Feilei2frarment;
import com.mofanstore.ui.fragment.Feileifrarment;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class FeileilvActivity extends BaseActivity {
    @InjectView(R.id.back)
    FrameLayout back;
    @InjectView(R.id.tv_btm1)
    TextView tvBtm1;
    @InjectView(R.id.tv_btm2)
    TextView tvBtm2;

    Feileifrarment feileifrarment;
    Feilei2frarment feilei2frarment;
    private FragmentManager fragmentManager;
    @Override
    public int intiLayout() {
        return R.layout.activit_feileilv;
    }

    @Override
    public void initView() {
        fragmentManager =getSupportFragmentManager();
        setTabSelection(0);
    }

    @Override
    public void initData() {

    }


    private void setTabSelection(int position) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragments(transaction);
        switch (position) {
            case 0:
                if (feileifrarment == null) {
                    feileifrarment = new Feileifrarment();
                    transaction.add(R.id.fl_containerfeilei, feileifrarment);
                } else {
                    transaction.show(feileifrarment);
                }
                break;
            case 1:
                if (feilei2frarment == null) {
                    feilei2frarment = new Feilei2frarment();
                    transaction.add(R.id.fl_containerfeilei, feilei2frarment);
                } else {
                    transaction.show(feilei2frarment);
                }
                break;

        }
        transaction.commit();
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (feileifrarment != null) {

            transaction.hide(feileifrarment);
        }
        if (feilei2frarment != null) {
            transaction.hide(feilei2frarment);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.inject(this);
    }

    @OnClick({R.id.back, R.id.tv_btm1, R.id.tv_btm2})
    public void onViewClicked(View view) {
        Drawable drawable = getResources().getDrawable(R.mipmap.line2x);
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.tv_btm1:
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                tvBtm1.setCompoundDrawables(null, null, null, drawable);
                tvBtm2.setCompoundDrawables(null, null, null, null);
                setTabSelection(0);
                break;
            case R.id.tv_btm2:
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                tvBtm2.setCompoundDrawables(null, null, null, drawable);
                tvBtm1.setCompoundDrawables(null, null, null, null);
                setTabSelection(1);
                break;
        }
    }
}
