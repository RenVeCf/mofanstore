package com.mofanstore.ui.activity.user;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.luck.picture.lib.tools.ScreenUtils;
import com.mofanstore.R;
import com.mofanstore.base.BaseActivity;
import com.mofanstore.tool.ListBaseAdapter;
import com.mofanstore.tool.SuperViewHolder;
import com.mofanstore.ui.activity.Adater.HuboitemAdater;
import com.mofanstore.ui.activity.hulan.HulanissueLvActivity;
import com.mofanstore.util.AppUtil;
import com.mofanstore.util.ExpandTextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.OnClick;

public class MyzanActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {
    @InjectView(R.id.back)
    FrameLayout back;
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.tv_commiy)
    TextView tvCommiy;
    @InjectView(R.id.commit)
    FrameLayout commit;
    @InjectView(R.id.recyclerview)
    LuRecyclerView recyclerview;
    @InjectView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    private int mCurrentCounter = 0;
    RecycleAdapter recycleAdapter;
    RecycleitenAdapter recycleitenAdapter;
    private LuRecyclerViewAdapter mLuRecyclerViewAdapter = null;
    private LuRecyclerViewAdapter mLuRecyclerViewitenAdapter = null;
    private List<String> onlinelawyer = new ArrayList<>();
    @Override
    public int intiLayout() {
        return R.layout.activit_myatter;
    }

    @Override
    public void initView() {
        tvName.setText("我的点赞");

        //设置刷新时动画的颜色，可以设置4个
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setProgressViewOffset(false, 0, AppUtil.dip2px(MyzanActivity.this, 48));
            swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
            swipeRefreshLayout.setOnRefreshListener(this);
        }
        recyclerview.setLayoutManager(new LinearLayoutManager(MyzanActivity.this));
        recycleAdapter = new RecycleAdapter(MyzanActivity.this);
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

        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        onlinelawyer.add("");
        onlinelawyer.add("");
        onlinelawyer.add("");
        onlinelawyer.add("");
        onlinelawyer.add("");
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

    HuboitemAdater huboitemAdater;
    public class RecycleAdapter extends ListBaseAdapter<String> {
        private List<String> menu = new ArrayList<>();
        private Context context;

        public RecycleAdapter(Context context) {
            super(context);
            this.context = context;

        }

        @Override
        public int getLayoutId() {
            return R.layout.activity_thuboitem;
        }

        @Override
        public void onBindItemHolder(SuperViewHolder holder, final int position) {
            menu=getDataList();
            ListView lv_huifu=holder.getView(R.id.lv_huifu);
            TextView tv_numLIST=holder.getView(R.id.tv_numLIST);
            ExpandTextView tv_telte=holder.getView(R.id.tv_telte);
            LuRecyclerView recyclerview=holder.getView(R.id.recyclerview);
            huboitemAdater=new HuboitemAdater(context);
            lv_huifu.setAdapter(huboitemAdater);

            recyclerview.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            recycleitenAdapter = new RecycleitenAdapter(context);
            mLuRecyclerViewitenAdapter = new LuRecyclerViewAdapter(recycleitenAdapter);
            recyclerview.setAdapter(mLuRecyclerViewitenAdapter);
            int whidth = ScreenUtils.getScreenWidth(context) - ScreenUtils.dip2px(context, 16 * 2);
            tv_telte.initWidth(whidth);
            // 设置最大行数(如果SDK >= 16 也可以直接在xml里设置)
            tv_telte.setMaxLines(3);
            String content = " 无论是材质,颜色,还是质地都超级好!显瘦!显白!一点毛病都没有!尤其是抽绳可以把裙摆变成层层叠叠浪漫荷叶边的鱼尾裙!无论是材质,颜一点毛病都没有!尤其是抽绳可以把裙摆变成层层叠叠浪漫荷叶边的鱼尾裙!无论是材质,颜";
            tv_telte.setCloseText(content);
            recycleitenAdapter.addAll(onlinelawyer);
            recyclerview.refreshComplete(10);
            mLuRecyclerViewitenAdapter.notifyDataSetChanged();
            mLuRecyclerViewitenAdapter.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {

                }
            });
            tv_numLIST.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(context, HulanissueLvActivity.class);
                    startActivity(intent);
                }
            });
        }

    }
    public class RecycleitenAdapter extends ListBaseAdapter<String> {
        private Context context;
        private List<String> menu;

        public RecycleitenAdapter(Context context) {
            super(context);
            this.context = context;
        }

        @Override
        public int getLayoutId() {
            return R.layout.activity_huboview_item;
        }

        @Override
        public void onBindItemHolder(SuperViewHolder holder, int position) {
            menu = getDataList();

        }

    }
    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
