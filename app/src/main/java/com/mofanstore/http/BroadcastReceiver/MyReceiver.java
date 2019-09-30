package com.mofanstore.http.BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;


public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }
    private SharedPreferences sp;

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "该账号已在其他设备上登录", Toast.LENGTH_SHORT).show();
        sp = context.getSharedPreferences("legeUserInfo",0);
        sp.edit().clear().commit();
//        Intent intent1 = new Intent(context, LoginActiity.class);
//        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(intent1);
    }

}