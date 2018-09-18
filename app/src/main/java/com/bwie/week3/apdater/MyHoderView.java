package com.bwie.week3.apdater;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.week3.R;
import com.bwie.week3.mvp.AccounConten;

public class MyHoderView extends RecyclerView.ViewHolder {

    public TextView tv_name;
    public TextView tv_title;
    public ImageView tv_image;

    public MyHoderView(View itemview){
        super(itemview);

        tv_image = itemview.findViewById(R.id.tv_image);
        tv_title = itemview.findViewById(R.id.tv_title);
        tv_name = itemview.findViewById(R.id.tv_name);


    }

}
