package com.example.administrator.gigot.main.pager2.tab;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.gigot.main.pager2.tab.bean.TabBean;
import com.example.administrator.gigot.main.pager2.tab.tabadapter.FindTabAdapter;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;


public class FindTabFragment extends Fragment {

    private FindTabAdapter mFindTabAdapter;
    private ArrayList<TabBean> list = new ArrayList();
    private List<TabBean> mTestData;

    //onCreate()方法调用之前就调用
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        Log.i(TAG, "setUserVisibleHintisVisible: 1111111" + isVisibleToUser);
//，isVisible()方法可以判断Fragment的视图是否创建好
        //isVisibleToUser
        if (isVisibleToUser && isVisible()) {
            Log.i(TAG, "setUserVisibleHintisVisible: 222222" + isVisible());
            initData();
        }
        super.setUserVisibleHint(isVisibleToUser);
    }

    private void initData() {
        mTestData = new ArrayList();
        mTestData.clear();
        for (int i = 0; i < 15; i++) {
            TabBean tabBean = new TabBean();
            tabBean.name = "MM" + i;
            if (i % 2 == 1) {
                tabBean.url = "http://ww1.sinaimg.cn/large/0065oQSqly1frslibvijrj30k80q678q.jpg";
            } else {
                tabBean.url = "http://ww1.sinaimg.cn/large/0065oQSqly1frqscr5o00j30k80qzafc.jpg";
            }
            if (i==5){
                tabBean.url = "http://ww1.sinaimg.cn/lar";
            }
            mTestData.add(tabBean);
        }
        list.addAll(mTestData);
        mFindTabAdapter.notifyDataSetChanged();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {




        RecyclerView recyclerView = new RecyclerView(getContext());

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //设置Adapter
        mFindTabAdapter = new FindTabAdapter(getContext(), list);

        recyclerView.setAdapter(mFindTabAdapter);


        if (getUserVisibleHint()) {
            Log.i(TAG, "setUserVisibleHintisVisible: 333333" + isVisible());
            initData();//第一个不显示的处理方式
        }
        return recyclerView;
    }
}
