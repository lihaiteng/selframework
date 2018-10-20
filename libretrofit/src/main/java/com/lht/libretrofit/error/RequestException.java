package com.lht.libretrofit.error;

/**
 * Created by LiHT on 2017/5/26.
 */

public class RequestException extends RuntimeException{

//    public RequestException(<? extends IHttpStatus> httpStatus){
//        super(httpStatus.showMsg());
//    }

    public RequestException(String msg){
        super(msg);
    }

}
