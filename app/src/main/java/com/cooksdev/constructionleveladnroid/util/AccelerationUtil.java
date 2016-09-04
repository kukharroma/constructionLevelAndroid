package com.cooksdev.constructionleveladnroid.util;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;

import com.cooksdev.constructionleveladnroid.model.AccelerationDegrees;

/**
 * Created by roma on 03.09.16.
 */
public class AccelerationUtil {

    private static int BINARY_POWER = 2;
    private static int X_POSITION = 0;
    private static int Y_POSITION = 1;
    private static int Z_POSITION = 2;


    public static AccelerationDegrees getDegreesFromSensorEvent(SensorEvent event) {
        return getDegreesFromAccelerationData(event.values);
    }

    public static AccelerationDegrees getDegreesFromAccelerationData(float[] acceleration) {
        float x = acceleration[X_POSITION];
        float y = acceleration[Y_POSITION];
        float z = acceleration[Z_POSITION];

        double accelerationVector = getAccelerationVector(x, y, z);

        x = (float) (x / accelerationVector);
        y = (float) (y / accelerationVector);

        int xDegrees = (int) Math.round(Math.toDegrees(Math.atan2(x, y)));
        int yDegrees = (int) Math.round(Math.toDegrees(Math.atan2(y, x)));

        return new AccelerationDegrees(xDegrees, yDegrees);
    }

    private static double getAccelerationVector(float x, float y, float z) {
        return Math.sqrt(Math.pow(x, BINARY_POWER)
                + Math.pow(y, BINARY_POWER)
                + Math.pow(z, BINARY_POWER));
    }

}
