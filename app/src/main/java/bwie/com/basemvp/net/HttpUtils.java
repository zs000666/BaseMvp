package bwie.com.basemvp.net;

import java.net.HttpURLConnection;
import java.util.concurrent.TimeUnit;

import bwie.com.basemvp.api.Api;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * date:2019/7/13
 * name:windy
 * function:工具类
 */
public class HttpUtils {
  private static HttpUtils getInstance;
  private Retrofit retrofit;
  private OkHttpClient okHttpClient;

  private HttpUtils(){
      //日志缓冲
      okHttpClient=new OkHttpClient.Builder()
           .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
           .readTimeout(10, TimeUnit.SECONDS)
           .writeTimeout(10,TimeUnit.SECONDS)
           .connectTimeout(10,TimeUnit.SECONDS)
           .addNetworkInterceptor(new HttpLoggingInterceptor())
           .build();
      //retrofit
      retrofit=new Retrofit.Builder()
              .client(okHttpClient)
              .baseUrl(Api.BASE_URL)
              .addConverterFactory(GsonConverterFactory.create())
              .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
              .build();
  }
      //枷锁
    public static HttpUtils httpUtils(){
      if (getInstance==null){
          synchronized (HttpUtils.class){
              if (getInstance==null){
                  getInstance=new HttpUtils();
              }
          }
      }
      return getInstance;
    }
    public <T>T creat(Class<T> clz){
        return retrofit.create(clz);
    }
}
