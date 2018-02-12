package com.summer.mvpandroidframe.network.entity.data;

/**
 * Created by xiahailiang on 2018/2/12.
 */

public class DataTest implements BaseData {
    private static final long serialVersionUID = -8487668922240252288L;
    private boolean novelTabSwitch;

    public boolean isNovelTabSwitch() {
        return novelTabSwitch;
    }

    public void setNovelTabSwitch(boolean novelTabSwitch) {
        this.novelTabSwitch = novelTabSwitch;
    }

    @Override
    public String toString() {
        return "DataTest{" +
                "novelTabSwitch=" + novelTabSwitch +
                '}';
    }
}
