package com.cooksdev.constructionleveladnroid.util;

import android.hardware.SensorEvent;

import com.cooksdev.constructionleveladnroid.model.AccelerationDegrees;

/**
 * Created by roma on 03.09.16.
 */
public class AccelerationUtil {

    private static int BINARY_POWER = 2;

    private static int X_AXIS_POSITION = 0;
    private static int Y_AXIS_POSITION = 1;
    private static int Z_AXIS_POSITION = 2;


    public static AccelerationDegrees getDegreesFromSensorEvent(SensorEvent event) {
        return getDegreesFromAccelerationData(event.values);
    }

    public static AccelerationDegrees getDegreesFromAccelerationData(float[] acceleration) {
        float X_AXIS = acceleration[X_AXIS_POSITION];
        float Y_AXIS = acceleration[Y_AXIS_POSITION];
        float Z_AXIS = acceleration[Z_AXIS_POSITION];

        double accelerationVector = getAccelerationVector(X_AXIS, Y_AXIS, Z_AXIS);

        X_AXIS = (float) (X_AXIS / accelerationVector);
        Y_AXIS = (float) (Y_AXIS / accelerationVector);

        int xDegrees = (int) Math.round(Math.toDegrees(Math.atan2(X_AXIS, Y_AXIS)));
        int yDegrees = (int) Math.round(Math.toDegrees(Math.atan2(Y_AXIS, X_AXIS)));

        return new AccelerationDegrees(xDegrees, yDegrees);
    }

    private static double getAccelerationVector(float x, float y, float z) {
        return Math.sqrt(Math.pow(x, BINARY_POWER)
                + Math.pow(y, BINARY_POWER)
                + Math.pow(z, BINARY_POWER));
    }

}
