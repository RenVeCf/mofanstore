package com.mofanstore.ui.activity.Adater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mofanstore.R;
import com.mofanstore.util.RoundAngleImageView;
import com.mofanstore.util.RoundImagecfView;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class ShopdetaigvAdater extends BaseAdapter {
    private LayoutInflater inflater;
    private Context mContext;

    public ShopdetaigvAdater(Context context) {
        super();
        mContext = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 3;
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
            convertView = inflater.inflate(R.layout.activity_detailgvitem, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }


    static class ViewHolder {
        @InjectView(R.id.evale_img)
        RoundImagecfView evaleImg;
        @InjectView(R.id.userimg)
        RoundAngleImageView userimg;
        @InjectView(R.id.tv_username)
        TextView tvUsername;
        @InjectView(R.id.tv_lvname)
        TextView tvLvname;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}