package com.example.administrator.gigot.main.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.gigot.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;
import android.view.View;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHondler>{

    Context context;
    List<BeaseMM > list;
    public MyAdapter(Context context, List<BeaseMM > list) {
        this.context = context;
        this.list = list;
    }
    @Override
    public MyViewHondler onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=View.inflate(context, R.layout.recycle_item_test,null);
        MyViewHondler myViewHondler=new MyViewHondler(view);
        return myViewHondler;
    }
    @Override
    public void onBindViewHolder(MyViewHondler holder, int position) {
        ImageLoader.getInstance().displayImage("url",holder.im, Myapp.getDisk());
        holder.tv.setText("eee");
        holder.tv1.setText("ddd");
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    public class MyViewHondler extends RecyclerView.ViewHolder{
        ImageView im;
        TextView tv;
        TextView tv1;
        public MyViewHondler(View itemView) {
            super(itemView);
            im=  itemView.findViewById(R.id.recyclerview_img);
            tv= itemView.findViewById(R.id.recyclerview_text);
            tv1= itemView.findViewById(R.id.recyclerview_text1);
        }
    }
}