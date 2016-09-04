package com.cooksdev.constructionleveladnroid.acceleration;

import android.hardware.SensorEvent;

import com.cooksdev.constructionleveladnroid.acceleration.model.AccelerationAngle;
import com.cooksdev.constructionleveladnroid.acceleration.model.AccelerationVector;

/**
 * Created by roma on 03.09.16.
 * <p/>
 * Converts acceleration data from (X, Y, Z) axis to
 * the angles of inclination of the device to the ground.
 */
public class AccelerationUtil {

    private static int BINARY_POWER = 2;

    private static int X_AXIS_POSITION = 0;
    private static int Y_AXIS_POSITION = 1;
    private static int Z_AXIS_POSITION = 2;

    /**
     * Return AccelerationAngle instance witch contains angles
     * of inclination of the device to the ground.
     *
     * @param event {@link SensorEvent#values data}.
     * @return {@link AccelerationAngle}
     */

    public static AccelerationAngle getAnglesFromSensorEvent(SensorEvent event) {
        return getAnglesFromAccelerationData(event.values);
    }

    /**
     * Return AccelerationAngle instance witch contains angles
     * of inclination of the device to the ground.
     *
     * @param acceleration data like this  {@link SensorEvent#values data}.
     * @return {@link AccelerationAngle}
     */
    public static AccelerationAngle getAnglesFromAccelerationData(float[] acceleration) {
        float X_AXIS = acceleration[X_AXIS_POSITION];
        float Y_AXIS = acceleration[Y_AXIS_POSITION];
        float Z_AXIS = acceleration[Z_AXIS_POSITION];

        AccelerationVector accelerationVector = getAccelerationVector(X_AXIS, Y_AXIS, Z_AXIS);

        X_AXIS = (float) (X_AXIS / accelerationVector.getVector());
        Y_AXIS = (float) (Y_AXIS / accelerationVector.getVector());

        int xDegrees = (int) Math.round(Math.toDegrees(Math.atan2(X_AXIS, Y_AXIS)));
        int yDegrees = (int) Math.round(Math.toDegrees(Math.atan2(Y_AXIS, X_AXIS)));

        return new AccelerationAngle(xDegrees, yDegrees);
    }

    /**
     * Returns AccelerationVector from (X, Y, Z) axis
     *
     * @param x acceleration from X axis
     * @param y acceleration from Y axis
     * @param z acceleration from Z axis
     * @return {@link AccelerationVector}
     */
    public static AccelerationVector getAccelerationVector(float x, float y, float z) {
        return new AccelerationVector(Math.sqrt(Math.pow(x, BINARY_POWER)
                + Math.pow(y, BINARY_POWER)
                + Math.pow(z, BINARY_POWER)));
    }

}
