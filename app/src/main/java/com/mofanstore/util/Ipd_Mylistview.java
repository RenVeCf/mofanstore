package com.mofanstore.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

/**
 * Created by Administrator on 2017/5/23.
 */
public class Ipd_Mylistview extends ListView {
    public Ipd_Mylistview(Context context) {

        super(context);

    }

    public Ipd_Mylistview(Context context, AttributeSet attrs) {

        super(context, attrs);

    }

    public Ipd_Mylistview(Context context, AttributeSet attrs, int defStyle) {

        super(context, attrs, defStyle);

    }
    @Override
    /**
     * 重写该方法，达到使ListView适应ScrollView的效果
     */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if(ev.getAction() == MotionEvent.ACTION_MOVE){
            return true;
        }
        return super.dispatchTouchEvent(ev);
    }
}
