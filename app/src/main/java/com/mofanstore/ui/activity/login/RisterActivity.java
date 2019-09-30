package com.mofanstore.ui.activity.login;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mofanstore.R;
import com.mofanstore.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class RisterActivity extends BaseActivity {

    @InjectView(R.id.back)
    FrameLayout back;
    @InjectView(R.id.tv_btm1)
    TextView tvBtm1;
    @InjectView(R.id.tv_btm2)
    TextView tvBtm2;
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
    @InjectView(R.id.fg_yaoqm)
    EditText fgYaoqm;
    @InjectView(R.id.rl_code)
    RelativeLayout rlCode;
    @InjectView(R.id.cb_agree)
    CheckBox cbAgree;
    @InjectView(R.id.tv_agreement)
    TextView tvAgreement;
    @InjectView(R.id.rl_agree)
    RelativeLayout rlAgree;
    @InjectView(R.id.comnit)
    Button comnit;
    @InjectView(R.id.tv_rigter)
    TextView tvRigter;

    @Override
    public int intiLayout() {
        return R.layout.activity_rigster;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.inject(this);
    }

    @OnClick({R.id.back, R.id.tv_btm1, R.id.tv_btm2, R.id.bt_getAuthCode, R.id.cb_agree, R.id.comnit, R.id.tv_rigter})
    public void onViewClicked(View view) {
        Intent intent;
        Drawable drawable =getResources().getDrawable(R.mipmap.line2);
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.tv_btm1:
                drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
                tvBtm1.setCompoundDrawables(null, null, null, drawable);
                tvBtm2.setCompoundDrawables(null, null, null, null);
                etPhone.setHint("输入您的手机号");
                break;
            case R.id.tv_btm2:
                drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
                tvBtm2.setCompoundDrawables(null, null, null, drawable);
                tvBtm1.setCompoundDrawables(null, null, null, null);
                etPhone.setHint("输入您的邮箱号");
                break;
            case R.id.bt_getAuthCode:
                if (!TextUtils.isEmpty(etPhone.getText().toString())) {
//                    setcode(etPhone.getText().toString());
                } else {
                    toastLong("请输入正确的手机号码");
                }
                break;
            case R.id.cb_agree:
                intent=new Intent(RisterActivity.this, HtmlActivity.class);
                intent.putExtra("name","用户协议");
                intent.putExtra("url","https://www.baidu.com/");
                startActivity(intent);
                break;
            case R.id.comnit:
                if (TextUtils.isEmpty(etPhone.getText().toString())) {
                    if (!fgCode.getText().toString().equals("")) {
                        if (!fgPsw.getText().toString().equals("")) {
                            if (cbAgree.isChecked() == true) {
//                                rister();
                            } else {
                                toastLong("请先阅读并同意用户协议");
                            }
                        } else {
                            toastLong("请输入6-16位密码");
                        }
                    } else {
                        toastLong("请输入短信验证码");
                    }
                } else {
                    toastLong("请输入正确的手机号");
                }
                break;
            case R.id.tv_rigter:
                finish();
                break;
        }
    }


//    private void setcode(String phone) {
//        String time = MyTimeUtils.getStringDate();
//        SortedMap<String, Object> map = new TreeMap<>();
//        SortedMap<String, Object> mapchild = new TreeMap<>();
//        mapchild.put("PHONE",phone);
//        map.put("createTime", time);
//        GlobalParams.encrypt(mapchild, map);
//        map.put("sign", MD5.getMD5Str(time + new Gson().toJson(mapchild)));
//        new RxHttp<BaseResult>().send(ApiManager.getService().sendCode(map),
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
//                    @Override
//                    public void onError(Throwable e) {
//                        super.onError(e);
//                        e.printStackTrace();
//                    }
//                });
//    }
//    Userinfo userinfo;
//    private void rister() {
//        String time = MyTimeUtils.getStringDate();
//        SortedMap<String, Object> map = new TreeMap<>();
//        SortedMap<String, Object> mapchild = new TreeMap<>();
//        mapchild.put("CATEGORY",sp.getString("usertype",""));
//        mapchild.put("CODE",fgCode.getText().toString());
//        mapchild.put("PASSWORD",fgPsw.getText().toString());
//        mapchild.put("PHONE",etPhone.getText().toString());
//        mapchild.put("REGISTER_TYPE",TYPE);
//        mapchild.put("OPENID",OPENID);
//        map.put("createTime", time);
//        GlobalParams.encrypt(mapchild, map);
//        map.put("sign", MD5.getMD5Str(time + new Gson().toJson(mapchild)));
//        new RxHttp<BaseResult<Userinfo>>().send(ApiManager.getService().register(map),
//                new Response<BaseResult<Userinfo>>(this, true, "") {
//                    @Override
//                    public void onNext(BaseResult<Userinfo> result) {
//                        super.onNext(result);
//                        if (result.response.toString().equals("0")) {
//                            userinfo=result.data;
//                            sp.edit().putString("APPUSER_ID", result.data.getAPPUSER_ID()).commit();
//                            sp.edit().putString("PHONE", result.data.getPHONE()).commit();
//                            sp.edit().putString("MER_LEVEL", result.data.getMER_LEVEL()).commit();
//                            sp.edit().putString("IS_AUDIT", result.data.getIS_AUDIT()).commit();
//                            toastLong(result.desc);
//                            if (sp.getString("usertype","").equals("1")){
//                                Intent intent1 = new Intent("pullview");
//                                sendBroadcast(intent1);
//                                AppManager.getAppManager().finishAllloginActivity();
//                            }else{
//                                if (userinfo.getIS_AUDIT().equals("1")) {
//                                    Intent intent = new Intent(RisterActivity.this, MasterMainActivity.class);
//                                    startActivity(intent);
//                                    AppManager.getAppManager().finishAllloginActivity();
//                                }else{
//                                    Intent intent=new Intent(RisterActivity.this, wsziliaoActivity.class);
//                                    intent.putExtra("type","1");
//                                    startActivity(intent);
//                                }
//                            }
//
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
            btGetAuthCode.setTextColor(0xff7ED321);
        }

        @Override
        public void onTick(long millisUntilFinished) {//计时过程显示
            btGetAuthCode.setClickable(false);
            btGetAuthCode.setText(millisUntilFinished / 1000 + "秒");
            btGetAuthCode.setTextColor(0xff999999);
        }
    }
}
