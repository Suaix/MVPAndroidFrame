package com.summer.mvpandroidframe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.summer.library.mvpbase.BaseMVPAppcompatActivity;
import com.summer.library.mvpbase.IUI;
import com.summer.mvpandroidframe.data.MessageEvent;

import eventbus.EventBus;
import eventbus.Subscribe;
import eventbus.ThreadMode;

public class MainActivity extends BaseMVPAppcompatActivity<MainPrensenter> {

    private Button bt;
    private TextView tv;
    private Button btSendEvent;

    @Override
    protected void onCreateExecute(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        initView();
        addListener();
    }

    /**
     * 初始化布局控件
     */
    private void initView() {
        bt = findViewById(R.id.bt_add_data);
        tv = findViewById(R.id.tv_content);
        btSendEvent = findViewById(R.id.bt_send_event);
    }

    /**
     * 给控件添加Listener
     */
    private void addListener() {
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().test();
            }
        });
        btSendEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new MessageEvent("This is message from event bus"));
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

    @Override
    protected boolean isBindEventBusHere() {
        return true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessagEvent(MessageEvent event){
        tv.setText(event.getMessage());
    }
}
