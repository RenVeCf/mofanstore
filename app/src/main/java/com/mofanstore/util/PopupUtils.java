package com.mofanstore.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.mofanstore.R;
import com.mofanstore.util.city.CityPicker;
import com.mofanstore.util.city.TimePicker;
import com.mofanstore.util.city.TimerdayPicker;
import com.mofanstore.util.city.WheelView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class PopupUtils  {


    /**
     * 初始化popupWindow
     *
     * @param view
     */
    public static PopupWindow menuWindow;


    private static Dialog dialog;

    private static Dialog myDialog;

    private static Dialog cityDialog;
    private static String result;
    private static PopupWindow popupWindow;
    private static WheelView mViewProvince, id_city;
    private static String profession;
    private static List<String> namePosition=new ArrayList<>();
    private TextView tvConfirm;
    private TextView tvCancel;


    /**
     * 关闭窗口
     *
     * @param context
     */
    private static void closePopupWindow(Activity context) {
        if (popupWindow != null && popupWindow.isShowing()) {
            popupWindow.dismiss();
            popupWindow = null;
            WindowManager.LayoutParams params = context.getWindow().getAttributes();
            params.alpha = 1f;
            context.getWindow().setAttributes(params);
        }
    }



    public static void showBirthdayPopwindow(Activity context, View view) {

        int mScreenWidth;
        int mScreenHeight;
        DisplayMetrics metric = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay()
                .getMetrics(metric);
        mScreenWidth = metric.widthPixels;
        mScreenHeight = metric.heightPixels;
        dialog = new Dialog(context, R.style.about_dialog);
        dialog.setContentView(view);

        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        dialogWindow.setGravity(Gravity.BOTTOM);

        lp.width = mScreenWidth;
        lp.height = (int) (mScreenHeight * 0.49);
        dialogWindow.setWindowAnimations(R.style.dialog_anim_bottom);
        dialogWindow.setAttributes(lp);

        dialog.setCanceledOnTouchOutside(true);

        dialog.show();


    }

    /**
     * 弹出地址控件
     */
    public static void showAddressDialog(Activity context, final onSelectFinishListener listener) {
        int mScreenWidth;
        int mScreenHeight;
        DisplayMetrics metric = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay()
                .getMetrics(metric);
        mScreenWidth = metric.widthPixels;
        mScreenHeight = metric.heightPixels;
        View view = LayoutInflater.from(context).inflate(R.layout.view_city, null, false);
        final Dialog dialog = new Dialog(context, R.style.about_dialog);
        dialog.setContentView(view);

        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        dialogWindow.setGravity(Gravity.BOTTOM);

        lp.width = mScreenWidth;
        lp.height = (int) (mScreenHeight * 0.35);
        dialogWindow.setWindowAnimations(R.style.dialog_anim_bottom);
        dialogWindow.setAttributes(lp);

        dialog.setCanceledOnTouchOutside(true);

        dialog.show();

        TextView tvConfirm = (TextView) view.findViewById(R.id.tvText_confirm);
        TextView tvCancel = (TextView) view.findViewById(R.id.tvText_cancel);
        final CityPicker cityPicker = (CityPicker) view.findViewById(R.id.cpCity);


        tvConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> list = cityPicker.getSelect();
                String area = list.get(0)
                        + "" + list.get(1) + "" + list.get(2);

               /* tvAddress.setText(area);
                zipCode = cityPicker.getSelectZip();*/
//                tvAddress.setText(zipCode);
                if (listener != null) {
                    listener.onSelectFinish(area);
                }

                dialog.dismiss();
            }
        });
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    //自定义一个回调的接口
    public static View getDataPick(final Context context, final onSelectFinishListener listener) {
        View view = LayoutInflater.from(context).inflate(R.layout.time_picker, null, false);
        final TimePicker tpTime = (TimePicker) view.findViewById(R.id.tpTime);
        Calendar calendar = Calendar.getInstance();
        tpTime.setDefault(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
        TextView tvConfirm = (TextView) view.findViewById(R.id.tvDialog_confirm);
        TextView tvCancel = (TextView) view.findViewById(R.id.tvDialog_cancel);
        final TextView tvDialog_Date = (TextView) view.findViewById(R.id.tvDialog_Date);
        tvConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int month = Integer.valueOf(tpTime.getMonth());
                String m;
                if (month < 10) {
                    m = "0" + month;
                } else {
                    m = String.valueOf(month);
                }
                int year = Integer.valueOf(tpTime.getYear());
                int d = getDay(year, month);
                int day = Integer.valueOf(tpTime.getDay());
                if (day > d) {
                    day = d;
                }
                String da;
                if (day < 10) {
                    da = "0" + day;
                } else {
                    da = String.valueOf(day);
                }
                if (dialog != null) {
                    dialog.dismiss();
                }
                if (listener != null) {
                    listener.onSelectFinish(year + "-" + m + "-" + da);
                    tvDialog_Date.setText(year + "-" + m + "-" + da);
                }

            }

        });
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });
        return view;
    }



    public static View getDatatime(final Context context,String tetle, ArrayList<String> data,final onSelectFinishListener listener) {
        View view = LayoutInflater.from(context).inflate(R.layout.time_dialog, null, false);
        final TimerdayPicker tpTime = (TimerdayPicker) view.findViewById(R.id.tpTime);
        TextView tvConfirm = (TextView) view.findViewById(R.id.comnit);
        TextView tvDialog_cancel = (TextView) view.findViewById(R.id.tvDialog_cancel);
        tvDialog_cancel.setText(tetle);
        final TextView tvDialog_Date = (TextView) view.findViewById(R.id.tvDialog_Date);
        tpTime.mWheelYear.setItems(data);
        tvConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                int month = Integer.valueOf(tpTime.getMonth());
//                String m;
//                if (month < 10) {
//                    m = "0" + month;
//                } else {
//                    m = String.valueOf(month);
//                }

                String year = tpTime.getYear();
//                String m1;
//                if (year < 10) {
//                    m1 = "0" + year;
//                } else {
//                    m1 = String.valueOf(year);
//                }

                if (dialog != null) {
                    dialog.dismiss();
                }
                if (listener != null) {
                    listener.onSelectFinish(year+"");
                }

            }

        });

        return view;
    }


    /**
     * @param year  年
     * @param month 月
     * @return 真实2月份天数
     */
    private static int getDay(int year, int month) {
        int day = 30;
        boolean flag = false;
        switch (year % 4) {
            case 0:
                flag = true;
                break;
            default:
                flag = false;
                break;
        }
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                day = 31;
                break;
            case 2:
                day = flag ? 29 : 28;
                break;
            default:
                day = 30;
                break;
        }
        return day;
    }


    public interface onSelectFinishListener {
        public void onSelectFinish(String birthday);
    }



}
