package com.mofanstore.ui.activity.Adater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.mofanstore.R;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class ShopitemlvAdater extends BaseAdapter {
    private LayoutInflater inflater;
    private Context mContext;
    ShopitemAdater shopitemAdater;
    public ShopitemlvAdater(Context context) {
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
            convertView = inflater.inflate(R.layout.activity_shopcar2item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        shopitemAdater=new ShopitemAdater(mContext);
        viewHolder.ipdCartLv.setAdapter(shopitemAdater);
        return convertView;
    }

    class ViewHolder {
        @InjectView(R.id.cb_agree1)
        CheckBox cbAgree1;
        @InjectView(R.id.tvnum)
        TextView tvnum;
        @InjectView(R.id.ipd_cart_lv)
        ListView ipdCartLv;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}