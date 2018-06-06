package com.example.administrator.gigot.textviewpagerviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyAdapter   extends FragmentPagerAdapter {
    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 2)
            return new ChildrenFragment();
        return new TestFragment(position);
    }

    @Override
    public int getCount() {
        return 4;
    }

}
