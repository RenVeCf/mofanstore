package com.mofanstore.ui.activity.Adater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mofanstore.R;
import com.mofanstore.util.RoundAngleImageView;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class HuboitemAdater extends BaseAdapter {
    private LayoutInflater inflater;
    private Context mContext;

    public HuboitemAdater(Context context) {
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
            convertView = inflater.inflate(R.layout.huboitem, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }


    static class ViewHolder {
        @InjectView(R.id.userimg2)
        RoundAngleImageView userimg2;
        @InjectView(R.id.ed_usere)
        TextView edUsere;
        @InjectView(R.id.ed_username)
        TextView edUsername;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}