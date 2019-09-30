package com.mofanstore.ui.activity.Adater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mofanstore.R;
import com.mofanstore.util.FlowLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class PropertyAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private Context mContext;
    private View root_view;
    TextView item_bt;
    public PropertyAdapter(Context context) {
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
            convertView = inflater.inflate(R.layout.activity_lsspecificationsitem, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.flowLayout.removeAllViews();
        if (position==0){
            viewHolder.name.setText("颜色");

            for (int i = 0; i < 4; i++) {
                root_view = View.inflate(mContext, R.layout.ipd_activity_search_gv_item, null);
                item_bt = (TextView) root_view.findViewById(R.id.item_bt);
//            item_bt.setTag(recommendList.get(i).getTelte());
                item_bt.setText("黑");
                viewHolder.flowLayout.addView(root_view, i);
                item_bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }
        }else {
            viewHolder.name.setText("尺寸");
            for (int i = 0; i < 4; i++) {
                root_view = View.inflate(mContext, R.layout.ipd_activity_search_gv_item, null);
                item_bt = (TextView) root_view.findViewById(R.id.item_bt);
//            item_bt.setTag(recommendList.get(i).getTelte());
                item_bt.setText("S");
                viewHolder.flowLayout.addView(root_view, i);
                item_bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }
        }
        return convertView;
    }


    static class ViewHolder {
        @InjectView(R.id.name)
        TextView name;
        @InjectView(R.id.myviewgroud)
        FlowLayout flowLayout;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }

}