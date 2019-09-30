package com.mofanstore.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mofanstore.R;
import com.mofanstore.base.BaseFragment;
import com.mofanstore.util.GridSpacingItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class GoodsCommentFragment extends BaseFragment {
    @InjectView(R.id.rv_one)
    RecyclerView rvone;
    private List<String> list = new ArrayList<>();
    @Override
    protected int intiLayout() {
        return R.layout.fragment_goodcomment;
    }

    @Override
    protected void initView() {
        StaggeredGridLayoutManager staggeredGridLayoutManager =
                new StaggeredGridLayoutManager(2,
                        StaggeredGridLayoutManager.VERTICAL);
        rvone.setLayoutManager(staggeredGridLayoutManager);

        rvone.addItemDecoration(new GridSpacingItemDecoration(30));
        list.add("专门使用过再来评价。第一次不会用，没涂凝胶，那电流的味道有点……哈哈，然后赶紧联系…服，客服给发了视频，说前三次需要充电十几个小时才可以用。充好用了感觉不错，没有电的感觉。后面长期使用了我来追评。");
        list.add("包装高大上，宝贝小巧精致，期待有实际效果！");
        list.add("看了洪胖胖来的，这个小绿蛙极对我心思，两个亮亮的大眼睛配小绿身，漂亮！按说明书先充…16个多小时的电，并没有像说明书中说的灯会从闪烁到长亮，就一直闪跳，一直闪跳。问了客服说是镍氢电池不稳定会出现这种情况，只要前三次充满16小时，以后稳定了就会长亮提示。裸脸试用了下有轻微刺痛感，客服说这说明工作正常。客服奥利奥人非常好，很耐心的解释我的问题。感谢！");
        list.add("包装高大上，宝贝小巧精致，期待有实际效果！");
        list.add("包装高大上，宝贝小巧精致，期待有实际效果！");
        rvone.setAdapter(new MyAdapter());
    }

    @Override
    protected void initData() {

    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_rvone, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.tvname.setText(list.get(position));
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            ImageView ivIcon;
            TextView tvname;
            public ViewHolder(View itemView) {
                super(itemView);
                ivIcon = itemView.findViewById(R.id.evale_img);
                tvname = itemView.findViewById(R.id.tv_lvname);
            }
        }
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
