package com.mofanstore.ui.activity.hulan;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.permissions.RxPermissions;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.mofanstore.R;
import com.mofanstore.base.BaseActivity;
import com.mofanstore.ui.activity.Adater.GridImageAdapter;
import com.mofanstore.util.FullyGridLayoutManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class IssueActivity extends BaseActivity {
    @InjectView(R.id.back)
    FrameLayout back;
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.tv_commiy)
    TextView tvCommiy;
    @InjectView(R.id.commit)
    FrameLayout commit;
    @InjectView(R.id.recycler)
    RecyclerView recyclerView;
    @InjectView(R.id.ed_isue_tetil)
    EditText edIsueTetil;
    @InjectView(R.id.ed_isue_connect)
    EditText edIsueConnect;
    @InjectView(R.id.rl_shop)
    RelativeLayout rlShop;
    @InjectView(R.id.rl_adder)
    RelativeLayout rlAdder;
    private GridImageAdapter adapter;
    private List<LocalMedia> selectList = new ArrayList<>();

    @Override
    public int intiLayout() {
        return R.layout.activit_issue;
    }

    @Override
    public void initView() {
        tvCommiy.setText("发布");
        commit.setVisibility(View.VISIBLE);
        FullyGridLayoutManager manager = new FullyGridLayoutManager(IssueActivity.this, 4, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        adapter = new GridImageAdapter(IssueActivity.this, onAddPicClickListener);
        adapter.setList(selectList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new GridImageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                if (selectList.size() > 0) {
                    LocalMedia media = selectList.get(position);
                    String pictureType = media.getPictureType();
                    int mediaType = PictureMimeType.pictureToVideo(pictureType);
                    switch (mediaType) {
                        case 1:
                            // 预览图片 可自定长按保存路径
                            //PictureSelector.create(MainActivity.this).themeStyle(themeId).externalPicturePreview(position, "/custom_file", selectList);
                            PictureSelector.create(IssueActivity.this).themeStyle(R.style.picture_default_style).openExternalPreview(position, selectList);
                            break;
                        case 2:
                            // 预览视频
                            PictureSelector.create(IssueActivity.this).externalPictureVideo(media.getPath());
                            break;
                        case 3:
                            // 预览音频
                            PictureSelector.create(IssueActivity.this).externalPictureAudio(media.getPath());
                            break;
                    }
                }
            }
        });

        // 清空图片缓存，包括裁剪、压缩后的图片 注意:必须要在上传完成后调用 必须要获取权限
        RxPermissions permissions = new RxPermissions(this);
        permissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE).subscribe(new Observer<Boolean>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(Boolean aBoolean) {
                if (aBoolean) {
                    PictureFileUtils.deleteCacheDirFile(IssueActivity.this);
                } else {
                    Toast.makeText(IssueActivity.this,
                            getString(R.string.picture_jurisdiction), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        });
    }

    @Override
    public void initData() {

    }


    private GridImageAdapter.onAddPicClickListener onAddPicClickListener = new GridImageAdapter.onAddPicClickListener() {
        @Override
        public void onAddPicClick() {
            // 进入相册 以下是例子：不需要的api可以不写
            PictureSelector.create(IssueActivity.this)
                    .openGallery(PictureMimeType.ofImage())// 全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                    .maxSelectNum(15)// 最大图片选择数量
                    .minSelectNum(1)// 最小选择数量
                    .imageSpanCount(4)// 每行显示个数
                    .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选
                    .previewImage(true)// 是否可预览图片
                    .isCamera(true)// 是否显示拍照按钮
                    .compress(true)// 是否压缩
                    .synOrAsy(true)//同步true或异步false 压缩 默认同步
                    .selectionMedia(selectList)// 是否传入已选图片
                    .minimumCompressSize(100)// 小于100kb的图片不压缩
                    .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
//            } else {
//                // 单独拍照
//                PictureSelector.create(IssueOrderActivity.this)
//                        .openCamera(PictureMimeType.ofImage())// 单独拍照，也可录像或也可音频 看你传入的类型是图片or视频
//                        .maxSelectNum(9)// 最大图片选择数量
//                        .minSelectNum(3)// 最小选择数量
//                        .imageSpanCount(4)// 每行显示个数
//                        .selectionMode(PictureConfig.MULTIPLE )// 多选 or 单选
//                        .previewImage(true)// 是否可预览图片
//                        .isCamera(true)// 是否显示拍照按钮
//                        .compress(true)// 是否压缩
//                        .synOrAsy(true)//同步true或异步false 压缩 默认同步
//                        .selectionMedia(selectList)// 是否传入已选图片
//                        .minimumCompressSize(100)// 小于100kb的图片不压缩
//                        .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
//            }
        }

    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
                    selectList = PictureSelector.obtainMultipleResult(data);
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true
                    // 如果裁剪并压缩了，已取压缩路径为准，因为是先裁剪后压缩的
                    for (LocalMedia media : selectList) {
                        Log.i("图片-----》", media.getPath());
                    }
                    adapter.setList(selectList);
                    adapter.notifyDataSetChanged();
                    break;
            }
        }
    }


    private void upload() {
        LOCALE_IMG = "";
        for (int i = 0; i < selectList.size(); i++) {
            if (selectList.get(i).isCompressed() == true) {
                path = selectList.get(i).getCompressPath();
            } else {
                path = selectList.get(i).getPath();
            }
//            Sethead(path);
        }
    }

    private int coumt = 0;

//    private void Sethead(final String temppath) {
//        Map<String, RequestBody> mapchild = new HashMap<String, RequestBody>();
//        mapchild.put("DIR", getTextRequestBody("good"));//DIR目录：用户资料个人中心 user 发布会诊 con
//        mapchild.put("PIC\";filename=\"" + (System.currentTimeMillis() + ".png"), getImageRequestBody(temppath));//单图上传
//        new RxHttp<picinfobean<String>>().send(ApiManager.getService().uploadPic(mapchild),
//                new Response<picinfobean<String>>(ReportuserActivity.this, false, "") {
//                    @Override
//                    public void onNext(picinfobean<String> result) {
//                        super.onNext(result);
//                        if (result.response.equals("0")) {
//                            coumt++;
//                            LOCALE_IMG += result.data + ",";
//                            if (coumt == selectList.size()) {
//                                Commit();
//                            }
//                        } else {
//                            Toast.makeText(ReportuserActivity.this, "" + result.desc, Toast.LENGTH_SHORT).show();
//                            LoadingUtils.dismiss();
//                        }
//                    }
//                });
//    }

    public static RequestBody getImageRequestBody(String filePath) {
        return RequestBody.create(MediaType.parse("image/png"), new File(filePath));
    }

    public static RequestBody getTextRequestBody(String body) {
        return RequestBody.create(MediaType.parse("text/plan"), body);
    }

    private String LOCALE_IMG = "";
    private SharedPreferences sp;
    private String path = "";

//    private void Commit() {
//        String time = MyTimeUtils.getStringDate();
//        SortedMap<String, Object> map = new TreeMap<>();
//        SortedMap<String, Object> mapchild = new TreeMap<>();
//        mapchild.put("USER_ID", sp.getString("user_id", ""));
//        mapchild.put("CONTENT", edLoginPsw.getText().toString());
//        mapchild.put("GOOD_ID", goodid);
//        if (LOCALE_IMG != null && !LOCALE_IMG.equals("")) {
//            mapchild.put("PICS", LOCALE_IMG.substring(0, LOCALE_IMG.length() - 1));
//        }
//        mapchild.put("TYPE", TYPE);
//        map.put("createTime", time);
//        GlobalParams.encrypt(mapchild, map);
//        map.put("sign", MD5.getMD5Str(time + new Gson().toJson(mapchild)));
//        new RxHttp<BaseResult>().send(ApiManager.getService().app_scene(map),
//                new Response<BaseResult>(ReportuserActivity.this, true, "") {
//                    @Override
//                    public void onNext(BaseResult result) {
//                        super.onNext(result);
//                        if (result.response.toString().equals("0")) {
//                            LoadingUtils.dismiss();
//                            Toast.makeText(ReportuserActivity.this, "提交成功!", Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent();
//                            setResult(111, intent);
//                            finish();
//                        } else {
//                            LoadingUtils.dismiss();
//                            Toast.makeText(ReportuserActivity.this, result.desc + "", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        super.onError(e);
//                        e.printStackTrace();
//                        LoadingUtils.dismiss();
//                    }
//                });
//    }


    @OnClick({R.id.back, R.id.commit, R.id.rl_shop, R.id.rl_adder})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.commit:
                break;
            case R.id.rl_shop:
                intent = new Intent(IssueActivity.this, SousuoActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_adder:
                intent = new Intent(IssueActivity.this, AdderhulanActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.inject(this);
    }
}
