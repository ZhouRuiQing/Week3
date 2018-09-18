package com.bwie.week3.mvp;

import com.bwie.week3.base.IBaseModel;
import com.bwie.week3.base.IBasePresent;
import com.bwie.week3.base.IBaseView;

/**
 *  MVP 的契约类
 */
public interface AccounConten {

    interface View extends IBaseView {

        void showding(String relult);
        void hideing();
        void Error();
    }
    interface Model extends IBaseModel{

        interface NetCallBack{
            void  onSuccess(String relult);
            void  onReeor(String msg);
        }

        void showData(String url,NetCallBack callBack);

    }

    interface Present extends IBasePresent<View>{

        void Showdata(String url);
    }
}
