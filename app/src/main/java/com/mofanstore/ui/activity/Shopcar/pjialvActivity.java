package com.mofanstore.ui.activity.Shopcar;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.permissions.RxPermissions;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.mofanstore.R;
import com.mofanstore.base.BaseActivity;
import com.mofanstore.tool.ListBaseAdapter;
import com.mofanstore.tool.SuperViewHolder;
import com.mofanstore.ui.activity.Adater.GridImageAdapter;
import com.mofanstore.util.AppUtil;
import com.mofanstore.util.FullyGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class pjialvActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener{
    @InjectView(R.id.back)
    FrameLayout back;
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.tv_commiy)
    TextView tvCommiy;
    @InjectView(R.id.commit)
    FrameLayout commit;
    @InjectView(R.id.recyclerview)
    LuRecyclerView recyclerview;
    @InjectView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    private int mCurrentCounter = 0;
    RecycleAdapter recycleAdapter;
    private LuRecyclerViewAdapter mLuRecyclerViewAdapter = null;
    @Override
    public int intiLayout() {
        return R.layout.activit_pjialayot;
    }

    @Override
    public void initView() {
        tvName.setText("发表评价");

        //设置刷新时动画的颜色，可以设置4个
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setProgressViewOffset(false, 0, AppUtil.dip2px(pjialvActivity.this, 48));
            swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
            swipeRefreshLayout.setOnRefreshListener(this);
        }
        recyclerview.setLayoutManager(new LinearLayoutManager(pjialvActivity.this));
        recycleAdapter = new RecycleAdapter(pjialvActivity.this);
        mLuRecyclerViewAdapter = new LuRecyclerViewAdapter(recycleAdapter);
        recyclerview.setAdapter(mLuRecyclerViewAdapter);

        recyclerview.setFooterViewColor(R.color.jindu, R.color.heise, R.color.colorAccentBAI);
        //设置底部加载文字提示
        recyclerview.setFooterViewHint("拼命加载中", "已经全部加载完毕!", "网络不给力啊，点击再试一次吧");

        recyclerview.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                mCurrentCounter++;
//                if (tolte>mCurrentCounter) {
//                    sellerAdd(1);
//                } else {
                recyclerview.setNoMore(true);
//                }
            }
        });

        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        onRefresh();
    }

    @Override
    public void initData() {

    }


    private List<String> list = new ArrayList<>();

    @Override
    public void onRefresh() {
        mCurrentCounter = 0;
        swipeRefreshLayout.setRefreshing(true);
        recyclerview.setRefreshing(true);//同时调用LuRecyclerView的setRefreshing方法
        recycleAdapter.clear();
        recycleAdapter.addAll(list);
        recyclerview.refreshComplete(10);
        swipeRefreshLayout.setRefreshing(false);
        mLuRecyclerViewAdapter.notifyDataSetChanged();
    }
//    int tolte;
//    private SharedPreferences sp;
//    private void sellerAdd(final int type) {
//        String time = MyTimeUtils.getStringDate();
//        SortedMap<String, Object> map = new TreeMap<>();
//        SortedMap<String, Object> mapchild = new TreeMap<>();
//        mapchild.put("PAGE", mCurrentCounter);
//        mapchild.put("APPUSER_ID", sp.getString("APPUSER_ID",""));
//        mapchild.put("GENRE", sp.getString("usertype", ""));
//        mapchild.put("COUNT", "10");
//        mapchild.put("TYPE", "0");
//        map.put("createTime", time);
//        GlobalParams.encrypt(mapchild, map);
//        map.put("sign", MD5.getMD5Str(time + new Gson().toJson(mapchild)));
//        new RxHttp<BaseListResult<mssagelistbean>>().send(ApiManager.getService().getListmessage(map),
//                new Response<BaseListResult<mssagelistbean>>(XtmssagelistActivity.this, false, "") {
//                    @Override
//                    public void onNext(BaseListResult<mssagelistbean> result) {
//                        super.onNext(result);
//                        if (result.response.toString().equals("0")) {
//                            list = result.data;
//                            tolte=result.pages;
//                            if (type == 0) {
//                                recycleAdapter.addAll(list);
//                                recyclerview.refreshComplete(10);
//                                swipeRefreshLayout.setRefreshing(false);
//                                mLuRecyclerViewAdapter.notifyDataSetChanged();
//                            } else {
//                                recycleAdapter.addAll(list);
//                                recyclerview.refreshComplete(10);
//                                swipeRefreshLayout.setRefreshing(false);
//                                mLuRecyclerViewAdapter.notifyDataSetChanged();
//                            }
//                        }else{
//                            toastLong(result.desc+"");
//                            recyclerview.refreshComplete(10);
//                            swipeRefreshLayout.setRefreshing(false);
//                            mLuRecyclerViewAdapter.notifyDataSetChanged();
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        super.onError(e);
//                        if (recyclerview!=null) {
//                            recyclerview.refreshComplete(10);
//                            swipeRefreshLayout.setRefreshing(false);
//                            mLuRecyclerViewAdapter.notifyDataSetChanged();
//                        }
//                    }
//                });
//    }

    private GridImageAdapter adapter;
    private List<LocalMedia> selectList = new ArrayList<>();
    public class RecycleAdapter extends ListBaseAdapter<String> {
        private List<String> menu = new ArrayList<>();
        private Context context;

        public RecycleAdapter(Context context) {
            super(context);
            this.context = context;

        }

        @Override
        public int getLayoutId() {
            return R.layout.activity_pjiaitem;
        }

        @Override
        public void onBindItemHolder(SuperViewHolder holder, final int position) {
            menu=getDataList();
            RecyclerView recycler=holder.getView(R.id.recycler);

            FullyGridLayoutManager manager = new FullyGridLayoutManager(pjialvActivity.this, 4, GridLayoutManager.VERTICAL, false);
            recycler.setLayoutManager(manager);
            adapter = new GridImageAdapter(pjialvActivity.this, onAddPicClickListener);
            adapter.setList(selectList);
            recycler.setAdapter(adapter);
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
                                PictureSelector.create(pjialvActivity.this).themeStyle(R.style.picture_default_style).openExternalPreview(position, selectList);
                                break;
                            case 2:
                                // 预览视频
                                PictureSelector.create(pjialvActivity.this).externalPictureVideo(media.getPath());
                                break;
                            case 3:
                                // 预览音频
                                PictureSelector.create(pjialvActivity.this).externalPictureAudio(media.getPath());
                                break;
                        }
                    }
                }
            });

            // 清空图片缓存，包括裁剪、压缩后的图片 注意:必须要在上传完成后调用 必须要获取权限
            RxPermissions permissions = new RxPermissions(pjialvActivity.this);
            permissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE).subscribe(new Observer<Boolean>() {
                @Override
                public void onSubscribe(Disposable d) {
                }

                @Override
                public void onNext(Boolean aBoolean) {
                    if (aBoolean) {
                        PictureFileUtils.deleteCacheDirFile(pjialvActivity.this);
                    } else {
                        Toast.makeText(pjialvActivity.this,
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
    }


    private GridImageAdapter.onAddPicClickListener onAddPicClickListener = new GridImageAdapter.onAddPicClickListener() {
        @Override
        public void onAddPicClick() {
            // 进入相册 以下是例子：不需要的api可以不写
            PictureSelector.create(pjialvActivity.this)
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

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
