package com.mofanstore.ui.activity.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;

import com.mofanstore.MainActivity;
import com.mofanstore.R;
import com.mofanstore.base.BaseActivity;


/**
 * Created by Administrator on 2017/12/27.
 */

public class WlcomeActivity extends BaseActivity {
    private SharedPreferences sp;
    boolean isFirstIn = false;
    private Intent intent;
    @Override
    public int intiLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    public void initView() {
        SharedPreferences preferences = getSharedPreferences(
                "first_pref", MODE_PRIVATE);

        // 取得相应的isFirstIn，如果没有该isFirstIn，说明还未写入，用true作为默认
        isFirstIn = preferences.getBoolean("isFirstIn", true);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
//                if (!isFirstIn) {
//                    sp = getSharedPreferences("mofanUserInfo", MODE_PRIVATE);
                    Handler handler=new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                                Intent intent=new Intent(WlcomeActivity.this, LoginActivity.class);
                                startActivity(intent);
                                finish();
                        }
                    }, 1000);
//                }else{
//                    intent = new Intent(WlcomeActivity.this, GuideActivity.class);
//                    startActivity(intent);
//                    finish();
//                }
            }
        }, 1000);



    }

    @Override
    public void initData() {

    }
}
