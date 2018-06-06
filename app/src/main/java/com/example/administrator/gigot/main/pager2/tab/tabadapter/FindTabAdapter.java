package com.example.administrator.gigot.main.pager2.tab.tabadapter;

import android.content.Context;

import com.example.administrator.gigot.R;
import com.example.administrator.gigot.main.common.recycleview.BaseAdapter;
import com.example.administrator.gigot.main.common.recycleview.BaseHolder;
import com.example.administrator.gigot.main.pager2.tab.bean.TabBean;

import java.util.List;

public class FindTabAdapter extends BaseAdapter<TabBean> {

    private Context context;
    private String url = "http://ww1.sinaimg.cn/large/0065oQSqly1frslibvijrj3asdasd0k80q678q.jpg";

    public FindTabAdapter(Context context, List list) {
        super(R.layout.recycle_item, list);
        this.context = context;
    }

    @Override
    protected void convert(BaseHolder holder, TabBean item) {
        holder.setText(R.id.bookname, item.name).setText(R.id.bookprice, "100").setImageBitmap(context, R.id.imageView, item.url);
    }
}
