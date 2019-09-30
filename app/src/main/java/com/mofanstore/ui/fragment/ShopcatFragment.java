package com.mofanstore.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.mofanstore.R;
import com.mofanstore.base.BaseFragment;
import com.mofanstore.ui.activity.Adater.ShopbootAdater;
import com.mofanstore.ui.activity.Adater.ShopitemlvAdater;
import com.mofanstore.ui.activity.Shopcar.ShopcarcommitActivity;
import com.mofanstore.util.Ipd_Gridview;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class ShopcatFragment extends BaseFragment {
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.tv_commiy)
    TextView tvCommiy;
    @InjectView(R.id.commit)
    FrameLayout commit;
    @InjectView(R.id.tvnum)
    TextView tvnum;
    @InjectView(R.id.ipd_cart_lv)
    ListView ipdCartLv;
    @InjectView(R.id.cb_agree)
    CheckBox cbAgree;
    @InjectView(R.id.cart_Count)
    TextView cartCount;
    @InjectView(R.id.ipd_commit)
    TextView ipdCommit;
    @InjectView(R.id.quguanguan)
    TextView quguanguan;
    @InjectView(R.id.ipdguanguan)
    TextView ipdguanguan;
    @InjectView(R.id.ipd_pay_grid_view)
    Ipd_Gridview ipdPayGridView;
    @InjectView(R.id.ipd_pay_ll)
    LinearLayout ipdPayLl;
    @InjectView(R.id.ll_wu)
    LinearLayout llWu;
    ShopbootAdater shopbootAdater;
    ShopitemlvAdater shopitemlvAdater;
    @InjectView(R.id.flshop)
    FrameLayout flshop;

    @Override
    protected int intiLayout() {
        return R.layout.fram_shopcar;
    }

    @Override
    protected void initView() {
        shopbootAdater = new ShopbootAdater(getActivity());
        ipdPayGridView.setAdapter(shopbootAdater);

        shopitemlvAdater = new ShopitemlvAdater(getActivity());
        ipdCartLv.setAdapter(shopitemlvAdater);
    }

    @Override
    protected void initData() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.inject(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick({R.id.commit, R.id.cb_agree, R.id.ipd_commit, R.id.quguanguan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.commit:
                if (tvCommiy.getText().equals("完成")){
                    tvCommiy.setText("管理");
                    cartCount.setVisibility(View.VISIBLE);
                    ipdCommit.setText("结算");
                }else {
                    tvCommiy.setText("完成");
                    cartCount.setVisibility(View.GONE);
                    ipdCommit.setText("删除");
                }

            break;
            case R.id.cb_agree:
                break;
            case R.id.ipd_commit:
                Intent intent=new Intent(getActivity(),ShopcarcommitActivity.class);
                startActivity(intent);
                break;
            case R.id.quguanguan:
                llWu.setVisibility(View.GONE);
                flshop.setVisibility(View.VISIBLE);
                break;
        }
    }
}
