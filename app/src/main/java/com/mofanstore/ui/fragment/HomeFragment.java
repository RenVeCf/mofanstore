package com.mofanstore.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.mofanstore.R;
import com.mofanstore.base.BaseFragment;
import com.mofanstore.http.BroadcastReceiver.ListBasegridAdapter;
import com.mofanstore.tool.SuperTwoViewHolder;
import com.mofanstore.tool.SuperViewHolder;
import com.mofanstore.ui.activity.home.FeileilvActivity;
import com.mofanstore.ui.activity.home.ShopdetailActivity;
import com.mofanstore.ui.activity.home.ShoplvActivity;
import com.mofanstore.ui.activity.home.ZouxiulvActivity;
import com.mofanstore.util.AppUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.OnClick;


public class HomeFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{

    public String[] str = new String[]{"精选", "连衣裙", "T恤", "配饰", "牛仔裤"};
    @InjectView(R.id.tv_commiy)
    ImageView tvCommiy;
    @InjectView(R.id.back)
    FrameLayout back;
    @InjectView(R.id.ed_keyword)
    TextView edKeyword;
    @InjectView(R.id.llousuo)
    LinearLayout llousuo;
    @InjectView(R.id.recyclerview)
    LuRecyclerView recyclerview;
    @InjectView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    private TabAdapter adapter;
    private HomeitemFragment homeitemFragment;
    TextView tab_text;

    private int mCurrentCounter = 0;
    private LuRecyclerViewAdapter mLuRecyclerViewAdapter = null;
    RecycleAdapter recycleAdapter;

    @Override
    protected int intiLayout() {
        return R.layout.fragment_newhome;
    }

    @Override
    protected void initView() {

        //设置刷新时动画的颜色，可以设置4个
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setProgressViewOffset(false, 0, AppUtil.dip2px(getActivity(), 48));
            swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
            swipeRefreshLayout.setOnRefreshListener(this);
        }

        final GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (mLuRecyclerViewAdapter.isHeader(position) || mLuRecyclerViewAdapter.isFooter(position)) {
                    return gridLayoutManager.getSpanCount();
                }else{
                    return 1;
                }
            }
        });

//        recyclerview.addItemDecoration(new GridSpacingItemDecoration(30));
        recyclerview.setLayoutManager(gridLayoutManager);
        recycleAdapter = new RecycleAdapter(getActivity());
        mLuRecyclerViewAdapter = new LuRecyclerViewAdapter(recycleAdapter);
        recyclerview.setAdapter(mLuRecyclerViewAdapter);

        recyclerview.setFooterViewColor(R.color.jindu, R.color.heise, R.color.colorAccentBAI);
        //设置底部加载文字提示
        recyclerview.setFooterViewHint("拼命加载中", "已经全部加载完毕!", "网络不给力啊，点击再试一次吧");

        recyclerview.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                mCurrentCounter++;
                // if (TotalPage==1) {
//                sellerAdd(1);
                //  }
//                else {
                   recyclerview.setNoMore(true);
//                 }
            }
        });
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        onRefresh();
        mLuRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (position>0) {
                    Intent intent = new Intent(getActivity(), ShopdetailActivity.class);
                    startActivity(intent);
                }
            }
        });
    }


    @Override
    protected void initData() {


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

//    private List<imagesbean> data2=new ArrayList<>();
//    private void sellerAdd(final int type) {
//        String time = MyTimeUtils.getStringDate();
//        SortedMap<String, Object> map = new TreeMap<>();
//        SortedMap<String, Object> mapchild = new TreeMap<>();
//        mapchild.put("page", mCurrentCounter);
//        mapchild.put("catid", catid);
//        map.put("createTime", time);
//        GlobalParams.encrypt(mapchild, map);
//        map.put("sign", MD5.getMD5Str(time + new Gson().toJson(mapchild)));
//        new RxHttp<Base2Result<productlistbean>>().send(ApiManager.getService().productlist(map),
//                new Response<Base2Result<productlistbean>>(ShopexchangeActivity.this, false, "") {
//                    @Override
//                    public void onNext(Base2Result<productlistbean> result) {
//                        super.onNext(result);
//                        if (result.response.toString().equals("0")) {
//                            list = result.data;
//                            data2=result.data2;
//                            if (type == 0) {
//                                recycleAdapter.clear();
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
//                        } else if (result.response.toString().equals("40000")) {
//                            recyclerview.refreshComplete(10);
//                            swipeRefreshLayout.setRefreshing(false);
//                            mLuRecyclerViewAdapter.notifyDataSetChanged();
//                            Intent intent = new Intent();
//                            intent.setAction("guoer");
//                            //写法一
//                            ComponentName componentName = new ComponentName("com.guosue", "com.guosue.http.BroadcastReceiver.MyReceiver");
//                            intent.setComponent(componentName);
//                            sendBroadcast(intent);//发送普通广播
//
//                        } else {
//                            recyclerview.refreshComplete(10);
//                            swipeRefreshLayout.setRefreshing(false);
//                            mLuRecyclerViewAdapter.notifyDataSetChanged();
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        super.onError(e);
//                        if (recyclerview != null) {
//                            recyclerview.refreshComplete(10);
//                            swipeRefreshLayout.setRefreshing(false);
//                            mLuRecyclerViewAdapter.notifyDataSetChanged();
//                        }
//                    }
//                });
//    }


    ConvenientBanner convenientBanner;
    public class RecycleAdapter extends ListBasegridAdapter<String> {
        private List<String> dataitem = new ArrayList<>();
        public static final int TYPE_TOP_IMAGE = 0;
        public static final int TYPE_BOTTON_IMAGE = 1;

        private Context context;

        public RecycleAdapter(Context context) {
            super(context);
            this.context = context;
        }

        @Override
        public int getLayoutId() {
            return R.layout.activityhomeitem;
        }

        @Override
        public int getLayouttopId() {
            return R.layout.hometop;
        }

        @Override
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
            RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
            if(manager instanceof GridLayoutManager) {
                final GridLayoutManager gridManager = ((GridLayoutManager) manager);
                gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(int position) {
//                        return getItemViewType(position) == 0||getItemViewType(position) == 3
//                                ? gridManager.getSpanCount() : 1;

                        return (position==0||mLuRecyclerViewAdapter.isFooter(position)) ? gridManager.getSpanCount() : 1;
                    }
                });
            }
        }

        @Override
        public void onBindItemHolder(SuperViewHolder holder, int position) {
          RelativeLayout xuanz_youhui=holder.getView(R.id.xuanz_youhui);
          LinearLayout llflei4=holder.getView(R.id.llflei4);
            xuanz_youhui.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(getActivity(),ZouxiulvActivity.class);
                    startActivity(intent);
                }
            });
            llflei4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(getActivity(),FeileilvActivity.class);
                    startActivity(intent);
                }
            });
        }

        @Override
        public void onBindItem2Holder(SuperTwoViewHolder holder, final int position) {
            dataitem=getDataList();

        }

    }

    @OnClick({R.id.back, R.id.llousuo})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.back:
                intent=new Intent(getActivity(),ShoplvActivity.class);
                intent.putExtra("name","商品列表");
                startActivity(intent);
                break;
            case R.id.llousuo:
                break;
        }
    }

//    private List<bannerbean> banner;
//    private List<newslistitembean> information;
//    private void gethome() {
//        Map<String, String> map = new HashMap<>();
//        new RxHttp<BaseResult<homebean>>().send(ApiManager2.getService().home(map),
//                new Response<BaseResult<homebean>>(getActivity(), false, "") {
//                    @Override
//                    public void onNext(BaseResult<homebean> result) {
//                        super.onNext(result);
//                        if (result.success.toString().equals("true")) {
//                            banner=result.data.getBanner();
//                            information=result.data.getInformation();
//                            setBanner(banner);
//                            convenientBanner.startTurning(3000);
//
//                            homeadater=new Homeadater(getActivity(),information);
//                            lvZaos.setAdapter(homeadater);
//                            lvZaos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                                @Override
//                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                                    Intent intent=new Intent(getActivity(),huodondetailActivity.class);
//                                    intent.putExtra("name",information.get(i).getTitle());
//                                    intent.putExtra("context",information.get(i).getHtml());
//                                    startActivity(intent);
//                                }
//                            });
//                        } else {
//                            toastLong(result.msg);
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
//
//
//    private void setBanner(final List<bannerbean> banner) {
//        convenientBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
//            @Override
//            public NetworkImageHolderView createHolder() {
//                return new NetworkImageHolderView();
//            }
//        }, banner)
//                //    .setPointViewVisible(false)    //设置指示器是否可见
//                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
//                .setPageIndicator(new int[]{R.mipmap.sy_13, R.mipmap.sy_15})
//                //设置指示器的方向
//                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
//                .setOnItemClickListener(new com.bigkoo.convenientbanner.listener.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(int position) {
////                        if (position<2){
////                            Intent intent=new Intent(getActivity(), RisgterActivity.class);
////                            intent.putExtra("name","报名");
////                            startActivity(intent);
////                        }
//                    }
//                });
//    }
//
//
//    private class NetworkImageHolderView implements Holder<bannerbean> {
//        private ImageView imageView;
//
//        @Override
//        public View createView(Context context) {
//            //你可以通过layout文件来创建，也可以像我一样用代码创建，不一定是Image，任何控件都可以进行翻页
//            imageView = new ImageView(context);
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            return imageView;
//        }
//
//        @Override
//        public void UpdateUI(Context context, int position, bannerbean data) {
//            if (getActivity() != null) {
//                RequestOptions options = new RequestOptions()
//                        .centerCrop()
//                        .diskCacheStrategy(DiskCacheStrategy.ALL);
//                Glide.with(getActivity())
//                        .load(HttpUrl.IMAGE_URL + data.getBanner())
//                        .apply(options)
//                        .into(imageView);
//            }
//        }
//    }
//
//
//    public class RecycleAdapter extends ListBaseAdapter<stockindexlistbean> {
//        private Context context;
//        private List<stockindexlistbean> menu;
//
//        public RecycleAdapter(Context context) {
//            super(context);
//            this.context = context;
//        }
//
//        @Override
//        public int getLayoutId() {
//            return R.layout.activity_home_item;
//        }
//
//        @Override
//        public void onBindItemHolder(SuperViewHolder holder, int position) {
//             menu = getDataList();
//             TextView tv_lvzhiw=holder.getView(R.id.tv_lvzhiw);
//             TextView tv_lvzhiw1=holder.getView(R.id.tv_lvzhiw1);
//             TextView tv_lvzhiw2=holder.getView(R.id.tv_lvzhiw2);
//             tv_lvzhiw.setText(menu.get(position).getName());
//             tv_lvzhiw2.setText(menu.get(position).getChange()+menu.get(position).getChangeRate());
//             tv_lvzhiw1.setText(menu.get(position).getPrice());
//             if (menu.get(position).getChange().contains("-")){
//                 tv_lvzhiw1.setTextColor(0xff5BBD4F);
//             }else {
//                 tv_lvzhiw1.setTextColor(0xffE17073);
//             }
//        }
//
//    }


    class TabAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments;


        public TabAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }


        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

}
