package com.mofanstore.ui.activity.Adater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mofanstore.R;
import com.mofanstore.util.Ipd_Gridview;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MyzhujiAdater extends BaseAdapter {
    private LayoutInflater inflater;
    private Context mContext;

    public MyzhujiAdater(Context context) {
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
            convertView = inflater.inflate(R.layout.myzhujilvitem, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Myzhuji2Adater myzhuji2Adater=new Myzhuji2Adater(mContext);
        viewHolder.ipdPayGridView.setAdapter(myzhuji2Adater);
        return convertView;
    }


    static class ViewHolder {
        @InjectView(R.id.tv_username)
        TextView tvUsername;
        @InjectView(R.id.ipd_pay_grid_view)
        Ipd_Gridview ipdPayGridView;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}