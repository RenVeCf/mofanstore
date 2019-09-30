package com.mofanstore.ui.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.mofanstore.R;
import com.mofanstore.base.BaseActivity;
import com.mofanstore.ui.activity.Adater.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class ZouxiulvActivity extends BaseActivity {
    @InjectView(R.id.back)
    FrameLayout back;
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.tv_commiy)
    TextView tvCommiy;
    @InjectView(R.id.commit)
    FrameLayout commit;
    @InjectView(R.id.expand_list)
    ExpandableListView expandList;
    ExpandableListAdapter expandableListAdapter;
    List<String> datalist = new ArrayList<>();
    @Override
    public int intiLayout() {
        return R.layout.activit_zouxiulv;
    }

    @Override
    public void initView() {
        tvName.setText("品牌");
        expandList.setGroupIndicator(null);
        datalist.add("RAIVE");
        datalist.add("DEMERIEL");
        datalist.add("AUGUSTHARMONY");
        datalist.add("DEMERIEL");
        expandableListAdapter = new ExpandableListAdapter(ZouxiulvActivity.this, datalist);
        expandList.setAdapter(expandableListAdapter);
        //        设置分组项的点击监听事件
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
                Intent intent = new Intent(ZouxiulvActivity.this, NewShopdetailActivity.class);
                intent.putExtra("flag", "3");
                startActivity(intent);
                return true;
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

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
