package com.mofanstore.ui.activity.Adater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mofanstore.R;
import com.mofanstore.util.Ipd_Mylistview;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class ShopcarcommitlvAadater extends BaseAdapter {
    private LayoutInflater inflater;
    private Context mContext;
    ShopcarcommitAadater shopcarcommitAadater;

    public ShopcarcommitlvAadater(Context context) {
        super();
        mContext = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 2;
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
            convertView = inflater.inflate(R.layout.activity_shopccomititem, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        shopcarcommitAadater = new ShopcarcommitAadater(mContext);
        viewHolder.ipdCartLv.setAdapter(shopcarcommitAadater);
        return convertView;
    }

    static class ViewHolder {
        @InjectView(R.id.tvnum)
        TextView tvnum;
        @InjectView(R.id.ipd_cart_lv)
        Ipd_Mylistview ipdCartLv;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}