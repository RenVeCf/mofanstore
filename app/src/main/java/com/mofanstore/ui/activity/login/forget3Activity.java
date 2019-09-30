package com.mofanstore.ui.activity.login;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mofanstore.R;
import com.mofanstore.base.BaseActivity;

import butterknife.InjectView;
import butterknife.OnClick;

public class forget3Activity extends BaseActivity {
    @InjectView(R.id.back)
    FrameLayout back;
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.tv_commiy)
    TextView tvCommiy;
    @InjectView(R.id.commit)
    FrameLayout commit;
    @InjectView(R.id.et_phone)
    EditText etPhone;
    @InjectView(R.id.rled1)
    RelativeLayout rled1;
    @InjectView(R.id.fg_code)
    EditText fgCode;
    @InjectView(R.id.bt_getAuthCode)
    TextView btGetAuthCode;
    @InjectView(R.id.rl_phone)
    RelativeLayout rlPhone;
    @InjectView(R.id.fg_psw)
    EditText fgPsw;
    @InjectView(R.id.rl_account)
    RelativeLayout rlAccount;
    @InjectView(R.id.comnit)
    Button comnit;
    private TimeCount time1;
    boolean in_true = true;
    @Override
    public int intiLayout() {
        return R.layout.activit_forget3;
    }

    @Override
    public void initView() {
        tvName.setText("忘记密码");
        time1 = new TimeCount(60000, 1000);//构造CountDownTimer对象
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.back, R.id.bt_getAuthCode, R.id.comnit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_getAuthCode:
                if (!etPhone.getText().toString().equals("") && etPhone.getText().toString().length() == 11) {
//                    getcode(etPhone.getText().toString());
                } else {
                    toastLong("请输入正确的手机号码");
                }
                break;
            case R.id.comnit:
                if (!etPhone.getText().toString().equals("")) {
                    if (!fgCode.getText().toString().equals("")) {
                        if (!fgPsw.getText().toString().equals("")) {
//                            findPwd();
                        } else {
                            toastLong("请输入新密码");
                        }
                    } else {
                        toastLong("请输入短信验证码");
                    }
                } else {
                    toastLong("请输入手机号");
                }
                break;
        }
    }

//    private void findPwd() {
//        String time = MyTimeUtils.getStringDate();
//        SortedMap<String, Object> map = new TreeMap<>();
//        SortedMap<String, Object> mapchild = new TreeMap<>();
//        mapchild.put("PASSWORD",fgPsw.getText().toString());
//        mapchild.put("CODE",fgCode.getText().toString());
//        mapchild.put("PHONE",etPhone.getText().toString());
//        map.put("createTime", time);
//        GlobalParams.encrypt(mapchild, map);
//        map.put("sign", MD5.getMD5Str(time + new Gson().toJson(mapchild)));
//        new RxHttp<BaseResult>().send(ApiManager.getService().findPwd(map),
//                new Response<BaseResult>(this, true, "") {
//                    @Override
//                    public void onNext(BaseResult result) {
//                        super.onNext(result);
//                        if (result.response.toString().equals("0")) {
//                            toastLong(result.desc);
//                            finish();
//                        } else {
//                            toastLong(result.desc);
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        super.onError(e);
//                        e.printStackTrace();
//                    }
//                });
//    }

    class TimeCount extends CountDownTimer {
        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);//参数依次为总时长,和计时的时间间隔
        }

        @Override
        public void onFinish() {//计时完毕时触发
            btGetAuthCode.setText("发送验证码");
            btGetAuthCode.setClickable(true);
            btGetAuthCode.setTextColor(0xff008AFF);
        }

        @Override
        public void onTick(long millisUntilFinished) {//计时过程显示
            btGetAuthCode.setClickable(false);
            btGetAuthCode.setText(millisUntilFinished / 1000 + "秒");
            btGetAuthCode.setTextColor(0xff999999);
        }
    }

//    private void getcode(String phone) {
//        String time = MyTimeUtils.getStringDate();
//        SortedMap<String, Object> map = new TreeMap<>();
//        SortedMap<String, Object> mapchild = new TreeMap<>();
//        mapchild.put("PHONE",phone);
//        map.put("createTime", time);
//        GlobalParams.encrypt(mapchild, map);
//        map.put("sign", MD5.getMD5Str(time + new Gson().toJson(mapchild)));
//        new RxHttp<BaseResult>().send(ApiManager.getService().findCode(map),
//                new Response<BaseResult>(this, true, "") {
//                    @Override
//                    public void onNext(BaseResult result) {
//                        super.onNext(result);
//                        if (result.response.toString().equals("0")) {
//                            toastLong(result.desc);
//                            time1.start();
//                        } else {
//                            toastLong(result.desc);
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        super.onError(e);
//                        e.printStackTrace();
//                    }
//                });
//    }
}
