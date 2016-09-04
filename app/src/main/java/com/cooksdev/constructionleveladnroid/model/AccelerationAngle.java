package com.cooksdev.constructionleveladnroid.model;

/**
 * Created by roma on 03.09.16.
 *
 * Represents angle of X and Y axis.
 */

public class AccelerationAngle {
    private int xAngle;
    private int yAngle;

    public AccelerationAngle(int xAngle, int yAngle) {
        this.xAngle = xAngle;
        this.yAngle = yAngle;
    }

    public int getXAngle() {
        return xAngle;
    }

    public void setXAngle(int xAngle) {
        this.xAngle = xAngle;
    }

    public int getYAngle() {
        return yAngle;
    }

    public void setYAngle(int yAngle) {
        this.yAngle = yAngle;
    }
}
