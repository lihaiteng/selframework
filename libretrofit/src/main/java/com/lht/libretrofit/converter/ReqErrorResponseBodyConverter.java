package com.lht.libretrofit.converter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.lht.libretrofit.base.IHttpStatus;
import com.lht.libretrofit.error.RequestException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Converter;

import static okhttp3.internal.Util.UTF_8;

/**
 * Created by LiHT on 2017/5/26.
 */

public class ReqErrorResponseBodyConverter<T,H extends IHttpStatus> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;
    private Class<H> httpStatusClass;

    ReqErrorResponseBodyConverter(Gson gson, TypeAdapter<T> adapter,Class<H> httpStatusClass) {
        this.gson = gson;
        this.adapter = adapter;
        this.httpStatusClass = httpStatusClass;
    }

    @Override public T convert(ResponseBody value) throws IOException,RequestException {
        String response = value.string();
        H httpStatus;
        try {
            httpStatus = gson.fromJson(response,httpStatusClass);//只对外围的请求相应状态字段解析
        }catch (Exception e){
//            LogUtil.d("外围字段转HttpStatus异常");
            return null;
        }
        if (!httpStatus.requestIfSuccess()) {//判断是否请求成功
            value.close();
//            throw new RequestException(httpStatus.getResult(), httpStatus.getShowMsg());
            throw new RequestException(httpStatus.showMsg());
        }
        MediaType contentType = value.contentType();
        Charset charset = contentType != null ? contentType.charset(UTF_8) : UTF_8;
        InputStream inputStream = new ByteArrayInputStream(response.getBytes());
        Reader reader = new InputStreamReader(inputStream, charset);
        JsonReader jsonReader = gson.newJsonReader(reader);
        try {
            return adapter.read(jsonReader);
        } catch (Exception e){
//            LogUtil.d("Gson转实体异常");
            return null;
        } finally {
            value.close();
        }
    }
}
