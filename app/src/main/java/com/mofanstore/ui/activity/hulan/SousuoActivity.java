package com.mofanstore.ui.activity.hulan;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.mofanstore.util.FlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class SousuoActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    @InjectView(R.id.ed_keyword)
    EditText edKeyword;
    @InjectView(R.id.llousuo)
    LinearLayout llousuo;
    @InjectView(R.id.tv_commiy)
    TextView tvCommiy;
    @InjectView(R.id.back)
    FrameLayout back;
    @InjectView(R.id.im_detal)
    ImageView imDetal;
    @InjectView(R.id.flowlayout)
    FlowLayout flowLayout;
    @InjectView(R.id.ll_vis)
    LinearLayout llVis;
    @InjectView(R.id.flowlayout2)
    FlowLayout flowlayout2;
    @InjectView(R.id.ll_vis2)
    LinearLayout llVis2;
    @InjectView(R.id.sousuoll)
    LinearLayout sousuoll;
    @InjectView(R.id.recyclerview)
    LuRecyclerView recyclerview;
    @InjectView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    private View root_view;
    TextView item_bt;
    private String className = "";
    private int mCurrentCounter = 0;
    RecycleAdapter recycleAdapter;
    private LuRecyclerViewAdapter mLuRecyclerViewAdapter = null;

    @Override
    public int intiLayout() {
        return R.layout.activity_sousuo;
    }

    @Override
    public void initView() {
        edKeyword.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId,
                                          KeyEvent event) {
                if ((actionId == 0 || actionId == 3) && event != null) {
                    //点击搜索要做的操作
                    if (!v.getText().toString().equals("")) {
                        className = v.getText().toString();
                        sousuoll.setVisibility(View.GONE);
                        swipeRefreshLayout.setVisibility(View.VISIBLE);
                        onRefresh();
                    } else {
                        toastLong("请输入搜索关键字");
                    }
                }
                return false;
            }
        });
        recommendList.add("");
        recommendList.add("");
        recommendList.add("");
        recommendList.add("");
        flowLayout.removeAllViews();
        for (int i = 0; i < recommendList.size(); i++) {
            root_view = View.inflate(SousuoActivity.this, R.layout.ipd_activity_search_gv_item, null);
            item_bt = (TextView) root_view.findViewById(R.id.item_bt);
//            item_bt.setTag(recommendList.get(i).getTelte());
//            item_bt.setText(recommendList.get(i).getTelte());
            flowLayout.addView(root_view, i);
            item_bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    className = (String) v.getTag();
                    sousuoll.setVisibility(View.GONE);
                    swipeRefreshLayout.setVisibility(View.VISIBLE);
                    onRefresh();
                }
            });
        }
        flowlayout2.removeAllViews();
        for (int i = 0; i < recommendList.size(); i++) {
            root_view = View.inflate(SousuoActivity.this, R.layout.ipd_activity_search_gv_item, null);
            item_bt = (TextView) root_view.findViewById(R.id.item_bt);
//            item_bt.setTag(recommendList.get(i).getTelte());
//            item_bt.setText(recommendList.get(i).getTelte());
            flowlayout2.addView(root_view, i);
            item_bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    className = (String) v.getTag();
                    sousuoll.setVisibility(View.GONE);
                    swipeRefreshLayout.setVisibility(View.VISIBLE);
                    onRefresh();
                }
            });
        }
    }

    private List<String> recommendList=new ArrayList<>();
//
//    private void getrecommendList() {
//        SortedMap<String, String> map = new TreeMap<>();
//        new RxHttp<BaseResult<recommendListdatabean>>().send(ApiManager.getService().recommendList(map),
//                new Response<BaseResult<recommendListdatabean>>(this, true, "") {
//                    @Override
//                    public void onNext(BaseResult<recommendListdatabean> result) {
//                        super.onNext(result);
//                        if (result.code.toString().equals("200")) {
//                            recommendList = result.data.getRecommendList();
//                            flowLayout.removeAllViews();
//                            for (int i = 0; i < recommendList.size(); i++) {
//                                root_view = View.inflate(SousuoActivity.this, R.layout.ipd_activity_search_gv_item, null);
//                                item_bt = (TextView) root_view.findViewById(R.id.item_bt);
//                                item_bt.setTag(recommendList.get(i).getTelte());
//                                item_bt.setText(recommendList.get(i).getTelte());
//                                flowLayout.addView(root_view, i);
//                                item_bt.setOnClickListener(new View.OnClickListener() {
//                                    @Override
//                                    public void onClick(View v) {
//                                        className = (String) v.getTag();
//                                        llVis.setVisibility(View.GONE);
//                                        swipeRefreshLayout.setVisibility(View.VISIBLE);
//                                        onRefresh();
//                                    }
//                                });
//                            }
//                        } else if (result.code.toString().equals("900")) {
//                            Intent intent = new Intent();
//                            intent.setAction("sepcollege");
//                            //写法一
//                            ComponentName componentName = new ComponentName("com.sepcollege", "com.sepcollege.http.BroadcastReceiver.MyReceiver");
//                            intent.setComponent(componentName);
//                            sendBroadcast(intent);//发送普通广播
//                        } else {
//                            toastLong(result.msg);
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        super.onError(e);
//                        e.printStackTrace();
//                    }
//                });
//    }

    @Override
    public void initData() {

        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setProgressViewOffset(false, 0, AppUtil.dip2px(SousuoActivity.this, 48));
            swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
            swipeRefreshLayout.setOnRefreshListener(this);
        }
        recyclerview.setLayoutManager(new GridLayoutManager(SousuoActivity.this,2));
        recycleAdapter = new RecycleAdapter(SousuoActivity.this);
        mLuRecyclerViewAdapter = new LuRecyclerViewAdapter(recycleAdapter);
        recyclerview.setAdapter(mLuRecyclerViewAdapter);

        recyclerview.addItemDecoration(new DividerItemDecoration(2,20,true));

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
//                Intent intent = new Intent(SousuoActivity.this, KechengdetailActivity.class);
//                intent.putExtra("flag", "2");
//                intent.putExtra("lvTotalsec", "0");
//                intent.putExtra("ClassId", recycleAdapter.getDataList().get(position).getClassId());
//                startActivity(intent);
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

        }

    }


    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
