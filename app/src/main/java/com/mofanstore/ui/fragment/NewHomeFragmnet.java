package com.mofanstore.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.mofanstore.R;
import com.mofanstore.base.BaseFragment;
import com.mofanstore.tool.ListBaseAdapter;
import com.mofanstore.tool.SuperViewHolder;
import com.mofanstore.ui.activity.home.FeileilvActivity;
import com.mofanstore.ui.activity.home.MytuangouLvActivity;
import com.mofanstore.ui.activity.home.NewShopdetailActivity;
import com.mofanstore.ui.activity.home.ShoplvActivity;
import com.mofanstore.ui.activity.home.ZouxiulvActivity;
import com.mofanstore.ui.activity.hulan.SousuoActivity;
import com.mofanstore.ui.activity.user.MyyaoqinActivity;
import com.mofanstore.ui.activity.user.RiliActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class NewHomeFragmnet extends BaseFragment {
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
    @InjectView(R.id.convenientBanner)
    ConvenientBanner convenientBanner;
    @InjectView(R.id.llflei1)
    LinearLayout llflei1;
    @InjectView(R.id.llflei2)
    LinearLayout llflei2;
    @InjectView(R.id.llflei3)
    LinearLayout llflei3;
    @InjectView(R.id.llflei4)
    LinearLayout llflei4;
    @InjectView(R.id.llxinping1)
    LinearLayout llxinping1;
    @InjectView(R.id.llxinping2)
    LinearLayout llxinping2;
    @InjectView(R.id.llxinping3)
    LinearLayout llxinping3;
    @InjectView(R.id.llxinping4)
    LinearLayout llxinping4;
    @InjectView(R.id.convenientBanner2)
    ConvenientBanner convenientBanner2;
    @InjectView(R.id.dis_img)
    TextView disImg;
    @InjectView(R.id.xuanz_youhui)
    RelativeLayout xuanzYouhui;
    @InjectView(R.id.dis_img1)
    TextView disImg1;
    @InjectView(R.id.llzouxou1)
    FrameLayout llzouxou1;
    @InjectView(R.id.dis_img2)
    TextView disImg2;
    @InjectView(R.id.llzouxou2)
    FrameLayout llzouxou2;
    @InjectView(R.id.dis_img3)
    TextView disImg3;
    @InjectView(R.id.llzouxou3)
    FrameLayout llzouxou3;
    @InjectView(R.id.xuanz_tuangou)
    RelativeLayout xuanzTuangou;
    @InjectView(R.id.recyclerviewtuangou)
    LuRecyclerView recyclerviewtuangou;
    @InjectView(R.id.toolbar)
    LinearLayout toolbar;
    @InjectView(R.id.tab)
    TabLayout tablayout;
    @InjectView(R.id.appbar)
    AppBarLayout appbar;

    @InjectView(R.id.main_content)
    CoordinatorLayout mainContent;
    public String[] str = new String[]{"精选", "推荐", "最新", "女装", "男装", "时尚"};
    @InjectView(R.id.viewpager)
    ViewPager viewpager;
    TextView tab_text;
    @InjectView(R.id.im_qindao)
    ImageView imQindao;
    @InjectView(R.id.llyaoqin)
    LinearLayout llyaoqin;
    private TabAdapter adapter;
    private HomeitemFragment homeitemFragment;

    private List<String> onlinelawyer = new ArrayList<>();
    RecycleitenAdapter recycleitenAdapter;
    Recycle2itenAdapter recyclei2tenAdapter;
    private LuRecyclerViewAdapter mLuRecyclerViewitenAdapter = null;
    private LuRecyclerViewAdapter mLuRecyclerView2itenAdapter = null;

    @Override
    protected int intiLayout() {
        return R.layout.fragment_newhomefl;
    }

    @Override
    protected void initView() {
        onlinelawyer.add("");
        onlinelawyer.add("");
        onlinelawyer.add("");
        onlinelawyer.add("");

        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            fragments.add(homeitemFragment.newInstance(""));
        }
        adapter = new TabAdapter(getChildFragmentManager(), fragments);
        //给ViewPager设置适配器
        viewpager.setAdapter(adapter);
        //将TabLayout和ViewPager关联起来。
        tablayout.setupWithViewPager(viewpager);
        tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        for (int i = 0; i < adapter.getCount(); i++) {
            TabLayout.Tab tab = tablayout.getTabAt(i);//获得每一个tab
            tab.setCustomView(R.layout.activity_tab2_item);//给每一个tab设置view
            tab_text = (TextView) tab.getCustomView().findViewById(R.id.tab_tex);
            if (i == 0) {
                // 设置第一个tab的TextView是被选择的样式
                ((TextView) tab.getCustomView().findViewById(R.id.tab_tex)).setTextColor(0xff333333);
                ((TextView) tab.getCustomView().findViewById(R.id.tab_tex)).setTextSize(14);

            }
            tab_text.setText(str[i]);//设置tab上的文字
        }

        tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                ((TextView) tab.getCustomView().findViewById(R.id.tab_tex)).setTextColor(0xff333333);
                ((TextView) tab.getCustomView().findViewById(R.id.tab_tex)).setTextSize(14);
                viewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                ((TextView) tab.getCustomView().findViewById(R.id.tab_tex)).setTextColor(0xff999999);
                ((TextView) tab.getCustomView().findViewById(R.id.tab_tex)).setTextSize(12);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        recyclerviewtuangou.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recycleitenAdapter = new RecycleitenAdapter(getActivity());
        mLuRecyclerViewitenAdapter = new LuRecyclerViewAdapter(recycleitenAdapter);
        recyclerviewtuangou.setAdapter(mLuRecyclerViewitenAdapter);

        recycleitenAdapter.addAll(onlinelawyer);
        recyclerviewtuangou.refreshComplete(10);
        mLuRecyclerViewitenAdapter.notifyDataSetChanged();
        mLuRecyclerViewitenAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Intent intent = new Intent(getActivity(), NewShopdetailActivity.class);
                intent.putExtra("flag", "2");
                startActivity(intent);
            }
        });


        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclei2tenAdapter = new Recycle2itenAdapter(getActivity());
        mLuRecyclerView2itenAdapter = new LuRecyclerViewAdapter(recyclei2tenAdapter);
        recyclerview.setAdapter(mLuRecyclerView2itenAdapter);

        recyclei2tenAdapter.addAll(onlinelawyer);
        recyclerview.refreshComplete(10);
        mLuRecyclerView2itenAdapter.notifyDataSetChanged();
        mLuRecyclerView2itenAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Intent intent = new Intent(getActivity(), NewShopdetailActivity.class);
                intent.putExtra("flag", "2");
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.inject(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick({R.id.back, R.id.llzouxou1,R.id.llyaoqin, R.id.llzouxou2, R.id.llzouxou3, R.id.im_qindao, R.id.llousuo, R.id.llflei1, R.id.llflei2, R.id.llflei3, R.id.llflei4, R.id.llxinping1, R.id.llxinping2, R.id.llxinping3, R.id.llxinping4, R.id.xuanz_youhui, R.id.xuanz_tuangou})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.back:
                intent = new Intent(getActivity(), FeileilvActivity.class);
                startActivity(intent);
                break;
            case R.id.llyaoqin:
                intent = new Intent(getActivity(), MyyaoqinActivity.class);
                startActivity(intent);
                break;
            case R.id.llzouxou1:
                intent = new Intent(getActivity(), ShoplvActivity.class);
                intent.putExtra("name", "EIFINI");
                startActivity(intent);
                break;
            case R.id.llzouxou2:
                intent = new Intent(getActivity(), ShoplvActivity.class);
                intent.putExtra("name", "CHEMINS ");
                startActivity(intent);
                break;
            case R.id.llzouxou3:
                intent = new Intent(getActivity(), ShoplvActivity.class);
                intent.putExtra("name", "LEUANLE");
                startActivity(intent);
                break;
            case R.id.im_qindao:
                intent = new Intent(getActivity(), RiliActivity.class);
                startActivity(intent);
                break;
            case R.id.llousuo:
                intent = new Intent(getActivity(), SousuoActivity.class);
                startActivity(intent);
                break;
            case R.id.llflei1:
                intent = new Intent(getActivity(), ShoplvActivity.class);
                intent.putExtra("name", "饰品");
                startActivity(intent);
                break;
            case R.id.llflei2:
                intent = new Intent(getActivity(), ShoplvActivity.class);
                intent.putExtra("name", "折扣");
                startActivity(intent);
                break;
            case R.id.llflei3:
                intent = new Intent(getActivity(), ShoplvActivity.class);
                intent.putExtra("name", "榜单");
                startActivity(intent);
                break;
            case R.id.llflei4:
                intent = new Intent(getActivity(), FeileilvActivity.class);
                startActivity(intent);
                break;
            case R.id.llxinping1:
                intent = new Intent(getActivity(), ShoplvActivity.class);
                intent.putExtra("name", "新品");
                startActivity(intent);
                break;
            case R.id.llxinping2:
                intent = new Intent(getActivity(), ShoplvActivity.class);
                intent.putExtra("name", "人气");
                startActivity(intent);
                break;
            case R.id.llxinping3:
                intent = new Intent(getActivity(), ShoplvActivity.class);
                intent.putExtra("name", "明星款");
                startActivity(intent);
                break;
            case R.id.llxinping4:
                intent = new Intent(getActivity(), ShoplvActivity.class);
                intent.putExtra("name", "限量款");
                startActivity(intent);
                break;
            case R.id.xuanz_youhui:
                intent = new Intent(getActivity(), ZouxiulvActivity.class);
                startActivity(intent);
                break;
            case R.id.xuanz_tuangou:
                intent = new Intent(getActivity(), MytuangouLvActivity.class);
                startActivity(intent);
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
            return R.layout.activity_home_item;
        }

        @Override
        public void onBindItemHolder(SuperViewHolder holder, int position) {
            menu = getDataList();

        }

    }


    public class Recycle2itenAdapter extends ListBaseAdapter<String> {
        private Context context;
        private List<String> menu;

        public Recycle2itenAdapter(Context context) {
            super(context);
            this.context = context;
        }

        @Override
        public int getLayoutId() {
            return R.layout.ipd_activity_home_gv_item;
        }

        @Override
        public void onBindItemHolder(SuperViewHolder holder, int position) {
            menu = getDataList();

        }

    }


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
