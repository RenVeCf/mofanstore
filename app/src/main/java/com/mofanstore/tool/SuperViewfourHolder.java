package com.mofanstore.tool;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

public class SuperViewfourHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> views;

    public SuperViewfourHolder(View itemView) {
        super(itemView);
        this.views = new SparseArray<>();
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T getView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }
}