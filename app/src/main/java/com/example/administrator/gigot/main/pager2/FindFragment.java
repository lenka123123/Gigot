package com.example.administrator.gigot.main.pager2;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidkun.xtablayout.XTabLayout;
import com.example.administrator.gigot.R;
import com.example.administrator.gigot.main.pager2.tab.FindTabFragment;

import java.util.ArrayList;
import java.util.List;

public class FindFragment extends Fragment {

    private View view;
    private XTabLayout mxTabLayout;
    private ViewPager mViewPager;
    private List mTabList = new ArrayList();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_find, null);
        initview();
       initData();
        initAct();


        return view;
    }

    private void initview() {
        mxTabLayout = view.findViewById(R.id.xTablayout);
        mViewPager = view.findViewById(R.id.viewPager);
    }

    private void initData() {
        mTabList.add("新县");
        mTabList.add("光山");
        mTabList.add("麻城");
        mTabList.add("阜阳");
    }



    private void initAct() {

        mViewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                FindTabFragment fragment = new FindTabFragment();
                Bundle bundle = new Bundle();
                String ss = (String) mTabList.get(position);
                bundle.putString("title", ss);
                fragment.setArguments(bundle);
                return fragment;
            }

            @Override
            public int getCount() {
                return mTabList.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return (CharSequence) mTabList.get(position);
            }
        });

        mxTabLayout.setupWithViewPager(mViewPager);// TODO: 2018/5/30 0030  设置联动
    }
}
