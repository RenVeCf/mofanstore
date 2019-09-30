package com.mofanstore.ui.activity.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mofanstore.MainActivity;
import com.mofanstore.R;
import com.mofanstore.base.BaseActivity;

import butterknife.InjectView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {
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
    @InjectView(R.id.fg_psw)
    EditText fgPsw;
    @InjectView(R.id.rl_account)
    RelativeLayout rlAccount;
    @InjectView(R.id.tv_nocode)
    TextView tvNocode;
    @InjectView(R.id.tv_rigter)
    TextView tvRigter;
    @InjectView(R.id.comnit)
    Button comnit;
    @InjectView(R.id.tv_wchat)
    TextView tvWchat;
    @InjectView(R.id.tv_QQ)
    TextView tvQQ;
    private SharedPreferences sp;
    boolean in_true = true;

    @Override
    public int intiLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        tvName.setText("登录");
        sp = getSharedPreferences("CmUserInfo", MODE_PRIVATE);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.tv_nocode, R.id.back, R.id.tv_rigter, R.id.comnit, R.id.tv_wchat, R.id.tv_QQ})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;

            case R.id.tv_rigter:
                intent = new Intent(LoginActivity.this, RisterActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_nocode:
                intent = new Intent(LoginActivity.this, forgetActivity.class);
                startActivity(intent);
                break;
            case R.id.comnit:
                if (!TextUtils.isEmpty(etPhone.getText().toString())) {
                    if (!fgPsw.getText().toString().equals("")) {
//                        Login();
                        toastLong("登录成功");
                         intent=new Intent(LoginActivity.this, MainActivity.class);
                         startActivity(intent);
                         finish();
                    } else {
                        toastLong("输入登录密码");
                    }
                } else {
                    toastLong("输入您的手机号或邮箱");
                }
                break;
            case R.id.tv_wchat:
//                Platform plat = ShareSDK.getPlatform(Wechat.NAME);
//                plat.removeAccount(true); //移除授权状态和本地缓存，下次授权会重新授权
//                plat.SSOSetting(false); //SSO授权，传false默认是客户端授权，没有客户端授权或者不支持客户端授权会跳web授权
//                plat.setPlatformActionListener(new PlatformActionListener() {
//                    @Override
//                    public void onComplete(Platform platform, int action, HashMap<String, Object> hashMap) {
//                        if (action == Platform.ACTION_USER_INFOR) {
//                            PlatformDb platDB = platform.getDb();//获取数平台数据DB
//                            open(platDB.getToken(), "0");
//                        }
//                        toastLong("回调成功");
//                    }
//
//                    @Override
//                    public void onError(Platform platform, int i, Throwable throwable) {
//                        toastLong("回调错误" + i);
//                    }
//
//                    @Override
//                    public void onCancel(Platform platform, int i) {
//                        toastLong("回调quxiao");
//                    }
//                });
//                if (plat.isClientValid()) {
//                    //判断是否存在授权凭条的客户端，true是有客户端，false是无
//                }
//                if (plat.isAuthValid()) {
//                    return;
//                }
//                plat.showUser(null);
                break;
            case R.id.tv_QQ:
//
//                Platform plat1 = ShareSDK.getPlatform(QQ.NAME);
//                plat1.removeAccount(true); //移除授权状态和本地缓存，下次授权会重新授权
//                plat1.SSOSetting(false); //SSO授权，传false默认是客户端授权，没有客户端授权或者不支持客户端授权会跳web授权
//                plat1.setPlatformActionListener(new PlatformActionListener() {
//                    @Override
//                    public void onComplete(Platform platform, int action, HashMap<String, Object> hashMap) {
//                        if (action == Platform.ACTION_USER_INFOR) {
//                            PlatformDb platDB = platform.getDb();//获取数平台数据DB
//                            open(platDB.getToken(), "0");
//                        }
//                        toastLong("回调成功");
//                    }
//
//                    @Override
//                    public void onError(Platform platform, int i, Throwable throwable) {
//                        toastLong("回调错误" + i);
//                    }
//
//                    @Override
//                    public void onCancel(Platform platform, int i) {
//                        toastLong("回调quxiao");
//                    }
//                });
//                //授权回调监听，监听oncomplete，onerror，oncancel三种状态
//                if (plat1.isClientValid()) {
//                    //判断是否存在授权凭条的客户端，true是有客户端，false是无
//                }
//                if (plat1.isAuthValid()) {
////判断是否已经存在授权状态，可以根据自己的登录逻辑设置
//                    return;
//                }
////plat.authorize();	//要功能，不要数据
//                plat1.showUser(null);
                break;
        }
    }

//    Userinfo userinfo;
//
//    private void Login() {
//        String time = MyTimeUtils.getStringDate();
//        SortedMap<String, Object> map = new TreeMap<>();
//        SortedMap<String, Object> mapchild = new TreeMap<>();
//        mapchild.put("PASSWORD", fgPsw.getText().toString());
//        mapchild.put("PHONE", etPhone.getText().toString());
//        mapchild.put("GENRE", sp.getString("usertype", ""));
//        map.put("createTime", time);
//        GlobalParams.encrypt(mapchild, map);
//        map.put("sign", MD5.getMD5Str(time + new Gson().toJson(mapchild)));
//        new RxHttp<BaseResult<Userinfo>>().send(ApiManager.getService().login(map),
//                new Response<BaseResult<Userinfo>>(this, true, "") {
//                    @Override
//                    public void onNext(BaseResult<Userinfo> result) {
//                        super.onNext(result);
//                        if (result.response.toString().equals("0")) {
//                            userinfo = result.data;
//                            sp.edit().putString("APPUSER_ID", result.data.getAPPUSER_ID()).commit();
//                            sp.edit().putString("PHONE", result.data.getPHONE()).commit();
//                            sp.edit().putString("MER_LEVEL", result.data.getMER_LEVEL()).commit();
//                            sp.edit().putString("IS_AUDIT", result.data.getIS_AUDIT()).commit();
//                            Intent intent1 = new Intent("pullview");
//                            sendBroadcast(intent1);
//                            JPushInterface.setAlias(getApplicationContext(), "cm_" + result.data.getAPPUSER_ID(), new TagAliasCallback() {
//                                @Override
//                                public void gotResult(int i, String s, Set<String> set) {
//
//                                }
//                            });
//                            toastLong(result.desc);
//                            if (sp.getString("usertype", "").equals("1")) {
//                                Intent intent = new Intent(LoginActivity.this, UsermMainActivity.class);
//                                startActivity(intent);
//                                finish();
//                            } else {
//                                Intent intent = new Intent(LoginActivity.this, MasterMainActivity.class);
//                                startActivity(intent);
//                                finish();
//                            }
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
//
//
//    private void open(final String OPENID, final String TYPE) {
//        String time = MyTimeUtils.getStringDate();
//        SortedMap<String, Object> map = new TreeMap<>();
//        SortedMap<String, Object> mapchild = new TreeMap<>();
//        mapchild.put("OPENID", OPENID);
//        mapchild.put("TYPE", TYPE);
//        mapchild.put("GENRE", sp.getString("usertype", ""));
//        map.put("createTime", time);
//        GlobalParams.encrypt(mapchild, map);
//        map.put("sign", MD5.getMD5Str(time + new Gson().toJson(mapchild)));
//        new RxHttp<BaseResult<Userinfo>>().send(ApiManager.getService().open(map),
//                new Response<BaseResult<Userinfo>>(this, true, "") {
//                    @Override
//                    public void onNext(BaseResult<Userinfo> result) {
//                        super.onNext(result);
//                        if (result.response.toString().equals("0")) {
//                            userinfo = result.data;
//                            sp.edit().putString("APPUSER_ID", result.data.getAPPUSER_ID()).commit();
//                            sp.edit().putString("PHONE", result.data.getPHONE()).commit();
//                            sp.edit().putString("MER_LEVEL", result.data.getMER_LEVEL()).commit();
//                            sp.edit().putString("IS_AUDIT", result.data.getIS_AUDIT()).commit();
//                            JPushInterface.setAlias(getApplicationContext(), "cm_" + result.data.getAPPUSER_ID(), new TagAliasCallback() {
//                                @Override
//                                public void gotResult(int i, String s, Set<String> set) {
//
//                                }
//                            });
//                            toastLong(result.desc);
//                            if (sp.getString("usertype", "").equals("1")) {
//                                Intent intent = new Intent(LoginActivity.this, UsermMainActivity.class);
//                                startActivity(intent);
//                                finish();
//                            } else {
//                                Intent intent = new Intent(LoginActivity.this, MasterMainActivity.class);
//                                startActivity(intent);
//                                finish();
//                            }
//                        } else {
//                            Intent intent = new Intent(LoginActivity.this, WXLoginActivity.class);
//                            intent.putExtra("OPENID", OPENID);
//                            intent.putExtra("TYPE", TYPE);
//                            startActivity(intent);
//                            finish();
//
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

//    PlatformActionListener platformActionListener = new PlatformActionListener() {
//        @Override
//        public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
//            if (i == Platform.ACTION_USER_INFOR) {
//                PlatformDb platDB = platform.getDb();//获取数平台数据DB
//                //通过DB获取各种数据
////                            platDB.getToken();
////                            platDB.getUserGender();
////                            platDB.getUserIcon();
////                            platDB.getUserId();
////                            platDB.getUserName();
//                open(platDB.getToken(), "0");
//            }
//        }
//
//        @Override
//        public void onError(Platform platform, int i, Throwable throwable) {
//            toastLong("授权失败");
//        }
//
//        @Override
//        public void onCancel(Platform platform, int i) {
//            toastLong("授权取消");
//        }
//    };

}
