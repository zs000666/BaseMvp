package bwie.com.lib_core.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gyf.barlibrary.ImmersionBar;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * date:2019/7/13
 * name:windy
 * function:
 */
public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayout());
        bind = ButterKnife.bind(this);
        bindView();
        init();
    }

    public void init(){
        //沉浸式
        ImmersionBar.with(this).transparentBar().statusBarDarkFont(true).init();
    }

    protected abstract void bindView();

    protected abstract int bindLayout();
    /**
     * 无参跳转
     *
     * @param clz
     */
    public void intent(Class<?> clz){
      startActivity(new Intent(this,clz));
    }
}
