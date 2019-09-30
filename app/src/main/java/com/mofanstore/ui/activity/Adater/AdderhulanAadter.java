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


public class AdderhulanAadter extends BaseAdapter {
    private LayoutInflater inflater;
    private Context mContext;
    private int temp=-1;

    public AdderhulanAadter(Context context) {
        super();
        mContext = context;
        inflater = LayoutInflater.from(context);
    }

    public void setbg(int temp1){
        temp=temp1;
        notifyDataSetChanged();
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
            convertView = inflater.inflate(R.layout.adderhulanitem, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (temp==position){
            viewHolder.imMoren.setVisibility(View.VISIBLE);
        }else {
            viewHolder.imMoren.setVisibility(View.GONE);
        }

        return convertView;
    }


    static class ViewHolder {
        @InjectView(R.id.ed_addername)
        TextView edAddername;
        @InjectView(R.id.ed_userdetail)
        TextView edUserdetail;
        @InjectView(R.id.im_moren)
        ImageView imMoren;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}