package com.mofanstore.base;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mofanstore.R;
import com.mofanstore.util.StatusBarCompat;

import butterknife.ButterKnife;

public abstract class BaseFramnetActivity extends FragmentActivity {
    /***封装toast对象**/
    private static Toast toast;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//            StatusBarUtil.setStatusBarColor(BaseFramnetActivity.this, R.color.colorzhuti);
//        }
        StatusBarCompat.compat(this, Color.parseColor("#3F3F3F"));
        //设置布局
        setContentView(intiLayout());
        ButterKnife.inject(this);
        //初始化控件
        initView();
        //设置数据
        initData();
    }

    /**
     * 设置布局
     *
     * @return
     */
    public abstract int intiLayout();

    /**
     * 初始化布局
     */
    public abstract void initView();

    /**
     * 设置数据
     */
    public abstract void initData();

    /**
     * 显示长toast
     * @param msg
     */
    public void toastLong(String msg){
        View layout = LayoutInflater.from(this).inflate(R.layout.activity_toast, null);
        TextView nam_tos = (TextView) layout.findViewById(R.id.nam_tos);
        nam_tos.setText(msg);
        if (toast == null) {
            //context.getApplicationContext()取代context也是为了防止内存泄露
            toast = new Toast(this.getApplicationContext());
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(layout);
            toast.show();
        } else {
            toast.setView(layout);
            toast.show();
        }
    }
}
