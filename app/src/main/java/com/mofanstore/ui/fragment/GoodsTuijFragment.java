package com.mofanstore.ui.fragment;

import android.widget.LinearLayout;

import com.mofanstore.R;
import com.mofanstore.base.BaseFragment;
import com.mofanstore.ui.activity.Adater.ShopbootAdater;
import com.mofanstore.util.Ipd_Gridview;

import butterknife.InjectView;

public class GoodsTuijFragment extends BaseFragment {
    @InjectView(R.id.ipd_pay_grid_view)
    Ipd_Gridview ipdPayGridView;
    @InjectView(R.id.ipd_pay_ll)
    LinearLayout ipdPayLl;
    ShopbootAdater shopbootAdater;
    @Override
    public int intiLayout() {
        return R.layout.fragment_goodtuij;
    }

    @Override
    public void initView() {
        shopbootAdater = new ShopbootAdater(getActivity());
        ipdPayGridView.setAdapter(shopbootAdater);
    }

    @Override
    public void initData() {

    }

}
