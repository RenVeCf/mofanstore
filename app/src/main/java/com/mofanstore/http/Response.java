package com.mofanstore.http;

import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.Toast;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

public   class Response<T> extends Subscriber<T> {

    private Context mContext;
    private boolean mNeedDialog = false;
    private onCancelRequestListener cancelRequestListener;
    private String title;
    public Response(Context context) {
        this.mContext = context;
    }

    public Response(Context context, boolean needDialog, String title) {
        this.mContext = context;
        this.title=title;

        this.mNeedDialog = needDialog;
    }

    public Response(Context context, boolean needDialog, onCancelRequestListener cancelRequestListener) {
        this.mContext = context;
        this.mNeedDialog = needDialog;
        this.cancelRequestListener = cancelRequestListener;
    }


    /**
     * 此方法现在onNext或者onError之后都会调用
     * 所以一般要处理请求结束时的信息是，需要重写此方法
     * 例如，loading结束时，刷新下拉刷新结果时等…………
     */
    @Override
    public void onCompleted() {
        if (mNeedDialog) {
            LoadingUtils.dismiss();
        }
        mContext = null;
    }




    @Override
    public void onNext(T t) {
     //   boolean flag = false;

//        if(t instanceof BaseResult){
//            if("600".equals(((BaseResult)t).code)){
//                flag =true;
//            }
//        }
//        if(flag){
//         //   ToastCommom.createToastConfig().ToastShow(MyApp.getInstance(), "很抱歉！您的帐号已经被冻结，无法登录使用");
////            Intent intent = new Intent(mContext,LoginActivity.class);
////            if (mContext!=null && ( !(mContext instanceof LoginActivity))){
////                mContext.startActivity(intent);
////                ((Activity)mContext).finish();
////            }
//            throw new RuntimeException(new Throwable("login fail"));
//        }


    }



    @Override
    public void onStart() {
        if (mNeedDialog) {

            LoadingUtils.show(mContext, title);
            LoadingUtils.setOnKeyListener(new DialogInterface.OnKeyListener() {
                @Override
                public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    if (i == KeyEvent.KEYCODE_BACK) {
                        unsubscribe();
                        LoadingUtils.dismiss();
                        if (cancelRequestListener != null) {
                            cancelRequestListener.onCancelRequest();
                        }
                    }
                    return false;
                }
            });
        }
    }

    /**
     * 除非非要获取网络错误信息，否则一般不需要重写此方法；
     * 例如：网络400，404，断网，超时，等等…………
     */
    @Override
    public void onError(Throwable e) {
            LoadingUtils.dismiss();
            try {
                if (e instanceof ConnectException || e instanceof UnknownHostException) {
                    RefreshCompletes();
                    Toast.makeText(mContext, "服务器连接超时,请检查网络", Toast.LENGTH_SHORT).show();
                } else if (e instanceof SocketTimeoutException) {
                    RefreshCompletes();
                    Toast.makeText(mContext, "服务器连接超时,请检查网络", Toast.LENGTH_SHORT).show();
                } else if (e instanceof HttpException) {
                    RefreshCompletes();
                    Toast.makeText(mContext,"服务器异常", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception ignored) {
        }
        if (e == null || mContext == null)
            return;

    }

    public  void  RefreshCompletes() {};

    public interface onCancelRequestListener {
        void onCancelRequest();
    }

}