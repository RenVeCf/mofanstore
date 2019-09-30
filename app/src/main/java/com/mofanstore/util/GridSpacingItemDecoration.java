package com.mofanstore.util;


import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

    private int spanCount;


    public GridSpacingItemDecoration(int spanCount) {
        this.spanCount = spanCount;
;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view); // item position
        int column = position % spanCount; // item column

            outRect.left = 30; // spacing - column * ((1f / spanCount) * spacing)
            outRect.right = 30; // (column + 1) * ((1f / spanCount) * spacing)
            outRect.top = 0;
            outRect.bottom = 0; // item bottom
    }
}
