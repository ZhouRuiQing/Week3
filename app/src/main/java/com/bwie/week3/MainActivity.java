package com.bwie.week3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bwie.week3.apdater.Myapdater;
import com.bwie.week3.bean.UiBean;
import com.bwie.week3.mvp.AccounConten;
import com.bwie.week3.mvp.AccountPresent;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AccounConten.View {

    private RecyclerView rexecyView;
    private AccountPresent present;
    private List<UiBean.ResultBean.NearbyCinemaListBean> list = new ArrayList<>();
    private Myapdater apdater;
    private UiBean bean;
    private ImageView map_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        

        rexecyView = findViewById(R.id.recylerView);
        map_image = findViewById(R.id.map_image);

        map_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,GaodeActivity.class);
                startActivity(intent);
            }
        });

        rexecyView.setLayoutManager(new LinearLayoutManager(this));
        apdater = new Myapdater(list,this);
        rexecyView.setAdapter(apdater);

        rexecyView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));


        present=new AccountPresent();
        present.attch(this);
        present.Showdata("http://172.17.8.100/movieApi/cinema/v1/findRecommendCinemas?longitude=116.30551391385724&laitude=40.04571807462411&page=1&count=10&userld=18&sessionld=15320748258726");

    }

    @Override
    public void showding(String relult) {

        Log.i("aaa",relult+"sss");

        Gson gson = new Gson();
         bean = gson.fromJson(relult, UiBean.class);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                list.addAll(bean.getResult().getNearbyCinemaList());
                apdater.notifyDataSetChanged();
            }
        });



    }

    @Override
    public void hideing() {

    }

    @Override
    public void Error() {

    }
}
