package com.bwie.week3.mvp;

import android.util.Log;

import java.lang.ref.WeakReference;

import javax.security.auth.callback.Callback;

public class AccountPresent implements AccounConten.Present{

    private AccounConten.Model model;
    private AccounConten.View view;
    private WeakReference<AccountModel> modelWeakReference;
    private  WeakReference<AccounConten.View> viewWeakReference;

    @Override
    public void Showdata(String url) {

        modelWeakReference.get().showData(url, new AccounConten.Model.NetCallBack() {
            @Override
            public void onSuccess(String relult) {
                view.showding(relult);
            }

            @Override
            public void onReeor(String msg) {

                String msgs = msg.toString();

                Log.i("aaa",msgs);
            }
        });
    }

    @Override
    public void attch(AccounConten.View view) {

        this.view=view;
        viewWeakReference = new WeakReference(view);
        model=new AccountModel();
        modelWeakReference=new WeakReference(model);
    }

    @Override
    public void deAttch() {

    }
}
