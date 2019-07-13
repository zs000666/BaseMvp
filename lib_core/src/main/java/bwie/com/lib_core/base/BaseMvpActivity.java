package bwie.com.lib_core.base;

import bwie.com.lib_core.base.mvp.BaseModel;
import bwie.com.lib_core.base.mvp.BasePresenter;
import bwie.com.lib_core.base.mvp.BaseView;

/**
 * date:2019/7/13
 * name:windy
 * function:
 */
public abstract class BaseMvpActivity <M extends BaseModel,P extends BasePresenter>extends BaseActivity implements BaseView {

    public M model;
    public P presenter;
    @Override
    protected void bindView() {
     presenter=(P)initPresenter();
     if (presenter!=null){
       model=(M)presenter.getModel();
      if (model!=null){
        presenter.attach(model,this);
      }
     }
     initDataEr();
    }

    protected abstract void initDataEr();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter!=null){
            presenter.dettach();
        }
    }
}
