package com.lht.libretrofit.error;

import android.content.Context;
import android.widget.Toast;

import java.io.IOException;

import retrofit2.HttpException;
import rx.Subscriber;

/**
 * Created by LiHT on 2017/5/26.
 */

public class BaseSubscriber<T> extends Subscriber<T> {

    protected Context mContext;

    public BaseSubscriber(Context context) {
        this.mContext = context;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(final Throwable e) {
        if (e instanceof HttpException) {
            Toast.makeText(mContext,"网络请求失败，请检查网络", Toast.LENGTH_SHORT).show();
        } else if (e instanceof IOException) {
            Toast.makeText(mContext,"网络请求处理失败，请重试", Toast.LENGTH_SHORT).show();
        } else if (e instanceof RequestException) {
            Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();
            onError(e,e.getMessage());
        }
    }

    public void onError(final Throwable e,String msg) {

    }

    @Override
    public void onNext(T t) {

    }

}
