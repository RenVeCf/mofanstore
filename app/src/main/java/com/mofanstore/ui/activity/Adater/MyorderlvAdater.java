package com.mofanstore.ui.activity.Adater;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mofanstore.R;
import com.mofanstore.ui.activity.user.Ipd_aftersaleActivity;
import com.mofanstore.util.RoundImagecfView;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MyorderlvAdater extends BaseAdapter {
    private LayoutInflater inflater;
    private Context mContext;

    public MyorderlvAdater(Context context) {
        super();
        mContext = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 1;
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
            convertView = inflater.inflate(R.layout.myorderlvitem, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tuikuanbtm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mContext, Ipd_aftersaleActivity.class);
                mContext.startActivity(intent);
            }
        });
        return convertView;
    }


    static class ViewHolder {
        @InjectView(R.id.cart_photo)
        RoundImagecfView cartPhoto;
        @InjectView(R.id.cart_name)
        TextView cartName;
        @InjectView(R.id.cart_cotext)
        TextView cartCotext;
        @InjectView(R.id.cart_price)
        TextView cartPrice;
        @InjectView(R.id.jian)
        TextView jian;
        @InjectView(R.id.tuikuanbtm)
        TextView tuikuanbtm;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}