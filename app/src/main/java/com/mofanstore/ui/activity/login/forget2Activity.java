package com.mofanstore.ui.activity.login;

import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.mofanstore.R;
import com.mofanstore.base.BaseActivity;

import butterknife.InjectView;
import butterknife.OnClick;

public class forget2Activity extends BaseActivity {
    @InjectView(R.id.back)
    FrameLayout back;
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.tv_commiy)
    TextView tvCommiy;
    @InjectView(R.id.commit)
    FrameLayout commit;
    @InjectView(R.id.ed_nickname)
    TextView edNickname;
    @InjectView(R.id.ed_code)
    TextView edCode;
    private String code;
    @Override
    public int intiLayout() {
        return R.layout.activit_forget2;
    }

    @Override
    public void initView() {
        tvName.setText("找回密码");
    }

    @Override
    public void initData() {

    }
//    private SharedPreferences sp;
//    issetbean  isseut;
//    private void isset() {
//        Map<String, String> map = new HashMap<>();
//        map.put("code", code);
//        new RxHttp<BaseResult<issetbean>>().send(ApiManager.getService().isset(map),
//                new Response<BaseResult<issetbean>>(forget2Activity.this, false, "") {
//                    @Override
//                    public void onNext(BaseResult<issetbean> result) {
//                        super.onNext(result);
//                        if (result.code.equals("200")) {
//                            isseut=result.data;
//                            sp = getSharedPreferences("kusanUserInfo", MODE_PRIVATE);
//                            sp.edit().putString("user_id", isseut.getUser_id()).commit();
//                        } else {
//                            toastLong(result.msg);
//
//                        }
//                    }
//                });
//    }

    @OnClick({R.id.back, R.id.ed_nickname, R.id.ed_code})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.ed_nickname:
                intent=new Intent(forget2Activity.this,forgetActivity.class);
                startActivity(intent);

                break;
            case R.id.ed_code:
                    intent=new Intent(forget2Activity.this,forget3Activity.class);
                    startActivity(intent);
                break;
        }
    }
}
