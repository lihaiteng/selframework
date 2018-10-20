package com.lht.libretrofit.base;

import android.content.Context;

import com.lht.libretrofit.converter.ReqErrorConverterFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by LiHT on 2017/5/9.
 */

public class RetrofitHelper{

    private OkHttpClient client;
    private OkHttpClient.Builder builder;
    private Retrofit retrofit;

    private RetrofitHelper(){
    }

    public <T>T getiHttpService(Class<T> service){
        return  retrofit.create(service);
    }

    public class Builder<H>{
        private Context context;
        private String baseUrl;
        private int connectTimeout = 15;
        private boolean isDebug = true;
        private Class<H> httpStatus;
        //拦截器集合
        private List<Interceptor> interceptorList;

        public Builder(Context context) {
            this.context = context;
            interceptorList = new ArrayList<>();
            builder = new OkHttpClient.Builder();
            builder.retryOnConnectionFailure(true);//连接失败后是否重新连接
        }

        public String getBaseUrl() {
            return baseUrl;
        }

        public Builder setBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        public int getConnectTimeout() {
            return connectTimeout;
        }

        public Builder setConnectTimeout(int connectTimeout) {
            if(connectTimeout>5 && connectTimeout<30){
                this.connectTimeout = connectTimeout;
            }
            return this;
        }

        public boolean isDebug() {
            return isDebug;
        }

        public Builder setDebug(boolean debug) {
            isDebug = debug;
            return this;
        }

        public Class<H> getHttpStatus() {
            return httpStatus;
        }

        public void setHttpStatus(Class<H> httpStatus) {
            this.httpStatus = httpStatus;
        }

        public Builder addIntercepter(Interceptor interceptor){
            interceptorList.add(interceptor);
            return this;
        }

        public RetrofitHelper build(){
            builder.connectTimeout(connectTimeout, TimeUnit.SECONDS);//超时时间connectTimeout秒

            if(isDebug){
                HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
                logging.setLevel(HttpLoggingInterceptor.Level.BODY);
                builder.addInterceptor(logging);
            }
            //添加拦截器
            for(Interceptor interceptor : interceptorList){
                builder.addInterceptor(interceptor);
            }
            client = builder.build();
            ReqErrorConverterFactory reqErrorConverterFactory = ReqErrorConverterFactory.create();
            reqErrorConverterFactory.setHttpStatusClass(httpStatus);
            retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                    .client(client)//设置okhttp
                    //解析数据   GsonConverterFactory   ReqErrorConverterFactory
                    .addConverterFactory(reqErrorConverterFactory)//TODO lht
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            return new RetrofitHelper();
        }
    }
/**
* 拦截器定义示例
*/
//    public class MustParamsInterceptor implements Interceptor {
//        @Override
//        public okhttp3.Response intercept(Chain chain) throws IOException {
//            if("".equals(UserID)){
//                userInfo = (LoginBean.DataEntity.UserInfoEntity)spUtil.getEntity(AppData.spUsrName);
//                if(userInfo!=null) UserID=userInfo.getUserID();
//            }
//            String usrid = "";
//            userInfo = (LoginBean.DataEntity.UserInfoEntity)spUtil.getEntity(AppData.spUsrName);
//            if(userInfo!=null) usrid=userInfo.getUserID();
//            Request request = chain.request();
//            HttpUrl httpUrl = request.url().newBuilder()
//                    .addQueryParameter("apikey", AppData.apikey)
//                    .addQueryParameter("apisecret", AppData.apisecret)
//                    .addQueryParameter("UserID", usrid)
//                    .build();
//            request = request.newBuilder().url(httpUrl).build();
//            return chain.proceed(request);
//        }
//    }

}
