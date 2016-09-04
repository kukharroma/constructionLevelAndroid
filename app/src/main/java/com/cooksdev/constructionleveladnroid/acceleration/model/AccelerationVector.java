package com.cooksdev.constructionleveladnroid.acceleration.model;

/**
 * Created by roma on 03.09.16.
 *
 * Represents value of acceleration vector.
 */
public class AccelerationVector {
    private double vector;

    public AccelerationVector(double vector) {
        this.vector = vector;
    }

    public double getVector() {
        return vector;
    }

    public void setVector(double vector) {
        this.vector = vector;
    }
}
