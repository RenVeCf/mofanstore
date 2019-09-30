package com.mofanstore.ui.activity.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.mofanstore.R;
import com.mofanstore.base.BaseActivity;
import com.mofanstore.tool.ListBaseAdapter;
import com.mofanstore.tool.SuperViewHolder;
import com.mofanstore.util.AppUtil;
import com.mofanstore.util.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class ShoplvActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    @InjectView(R.id.back)
    FrameLayout back;
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.tv_commiy)
    TextView tvCommiy;
    @InjectView(R.id.commit)
    FrameLayout commit;
    @InjectView(R.id.my_group_quanbu)
    TextView myGroupQuanbu;
    @InjectView(R.id.my_group_quanbu2)
    TextView myGroupQuanbu2;
    @InjectView(R.id.my_group_quanbu3)
    TextView myGroupQuanbu3;
    @InjectView(R.id.my_group_quanbu4)
    TextView myGroupQuanbu4;
    @InjectView(R.id.my_group_quanbu5)
    TextView myGroupQuanbu5;
    @InjectView(R.id.rl_group_quanbu5)
    RelativeLayout rlGroupQuanbu5;
    @InjectView(R.id.recyclerview)
    LuRecyclerView recyclerview;
    @InjectView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    private int mCurrentCounter = 0;
    RecycleAdapter recycleAdapter;
    private LuRecyclerViewAdapter mLuRecyclerViewAdapter = null;
    private String name;
    @Override
    public int intiLayout() {
        return R.layout.activit_shoplv;
    }

    @Override
    public void initView() {
        name=getIntent().getExtras().getString("name");
        tvName.setText(name);
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setProgressViewOffset(false, 0, AppUtil.dip2px(ShoplvActivity.this, 48));
            swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
            swipeRefreshLayout.setOnRefreshListener(this);
        }

        final GridLayoutManager gridLayoutManager = new GridLayoutManager(ShoplvActivity.this, 2);

        recyclerview.addItemDecoration(new DividerItemDecoration(2,30,true));
        recyclerview.setLayoutManager(gridLayoutManager);
        recycleAdapter = new RecycleAdapter(ShoplvActivity.this);
        mLuRecyclerViewAdapter = new LuRecyclerViewAdapter(recycleAdapter);
        recyclerview.setAdapter(mLuRecyclerViewAdapter);

        recyclerview.setFooterViewColor(R.color.jindu, R.color.heise, R.color.colorAccentBAI);
        //设置底部加载文字提示
        recyclerview.setFooterViewHint("拼命加载中", "已经全部加载完毕!", "网络不给力啊，点击再试一次吧");

        recyclerview.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                mCurrentCounter++;
                // if (TotalPage == 1) {
//                sellerAdd(1);
//                } else {
                recyclerview.setNoMore(true);
//                }
            }
        });
        mLuRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(ShoplvActivity.this, NewShopdetailActivity.class);
                intent.putExtra("flag","1");
                startActivity(intent);
            }
        });

        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        onRefresh();
    }

    @Override
    public void initData() {

    }

    private List<String> list = new ArrayList<>();

    @Override
    public void onRefresh() {
        mCurrentCounter = 0;
        swipeRefreshLayout.setRefreshing(true);
        recyclerview.setRefreshing(true);//同时调用LuRecyclerView的setRefreshing方法
        recycleAdapter.clear();
        recycleAdapter.addAll(list);
        recyclerview.refreshComplete(10);
        swipeRefreshLayout.setRefreshing(false);
        mLuRecyclerViewAdapter.notifyDataSetChanged();
    }

//    private void sellerAdd(final int type) {
//        SortedMap<String, String> map = new TreeMap<>();
//        map.put("className", className);
//        map.put("page", mCurrentCounter + "");
//        new RxHttp<BaseResult<classListByTypeLlistbean>>().send(ApiManager.getService().classListByType(map),
//                new Response<BaseResult<classListByTypeLlistbean>>(SousuoActivity.this, false, "") {
//                    @Override
//                    public void onNext(BaseResult<classListByTypeLlistbean> result) {
//                        super.onNext(result);
//                        if (result.code.equals("200")) {
//                            list = result.data.getClassListByType();
//                            if (type == 0) {
//                                recycleAdapter.addAll(list);
//                                recyclerview.refreshComplete(10);
//                                swipeRefreshLayout.setRefreshing(false);
//                                mLuRecyclerViewAdapter.notifyDataSetChanged();
//                            } else {
//                                recycleAdapter.addAll(list);
//                                recyclerview.refreshComplete(10);
//                                swipeRefreshLayout.setRefreshing(false);
//                                mLuRecyclerViewAdapter.notifyDataSetChanged();
//                            }
//                        } else {
//                            toastLong(result.msg + "");
//                            recyclerview.refreshComplete(10);
//                            swipeRefreshLayout.setRefreshing(false);
//                            mLuRecyclerViewAdapter.notifyDataSetChanged();
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        super.onError(e);
//                        if (recyclerview != null) {
//                            recyclerview.refreshComplete(10);
//                            swipeRefreshLayout.setRefreshing(false);
//                            mLuRecyclerViewAdapter.notifyDataSetChanged();
//                        }
//                    }
//                });
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.inject(this);
    }

    public class RecycleAdapter extends ListBaseAdapter<String> {
        private List<String> menu = new ArrayList<>();
        private Context context;

        public RecycleAdapter(Context context) {
            super(context);
            this.context = context;

        }

        @Override
        public int getLayoutId() {
            return R.layout.activitysuosuoitem;
        }

        @Override
        public void onBindItemHolder(SuperViewHolder holder, final int position) {
            menu = getDataList();
            CheckBox cb_agree = holder.getView(R.id.cb_agree);
            cb_agree.setVisibility(View.GONE);
        }

    }


    @OnClick({R.id.back, R.id.my_group_quanbu, R.id.my_group_quanbu2, R.id.my_group_quanbu3, R.id.my_group_quanbu4, R.id.my_group_quanbu5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.my_group_quanbu:
                myGroupQuanbu.setTextColor(0xff333333);
                myGroupQuanbu.setTextSize(14);
                myGroupQuanbu2.setTextSize(12);
                myGroupQuanbu3.setTextSize(12);
                myGroupQuanbu4.setTextSize(12);
                myGroupQuanbu5.setTextSize(12);
                myGroupQuanbu2.setTextColor(0xff999999);
                myGroupQuanbu3.setTextColor(0xff999999);
                myGroupQuanbu4.setTextColor(0xff999999);
                myGroupQuanbu5.setTextColor(0xff999999);
                break;
            case R.id.my_group_quanbu2:
                myGroupQuanbu2.setTextColor(0xff333333);
                myGroupQuanbu.setTextColor(0xff999999);
                myGroupQuanbu3.setTextColor(0xff999999);
                myGroupQuanbu4.setTextColor(0xff999999);
                myGroupQuanbu5.setTextColor(0xff999999);
                myGroupQuanbu2.setTextSize(14);
                myGroupQuanbu.setTextSize(12);
                myGroupQuanbu3.setTextSize(12);
                myGroupQuanbu4.setTextSize(12);
                myGroupQuanbu5.setTextSize(12);
                break;
            case R.id.my_group_quanbu3:
                myGroupQuanbu3.setTextColor(0xff333333);
                myGroupQuanbu2.setTextColor(0xff999999);
                myGroupQuanbu.setTextColor(0xff999999);
                myGroupQuanbu4.setTextColor(0xff999999);
                myGroupQuanbu5.setTextColor(0xff999999);
                myGroupQuanbu3.setTextSize(14);
                myGroupQuanbu.setTextSize(12);
                myGroupQuanbu2.setTextSize(12);
                myGroupQuanbu4.setTextSize(12);
                myGroupQuanbu5.setTextSize(12);
                break;
            case R.id.my_group_quanbu4:
                myGroupQuanbu4.setTextColor(0xff333333);
                myGroupQuanbu2.setTextColor(0xff999999);
                myGroupQuanbu3.setTextColor(0xff999999);
                myGroupQuanbu.setTextColor(0xff999999);
                myGroupQuanbu5.setTextColor(0xff999999);
                myGroupQuanbu4.setTextSize(14);
                myGroupQuanbu.setTextSize(12);
                myGroupQuanbu2.setTextSize(12);
                myGroupQuanbu3.setTextSize(12);
                myGroupQuanbu5.setTextSize(12);
                break;
            case R.id.my_group_quanbu5:
                myGroupQuanbu5.setTextColor(0xff333333);
                myGroupQuanbu2.setTextColor(0xff999999);
                myGroupQuanbu3.setTextColor(0xff999999);
                myGroupQuanbu4.setTextColor(0xff999999);
                myGroupQuanbu.setTextColor(0xff999999);
                myGroupQuanbu5.setTextSize(14);
                myGroupQuanbu.setTextSize(12);
                myGroupQuanbu2.setTextSize(12);
                myGroupQuanbu3.setTextSize(12);
                myGroupQuanbu4.setTextSize(12);
                break;
        }
    }
}
