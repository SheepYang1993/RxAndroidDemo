package me.sheepyang.rxandroiddemo.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import butterknife.ButterKnife;
import me.sheepyang.rxandroiddemo.util.AppManager;
import me.sheepyang.rxandroiddemo.util.LogUtils;
import me.sheepyang.rxandroiddemo.util.ToastUtils;


/**
 * Created by Administrator on 2016-12-12.
 */

public abstract class BaseActivity extends AppCompatActivity {
    public Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        ButterKnife.bind(this);
        mContext = this;
        // 添加Activity到堆栈
        AppManager.getAppManager().addActivity(this);
    }

    public abstract
    @LayoutRes
    int setLayoutId();

    public void setBarTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
            getSupportActionBar().setTitle(title);
        }
    }

    public void showToast(int resId) {
        if (!this.isFinishing()) {
            ToastUtils.showShortToast(this, resId);
        }
    }

    public void showToast(String msg) {
        if (!this.isFinishing()) {
            ToastUtils.showShortToast(this, msg);
        }
    }

    public void log(Object msg) {
        LogUtils.i(msg);
    }
}
