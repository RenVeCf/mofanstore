package com.mofanstore.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mofanstore.R;

import butterknife.ButterKnife;

public  abstract class BaseFragment extends Fragment {
    /***封装toast对象**/
    private static Toast toast;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(intiLayout(),null);
        ButterKnife.inject(this, view);
        return view;
    }

    /**
     * 绑定布局
     * @return
     */
    protected abstract int intiLayout();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    /**
     * 初始化组件
     */
    protected abstract void initView();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    /**
     * 设置数据等逻辑代码
     */
    protected abstract void initData();

    /**
     * 显示长toast
     * @param msg
     */
    public void toastLong(String msg){
        View layout = LayoutInflater.from(getActivity()).inflate(R.layout.activity_toast, null);
        TextView nam_tos = (TextView) layout.findViewById(R.id.nam_tos);
        nam_tos.setText(msg);
        if (toast == null) {
            //context.getApplicationContext()取代context也是为了防止内存泄露
            toast = new Toast(this.getActivity());
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(layout);
            toast.show();
        } else {
            toast.setView(layout);
            toast.show();
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
