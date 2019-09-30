package com.mofanstore.ui.activity.Adater;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.mofanstore.R;
import com.mofanstore.tool.ListBaseAdapter;
import com.mofanstore.tool.SuperViewHolder;
import com.mofanstore.ui.activity.home.NewShopdetailActivity;
import com.mofanstore.ui.activity.home.ShoplvActivity;

import java.util.ArrayList;
import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private List<String> onlinelawyer = new ArrayList<>();
    private Context mContext;
    List<String> datalist=new ArrayList<>();
    public ExpandableListAdapter(Context context, List<String> datalist){
        mContext = context;
        this.datalist = datalist;
        onlinelawyer.add("");
        onlinelawyer.add("");
        onlinelawyer.add("");
        onlinelawyer.add("");
        onlinelawyer.add("");
    }
    @Override
    public int getGroupCount() {
        return datalist.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View view = convertView;
        GroupHolder holder = null;
        if(view == null){
            holder = new GroupHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.expandlist_group, null);
            holder.groupName = (TextView)view.findViewById(R.id.tv_context);
            holder.arrow = (ImageView)view.findViewById(R.id.Im_close);
            view.setTag(holder);
        }else{
            holder = (GroupHolder)view.getTag();
        }

        //判断是否已经打开列表
        if(isExpanded){
            holder.arrow.setImageResource(R.mipmap.zhangkaijintou);
        }else{
            holder.arrow.setImageResource(R.mipmap.shouqijinat);
        }

        holder.groupName.setText(datalist.get(groupPosition));

        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View view = convertView;
        ChildHolder holder = null;
        if(view == null){
            holder = new ChildHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.expandlist_item, null);
            holder.recyclerview = (LuRecyclerView)view.findViewById(R.id.recyclerview);

            view.setTag(holder);
        }else{
            holder = (ChildHolder)view.getTag();
        }
        holder.recyclerview.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        RecycleAdapter recycleitenAdapter = new RecycleAdapter(mContext);
        LuRecyclerViewAdapter mLuRecyclerViewitenAdapter = new LuRecyclerViewAdapter(recycleitenAdapter);
        holder.recyclerview.setAdapter(mLuRecyclerViewitenAdapter);
        recycleitenAdapter.addAll(onlinelawyer);
        holder.recyclerview.refreshComplete(10);
        mLuRecyclerViewitenAdapter.notifyDataSetChanged();
        mLuRecyclerViewitenAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(mContext, NewShopdetailActivity.class);
                intent.putExtra("flag", "3");
                mContext.startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    class GroupHolder{
        public TextView groupName;
        public ImageView arrow;
    }

    class ChildHolder{
        public LuRecyclerView recyclerview;


    }

    public class RecycleAdapter extends ListBaseAdapter<String> {
        private Context context;
        private List<String> menu;

        public RecycleAdapter(Context context) {
            super(context);
            this.context = context;
        }

        @Override
        public int getLayoutId() {
            return R.layout.activityexpnditem;
        }

        @Override
        public void onBindItemHolder(SuperViewHolder holder, final int position) {
            menu = getDataList();
            LinearLayout ll1=holder.getView(R.id.ll1);
            LinearLayout ll2=holder.getView(R.id.ll2);
            if (position==4){
                ll2.setVisibility(View.VISIBLE);
                ll1.setVisibility(View.GONE);
                ll2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent  intent=new Intent(context,ShoplvActivity.class);
                        intent.putExtra("name","RAIVE");
                        context.startActivity(intent);
                    }
                });
            }else {
                ll1.setVisibility(View.VISIBLE);
                ll2.setVisibility(View.GONE);
            }
        }

    }
}
