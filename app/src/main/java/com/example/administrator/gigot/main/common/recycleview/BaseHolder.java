package com.example.administrator.gigot.main.common.recycleview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.gigot.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.HashMap;

public class BaseHolder extends RecyclerView.ViewHolder {

    //不写死控件变量，而采用Map方式
    private HashMap<Integer, View> mViews = new HashMap<>();

    public BaseHolder(View itemView) {
        super(itemView);
    }

    /**
     * 获取控件的方法
     */
    public <T> T getView(Integer viewId) {
        //根据保存变量的类型 强转为该类型
        View view = mViews.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            //缓存
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * 传入文本控件id和设置的文本值，设置文本
     */
    public BaseHolder setText(Integer viewId, String value) {
        TextView textView = getView(viewId);
        if (textView != null) {
            textView.setText(value);
        }
        return this;
    }

    /**
     * 传入图片控件id和资源id，设置图片
     */
    public BaseHolder setImageResource(Integer viewId, Integer resId) {
        ImageView imageView = getView(viewId);
        if (imageView != null) {
            imageView.setImageResource(resId);
        }
        return this;
    }

    /**
     * 传入图片控件id和资源id，设置图片
     */
    public BaseHolder setImageBitmap(final Context context, Integer viewId, String bitmapUrl) {

        final ImageView imageView = getView(viewId);
        if (imageView != null) {//.placeholder(R.drawable.user_placeholder)
            Picasso.with(context).load(bitmapUrl).error(R.mipmap.ic_launcher).into(imageView);
        }
        return this;
    }

    //...还可以扩展出各种控件。
    //Fluent API 链式api  obj.setxxx().setyyy()....
}
