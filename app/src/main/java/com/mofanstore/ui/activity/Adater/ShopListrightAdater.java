package com.mofanstore.ui.activity.Adater;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mofanstore.R;
import com.mofanstore.ui.activity.home.ShoplvActivity;
import com.mofanstore.util.Ipd_Gridview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/18.
 */

public class ShopListrightAdater extends BaseExpandableListAdapter {
    private Context mContext;
    List<String> datalist=new ArrayList<>();
    public ShopListrightAdater(Context context, List<String> datalist){
        mContext = context;
        this.datalist = datalist;

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
            view = LayoutInflater.from(mContext).inflate(R.layout.expandlistflei_item, null);
            holder.gridview = (Ipd_Gridview)view.findViewById(R.id.ipd_pay_grid_view);

            view.setTag(holder);
        }else{
            holder = (ChildHolder)view.getTag();
        }
        ShopListrightgvAdater shopListrightgvAdater=new ShopListrightgvAdater(mContext);
        holder.gridview.setAdapter(shopListrightgvAdater);
        holder.gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(mContext,ShoplvActivity.class);
                intent.putExtra("name","T恤");
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
        public Ipd_Gridview gridview;


    }

}