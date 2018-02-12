package com.summer.mvpandroidframe.network.entity.response;

/**
 * Created by xiahailiang on 2018/2/12.
 */

public class BaseHeader {
    protected int code;
    protected String msg;
    protected boolean alert;
    protected long time;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isAlert() {
        return alert;
    }

    public void setAlert(boolean alert) {
        this.alert = alert;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "BaseHeader{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", alert=" + alert +
                ", time=" + time +
                '}';
    }
}
