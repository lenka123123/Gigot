package com.example.administrator.gigot.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.gigot.R;
import com.example.administrator.gigot.main.common.fragment.TabFragmentPagerAdapter;
import com.example.administrator.gigot.main.pager1.MeFragment;
import com.example.administrator.gigot.main.pager2.FindFragment;
import com.example.administrator.gigot.main.pager3.TodayFragment;
import com.example.administrator.gigot.main.pager4.OkFragment;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {

    private ViewPager mViewPager;
    private TabFragmentPagerAdapter adapter;
    private List<Fragment> list;
    private RadioGroup rg_home;
    private RadioButton rb_me;
    private RadioButton rb_find;
    private RadioButton rb_today;
    private RadioButton rb_today1;
    private RadioButton rb_ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        initView();
        initData();
        initAct();


    }


    public void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mViewPager = findViewById(R.id.viewpager);
        rg_home = findViewById(R.id.rg_home);
        rb_me = findViewById(R.id.rb_me);
        rb_find = findViewById(R.id.rb_find);
        rb_today1 = findViewById(R.id.rb_today);
        rb_ok = findViewById(R.id.rb_ok);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void initData() {

        //把Fragment添加到List集合里面
        list = new ArrayList<>();
        list.add(new MeFragment());
        list.add(new FindFragment());
        list.add(new TodayFragment());
        list.add(new OkFragment());
        adapter = new TabFragmentPagerAdapter(getSupportFragmentManager(), list);
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(0);  //初始化显示第一个页面

    }

    public void initAct() {
        mViewPager.addOnPageChangeListener(this);
        rg_home.setOnCheckedChangeListener(this);
        rg_home.check(R.id.rb_me);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                rg_home.check(R.id.rb_me);
                break;
            case 1:
                rg_home.check(R.id.rb_find);
                break;
            case 2:
                rg_home.check(R.id.rb_today);
                break;
            case 3:
                rg_home.check(R.id.rb_ok);
                break;
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        switch (checkedId) {
            case R.id.rb_me:
                mViewPager.setCurrentItem(0, false);
                break;

            case R.id.rb_find:
                mViewPager.setCurrentItem(1, false);
                break;
            case R.id.rb_today:
                mViewPager.setCurrentItem(2, false);
                break;
            case R.id.rb_ok:
                mViewPager.setCurrentItem(3, false);
                break;
        }

    }
}
