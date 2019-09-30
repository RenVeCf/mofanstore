package com.mofanstore.ui.activity.Adater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.mofanstore.R;
import com.mofanstore.util.RoundImagecfView;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class TuikuanAadater extends BaseAdapter {
    private LayoutInflater inflater;
    private Context mContext;
    ShopitemAdater shopitemAdater;

    public TuikuanAadater(Context context) {
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
            convertView = inflater.inflate(R.layout.activity_tuikuan2item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }


    static class ViewHolder {
        @InjectView(R.id.cart_photo)
        RoundImagecfView cartPhoto;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}