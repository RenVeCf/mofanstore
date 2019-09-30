package com.mofanstore.http;

import android.content.Intent;

import com.google.gson.Gson;
import com.mofanstore.Application;

import java.util.SortedMap;


/**
 * Created by XY on 2017/4/19.
 */
public class GlobalParams {
    private static Intent mIntent;
    static String title = "图片上传中";


    public static void encrypt(SortedMap<String, Object> mapchild, SortedMap<String, Object> map) {
        if (!Application.debug) {//加密
            try {
                String encrypt = Encryption.encrypt(new Gson().toJson(mapchild));
                map.put("data", encrypt);
             System.out.println("----------------------------------ture");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            map.put("data", mapchild);
            System.out.println("----------------------------------flase");
        }
    }


//    public static void loadCons(String url, ImageView imageView, int id) {
//        Glide.with(Appliction.getInstance()).load(HttpUrl.IMAGE_URL + url)
//                .placeholder(id)
//                .error(id)
//                .dontAnimate().into(imageView);
//    }
}
