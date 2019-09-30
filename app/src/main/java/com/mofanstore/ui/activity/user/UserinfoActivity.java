package com.mofanstore.ui.activity.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.mofanstore.R;
import com.mofanstore.base.BaseActivity;
import com.mofanstore.util.RoundAngleImageView;

import java.io.File;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class UserinfoActivity extends BaseActivity {


    @InjectView(R.id.back)
    FrameLayout back;
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.tv_commiy)
    TextView tvCommiy;
    @InjectView(R.id.commit)
    FrameLayout commit;
    @InjectView(R.id.im_photo)
    RoundAngleImageView imPhoto;
    @InjectView(R.id.imback)
    ImageView imback;
    @InjectView(R.id.user_name)
    RelativeLayout userName;
    @InjectView(R.id.tv_username)
    TextView tvUsername;
    @InjectView(R.id.tv_userlxiren)
    TextView tvUserlxiren;
    @InjectView(R.id.tv_usergonsname)
    TextView tvUsergonsname;
    @InjectView(R.id.tv_userkefname)
    TextView tvUserkefname;
    @InjectView(R.id.tv_phone)
    TextView tvPhone;

    @Override
    public int intiLayout() {
        return R.layout.activity_userminfo;
    }

    @Override
    public void initView() {
        tvName.setText("个人资料");
    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.user_name, R.id.back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.user_name:
                PictureSelector.create(UserinfoActivity.this)
                        .openGallery(PictureMimeType.ofImage())
                        // .maxSelectNum(1)
                        .enableCrop(true)
                        .cropWH(200, 200)
//                        .synOrAsy(true)
                        // .glideOverride(300, 300)
//                        .scaleEnabled(true)
                        .withAspectRatio(1, 1)
                        //  .circleDimmedLayer(true)
                        .compress(true)
                        // .compressSavePath(getPath())
                        .selectionMode(PictureConfig.SINGLE)
                        .forResult(101);
                break;

        }
    }

//    private void updateInfo() {
//        String time = MyTimeUtils.getStringDate();
//        SortedMap<String, Object> map = new TreeMap<>();
//        SortedMap<String, Object> mapchild = new TreeMap<>();
//        mapchild.put("APPUSER_ID", sp.getString("APPUSER_ID", ""));
//        mapchild.put("CATEGORY", sp.getString("usertype", ""));
//        mapchild.put("TYPE", "1");
//        if (!LOGO.equals("")) {
//            mapchild.put("LOGO", LOGO);
//        }
//        mapchild.put("NICKNAME", tvUsername.getText().toString());
//        mapchild.put("COMPANY", tvUsergonsname.getText().toString());
//        mapchild.put("CONTACT", tvUserlxiren.getText().toString());
//        mapchild.put("CUSTOMER", tvUserkefname.getText().toString());
//        map.put("createTime", time);
//        GlobalParams.encrypt(mapchild, map);
//        map.put("sign", MD5.getMD5Str(time + new Gson().toJson(mapchild)));
//        new RxHttp<BaseResult>().send(ApiManager.getService().updateInfo(map),
//                new Response<BaseResult>(this, true, "") {
//                    @Override
//                    public void onNext(BaseResult result) {
//                        super.onNext(result);
//                        if (result.response.toString().equals("0")) {
//                            toastLong(result.desc);
////                                     TOS();
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

    String temppath;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 101:
                if (resultCode == RESULT_OK) {
                    List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                    if (selectList.get(0).isCut() == true) {
                        temppath = selectList.get(0).getCutPath();
                    } else {
                        temppath = selectList.get(0).getPath();
                    }
//                    Sethead(temppath);
                }
                break;

        }
    }

//    private String LOGO = "";
//
//    //上传头像
//    private void Sethead(final String urlhead) {
//        Map<String, RequestBody> mapchild = new HashMap<String, RequestBody>();
//        mapchild.put("DIR", getTextRequestBody("user"));//DIR目录：
//        mapchild.put("APPUSER_ID", getTextRequestBody(sp.getString("APPUSER_ID", "")));
//        mapchild.put("PIC\";filename=\"" + (System.currentTimeMillis() + ".jpg"), getImageRequestBody(temppath));//单图上传
//        new RxHttp<BaseResult<String>>().send(ApiManager.getService().uploadPic(mapchild),
//                new Response<BaseResult<String>>(this, false, "") {
//                    @Override
//                    public void onNext(BaseResult<String> result) {
//                        super.onNext(result);
//                        if (result.response.equals("0")) {
//                            LOGO = result.data;
//                            Bitmap bitmap = ImageUtils.getSmallBitmap(temppath);
//                            ByteArrayOutputStream bStream = new ByteArrayOutputStream();
//                            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bStream);
//                            imPhoto.setImageBitmap(bitmap);
//
//                        } else {
//                            toastLong(result.desc + "");
//
//                        }
//                    }
//                });
//
//    }

    public static RequestBody getImageRequestBody(String filePath) {
        return RequestBody.create(MediaType.parse("image/jpg"), new File(filePath));
    }

    public static RequestBody getTextRequestBody(String body) {
        return RequestBody.create(MediaType.parse("text/plan"), body);
    }

//    Userinfo userinfo;
//
//    private void getuserinfo() {
//        String time = MyTimeUtils.getStringDate();
//        SortedMap<String, Object> map = new TreeMap<>();
//        SortedMap<String, Object> mapchild = new TreeMap<>();
//        mapchild.put("APPUSER_ID", sp.getString("APPUSER_ID", ""));
//        mapchild.put("GENRE", "1");
//        map.put("createTime", time);
//        GlobalParams.encrypt(mapchild, map);
//        map.put("sign", MD5.getMD5Str(time + new Gson().toJson(mapchild)));
//        new RxHttp<BaseResult<Userinfo>>().send(ApiManager.getService().getUSERInfo(map),
//                new Response<BaseResult<Userinfo>>(UserinfoActivity.this, false, "") {
//                    @Override
//                    public void onNext(BaseResult<Userinfo> result) {
//                        super.onNext(result);
//                        if (result.response.toString().equals("0")) {
//                            userinfo = result.data;
//                            RequestOptions options = new RequestOptions()
//
//                                    .diskCacheStrategy(DiskCacheStrategy.ALL);
//                            Glide.with(UserinfoActivity.this)
//                                    .load(HttpUrl.IMAGE_URL + userinfo.getLOGO())
//                                    .apply(options)
//                                    .into(imPhoto);
//                            tvUsername.setText(userinfo.getNICKNAME());
//                            tvUserlxiren.setText(userinfo.getCONTACT());
//                            tvPhone.setText(userinfo.getPHONE());
//                            tvUsergonsname.setText(userinfo.getCOMPANY());
//                            tvUserkefname.setText(userinfo.getCUSTOMER());
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.inject(this);
    }
}
