package com.mofanstore.ui.activity.user;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.codbking.calendar.CaledarAdapter;
import com.codbking.calendar.CalendarBean;
import com.codbking.calendar.CalendarDateView;
import com.codbking.calendar.CalendarUtil;
import com.mofanstore.R;
import com.mofanstore.base.BaseActivity;
import com.mofanstore.ui.activity.Adater.MyzhujiAdater;

import java.util.Calendar;
import java.util.Date;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MyzhujiActivity extends BaseActivity {
    @InjectView(R.id.back)
    FrameLayout back;
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.tv_commiy)
    TextView tvCommiy;
    @InjectView(R.id.commit)
    FrameLayout commit;
    @InjectView(R.id.calendarDateView)
    CalendarDateView mCalendarDateView;
    @InjectView(R.id.lvlist)
    ListView lvlist;
    private CaledarAdapter caledarAdapter;
    private MyzhujiAdater myzhujiAdater;

    @Override
    public int intiLayout() {
        return R.layout.activit_myzuji;
    }

    @Override
    public void initView() {
        tvName.setText("足迹");
        commit.setVisibility(View.VISIBLE);
        tvCommiy.setText("清空");
    }

    @Override
    public void initData() {
        caledarAdapter = new CaledarAdapter() {
            @Override
            public View getView(View convertView, ViewGroup parentView, CalendarBean bean) {
                TextView view;
                TextView Im_tilte;
                if (convertView == null) {
                    convertView = LayoutInflater.from(parentView.getContext()).inflate(R.layout.item_calendar, null);
                    ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(px(48), px(48));
                    convertView.setLayoutParams(params);
                }


                view = (TextView) convertView.findViewById(R.id.text);
                Im_tilte = (TextView) convertView.findViewById(R.id.Im_tilte);

                view.setText("" + bean.day);
                if (bean.mothFlag != 0) {
                    view.setTextColor(0xff666666);
                } else {
                    view.setTextColor(0xff666666);
                }

                System.out.println("EELE"+bean.moth+bean.day);
                int[] data = CalendarUtil.getYMD(new Date());


                // if (signsdata!=null&&signsdata.size()!=0) {
                Im_tilte.setVisibility(View.GONE);
                Im_tilte.setBackgroundResource(R.drawable.background_item);


//                for (signsbean tmp : signsdata) {
//                    String strdata[]= tmp.getTime().split("-");
//                    System.out.println(strdata[1]+"adapter--IF"+strdata[2]+"ELE"+bean.moth+bean.day);
//                    if (bean.year == Integer.parseInt(strdata[0]) && bean.moth == Integer.parseInt(strdata[1]) && bean.day == Integer.parseInt(strdata[2])) {
//                        Im_tilte.setVisibility(View.VISIBLE);
//                        Im_tilte.setBackgroundResource(R.drawable.background_item2);
//                        Im_tilte.setText("" + bean.day);
//                        Im_tilte.setTextColor(0xffffffff);
//                    }
//                }

                if (bean.year == data[0] && bean.moth == data[1] && bean.day == data[2]) {
                    Im_tilte.setVisibility(View.VISIBLE);
                    Im_tilte.setBackgroundResource(R.mipmap.heise2x);
                    Im_tilte.setVisibility(View.VISIBLE);
                    Im_tilte.setText("" + bean.day);
                    Im_tilte.setTextColor(0xffFFFFFF);
                }

                //  }
                return convertView;
            }
        };
        mCalendarDateView.setAdapter(caledarAdapter);

        myzhujiAdater=new MyzhujiAdater(MyzhujiActivity.this);
        lvlist.setAdapter(myzhujiAdater);
    }

    public static int px(float dipValue) {
        Resources r = Resources.getSystem();
        final float scale = r.getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    private String getDisPlayNumber(int num) {
        return num < 10 ? "0" + num : "" + num;
    }

    public static int getYear(){
        Calendar cd = Calendar.getInstance();
        return  cd.get(Calendar.YEAR);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.inject(this);
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
