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

    public int getxTilt() {
        return xTilt;
    }

    public void setxTilt(int xTilt) {
        this.xTilt = xTilt;
    }

    public int getyTilt() {
        return yTilt;
    }

    public void setyTilt(int yTilt) {
        this.yTilt = yTilt;
    }
}
