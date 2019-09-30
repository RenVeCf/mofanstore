package com.mofanstore.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mofanstore.R;
import com.mofanstore.base.BaseFragment;
import com.mofanstore.ui.activity.Adater.UserGVitemAdarer;
import com.mofanstore.ui.activity.Shopcar.MyorderlvActivity;
import com.mofanstore.ui.activity.Shopcar.TuikuanlvActivity;
import com.mofanstore.ui.activity.user.MyVipActivity;
import com.mofanstore.ui.activity.user.MyadderlvActivity;
import com.mofanstore.ui.activity.user.MyatterActivity;
import com.mofanstore.ui.activity.user.MyattershopActivity;
import com.mofanstore.ui.activity.user.MychuandaActivity;
import com.mofanstore.ui.activity.user.MycollectActivity;
import com.mofanstore.ui.activity.user.MydingzhilvActivity;
import com.mofanstore.ui.activity.user.MyfansActivity;
import com.mofanstore.ui.activity.user.MyjifenActivity;
import com.mofanstore.ui.activity.user.MysettingActivity;
import com.mofanstore.ui.activity.user.MytuangoulvActivity;
import com.mofanstore.ui.activity.user.MyvipkaqActivity;
import com.mofanstore.ui.activity.user.MyvipquanyiActivity;
import com.mofanstore.ui.activity.user.MyyaoqinActivity;
import com.mofanstore.ui.activity.user.MyzanActivity;
import com.mofanstore.ui.activity.user.MyzhujiActivity;
import com.mofanstore.ui.activity.user.RiliActivity;
import com.mofanstore.ui.activity.user.UserinfoActivity;
import com.mofanstore.util.Ipd_Gridview;
import com.mofanstore.util.RoundAngleImageView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class UserinfoFragment extends BaseFragment {


    @InjectView(R.id.tv_commiy)
    ImageView tvCommiy;
    @InjectView(R.id.commit)
    FrameLayout commit;
    @InjectView(R.id.userphoto)
    RoundAngleImageView userphoto;
    @InjectView(R.id.tv_username)
    TextView tvUsername;
    @InjectView(R.id.tv_userphone)
    TextView tvUserphone;
    @InjectView(R.id.rl_userinfo)
    RelativeLayout rlUserinfo;
    @InjectView(R.id.tv_td_product)
    TextView tvTdProduct;
    @InjectView(R.id.tv_jinrimorry)
    TextView tvJinrimorry;
    @InjectView(R.id.ll1_yjinri)
    LinearLayout ll1Yjinri;
    @InjectView(R.id.tv_th_product)
    TextView tvThProduct;
    @InjectView(R.id.tv_yugumorry)
    TextView tvYugumorry;
    @InjectView(R.id.ll2_yugu)
    LinearLayout ll2Yugu;
    @InjectView(R.id.tv_th_product1)
    TextView tvThProduct1;
    @InjectView(R.id.tv_yugumorry1)
    TextView tvYugumorry1;
    @InjectView(R.id.ll2_yugu1)
    LinearLayout ll2Yugu1;
    @InjectView(R.id.tv_th_product2)
    TextView tvThProduct2;
    @InjectView(R.id.tv_yugumorry2)
    TextView tvYugumorry2;
    @InjectView(R.id.ll2_yugu2)
    LinearLayout ll2Yugu2;
    @InjectView(R.id.rl_myorder)
    RelativeLayout rlMyorder;
    @InjectView(R.id.ll_myorder)
    LinearLayout llMyorder;
    @InjectView(R.id.ll_daiorder)
    LinearLayout llDaiorder;
    @InjectView(R.id.ll_daisangmen)
    LinearLayout llDaisangmen;
    @InjectView(R.id.ll_wxiuzhiong)
    LinearLayout llWxiuzhiong;
    @InjectView(R.id.ll_yiwchang)
    LinearLayout llYiwchang;
    @InjectView(R.id.gvbotton)
    Ipd_Gridview gvbotton;

    @Override
    protected int intiLayout() {
        return R.layout.fragment_userinfo;
    }

    @Override
    protected void initView() {
        UserGVitemAdarer userGVitemAdarer = new UserGVitemAdarer(getActivity());
        gvbotton.setAdapter(userGVitemAdarer);
        gvbotton.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==10){
                    Intent intent=new Intent(getActivity(), MyatterActivity.class);
                    startActivity(intent);
                }else if (i==11){
                    Intent intent=new Intent(getActivity(), MyfansActivity.class);
                    startActivity(intent);
                }else if (i==9){
                    Intent intent=new Intent(getActivity(), MyzanActivity.class);
                    startActivity(intent);
                }else if (i==8){
                    Intent intent=new Intent(getActivity(), MychuandaActivity.class);
                    startActivity(intent);
                }else if (i==4){
                    Intent intent=new Intent(getActivity(), MyyaoqinActivity.class);
                    startActivity(intent);
                }else if (i==3){
                    Intent intent=new Intent(getActivity(), MyvipkaqActivity.class);
                    startActivity(intent);
                }else if (i==0){
                    Intent intent=new Intent(getActivity(), MyattershopActivity.class);
                    startActivity(intent);
                }else if (i==2){
                    Intent intent=new Intent(getActivity(), MyvipquanyiActivity.class);
                    startActivity(intent);
                }else if (i==5){
                    Intent intent=new Intent(getActivity(), MyadderlvActivity.class);
                    startActivity(intent);
                }else if (i==6){
                    Intent intent=new Intent(getActivity(), MydingzhilvActivity.class);
                    startActivity(intent);
                }else if (i==7){
                    Intent intent=new Intent(getActivity(), MytuangoulvActivity.class);
                    startActivity(intent);
                }else if (i==1){
                    Intent intent=new Intent(getActivity(), RiliActivity.class);
                    startActivity(intent);
                }


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

    @OnClick({R.id.tv_userphone,R.id.commit, R.id.rl_userinfo, R.id.ll1_yjinri, R.id.ll2_yugu, R.id.ll2_yugu1, R.id.ll2_yugu2, R.id.rl_myorder, R.id.ll_myorder, R.id.ll_daiorder, R.id.ll_daisangmen, R.id.ll_wxiuzhiong, R.id.ll_yiwchang})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.tv_userphone:

                break;
            case R.id.commit:
                intent=new Intent(getActivity(), MysettingActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_userinfo:
                intent=new Intent(getActivity(), UserinfoActivity.class);
                startActivity(intent);
                break;
            case R.id.ll1_yjinri:
                intent=new Intent(getActivity(), MycollectActivity.class);
                startActivity(intent);
                break;
            case R.id.ll2_yugu:
                intent=new Intent(getActivity(), MyjifenActivity.class);
                startActivity(intent);
                break;
            case R.id.ll2_yugu1:
                 intent=new Intent(getActivity(), MyVipActivity.class);
                startActivity(intent);
                break;
            case R.id.ll2_yugu2:
                intent=new Intent(getActivity(), MyzhujiActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_myorder:
                intent=new Intent(getActivity(), MyorderlvActivity.class);
                intent.putExtra("typepage",0);
                startActivity(intent);
                break;
            case R.id.ll_myorder:
                intent=new Intent(getActivity(), MyorderlvActivity.class);
                intent.putExtra("typepage",1);
                startActivity(intent);
                break;
            case R.id.ll_daiorder:
                intent=new Intent(getActivity(), MyorderlvActivity.class);
                intent.putExtra("typepage",2);
                startActivity(intent);
                break;
            case R.id.ll_daisangmen:
                intent=new Intent(getActivity(), MyorderlvActivity.class);
                intent.putExtra("typepage",3);
                startActivity(intent);
                break;
            case R.id.ll_wxiuzhiong:
                intent=new Intent(getActivity(), MyorderlvActivity.class);
                intent.putExtra("typepage",4);
                startActivity(intent);
                break;
            case R.id.ll_yiwchang:
                intent=new Intent(getActivity(), TuikuanlvActivity.class);
                startActivity(intent);
                break;
        }
    }
}
