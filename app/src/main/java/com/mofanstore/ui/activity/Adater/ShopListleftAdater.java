package com.mofanstore.ui.activity.Adater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mofanstore.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2017/9/18.
 */

public class ShopListleftAdater extends BaseAdapter {
    private LayoutInflater inflater;
    private Context mContext;
    public int temp = 0;
    private List<String> datalist=new ArrayList<>();
    public ShopListleftAdater(Context context, List<String> datalist) {
        super();
        mContext = context;
        this.datalist = datalist;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datalist.size();
    }

    public void setData(int postion) {
        temp = postion;
        notifyDataSetChanged();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.activity_left_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (temp == position) {
            viewHolder.llBg.setBackgroundColor(0xffFFFFFF);
        } else {
            viewHolder.llBg.setBackgroundColor(0xfff5f5f5);
        }
        viewHolder.tvShopname.setText(datalist.get(position));
        return convertView;
    }


    static class ViewHolder {
        @InjectView(R.id.tv_shopname)
        TextView tvShopname;
        @InjectView(R.id.ll_bg)
        LinearLayout llBg;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
