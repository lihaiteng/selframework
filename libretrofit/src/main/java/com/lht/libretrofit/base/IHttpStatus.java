package com.lht.libretrofit.base;

/**
 * @date 2018/10/19 0019
 */

public interface IHttpStatus{
    /**
     * API是否请求成功
     */
    boolean requestIfSuccess();

    String showMsg();

}
