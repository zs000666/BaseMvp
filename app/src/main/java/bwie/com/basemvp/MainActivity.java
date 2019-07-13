package bwie.com.basemvp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.blankj.utilcode.util.SPUtils;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import bwie.com.basemvp.entry.LoginEntry;
import bwie.com.basemvp.mvp.Controller;
import bwie.com.basemvp.mvp.PresenterImpl;
import bwie.com.lib_core.base.BaseActivity;
import bwie.com.lib_core.base.BaseMvpActivity;
import bwie.com.lib_core.base.mvp.BaseModel;
import bwie.com.lib_core.base.mvp.BasePresenter;
import bwie.com.lib_core.base.mvp.BaseView;

public abstract class MainActivity extends BaseMvpActivity<Controller.Model, PresenterImpl> implements Controller.View{
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.password)
    EditText password;
    private HashMap<String, String> parms;
    private String string;
    private PresenterImpl presenter;
    @Override
    protected void bindView() {
        string = SPUtils.getInstance().getString("phone");
        if (!string.equals("")) {
            phone.setText(string);
        }
        presenter=new PresenterImpl();
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("phone");
        phone.setText(stringExtra);
    }
    @OnClick(R.id.login)
    public void Login(View view){
        String sphone = phone.getText().toString();
        String spwd = password.getText().toString();
        parms = new HashMap<>();
        parms.put("phone",sphone);
        parms.put("pwd",spwd);
        presenter.ShowUser(parms);
    }


    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void LoginUser(LoginEntry loginEntry) {
        if (loginEntry.getMessage().equals("登录成功")){
            SPUtils.getInstance().put("Image",loginEntry.getResult().getHeadPic());
            SPUtils.getInstance().put("Name",loginEntry.getResult().getNickName());
            SPUtils.getInstance().put("userId",loginEntry.getResult().getUserId()+"");
            SPUtils.getInstance().put("sessionId",loginEntry.getResult().getSessionId());
            Intent intent=new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);
        }
    }

}

