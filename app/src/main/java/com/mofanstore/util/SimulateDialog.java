package com.mofanstore.util;

/**
 * Created by XY on 2016/4/25.
 */

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.mofanstore.Application;
import com.mofanstore.R;

/**
 * 模仿<br/>
 * 俩种弹出方式<br/>
 * Created by Wallace on 2016/1/14.
 */
public class SimulateDialog {

    private Context context;
    private Dialog dialog;
    private TextView tvRight;
    private TextView tvLeft;
    private TextView tvTitle;

    private View view;

    public SimulateDialog(Context context){
        this.context = context;
    }



    public SimulateDialog setBottom(){
        int mScreenWidth = Application.getInstance().getScreenWidth();
        int mScreenHeight = Application.getInstance().getScreenHeight();
        view = LayoutInflater.from(context).inflate(R.layout.view_picture, null, false);
        dialog = new Dialog(context, R.style.about_dialog);
        dialog.setContentView(view);

        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        dialogWindow.setGravity(Gravity.BOTTOM);

        lp.width = mScreenWidth;
        lp.height = (int) (mScreenHeight * 0.3);
        dialogWindow.setWindowAnimations(R.style.dialog_anim_bottom);
        dialogWindow.setAttributes(lp);

        tvTitle = (TextView) view.findViewById(R.id.btnCancel);
        tvLeft = (TextView) view.findViewById(R.id.btnCamera);
        tvRight = (TextView) view.findViewById(R.id.btnGallery);
        return this;
    }
    public SimulateDialog setGenderBottom(){
        int mScreenWidth = Application.getInstance().getScreenWidth();
        int mScreenHeight = Application.getInstance().getScreenHeight();
        view = LayoutInflater.from(context).inflate(R.layout.view_gender, null, false);
        dialog = new Dialog(context, R.style.about_dialog);
        dialog.setContentView(view);

        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        dialogWindow.setGravity(Gravity.BOTTOM);

        lp.width = mScreenWidth;
        lp.height = (int) (mScreenHeight * 0.3);
        dialogWindow.setWindowAnimations(R.style.dialog_anim_bottom);
        dialogWindow.setAttributes(lp);

        tvTitle = (TextView) view.findViewById(R.id.btnCancel);
        tvLeft = (TextView) view.findViewById(R.id.btnboy);
        tvRight = (TextView) view.findViewById(R.id.btngirl);
        return this;
    }

    /**
     * 选择中间的时候是标题<br/>
     * 选择底部的时候是取消<br/>
     * @param title 标题
     * @return SimulateDialog
     */
    public SimulateDialog setTitle(CharSequence title){
        tvTitle.setText(title);
        return this;
    }

    /**
     * 选择中间的时候是标题<br/>
     * 选择底部的时候是取消<br/>
     * @param title 标题
     * @param onClickListener 点击事件
     * @return SimulateDialog
     */
    public SimulateDialog setTitle(CharSequence title, View.OnClickListener onClickListener){
        tvTitle.setText(title);
        tvTitle.setOnClickListener(onClickListener);
        return this;
    }

    public SimulateDialog setTitleColor(int color){
        tvTitle.setTextColor(color);
        return this;
    }
    public SimulateDialog setTitleSize(float size){
        tvTitle.setTextSize(size);
        return this;
    }
    /**
     * 右或者底部
     * @param sequence 文字
     * @param onClickListener 点击事件
     * @return SimulateDialog
     */
    public SimulateDialog setRight(CharSequence sequence, View.OnClickListener onClickListener){
        tvRight.setText(sequence);
        tvRight.setOnClickListener(onClickListener);
        return this;
    }
    public SimulateDialog setRight(CharSequence sequence){
        tvRight.setText(sequence);
        return this;
    }
    public SimulateDialog setRightColor(int color){
        tvRight.setTextColor(color);
        return this;
    }
    public SimulateDialog setRightSize(float size){
        tvRight.setTextSize(size);
        return this;
    }

    /**
     * 左边或者头部
     * @param sequence 文字
     * @param onClickListener 点击事件
     * @return SimulateDialog
     */
    public SimulateDialog setLeft(CharSequence sequence, View.OnClickListener onClickListener){
        tvLeft.setText(sequence);
        tvLeft.setOnClickListener(onClickListener);
        return this;
    }
    public SimulateDialog setLeft(CharSequence sequence){
        tvLeft.setText(sequence);
        return this;
    }
    public SimulateDialog setLeftSize(float size){
        tvLeft.setTextSize(size);
        return this;
    }

    public SimulateDialog setLeftColor(int color){
        tvLeft.setTextColor(color);
        return this;
    }
    public SimulateDialog cancelOnTouchOutSide(boolean cancel){
        dialog.setCanceledOnTouchOutside(cancel);
        return this;
    }
    public SimulateDialog showDialog(){


        dialog.show();
        return this;
    }

    public SimulateDialog close(){
        dialog.dismiss();
        return this;
    }


}

