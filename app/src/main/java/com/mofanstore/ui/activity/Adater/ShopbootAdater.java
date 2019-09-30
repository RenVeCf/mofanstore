package com.mofanstore.ui.activity.Adater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mofanstore.R;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class ShopbootAdater extends BaseAdapter {
    private LayoutInflater inflater;
    private Context mContext;

    public ShopbootAdater(Context context) {
        super();
        mContext = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 4;
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
            convertView = inflater.inflate(R.layout.shopboot, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }


    static class ViewHolder {
        @InjectView(R.id.evale_img)
        ImageView evaleImg;
        @InjectView(R.id.tv_lvname)
        TextView tvLvname;
        @InjectView(R.id.tv_lvzhiw)
        TextView tvLvzhiw;
        @InjectView(R.id.zhekou)
        TextView zhekou;
        @InjectView(R.id.shopcatbtm)
        ImageView shopcatbtm;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}