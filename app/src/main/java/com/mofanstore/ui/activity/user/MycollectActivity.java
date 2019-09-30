package com.mofanstore.ui.activity.user;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.mofanstore.R;
import com.mofanstore.base.BaseActivity;
import com.mofanstore.tool.ListBaseAdapter;
import com.mofanstore.tool.SuperViewHolder;
import com.mofanstore.util.AppUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.OnClick;

public class MycollectActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {
    @InjectView(R.id.back)
    FrameLayout back;
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.tv_commiy)
    TextView tvCommiy;
    @InjectView(R.id.commit)
    FrameLayout commit;
    @InjectView(R.id.tv_btm1)
    TextView tvBtm1;
    @InjectView(R.id.tv_btm2)
    TextView tvBtm2;
    @InjectView(R.id.recyclerview)
    LuRecyclerView recyclerview;
    @InjectView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    private int mCurrentCounter = 0;
    RecycleAdapter recycleAdapter;
    private LuRecyclerViewAdapter mLuRecyclerViewAdapter = null;
    public int flag = 0;
    @Override
    public int intiLayout() {
        return R.layout.activit_mycollect;
    }

    @Override
    public void initView() {
//        flag=getIntent().getExtras().getInt("flag");
        tvName.setText("收藏");
//        Drawable drawable = getResources().getDrawable(R.mipmap.line2);
//        if (flag==0){
//            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
//            tvBtm1.setCompoundDrawables(null, null, null, drawable);
//            tvBtm2.setCompoundDrawables(null, null, null, null);
//        }else {
//            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
//            tvBtm2.setCompoundDrawables(null, null, null, drawable);
//            tvBtm1.setCompoundDrawables(null, null, null, null);
//        }
        //设置刷新时动画的颜色，可以设置4个
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setProgressViewOffset(false, 0, AppUtil.dip2px(MycollectActivity.this, 48));
            swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
            swipeRefreshLayout.setOnRefreshListener(this);
        }
        recyclerview.setLayoutManager(new LinearLayoutManager(MycollectActivity.this));
//        recycleAdapter = new RecycleAdapter(MyVipActivity.this);
//        mLuRecyclerViewAdapter = new LuRecyclerViewAdapter(recycleAdapter);
//        recyclerview.setAdapter(mLuRecyclerViewAdapter);

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
        recycleAdapter = new RecycleAdapter(MycollectActivity.this);
        mLuRecyclerViewAdapter = new LuRecyclerViewAdapter(recycleAdapter);
        recyclerview.setAdapter(mLuRecyclerViewAdapter);

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
            if (flag == 0) {
                return R.layout.activity_collectitem;
            } else {
                return R.layout.activity_ppaiitem;
            }

        }


        @Override
        public void onBindItemHolder(SuperViewHolder holder, final int position) {

        }


    }

    @OnClick({R.id.back, R.id.tv_btm1, R.id.tv_btm2})
    public void onViewClicked(View view) {
        Drawable drawable = getResources().getDrawable(R.mipmap.lin3x);
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.tv_btm1:
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                tvBtm1.setCompoundDrawables(null, null, null, drawable);
                tvBtm2.setCompoundDrawables(null, null, null, null);
                flag = 0;
                onRefresh();
                break;
            case R.id.tv_btm2:
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                tvBtm2.setCompoundDrawables(null, null, null, drawable);
                tvBtm1.setCompoundDrawables(null, null, null, null);
                flag = 1;
                onRefresh();
                break;
        }
    }
}
