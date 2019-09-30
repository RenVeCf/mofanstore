package com.mofanstore.ui.fragment;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mofanstore.R;
import com.mofanstore.base.BaseFragment;
import com.mofanstore.ui.activity.Adater.MassgeAadater;
import com.mofanstore.ui.activity.massage.AtterlvActivity;
import com.mofanstore.ui.activity.massage.HbMassageLvActivity;
import com.mofanstore.ui.activity.massage.MassagextListActivity;
import com.mofanstore.ui.activity.massage.WuLiumassageLvActivity;
import com.mofanstore.util.Ipd_Mylistview;
import com.mofanstore.util.MyScrollView;
import com.mofanstore.util.SwipeRefreshLayoutCompat;

import butterknife.InjectView;
import butterknife.OnClick;

public class MassageFrament extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{
    @InjectView(R.id.Im_setting)
    ImageView ImSetting;
    @InjectView(R.id.ll_llbt1)
    LinearLayout llLlbt1;
    @InjectView(R.id.ll_llbt2)
    LinearLayout llLlbt2;
    @InjectView(R.id.ll_ll3)
    LinearLayout llLl3;
    @InjectView(R.id.lvbooot)
    Ipd_Mylistview lvbooot;
    @InjectView(R.id.scrollView)
    MyScrollView scrollView;
    @InjectView(R.id.swipeRefresh)
    SwipeRefreshLayoutCompat swipeRefresh;
    MassgeAadater massgeAadater;
    @Override
    protected int intiLayout() {
        return R.layout.frament_massge;
    }

    @Override
    protected void initView() {
        massgeAadater=new  MassgeAadater(getActivity());
        lvbooot.setAdapter(massgeAadater);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onRefresh() {
        swipeRefresh.setRefreshing(true);
        new Handler().postDelayed(new Runnable() {
            public void run() {

                swipeRefresh.setRefreshing(false);
            }
        }, 1000);
    }

    @OnClick({R.id.Im_setting, R.id.ll_llbt1, R.id.ll_llbt2, R.id.ll_ll3})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.Im_setting:
                intent=new Intent(getActivity(), AtterlvActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_llbt1:
                intent=new Intent(getActivity(), WuLiumassageLvActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_llbt2:
                intent=new Intent(getActivity(), MassagextListActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_ll3:
                intent=new Intent(getActivity(), HbMassageLvActivity.class);
                startActivity(intent);
                break;
        }
    }
}
