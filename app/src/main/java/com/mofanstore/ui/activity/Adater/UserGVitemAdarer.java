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

public class UserGVitemAdarer extends BaseAdapter {
    private LayoutInflater inflater;
    private Context mContext;

    public UserGVitemAdarer(Context context) {
        super();
        mContext = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 12;
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
            convertView = inflater.inflate(R.layout.activity_usergv_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (position==0){
            viewHolder.tvTelte.setText("关注品牌");
            viewHolder.Imitem.setImageResource(R.mipmap.icon_xinshouzhiyin);
        }else if (position==1){
            viewHolder.tvTelte.setText("签到记录");
            viewHolder.Imitem.setImageResource(R.mipmap.icon_yijianfatu);
        }else if (position==2){
            viewHolder.tvTelte.setText("会员等级");
            viewHolder.Imitem.setImageResource(R.mipmap.icon_zhuanshukefu);
        }else if (position==3){
            viewHolder.tvTelte.setText("VIP卡券");
            viewHolder.Imitem.setImageResource(R.mipmap.icon_guanyuwomen);
        }else if (position==4){
            viewHolder.tvTelte.setText("邀请有礼");
            viewHolder.Imitem.setImageResource(R.mipmap.icon_guanfanggonggao);
        }else if (position==5){
            viewHolder.tvTelte.setText("收货地址");
            viewHolder.Imitem.setImageResource(R.mipmap.icon_yijianfankui);
        }else if (position==6){
            viewHolder.tvTelte.setText("我的定制");
            viewHolder.Imitem.setImageResource(R.mipmap.icon_guanyuwomen2);
        }else if (position==7){
            viewHolder.tvTelte.setText("我的团购");
            viewHolder.Imitem.setImageResource(R.mipmap.icon_yijianfatu2);
        }else if (position==8){
            viewHolder.tvTelte.setText("我的穿搭");
            viewHolder.Imitem.setImageResource(R.mipmap.icon_yijianfatu3);
        }else if (position==9){
        viewHolder.tvTelte.setText("我的点赞");
        viewHolder.Imitem.setImageResource(R.mipmap.icon_yijianfatu4);
       }else if (position==10){
        viewHolder.tvTelte.setText("我的关注");
        viewHolder.Imitem.setImageResource(R.mipmap.icon_yijianfatu5);
        }else if (position==11){
        viewHolder.tvTelte.setText("我的粉丝");
        viewHolder.Imitem.setImageResource(R.mipmap.icon_yijianfatu6);
        }

        return convertView;
    }


    static class ViewHolder {
        @InjectView(R.id.Imitem)
        ImageView Imitem;
        @InjectView(R.id.tv_telte)
        TextView tvTelte;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
