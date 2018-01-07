package com.summer.library.utils;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

/**
 * @autho xia
 * @date 2018/1/7 下午4:46
 * @desciption Toast同一管理类，用来展示Toast
 */
public class ToastUtils {
    public static final String TAG = "ToastUtils";
    public static boolean isShow = true;

    private static Handler mHandler;
    private static Toast mToast;
    private static Context mContext;

    public static void init(Context context) {
        isShow = true;
        mContext = context;
        mHandler = new Handler();
        mToast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
    }

    public static void dismissToast() {
        isShow = false;
    }

    /**
     * 短时间显示Toast
     *
     * @param message
     */
    public static void showToastShort(final String message) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                if (isShow) {
                    Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    /**
     * 长时间显示Toast
     *
     * @param message
     */
    public static void showToastLong(final String message) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                if (isShow) {
                    Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    /**
     * 自定义显示Toast时间
     *
     * @param message
     * @param duration
     */
    public static void showToastDuration(final String message, final int duration) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                if (isShow) {
                    Toast.makeText(mContext, message, duration).show();
                }
            }
        });

    }
}
