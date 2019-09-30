package com.mofanstore.ui.activity.home;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.mofanstore.R;
import com.mofanstore.base.Base2Activity;
import com.mofanstore.tool.ListBaseAdapter;
import com.mofanstore.tool.SuperViewHolder;
import com.mofanstore.ui.activity.Adater.PropertyAdapter;
import com.mofanstore.ui.activity.Adater.ShopbootAdater;
import com.mofanstore.ui.activity.Adater.ShopdetaigvAdater;
import com.mofanstore.util.DividerItemDecoration;
import com.mofanstore.util.HoverScrollView;
import com.mofanstore.util.Ipd_Gridview;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class NewShopdetailActivity extends Base2Activity implements HoverScrollView.OnScrollListener {

    ShopdetaigvAdater shopdetaigvAdater;
    @InjectView(R.id.convenientBanner)
    ConvenientBanner convenientBanner;
    @InjectView(R.id.tv_lvzhiw)
    TextView tvLvzhiw;
    @InjectView(R.id.zhekou)
    TextView zhekou;
    @InjectView(R.id.tv_fahuo)
    TextView tvFahuo;
    @InjectView(R.id.tv_fahuo1)
    TextView tvFahuo1;
    @InjectView(R.id.tv_fahuo2)
    TextView tvFahuo2;
    @InjectView(R.id.tv_youhui)
    TextView tvYouhui;
    @InjectView(R.id.tv_youhui2)
    TextView tvYouhui2;
    @InjectView(R.id.tv_youhui3)
    TextView tvYouhui3;
    @InjectView(R.id.tv_pjianum)
    TextView tvPjianum;
    @InjectView(R.id.grid_view)
    Ipd_Gridview gridView;
    @InjectView(R.id.recyclerview)
    LuRecyclerView recyclerview;
    @InjectView(R.id.ll_pull_up)
    LinearLayout llPullUp;
    @InjectView(R.id.wv_goods_detailed)
    WebView wvGoodsDetailed;
    @InjectView(R.id.rv_one)
    RecyclerView rvOne;
    @InjectView(R.id.ipd_pay_grid_view)
    Ipd_Gridview ipdPayGridView;
    @InjectView(R.id.ipd_pay_ll)
    LinearLayout ipdPayLl;
    @InjectView(R.id.iv_back)
    ImageView ivBack;
    @InjectView(R.id.ll_back)
    LinearLayout llBack;
    @InjectView(R.id.shoptetla1)
    TextView shoptetla1;
    @InjectView(R.id.shoptetla12)
    TextView shoptetla12;
    @InjectView(R.id.shoptetla13)
    TextView shoptetla13;
    @InjectView(R.id.shoptetla14)
    TextView shoptetla14;
    @InjectView(R.id.imgouwu)
    ImageView imgouwu;
    @InjectView(R.id.imgouwu2)
    ImageView imgouwu2;
    @InjectView(R.id.ll_biaoti)
    LinearLayout llBiaoti;
    @InjectView(R.id.ll_title_root)
    LinearLayout llTitleRoot;
    @InjectView(R.id.collect_img)
    ImageView collectImg;
    @InjectView(R.id.collect_name)
    TextView collectName;
    @InjectView(R.id.kefu_ll)
    LinearLayout kefuLl;
    @InjectView(R.id.collect_ll)
    LinearLayout collectLl;
    @InjectView(R.id.ll_zuo)
    LinearLayout llZuo;
    @InjectView(R.id.jiaru_gouwuche_morry)
    TextView jiaruGouwucheMorry;
    @InjectView(R.id.jiaru_gouwuche)
    TextView jiaruGouwuche;
    @InjectView(R.id.jiaru_gouwuche_ll)
    LinearLayout jiaruGouwucheLl;
    @InjectView(R.id.lijigoumai)
    TextView lijigoumai;
    @InjectView(R.id.jiaru_gouwuche_ll2)
    LinearLayout jiaruGouwucheLl2;
    RecycleitenAdapter recycleitenAdapter;
    @InjectView(R.id.nestedscollview)
    HoverScrollView mHsv;
    @InjectView(R.id.ll_hand)
    LinearLayout llHand;
    @InjectView(R.id.ll_psot1)
    LinearLayout llPsot1;
    @InjectView(R.id.ll_psot2)
    LinearLayout llPsot2;
    @InjectView(R.id.ll_psot3)
    LinearLayout llPsot3;
    @InjectView(R.id.ll_psot4)
    LinearLayout llPsot4;
    @InjectView(R.id.tuaninfo)
    TextView tuaninfo;
    @InjectView(R.id.jiaru_gouwuche_morry2)
    TextView jiaruGouwucheMorry2;
    @InjectView(R.id.tv_konx)
    TextView tvKonx;
    @InjectView(R.id.tv_tuwei)
    TextView tvTuwei;
    @InjectView(R.id.tv_pjia)
    TextView tvPjia;
    @InjectView(R.id.tv_lick)
    TextView tvLick;
    private LuRecyclerViewAdapter mLuRecyclerViewitenAdapter = null;
    private List<String> onlinelawyer = new ArrayList<>();
    private List<String> list = new ArrayList<>();
    ShopbootAdater shopbootAdater;
    private String flag;

    @Override
    public int intiLayout() {

        return R.layout.activit_newshopdetail;
    }

    @Override
    public void initView() {
        flag = getIntent().getExtras().getString("flag");

        if (flag.equals("1")) {
            tuaninfo.setVisibility(View.GONE);
            jiaruGouwucheMorry2.setVisibility(View.GONE);
            jiaruGouwucheMorry.setVisibility(View.GONE);
            tvKonx.setVisibility(View.GONE);
        }else if (flag.equals("3")) {
            jiaruGouwucheLl.setVisibility(View.GONE);
        }else {
            tuaninfo.setVisibility(View.VISIBLE);
            jiaruGouwucheMorry2.setVisibility(View.VISIBLE);
            jiaruGouwucheMorry.setVisibility(View.VISIBLE);
            tvKonx.setVisibility(View.VISIBLE);
            collectLl.setVisibility(View.GONE);
            jiaruGouwuche.setText("单人购买");
            lijigoumai.setText("3人团");
        }
        showPopupWindow();
        showPopupWindow2();
        showPopupWindowTOP();
        mHsv.setOnScrollListener(this);
        onlinelawyer.add("");
        onlinelawyer.add("");
        onlinelawyer.add("");
        onlinelawyer.add("");
        onlinelawyer.add("");
        onlinelawyer.add("");

        shopdetaigvAdater = new ShopdetaigvAdater(NewShopdetailActivity.this);
        gridView.setAdapter(shopdetaigvAdater);

        recyclerview.setLayoutManager(new LinearLayoutManager(NewShopdetailActivity.this, LinearLayoutManager.HORIZONTAL, false));
        recycleitenAdapter = new RecycleitenAdapter(NewShopdetailActivity.this);
        mLuRecyclerViewitenAdapter = new LuRecyclerViewAdapter(recycleitenAdapter);
        recyclerview.setAdapter(mLuRecyclerViewitenAdapter);

        recycleitenAdapter.addAll(onlinelawyer);
        recyclerview.refreshComplete(10);
        mLuRecyclerViewitenAdapter.notifyDataSetChanged();
        mLuRecyclerViewitenAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });


        StaggeredGridLayoutManager staggeredGridLayoutManager =
                new StaggeredGridLayoutManager(2,
                        StaggeredGridLayoutManager.VERTICAL);
        rvOne.setLayoutManager(staggeredGridLayoutManager);

        rvOne.addItemDecoration(new DividerItemDecoration(2,30,true));
        list.add("专门使用过再来评价。第一次不会用，没涂凝胶，那电流的味道有点……哈哈，然后赶紧联系…服，客服给发了视频，说前三次需要充电十几个小时才可以用。充好用了感觉不错，没有电的感觉。后面长期使用了我来追评。");
        list.add("包装高大上，宝贝小巧精致，期待有实际效果！");
        list.add("看了洪胖胖来的，这个小绿蛙极对我心思，两个亮亮的大眼睛配小绿身，漂亮！按说明书先充…16个多小时的电，并没有像说明书中说的灯会从闪烁到长亮，就一直闪跳，一直闪跳。问了客服说是镍氢电池不稳定会出现这种情况，只要前三次充满16小时，以后稳定了就会长亮提示。裸脸试用了下有轻微刺痛感，客服说这说明工作正常。客服奥利奥人非常好，很耐心的解释我的问题。感谢！");
        list.add("包装高大上，宝贝小巧精致，期待有实际效果！");
        list.add("包装高大上，宝贝小巧精致，期待有实际效果！");
        rvOne.setAdapter(new MyAdapter());


        shopbootAdater = new ShopbootAdater(NewShopdetailActivity.this);
        ipdPayGridView.setAdapter(shopbootAdater);


        mHsv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.e("MotionEvent::", "X::" + view.getScaleX() + "Y::" + view.getScrollY() );
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        break;
                    case MotionEvent.ACTION_UP:
                        int scrollY=view.getScrollY();
                        if (scrollY == 0) {
                            Log.e("scroll::",  ", scrollY::" + view.getHeight()+"mScrollY"+scrollY);
                                if (popupWindowtoop != null) {
                                    popupWindowtoop.showAtLocation(jiaruGouwuche, Gravity.TOP, 0, 0);
                                }
                        }
                        break;
                    case MotionEvent.ACTION_MOVE:
//                        int scrollY=view.getScrollY();
//                          if (scrollY == 0) {
//                              Log.e("scroll::",  ", scrollY::" + view.getHeight()+"mScrollY"+scrollY);
//
//
////                                if (popupWindowtoop != null) {
////                                    popupWindowtoop.showAtLocation(jiaruGouwuche, Gravity.TOP, 0, 0);
////                                }
//                        }
                        break;

                    default:
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.inject(this);
    }

    private int size;
    private int size1bottom;
    private int size1bottom2;
    private int size1bottom3;
    private int size1bottom4;

    /**
     * 获取状态栏高度
     * @param context
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        int height = resources.getDimensionPixelSize(resourceId);
        return height;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            size = llTitleRoot.getHeight();
            size1bottom = llPsot1.getHeight()-tvTuwei.getHeight();
            size1bottom2 = llPsot1.getHeight()-tvTuwei.getHeight()+llPsot2.getHeight();
            size1bottom3 = llPsot1.getHeight()-tvTuwei.getHeight()+llPsot2.getHeight()+llPsot3.getHeight();
            size1bottom4 = llPsot1.getHeight()-tvTuwei.getHeight()+llPsot2.getHeight()+llPsot3.getHeight()+llPsot4.getHeight();

        }
    }
    public int mScrollY=0;
    @Override
    public void onScroll(int scrollY) {
//        Log.e("scroll::",  ", scrollY::" + scrollY);
        mScrollY=scrollY;
        if (scrollY >= size) {
            llTitleRoot.setBackgroundResource(R.color.colorzhuti);
            llBiaoti.setVisibility(View.VISIBLE);
        } else {
            llTitleRoot.setBackgroundResource(R.color.transparent);
            llBiaoti.setVisibility(View.GONE);
        }
        if (scrollY >= 0 && scrollY <= size1bottom) {
            Drawable rightDrawable = getResources().getDrawable(R.mipmap.line2x);
            rightDrawable.setBounds(0, 0, rightDrawable.getMinimumWidth(), rightDrawable.getMinimumHeight());
            shoptetla1.setCompoundDrawables(null, null, null, rightDrawable);
            shoptetla12.setCompoundDrawables(null, null, null, null);
            shoptetla13.setCompoundDrawables(null, null, null, null);
            shoptetla14.setCompoundDrawables(null, null, null, null);
        } else if (scrollY >= size1bottom && scrollY <= size1bottom2) {
            Drawable rightDrawable = getResources().getDrawable(R.mipmap.line2x);
            rightDrawable.setBounds(0, 0, rightDrawable.getMinimumWidth(), rightDrawable.getMinimumHeight());
            shoptetla12.setCompoundDrawables(null, null, null, rightDrawable);
            shoptetla13.setCompoundDrawables(null, null, null, null);
            shoptetla1.setCompoundDrawables(null, null, null, null);
            shoptetla14.setCompoundDrawables(null, null, null, null);
        } else if (scrollY >= size1bottom2 && scrollY <= size1bottom3) {
            Drawable rightDrawable = getResources().getDrawable(R.mipmap.line2x);
            rightDrawable.setBounds(0, 0, rightDrawable.getMinimumWidth(), rightDrawable.getMinimumHeight());
            shoptetla13.setCompoundDrawables(null, null, null, rightDrawable);
            shoptetla12.setCompoundDrawables(null, null, null, null);
            shoptetla1.setCompoundDrawables(null, null, null, null);
            shoptetla14.setCompoundDrawables(null, null, null, null);
        }else if (scrollY >= size1bottom3 && scrollY <= size1bottom4) {
            Drawable rightDrawable = getResources().getDrawable(R.mipmap.line2x);
            rightDrawable.setBounds(0, 0, rightDrawable.getMinimumWidth(), rightDrawable.getMinimumHeight());
            shoptetla14.setCompoundDrawables(null, null, null, rightDrawable);
            shoptetla12.setCompoundDrawables(null, null, null, null);
            shoptetla1.setCompoundDrawables(null, null, null, null);
            shoptetla13.setCompoundDrawables(null, null, null, null);
        }
    }

    @OnClick({R.id.ll_back, R.id.shoptetla1, R.id.shoptetla12, R.id.shoptetla13, R.id.shoptetla14, R.id.kefu_ll, R.id.collect_ll, R.id.jiaru_gouwuche_ll, R.id.jiaru_gouwuche_ll2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.shoptetla1:
                mHsv.post(new Runnable() {
                    @Override
                    public void run() {
                        //滚动到指定位置（滚动要跳过的控件的高度的距离）
                        mHsv.scrollTo(0, 0);
                        //如果要平滑滚动，可以这样写
                        Drawable rightDrawable = getResources().getDrawable(R.mipmap.line2x);
                        rightDrawable.setBounds(0, 0, rightDrawable.getMinimumWidth(), rightDrawable.getMinimumHeight());
                        shoptetla1.setCompoundDrawables(null, null, null, rightDrawable);
                        shoptetla12.setCompoundDrawables(null, null, null, null);
                        shoptetla13.setCompoundDrawables(null, null, null, null);
                        shoptetla14.setCompoundDrawables(null, null, null, null);
                    }
                });
                break;
            case R.id.shoptetla12:
                mHsv.post(new Runnable() {
                    @Override
                    public void run() {
                        //滚动到指定位置（滚动要跳过的控件的高度的距离）
                        mHsv.scrollTo(0, llPsot1.getHeight()-tvTuwei.getHeight());
                        //如果要平滑滚动，可以这样写
                        Drawable rightDrawable = getResources().getDrawable(R.mipmap.line2x);
                        rightDrawable.setBounds(0, 0, rightDrawable.getMinimumWidth(), rightDrawable.getMinimumHeight());
                        shoptetla12.setCompoundDrawables(null, null, null, rightDrawable);
                        shoptetla1.setCompoundDrawables(null, null, null, null);
                        shoptetla13.setCompoundDrawables(null, null, null, null);
                        shoptetla14.setCompoundDrawables(null, null, null, null);
                    }
                });
                break;
            case R.id.shoptetla13:
                mHsv.post(new Runnable() {
                    @Override
                    public void run() {
                        //滚动到指定位置（滚动要跳过的控件的高度的距离）
                        mHsv.scrollTo(0, llPsot1.getHeight()-tvTuwei.getHeight()+llPsot2.getHeight());
                        //如果要平滑滚动，可以这样写
                        Drawable rightDrawable = getResources().getDrawable(R.mipmap.line2x);
                        rightDrawable.setBounds(0, 0, rightDrawable.getMinimumWidth(), rightDrawable.getMinimumHeight());
                        shoptetla13.setCompoundDrawables(null, null, null, rightDrawable);
                        shoptetla12.setCompoundDrawables(null, null, null, null);
                        shoptetla1.setCompoundDrawables(null, null, null, null);
                        shoptetla14.setCompoundDrawables(null, null, null, null);
                    }
                });
                break;
            case R.id.shoptetla14:
                //滚动到指定位置（滚动要跳过的控件的高度的距离）
                mHsv.scrollTo(0, llPsot1.getHeight()-tvTuwei.getHeight()+llPsot2.getHeight()+llPsot3.getHeight());
                //如果要平滑滚动，可以这样写
                //scrollView.smoothScrollTo(0, llNeedToSkip.getMeasuredHeight());
                Drawable rightDrawable = getResources().getDrawable(R.mipmap.line2x);
                rightDrawable.setBounds(0, 0, rightDrawable.getMinimumWidth(), rightDrawable.getMinimumHeight());
                shoptetla14.setCompoundDrawables(null, null, null, rightDrawable);
                shoptetla12.setCompoundDrawables(null, null, null, null);
                shoptetla13.setCompoundDrawables(null, null, null, null);
                shoptetla1.setCompoundDrawables(null, null, null, null);
                break;
            case R.id.kefu_ll:
                break;
            case R.id.collect_ll:
                break;
            case R.id.jiaru_gouwuche_ll:
                popupWindowbj.showAtLocation(jiaruGouwuche, Gravity.BOTTOM, 0, 20);
                break;
            case R.id.jiaru_gouwuche_ll2:
                if (flag.equals("3")) {
                    popupWindow.showAtLocation(jiaruGouwuche, Gravity.BOTTOM, 0, 20);
                }else {
                    popupWindowbj.showAtLocation(jiaruGouwuche, Gravity.BOTTOM, 0, 20);
                }
                break;
        }
    }

    public class RecycleitenAdapter extends ListBaseAdapter<String> {
        private Context context;
        private List<String> menu;

        public RecycleitenAdapter(Context context) {
            super(context);
            this.context = context;
        }

        @Override
        public int getLayoutId() {
            return R.layout.activity_huboview_item;
        }

        @Override
        public void onBindItemHolder(SuperViewHolder holder, int position) {
            menu = getDataList();

        }

    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(NewShopdetailActivity.this).inflate(R.layout.item_rvone, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.tvname.setText(list.get(position));
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            ImageView ivIcon;
            TextView tvname;

            public ViewHolder(View itemView) {
                super(itemView);
                ivIcon = itemView.findViewById(R.id.evale_img);
                tvname = itemView.findViewById(R.id.tv_lvname);
            }
        }
    }

    private PopupWindow popupWindowbj;
    private PropertyAdapter propertyAdapter;
    private ListView detail_ppwindow_gv;

    /**
     * 显示
     *
     * @param
     */
    private void showPopupWindow() {
        if (popupWindowbj == null) {
            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(this.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.activity_detail_ppwindow, null);
            ImageView cart_num = (ImageView) view.findViewById(R.id.cart_num);
            detail_ppwindow_gv = (ListView) view.findViewById(R.id.lv_ppwoidos);
            propertyAdapter = new PropertyAdapter(NewShopdetailActivity.this);
            detail_ppwindow_gv.setAdapter(propertyAdapter);
            cart_num.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    popupWindowbj.dismiss();
                }
            });
            popupWindowbj = new PopupWindow(view, RadioGroup.LayoutParams.MATCH_PARENT,
                    RadioGroup.LayoutParams.WRAP_CONTENT);
        }

        popupWindowbj.setFocusable(true);
        popupWindowbj.setOutsideTouchable(false);
        // 这个是为了点击“返回Back”也能使其消失，并且并不会影响你的背景
        //popWindow.setBackgroundDrawable(new BitmapDrawable());
        WindowManager windowManager = (WindowManager) getSystemService(this.WINDOW_SERVICE);


    }

    /**
     * 显示
     *
     * @param
     */
    private PopupWindow popupWindow;
    private void showPopupWindow2() {
        if (popupWindow == null) {
            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(this.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.activity_detail2_ppwindow, null);
            ImageView cart_num = (ImageView) view.findViewById(R.id.cart_num);

            cart_num.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    popupWindow.dismiss();
                }
            });
            popupWindow = new PopupWindow(view, RadioGroup.LayoutParams.MATCH_PARENT,
                    RadioGroup.LayoutParams.WRAP_CONTENT);
        }

        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(false);
        // 这个是为了点击“返回Back”也能使其消失，并且并不会影响你的背景
        //popWindow.setBackgroundDrawable(new BitmapDrawable());
        WindowManager windowManager = (WindowManager) getSystemService(this.WINDOW_SERVICE);


    }


    /**
     * 显示
     *
     * @param
     */
    private PopupWindow popupWindowtoop;
    private void showPopupWindowTOP() {
        if (popupWindowtoop == null) {
            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(this.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.activity_detail3_ppwindow, null);
            ImageView cart_num = (ImageView) view.findViewById(R.id.cart_num);

            cart_num.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    popupWindowtoop.dismiss();
                }
            });
            popupWindowtoop = new PopupWindow(view, RadioGroup.LayoutParams.MATCH_PARENT,
                    RadioGroup.LayoutParams.WRAP_CONTENT);
        }

        popupWindowtoop.setFocusable(true);
        popupWindowtoop.setOutsideTouchable(false);
        // 这个是为了点击“返回Back”也能使其消失，并且并不会影响你的背景
        //popWindow.setBackgroundDrawable(new BitmapDrawable());
        WindowManager windowManager = (WindowManager) getSystemService(this.WINDOW_SERVICE);


    }

}
