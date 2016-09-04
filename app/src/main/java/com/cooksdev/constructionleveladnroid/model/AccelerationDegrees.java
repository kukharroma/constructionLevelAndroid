package com.cooksdev.constructionleveladnroid.model;

/**
 * Created by roma on 03.09.16.
 */
public class AccelerationDegrees {
    private int xTilt;
    private int yTilt;

    public AccelerationDegrees(int xTilt, int yTilt) {
        this.xTilt = xTilt;
        this.yTilt = yTilt;
    }

    public int getXTilt() {
        return xTilt;
    }

    public void setXTilt(int xTilt) {
        this.xTilt = xTilt;
    }

    public int getYTilt() {
        return yTilt;
    }

    public void setYTilt(int yTilt) {
        this.yTilt = yTilt;
    }
}
