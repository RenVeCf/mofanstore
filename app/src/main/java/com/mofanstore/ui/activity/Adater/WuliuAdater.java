package com.mofanstore.ui.activity.Adater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mofanstore.R;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class WuliuAdater extends BaseAdapter {
    private LayoutInflater inflater;
    private Context mContext;
    ShopitemAdater shopitemAdater;

    public WuliuAdater(Context context) {
        super();
        mContext = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 6;
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
            convertView = inflater.inflate(R.layout.activity_wuliuitem, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }


    static class ViewHolder {
        @InjectView(R.id.wuliu_item)
        TextView wuliuItem;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}