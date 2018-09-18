package com.bwie.week3.apdater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bwie.week3.R;
import com.bwie.week3.bean.UiBean;

import java.util.List;

public class Myapdater extends RecyclerView.Adapter<MyHoderView> {
    List<UiBean.ResultBean.NearbyCinemaListBean> list;
    Context context;

    public Myapdater(List<UiBean.ResultBean.NearbyCinemaListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHoderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        MyHoderView inflate = new MyHoderView(LayoutInflater.from(context).inflate(R.layout.item, parent, false));

        return inflate;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHoderView holder, int position) {

        holder.tv_name.setText(list.get(position).getName());
        holder.tv_title.setText(list.get(position).getAddress());

        if(list!=null&&list.size()>=0){

            Glide.with(context)
                    .load(list.get(position).getLogo())
                    .into(holder.tv_image);

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
