package com.summer.mvpandroidframe;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.summer.library.mvpbase.BaseMVPAppcompatActivity;
import com.summer.library.mvpbase.IUI;

public class MainActivity extends BaseMVPAppcompatActivity<MainPrensenter> {

    private Button bt;
    private TextView tv;

    /**
     * 获取布局资源的id，用来填充页面
     *
     * @return 页面布局id
     */
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    /**
     * 初始化布局控件
     */
    @Override
    protected void initView() {
        bt = findViewById(R.id.bt_add_data);
        tv = findViewById(R.id.tv_content);
    }

    /**
     * 给控件添加Listener
     */
    @Override
    protected void addListener() {
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().test();
            }
        });
    }

    /**
     * 创建Presenter
     *
     * @return Presenter
     */
    @Override
    protected MainPrensenter createPresenter() {
        return new MainPrensenter();
    }

    /**
     * 获取IUI实例
     *
     * @return IUI实例
     */
    @Override
    protected IUI getUI() {
        return this;
    }

    public void onTestResult(String result){
        tv.setText(result);
    }
}
