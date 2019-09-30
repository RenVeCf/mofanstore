package com.mofanstore.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.luck.picture.lib.tools.ScreenUtils;
import com.mofanstore.R;
import com.mofanstore.base.BaseFragment;
import com.mofanstore.tool.ListBaseAdapter;
import com.mofanstore.tool.SuperViewHolder;
import com.mofanstore.ui.activity.Adater.HuboitemAdater;
import com.mofanstore.ui.activity.hulan.HulanissueLvActivity;
import com.mofanstore.util.AppUtil;
import com.mofanstore.util.ExpandTextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;


public class Huboitem2Fragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{
    @InjectView(R.id.recyclerview)
    LuRecyclerView recyclerview;
    @InjectView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    private int mCurrentCounter = 0;
    RecycleAdapter recycleAdapter;
    private LuRecyclerViewAdapter mLuRecyclerViewAdapter = null;
    private List<String> list = new ArrayList<>();
    private List<String> onlinelawyer = new ArrayList<>();
    @Override
    protected int intiLayout() {
        return R.layout.activit_huboitem;
    }

    @Override
    protected void initView() {
        //设置刷新时动画的颜色，可以设置4个
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setProgressViewOffset(false, 0, AppUtil.dip2px(getActivity(), 48));
            swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
            swipeRefreshLayout.setOnRefreshListener(this);
        }
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycleAdapter = new RecycleAdapter(getActivity());
        mLuRecyclerViewAdapter = new LuRecyclerViewAdapter(recycleAdapter);
        recyclerview.setAdapter(mLuRecyclerViewAdapter);

        recyclerview.setFooterViewColor(R.color.jindu, R.color.heise, R.color.white);
        //设置底部加载文字提示
        recyclerview.setFooterViewHint("拼命加载中", "已经全部加载完毕!", "网络不给力啊，点击再试一次吧");

        recyclerview.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                mCurrentCounter++;
                recyclerview.setLoadMoreEnabled(false);
                recyclerview.setNoMore(false);
            }
        });

        mLuRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });

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
    protected void initData() {

    }

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
            return R.layout.activity_thubo2item;
        }


        @Override
        public void onBindItemHolder(SuperViewHolder holder, final int position) {
            menu=getDataList();
            ListView lv_huifu=holder.getView(R.id.lv_huifu);
            TextView tv_numLIST=holder.getView(R.id.tv_numLIST);
            ExpandTextView tv_telte=holder.getView(R.id.tv_telte);
            huboitemAdater=new HuboitemAdater(context);
            lv_huifu.setAdapter(huboitemAdater);



            int whidth = ScreenUtils.getScreenWidth(context) - ScreenUtils.dip2px(context, 16 * 2);
            tv_telte.initWidth(whidth);
            // 设置最大行数(如果SDK >= 16 也可以直接在xml里设置)
            tv_telte.setMaxLines(3);
            String content = " 无论是材质,颜色,还是质地都超级好!显瘦!显白!一点毛病都没有!尤其是抽绳可以把裙摆变成层层叠叠浪漫荷叶边的鱼尾裙!无论是材质,颜一点毛病都没有!尤其是抽绳可以把裙摆变成层层叠叠浪漫荷叶边的鱼尾裙!无论是材质,颜";
            tv_telte.setCloseText(content);

            tv_numLIST.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(context, HulanissueLvActivity.class);
                    startActivity(intent);
                }
            });
        }

    }


    public static Huboitem2Fragment newInstance(String cats_id) {
        Huboitem2Fragment fragment = new Huboitem2Fragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("cats_id", cats_id);
        fragment.setArguments(bundle);
        return fragment;
    }
}
