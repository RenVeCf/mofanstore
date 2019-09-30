package com.mofanstore.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.mofanstore.R;
import com.mofanstore.base.BaseFragment;
import com.mofanstore.tool.ListBaseAdapter;
import com.mofanstore.tool.SuperViewHolder;
import com.mofanstore.ui.activity.home.NewShopdetailActivity;
import com.mofanstore.util.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

public class HomeitemFragment extends BaseFragment {
    @InjectView(R.id.recyclerview)
    LuRecyclerView recyclerview;
    private int mCurrentCounter = 0;
    RecycleAdapter recycleAdapter;
    private LuRecyclerViewAdapter mLuRecyclerViewAdapter = null;
    @Override
    protected int intiLayout() {
        return R.layout.fragment_homeitem;
    }

    @Override
    protected void initView() {
        recyclerview.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recycleAdapter = new RecycleAdapter(getActivity());
        mLuRecyclerViewAdapter = new LuRecyclerViewAdapter(recycleAdapter);
        recyclerview.setAdapter(mLuRecyclerViewAdapter);

        recyclerview.addItemDecoration(new DividerItemDecoration(2,30,true));

        recyclerview.setFooterViewColor(R.color.jindu, R.color.heise, R.color.colorAccentBAI);
        //设置底部加载文字提示
        recyclerview.setFooterViewHint("拼命加载中", "已经全部加载完毕!", "网络不给力啊，点击再试一次吧");

        recyclerview.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                mCurrentCounter++;
                // if (TotalPage == 1) {
//               toastLong("没有下一页了");
//                } else {
                recyclerview.setNoMore(true);
//                }
            }
        });
        mLuRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), NewShopdetailActivity.class);
                intent.putExtra("flag","1");
                startActivity(intent);
            }
        });
        list.clear();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        mCurrentCounter = 0;
        recycleAdapter.clear();
        recycleAdapter.addAll(list);
        recyclerview.refreshComplete(10);
        mLuRecyclerViewAdapter.notifyDataSetChanged();
    }

    private List<String> list = new ArrayList<>();
    @Override
    protected void initData() {

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
            return R.layout.activityhomeitem;
        }

        @Override
        public void onBindItemHolder(SuperViewHolder holder, final int position) {
            menu = getDataList();

        }

    }


    public static HomeitemFragment newInstance(String cats_id) {
        HomeitemFragment fragment = new HomeitemFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("cats_id", cats_id);
        fragment.setArguments(bundle);
        return fragment;
    }

}
