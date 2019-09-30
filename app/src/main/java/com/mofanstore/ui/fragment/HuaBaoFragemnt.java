package com.mofanstore.ui.fragment;

import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.mofanstore.R;
import com.mofanstore.base.BaseFragment;

import butterknife.InjectView;
import butterknife.OnClick;

public class HuaBaoFragemnt extends BaseFragment {
    @InjectView(R.id.tv_btm1)
    TextView tvBtm1;
    @InjectView(R.id.tv_btm2)
    TextView tvBtm2;
    @InjectView(R.id.fl_container2)
    FrameLayout flContainer2;
    private FragmentManager fragmentManager;
    Huabofrarment huabofrarment;
    Huabo2frarment huabo2frarment;
    @Override
    protected int intiLayout() {
        return R.layout.activit_huabaofragment;
    }

    @Override
    protected void initView() {
        fragmentManager = getActivity().getSupportFragmentManager();
        setTabSelection(0);
    }

    @Override
    protected void initData() {

    }

    private void setTabSelection(int position) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragments(transaction);
        switch (position) {
            case 0:
                if (huabofrarment == null) {
                    huabofrarment = new Huabofrarment();
                    transaction.add(R.id.fl_container2, huabofrarment);
                } else {
                    transaction.show(huabofrarment);
                }
                break;
            case 1:
                if (huabo2frarment == null) {
                    huabo2frarment = new Huabo2frarment();
                    transaction.add(R.id.fl_container2, huabo2frarment);
                } else {
                    transaction.show(huabo2frarment);
                }
                break;

        }
        transaction.commit();
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (huabofrarment != null) {

            transaction.hide(huabofrarment);
        }
        if (huabo2frarment != null) {
            transaction.hide(huabo2frarment);
        }

    }

    @OnClick({R.id.tv_btm1, R.id.tv_btm2})
    public void onViewClicked(View view) {
        Drawable drawable = getResources().getDrawable(R.mipmap.line2);
        switch (view.getId()) {
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
