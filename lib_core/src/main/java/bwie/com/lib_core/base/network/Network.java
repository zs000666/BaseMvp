package bwie.com.lib_core.base.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;

import bwie.com.lib_core.R;

/**
 * date:2019/7/13
 * name:windy
 * function:网络监听
 */
public class Network {
    public static final int NETWORK_NONE = -1;
    public static final int NETWORK_MOBLE = 0;

    public static Context mContext;

    public static void init(Context context) {
        mContext = context;
    }

    public static int getNetworkMoble() {
        if (mContext == null) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    return NETWORK_MOBLE;
                } else {
                    return NETWORK_NONE;
                }
            }
        }
        return NETWORK_MOBLE;
    }
}