package com.mofanstore.http;


import com.mofanstore.bean.Userinfobean;
import com.mofanstore.bean.reasonbean;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import rx.Observable;

/**
 * Created by jumpbox on 16/5/2.
 */
public interface ApiService {


    //登录
    @FormUrlEncoded
    @POST("api/login")
    Observable<BaseResult<Userinfobean>>
    login(@FieldMap Map<String, String> map);


    @FormUrlEncoded
    @POST("api/apply/fail/reason")
    Observable<BaseResult<reasonbean>>
    reason(@FieldMap Map<String, String> map);

    //注册
    @FormUrlEncoded
    @POST("api/reg")
    Observable<BaseResult<Userinfobean>>
    reg(@FieldMap Map<String, String> map);

    //找回
    @FormUrlEncoded
    @POST("api/forget")
    Observable<BaseResult>
    foeget(@FieldMap Map<String, String> map);

    //获取手机验证码
    @FormUrlEncoded
    @POST("api/mobileCode")
    Observable<BaseResult>
    mobileCode(@FieldMap Map<String, String> map);

    //获取手机验证码
    @FormUrlEncoded
    @POST("api/driver/order/del")
    Observable<BaseResult>
    del(@FieldMap Map<String, String> map);
    //个人中心
    @FormUrlEncoded
    @POST("api/my")
    Observable<BaseResult<Userinfobean>>
    getMy(@FieldMap Map<String, String> map);

//    //个人中心
//    @FormUrlEncoded
//    @POST("api/search/area")
//    Observable<Base2Result<searchbean>>
//    search(@FieldMap Map<String, String> map);
//
//    @FormUrlEncoded
//    @POST("api/snatch/order")
//    Observable<BaseResult>
//    order(@FieldMap Map<String, String> map);
//
//    @FormUrlEncoded
//    @POST("api/snatch/info")
//    Observable<BaseResult<snatchbean>>
//    getsnatchinfo(@FieldMap Map<String, String> map);
//
//    @FormUrlEncoded
//    @POST("api/evaluate/passenger")
//    Observable<BaseResult>
//    passenger(@FieldMap Map<String, String> map);
//
//    @FormUrlEncoded
//    @POST("api/passenger/unarrive")
//    Observable<BaseResult>
//    unarrive(@FieldMap Map<String, String> map);
//
//    @FormUrlEncoded
//    @POST("api/apply/owner/info")
//    Observable<BaseResult<ownerinfobean>>
//    getownerinfo(@FieldMap Map<String, String> map);
//
//    @FormUrlEncoded
//    @POST("api/apply/owner")
//    Observable<BaseResult>
//    setowner(@FieldMap Map<String, String> map);
//
//    @FormUrlEncoded
//    @POST("api/add/car")
//    Observable<BaseResult>
//    addcar(@FieldMap Map<String, String> map);
//
//    @FormUrlEncoded
//    @POST("api/add/car/color")
//    Observable<Base2Result<carcolorbean>>
//    getcarcolor(@FieldMap Map<String, String> map);
//
//    @FormUrlEncoded
//    @POST("api/add/car/seat")
//    Observable<Base2Result<carcolorbean>>
//    getcarnum(@FieldMap Map<String, String> map);
//
//    //个人中心
//    @FormUrlEncoded
//    @POST("api/feedback")
//    Observable<BaseResult>
//    getfeed(@FieldMap Map<String, String> map);
//
//    //个人中心
//    @FormUrlEncoded
//    @POST("api/my/income")
//    Observable<BaseResult<ShouruLvbean>>
//    getincome(@FieldMap Map<String, String> map);
//
//    //个人中心
//    @FormUrlEncoded
//    @POST("api/my/wallet")
//    Observable<BaseResult<walletbean>>
//    getwallte(@FieldMap Map<String, String> map);
//
//    //个人中心
//    @FormUrlEncoded
//    @POST("api/my/invitation")
//    Observable<BaseResult<Yaoqinlvbean>>
//    getyaoqin(@FieldMap Map<String, String> map);
//
//    //个人中心
//    @FormUrlEncoded
//    @POST("api/car/list")
//    Observable<BaseResult<carlist2bean>>
//    getcarmanngelist(@FieldMap Map<String, String> map);
//
//    //个人中心
//    @FormUrlEncoded
//    @POST("api/driver/own")
//    Observable<Base2Result<carlistbean>>
//    getownlist(@FieldMap Map<String, String> map);
//
//    //个人中心
//    @FormUrlEncoded
//    @POST("api/add/car/brand")
//    Observable<Base2Result<brandbean>>
//    brand(@FieldMap Map<String, String> map);
//
//    //个人中心
//    @FormUrlEncoded
//    @POST("api/service/language")
//    Observable<Base2Result<languagebean>>
//    language(@FieldMap Map<String, String> map);
//
//    //个人中心
//    @FormUrlEncoded
//    @POST("api/my/bank/card")
//    Observable<BaseResult<Carlbbean>>
//    getcarlv(@FieldMap Map<String, String> map);
//
//    //个人中心
//    @FormUrlEncoded
//    @POST("api/my/bank/list")
//    Observable<Base2Result<Carxzbean>>
//    getcarlist(@FieldMap Map<String, String> map);
//
//    //个人中心
//    @FormUrlEncoded
//    @POST("api/my/add/bank/card")
//    Observable<BaseResult>
//    insertBank(@FieldMap Map<String, String> map);
//
//    //个人中心
//    @FormUrlEncoded
//    @POST("api/my/update/bank/card")
//    Observable<BaseResult>
//    insertBank2(@FieldMap Map<String, String> map);
//
//    //个人中心
//    @FormUrlEncoded
//    @POST("api/my/apply/bankshow")
//    Observable<BaseResult>
//    bankshow(@FieldMap Map<String, String> map);
//
//    //个人中心
//    @FormUrlEncoded
//    @POST("api/arrive/start")
//    Observable<BaseResult>
//    start(@FieldMap Map<String, String> map);
//
//    //个人中心
//    @FormUrlEncoded
//    @POST("api/passenger/arrive")
//    Observable<BaseResult>
//    arrive(@FieldMap Map<String, String> map);
//
//
//    //个人中心
//    @FormUrlEncoded
//    @POST("api/real/time/location")
//    Observable<BaseResult>
//    location(@FieldMap Map<String, String> map);
//    //个人中心
//    @FormUrlEncoded
//    @POST("api/end/service")
//    Observable<BaseResult>
//    endarrive(@FieldMap Map<String, String> map);
//
//    //个人中心
//    @FormUrlEncoded
//    @POST("api/start/server")
//    Observable<BaseResult>
//    server(@FieldMap Map<String, String> map);
//
//    //个人中心
//    @FormUrlEncoded
//    @POST("api/notice")
//    Observable<Base2Result<Msagebean>>
//    getnotice(@FieldMap Map<String, String> map);
//
//
//    //个人中心
//    @FormUrlEncoded
//    @POST("api/driver/home")
//    Observable<BaseResult<homebean>>
//    gethome(@FieldMap Map<String, String> map);
//
//    //个人中心
//    @FormUrlEncoded
//    @POST("api/snatch/hall")
//    Observable<Base2Result<orderlistbean>>
//    gethall(@FieldMap Map<String, String> map);
//
//    //个人中心
//    @FormUrlEncoded
//    @POST("api/driver/order/list")
//    Observable<Base2Result<orderlistbean>>
//    getorder(@FieldMap Map<String, String> map);


    //上传图片
    @Multipart
    @POST("api/my/upload")
    Observable<Base2Result<String>>
    uploadPic(@PartMap Map<String, RequestBody> map);
}
