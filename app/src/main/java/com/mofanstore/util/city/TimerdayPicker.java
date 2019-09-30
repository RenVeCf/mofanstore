package com.mofanstore.util.city;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.mofanstore.R;
import com.mofanstore.util.WheelViewpng;

/**
 * Created by Administrator on 2018/2/28.
 */


/**
 * container 2 wheelView implement timePicker
 */
public class TimerdayPicker extends LinearLayout {
    public WheelViewpng mWheelYear;

    private int year;
    private int month;

    public TimerdayPicker(Context context) {
        this(context, null);
    }

    public TimerdayPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater.from(getContext()).inflate(R.layout.view_timedata_picker, this);
        mWheelYear = (WheelViewpng) findViewById(R.id.year);
        mWheelYear.setOffset(2);
//        mWheelYear.setItems(getYearData());// 实际内容
        mWheelYear.setSeletion(0);// 设置默认被选中的项目

    }
    public String getYear(){
        return mWheelYear.getSeletedItem();
    }

//    private ArrayList<String> getYearData() {
//        ArrayList<String> list = new ArrayList<>();
//
//        list.add("+44");
//        list.add("+61");
//        list.add("+86");
//        return list;
//    }


}
