package com.mofanstore.ui.activity.Adater;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mofanstore.R;
import com.mofanstore.ui.activity.Shopcar.MyorderdetailActivity;
import com.mofanstore.util.Ipd_Mylistview;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MyorderAdater extends BaseAdapter {
    private LayoutInflater inflater;
    private Context mContext;

    public MyorderAdater(Context context) {
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
            convertView = inflater.inflate(R.layout.myorderlv, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        MyorderlvAdater myorderlvAdater=new MyorderlvAdater(mContext);
        viewHolder.cartList.setAdapter(myorderlvAdater);
        viewHolder.cartList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(mContext,MyorderdetailActivity.class);
                mContext.startActivity(intent);
            }
        });
        return convertView;
    }


    static class ViewHolder {
        @InjectView(R.id.tv_shopname)
        TextView tvShopname;
        @InjectView(R.id.cart_list)
        Ipd_Mylistview cartList;
        @InjectView(R.id.ll_ock)
        LinearLayout llOck;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}