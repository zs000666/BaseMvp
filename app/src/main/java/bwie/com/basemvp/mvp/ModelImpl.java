package bwie.com.basemvp.mvp;

import java.util.HashMap;

import javax.security.auth.callback.Callback;

import bwie.com.basemvp.api.ApiData;
import bwie.com.basemvp.entry.LoginEntry;
import bwie.com.basemvp.net.HttpUtils;
import bwie.com.lib_core.base.mvp.BaseModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * date:2019/7/13
 * name:windy
 * function:M层
 */
public class ModelImpl implements Controller.Model {

    @Override
    public void GetUser(HashMap<String, String> parms, final Callback callback) {
        HttpUtils.httpUtils().creat(ApiData.class).getLog(parms)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginEntry>() {
                    @Override
                    public void accept(LoginEntry loginEntry) throws Exception {

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
}
