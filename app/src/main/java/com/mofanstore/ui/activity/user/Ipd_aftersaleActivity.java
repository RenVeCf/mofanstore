package com.mofanstore.ui.activity.user;

import android.Manifest;
import android.content.Intent;
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
import com.mofanstore.ui.activity.Adater.ShopitemAdater;
import com.mofanstore.util.FullyGridLayoutManager;
import com.mofanstore.util.Ipd_Mylistview;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


/**
 * Created by Administrator on 2017/6/1./,aqweerdw
 * +
 */
public class Ipd_aftersaleActivity extends BaseActivity {

    @InjectView(R.id.back)
    FrameLayout back;
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.tv_commiy)
    TextView tvCommiy;
    @InjectView(R.id.commit)
    FrameLayout commit;
    @InjectView(R.id.cart_list)
    Ipd_Mylistview cartList;
    @InjectView(R.id.huowu_zt)
    TextView huowuZt;
    @InjectView(R.id.huowu_tv)
    TextView huowuTv;
    @InjectView(R.id.huow_zt_ll)
    RelativeLayout huowZtLl;
    @InjectView(R.id.tuikuan_shuom)
    TextView tuikuanShuom;
    @InjectView(R.id.return_contenttv)
    EditText returnContenttv;
    @InjectView(R.id.recycler)
    RecyclerView recyclerView;
    @InjectView(R.id.commit_tv)
    TextView commitTv;
    @InjectView(R.id.tv_add)
    TextView tvAdd;
    private GridImageAdapter adapter;
    private List<LocalMedia> selectList = new ArrayList<>();
    private ShopitemAdater shopitemAdater;

    @Override
    public int intiLayout() {
        return R.layout.ipd_activity_aftersale;
    }

    @Override
    public void initView() {
        tvName.setText("申请退款");
        shopitemAdater = new ShopitemAdater(Ipd_aftersaleActivity.this);
        cartList.setAdapter(shopitemAdater);
        FullyGridLayoutManager manager = new FullyGridLayoutManager(Ipd_aftersaleActivity.this, 4, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        adapter = new GridImageAdapter(Ipd_aftersaleActivity.this, onAddPicClickListener);
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
                            PictureSelector.create(Ipd_aftersaleActivity.this).themeStyle(R.style.picture_default_style).openExternalPreview(position, selectList);
                            break;
                        case 2:
                            // 预览视频
                            PictureSelector.create(Ipd_aftersaleActivity.this).externalPictureVideo(media.getPath());
                            break;
                        case 3:
                            // 预览音频
                            PictureSelector.create(Ipd_aftersaleActivity.this).externalPictureAudio(media.getPath());
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
                    PictureFileUtils.deleteCacheDirFile(Ipd_aftersaleActivity.this);
                } else {
                    Toast.makeText(Ipd_aftersaleActivity.this,
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
            PictureSelector.create(Ipd_aftersaleActivity.this)
                    .openGallery(PictureMimeType.ofImage())// 全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                    .maxSelectNum(3)// 最大图片选择数量
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


    @OnClick({R.id.tv_add,R.id.back, R.id.huow_zt_ll, R.id.commit_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.tv_add:
                Intent intent=new Intent(Ipd_aftersaleActivity.this,Ipd_aftersalelvActivity.class);
                startActivity(intent);
                break;
            case R.id.huow_zt_ll:
                break;
            case R.id.commit_tv:
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
