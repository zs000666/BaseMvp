package bwie.com.basemvp.application;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * date:2019/7/12
 * name:windy
 * function:fresco初始化
 */
public class WdApp extends Application {
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
        //fresco初始化
        Fresco.initialize(this);
    }
}
