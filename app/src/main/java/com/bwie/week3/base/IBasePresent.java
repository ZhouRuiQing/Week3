package com.bwie.week3.base;

public interface IBasePresent<V extends IBaseView> {

    void  attch(V v);
    void deAttch();

}
