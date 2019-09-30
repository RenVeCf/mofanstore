package com.mofanstore.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;

import com.mofanstore.R;
import com.mofanstore.base.BaseFragment;
import com.mofanstore.ui.activity.Adater.ShopListleftAdater;
import com.mofanstore.ui.activity.Adater.ShopListrightAdater;
import com.mofanstore.ui.activity.home.ShoplvActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class Feileifrarment extends BaseFragment {
    @InjectView(R.id.lv_left)
    ListView lvLeft;
    @InjectView(R.id.expand_list)
    ExpandableListView expandList;
    ShopListleftAdater shopListleftAdater;
    ShopListrightAdater shopListrightAdater;
    private List<String> datalist = new ArrayList<>();
    private List<String> datalist2 = new ArrayList<>();
    @Override
    protected int intiLayout() {
        return R.layout.fragment_feilei1;
    }

    @Override
    protected void initView() {
        datalist.add("女士");
        datalist.add("男士");
        datalist2.add("热门推荐");
        datalist2.add("裙装");
        datalist2.add("上衣");
        datalist2.add("裤装");
        expandList.setGroupIndicator(null);
        shopListleftAdater=new ShopListleftAdater(getActivity(),datalist);
        lvLeft.setAdapter(shopListleftAdater);
        lvLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                shopListleftAdater.setData(i);
            }
        });

        shopListrightAdater=new ShopListrightAdater(getActivity(),datalist2);
        expandList.setAdapter(shopListrightAdater);

        expandList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {

                // 请务必返回 false，否则分组不会展开
                return false;
            }
        });
        expandList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Intent intent=new Intent(getActivity(),ShoplvActivity.class);
                intent.putExtra("name","商品列表");
                startActivity(intent);
                return true;
            }
        });

        int groupCount = expandList.getCount();
        for (int i = 0; i < groupCount; i++) {
            expandList.expandGroup(i);
        }
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
}
