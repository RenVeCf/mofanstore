package com.mofanstore.tool;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class ListBase2Adapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    protected Context mContext;
    private LayoutInflater mInflater;
    public static final int TYPE_TOP_IMAGE = 0;
    public static final int TYPE_BOTTON_IMAGE = 1;
    protected List<T> mDataList = new ArrayList<>();

    public ListBase2Adapter(Context context) {
        mContext = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        if(viewType == TYPE_TOP_IMAGE) {
            itemView = mInflater.inflate(getLayouttopId(), parent, false);
            return new SuperViewHolder(itemView);
        }else {
            itemView = mInflater.inflate(getLayoutId(), parent, false);
            return new SuperTwoViewHolder(itemView);
        }

    }

    //根据条件返回条目的类型
    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_TOP_IMAGE;
        }  else {
            return TYPE_BOTTON_IMAGE;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof SuperViewHolder){
            onBindItemHolder((SuperViewHolder)holder, position);
        }else {
            onBindItem2Holder((SuperTwoViewHolder)holder, position);
        }

    }


    public abstract int getLayoutId();
    public abstract int getLayouttopId();

    public abstract void onBindItemHolder(SuperViewHolder holder, int position);
    public abstract void onBindItem2Holder(SuperTwoViewHolder holder, int position);

    public void onBindItemHolder(SuperViewHolder holder, int position, List<Object> payloads){

    }

    @Override
    public int getItemCount() {
        return mDataList.size()+1;
    }

    public List<T> getDataList() {
        return mDataList;
    }

    public void setDataList(Collection<T> list) {
        this.mDataList.clear();
        this.mDataList.addAll(list);
        notifyDataSetChanged();
    }

    public void addAll(Collection<T> list) {
        int lastIndex = this.mDataList.size();
        if (this.mDataList.addAll(list)) {
            notifyItemRangeInserted(lastIndex, list.size());
        }
    }

    public void remove(int position) {
        this.mDataList.remove(position);
        notifyDataSetChanged();

    }

    public void clear() {
        mDataList.clear();
        notifyDataSetChanged();
    }
}
