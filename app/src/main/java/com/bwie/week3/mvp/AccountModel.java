package com.bwie.week3.mvp;

import com.bwie.week3.utils.OkHttpUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class AccountModel implements AccounConten.Model {
    private OkHttpUtils okHttpUtils;

    public AccountModel(){

        okHttpUtils = new OkHttpUtils();
    }
    @Override
    public void showData(String url, final NetCallBack callBack) {

        OkHttpUtils.getInstance().get(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String estring = e.getMessage().toString();
                callBack.onReeor(estring);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String estring = response.body().string().toString();
                callBack.onSuccess(estring);
            }
        });
    }
}
