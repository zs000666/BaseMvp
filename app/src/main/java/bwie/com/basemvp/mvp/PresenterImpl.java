package bwie.com.basemvp.mvp;

import java.util.HashMap;

import bwie.com.basemvp.entry.LoginEntry;
import bwie.com.basemvp.net.CallBack;

/**
 * date:2019/7/13
 * name:windy
 * function:P层
 */
public class PresenterImpl extends Controller.Presenter{


    @Override
    public void ShowUser(HashMap<String, String> parms) {
        model.GetUser(parms, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                view.LoginUser((LoginEntry) object);
            }

            @Override
            public void onFail(String string) {
                System.out.print(string);
            }
        });
    }
}
