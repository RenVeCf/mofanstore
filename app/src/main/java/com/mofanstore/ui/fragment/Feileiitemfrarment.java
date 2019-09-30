package com.mofanstore.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;

import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.mofanstore.R;
import com.mofanstore.base.BaseFragment;
import com.mofanstore.tool.ListBaseAdapter;
import com.mofanstore.tool.SuperViewHolder;
import com.mofanstore.ui.activity.home.PpaidetailActivity;
import com.mofanstore.util.pyin.CharacterParser;
import com.mofanstore.util.pyin.PinyinComparator;
import com.mofanstore.util.pyin.SideBar;
import com.mofanstore.util.pyin.SortAdapter;
import com.mofanstore.util.pyin.SortModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.InjectView;

public class Feileiitemfrarment extends BaseFragment {

    @InjectView(R.id.country_lvcountry)
    ListView sortListView;
    @InjectView(R.id.sidrbar)
    SideBar sideBar;
    private SortAdapter adapter;
    private PinyinComparator pinyinComparator;

    private CharacterParser characterParser;
    private List<SortModel> SourceDateList;

    RecycleitenAdapter recycleitenAdapter;
    private LuRecyclerViewAdapter mLuRecyclerViewitenAdapter = null;
    private List<String> onlinelawyer = new ArrayList<>();

    @Override
    protected int intiLayout() {
        return R.layout.fragment_feilei2;
    }

    @Override
    protected void initView() {
        onlinelawyer.add("");
        onlinelawyer.add("");
        onlinelawyer.add("");
        onlinelawyer.add("");
        onlinelawyer.add("");
        onlinelawyer.add("");
        onlinelawyer.add("");

        characterParser = CharacterParser.getInstance();

        pinyinComparator = new PinyinComparator();

        SourceDateList = filledData(getResources().getStringArray(R.array.date));


        Collections.sort(SourceDateList, pinyinComparator);
        sortListView.addHeaderView(getheadview());

        adapter = new SortAdapter(getActivity(), SourceDateList);
        sortListView.setAdapter(adapter);


        //�����Ҳഥ������
        sideBar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {

            @Override
            public void onTouchingLetterChanged(String s) {

                int position = adapter.getPositionForSection(s.charAt(0));
                if (position != -1) {
                    sortListView.setSelection(position);
                }

            }
        });


    }

    @Override
    protected void initData() {

    }

    public View getheadview(){
        View headView = getLayoutInflater().inflate(R.layout.fragment_feileitop, null);
        LuRecyclerView recyclerview=headView.findViewById(R.id.recyclerview);

        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recycleitenAdapter = new RecycleitenAdapter(getActivity());
        mLuRecyclerViewitenAdapter = new LuRecyclerViewAdapter(recycleitenAdapter);
        recyclerview.setAdapter(mLuRecyclerViewitenAdapter);


        recycleitenAdapter.addAll(onlinelawyer);
        recyclerview.refreshComplete(10);
        mLuRecyclerViewitenAdapter.notifyDataSetChanged();
        mLuRecyclerViewitenAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), PpaidetailActivity.class);
                startActivity(intent);
            }
        });
        return headView;
    }

    private List<SortModel> filledData(String[] date) {
        List<SortModel> mSortList = new ArrayList<SortModel>();

        for (int i = 0; i < date.length; i++) {
            SortModel sortModel = new SortModel();
            sortModel.setName(date[i]);
            //����ת����ƴ��
            String pinyin = characterParser.getSelling(date[i]);
            String sortString = pinyin.substring(0, 1).toUpperCase();

            // ������ʽ���ж�����ĸ�Ƿ���Ӣ����ĸ
            if (sortString.matches("[A-Z]")) {
                sortModel.setSortLetters(sortString.toUpperCase());
            } else {
                sortModel.setSortLetters("#");
            }

            mSortList.add(sortModel);
        }
        return mSortList;

    }

    /**
     * ����������е�ֵ���������ݲ�����ListView
     *
     * @param filterStr
     */
    private void filterData(String filterStr) {
        List<SortModel> filterDateList = new ArrayList<SortModel>();

        if (TextUtils.isEmpty(filterStr)) {
            filterDateList = SourceDateList;
        } else {
            filterDateList.clear();
            for (SortModel sortModel : SourceDateList) {
                String name = sortModel.getName();
                if (name.indexOf(filterStr.toString()) != -1 || characterParser.getSelling(name).startsWith(filterStr.toString())) {
                    filterDateList.add(sortModel);
                }
            }
        }

        // ����a-z��������
        Collections.sort(filterDateList, pinyinComparator);
        adapter.updateListView(filterDateList);
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
            return R.layout.activity_flei_item;
        }

        @Override
        public void onBindItemHolder(SuperViewHolder holder, int position) {
            menu = getDataList();

        }

    }


    public static Feileiitemfrarment newInstance(String cats_id) {
        Feileiitemfrarment fragment = new Feileiitemfrarment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("cats_id", cats_id);
        fragment.setArguments(bundle);
        return fragment;
    }
}
