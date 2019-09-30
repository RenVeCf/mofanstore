package com.mofanstore.ui.activity.user;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.mofanstore.R;
import com.mofanstore.base.BaseActivity;
import com.mofanstore.tool.ListBaseAdapter;
import com.mofanstore.tool.SuperViewHolder;
import com.mofanstore.ui.activity.Adater.MyorderlvAdater;
import com.mofanstore.util.AppUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.OnClick;

public class MytuangoulvActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener{
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
    @InjectView(R.id.my_group_daichentuan)
    TextView myGroupDaichentuan;
    @InjectView(R.id.recyclerview)
    LuRecyclerView recyclerview;
    @InjectView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    @InjectView(R.id.tv_guangguang)
    TextView tvGuangguang;
    @InjectView(R.id.ll_wu)
    LinearLayout llWu;
    private int mCurrentCounter = 0;
    RecycleAdapter recycleAdapter;
    private LuRecyclerViewAdapter mLuRecyclerViewAdapter = null;
    private int flag=0;
    @Override
    public int intiLayout() {
        return R.layout.activit_mytuangou;
    }

    @Override
    public void initView() {
        tvName.setText("我的团购");
        //设置刷新时动画的颜色，可以设置4个
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setProgressViewOffset(false, 0, AppUtil.dip2px(MytuangoulvActivity.this, 48));
            swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
            swipeRefreshLayout.setOnRefreshListener(this);
        }
        recyclerview.setLayoutManager(new LinearLayoutManager(MytuangoulvActivity.this));
        recycleAdapter = new RecycleAdapter(MytuangoulvActivity.this);
        mLuRecyclerViewAdapter = new LuRecyclerViewAdapter(recycleAdapter);
        recyclerview.setAdapter(mLuRecyclerViewAdapter);

        recyclerview.setFooterViewColor(R.color.jindu, R.color.heise, R.color.colorAccentBAI);
        //设置底部加载文字提示
        recyclerview.setFooterViewHint("拼命加载中", "已经全部加载完毕!", "网络不给力啊，点击再试一次吧");

        recyclerview.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                mCurrentCounter++;
//                if (tolte>mCurrentCounter) {
//                    sellerAdd(1);
//                } else {
                recyclerview.setNoMore(true);
//                }
            }
        });

        mLuRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent=new Intent(MytuangoulvActivity.this,TuangouDetailActivity.class);
                startActivity(intent);
            }
        });

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
//    int tolte;
//    private SharedPreferences sp;
//    private void sellerAdd(final int type) {
//        String time = MyTimeUtils.getStringDate();
//        SortedMap<String, Object> map = new TreeMap<>();
//        SortedMap<String, Object> mapchild = new TreeMap<>();
//        mapchild.put("PAGE", mCurrentCounter);
//        mapchild.put("APPUSER_ID", sp.getString("APPUSER_ID",""));
//        mapchild.put("GENRE", sp.getString("usertype", ""));
//        mapchild.put("COUNT", "10");
//        mapchild.put("TYPE", "0");
//        map.put("createTime", time);
//        GlobalParams.encrypt(mapchild, map);
//        map.put("sign", MD5.getMD5Str(time + new Gson().toJson(mapchild)));
//        new RxHttp<BaseListResult<mssagelistbean>>().send(ApiManager.getService().getListmessage(map),
//                new Response<BaseListResult<mssagelistbean>>(XtmssagelistActivity.this, false, "") {
//                    @Override
//                    public void onNext(BaseListResult<mssagelistbean> result) {
//                        super.onNext(result);
//                        if (result.response.toString().equals("0")) {
//                            list = result.data;
//                            tolte=result.pages;
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
//                        }else{
//                            toastLong(result.desc+"");
//                            recyclerview.refreshComplete(10);
//                            swipeRefreshLayout.setRefreshing(false);
//                            mLuRecyclerViewAdapter.notifyDataSetChanged();
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        super.onError(e);
//                        if (recyclerview!=null) {
//                            recyclerview.refreshComplete(10);
//                            swipeRefreshLayout.setRefreshing(false);
//                            mLuRecyclerViewAdapter.notifyDataSetChanged();
//                        }
//                    }
//                });
//    }

    public class RecycleAdapter extends ListBaseAdapter<String> {
        private List<String> menu = new ArrayList<>();
        private Context context;

        public RecycleAdapter(Context context) {
            super(context);
            this.context = context;

        }

        @Override
        public int getLayoutId() {
            return R.layout.activity_tuangoulv;
        }

        @Override
        public void onBindItemHolder(SuperViewHolder holder, final int position) {
            menu=getDataList();
            ListView cart_list=holder.getView(R.id.cart_list);
            TextView red_tv=holder.getView(R.id.red_tv);
            MyorderlvAdater myorderlvAdater=new MyorderlvAdater(mContext);
            cart_list.setAdapter(myorderlvAdater);
            cart_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent=new Intent(context, TuangouDetailActivity.class);
                    startActivity(intent);
                }
            });
            red_tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(context, TuangouDetailActivity.class);
                    startActivity(intent);
                }
            });

            if (flag==0){
                red_tv.setVisibility(View.VISIBLE);
            }else {
                red_tv.setVisibility(View.GONE);
            }
        }

    }


    @OnClick({R.id.back, R.id.my_group_quanbu, R.id.my_group_daichentuan, R.id.tv_guangguang})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.my_group_quanbu:
                myGroupQuanbu.setTextColor(0xff333333);
                myGroupQuanbu.setTextSize(14);
                myGroupDaichentuan.setTextSize(12);
                myGroupDaichentuan.setTextColor(0xff999999);
                flag=0;
                break;
            case R.id.my_group_daichentuan:
                myGroupDaichentuan.setTextColor(0xff333333);
                myGroupDaichentuan.setTextSize(14);
                myGroupQuanbu.setTextSize(12);

                myGroupQuanbu.setTextColor(0xff999999);
                flag=0;
                break;
            case R.id.tv_guangguang:
                break;
        }
    }
}
