package com.mofanstore.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

/**
 * Created by Administrator on 2017/10/11.
 */

public class MyScrollView extends ScrollView {
    private boolean isScrolledToTop;
    private boolean isScrolledToBottom;
    private OnScrollListener onScrollListener;

    public interface OnScrollListener {
        void onScroll(int scrollY);

        void onScrolledToBottom();

        void onScrolledToTop();
    }


    public MyScrollView(Context context) {
        super(context, null, 0);
        // TODO Auto-generated constructor stub
    }


    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        // TODO Auto-generated constructor stub
    }


    public MyScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.onScrollListener = onScrollListener;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        // TODO Auto-generated method stub
        super.onScrollChanged(l, t, oldl, oldt);
        if (onScrollListener != null) {
            onScrollListener.onScroll(t);
        }
        View view = getChildAt(0);
        if (view == null)
            return;
        int diff = (view.getBottom() - (getHeight() + getScrollY()));
//        System.out.println("diff= " + diff
//                + ",view.getBottom()=" + view.getBottom()
//                + ",this.getHeight()=" + getHeight()
//                + ",this.getScrollY()=" + getScrollY());
        // if diff is zero, then the bottom has been reached
        isScrolledToBottom = false;
        isScrolledToTop = false;
        if (diff == 0) {
            isScrolledToBottom = true;
            if (onScrollListener != null)
                onScrollListener.onScrolledToBottom();
        } else if (getScrollY() == 0) {
            isScrolledToTop = true;
            if (onScrollListener != null)
                onScrollListener.onScrolledToTop();
        }
    }

    public boolean isTopEnd() {
        return isScrolledToTop;
    }

    public boolean isBottomEnd() {
        return isScrolledToBottom;

    }
}