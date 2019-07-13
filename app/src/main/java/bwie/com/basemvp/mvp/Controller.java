package bwie.com.basemvp.mvp;

import java.util.HashMap;

import javax.security.auth.callback.Callback;

import bwie.com.basemvp.entry.LoginEntry;
import bwie.com.basemvp.net.CallBack;
import bwie.com.lib_core.base.mvp.BaseModel;
import bwie.com.lib_core.base.mvp.BasePresenter;
import bwie.com.lib_core.base.mvp.BaseView;

/**
 * date:2019/7/13
 * name:windy
 * function:基类
 */
public interface Controller {
    interface Model extends BaseModel {
        void GetUser(HashMap<String,String>parms, CallBack callback);
    }
    interface View extends BaseView {
        void LoginUser(LoginEntry loginEntry);
    }
    abstract class Presenter extends BasePresenter<Model,View>{
        public abstract void ShowUser(HashMap<String,String>parms);

        @Override
        public Model getModel() {
            return model;
        }
    }
}
