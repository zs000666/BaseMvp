package bwie.com.basemvp.api;

import java.util.HashMap;

import bwie.com.basemvp.entry.LoginEntry;
import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * date:2019/7/13
 * name:windy
 * function:实现
 */
public interface ApiData {
     @POST(Api.LOGIN_URL)
    @FormUrlEncoded
    Observable<LoginEntry>getLog(@FieldMap HashMap<String,String> parms);
}
