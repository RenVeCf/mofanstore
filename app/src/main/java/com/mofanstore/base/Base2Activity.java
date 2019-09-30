package com.mofanstore.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.mofanstore.R;

import butterknife.ButterKnife;


public abstract class Base2Activity extends AppCompatActivity {
    /***封装toast对象**/
    private static Toast toast;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
