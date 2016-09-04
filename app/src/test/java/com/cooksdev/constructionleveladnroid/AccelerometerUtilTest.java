package com.cooksdev.constructionleveladnroid;

import com.cooksdev.constructionleveladnroid.model.AccelerationDegrees;
import com.cooksdev.constructionleveladnroid.util.AccelerationUtil;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by roma on 04.09.16.
 * <p/>
 * Tests AccelerometerUtil in different various
 * of angles in portrait and horizontal orientation
 * angles (0˚, 30˚, 45˚, 60˚, 90˚, 135˚, 180˚).
 */
public class AccelerometerUtilTest {

    @Test
    public void testPortrait_0() {
        float[] acceleration = new float[3];
        acceleration[0] = -0.008972168f;
        acceleration[1] = 8.689789f;
        acceleration[2] = 2.704071f;

        int xExpectedTilt = 0;
        int yExpectedTilt = 90;

        AccelerationDegrees actual = AccelerationUtil.getDegreesFromAccelerationData(acceleration);

        assertEquals(xExpectedTilt, actual.getXTilt());
        assertEquals(yExpectedTilt, actual.getYTilt());
    }

    @Test
    public void testPortrait_30() {
        float[] acceleration = new float[3];
        acceleration[0] = 4.205353f;
        acceleration[1] = 7.2865753f;
        acceleration[2] = 4.0505676f;

        int xExpectedTilt = 30;
        int yExpectedTilt = 60;

        AccelerationDegrees actual = AccelerationUtil.getDegreesFromAccelerationData(acceleration);

        assertEquals(xExpectedTilt, actual.getXTilt());
        assertEquals(yExpectedTilt, actual.getYTilt());
    }

    @Test
    public void testPortrait_45() {
        float[] acceleration = new float[3];
        acceleration[0] = 5.991516f;
        acceleration[1] = 5.9599915f;
        acceleration[2] = 4.246811f;

        int xExpectedTilt = 45;
        int yExpectedTilt = 45;

        AccelerationDegrees actual = AccelerationUtil.getDegreesFromAccelerationData(acceleration);

        assertEquals(xExpectedTilt, actual.getXTilt());
        assertEquals(yExpectedTilt, actual.getYTilt());
    }

    @Test
    public void testPortrait_60() {
        float[] acceleration = new float[3];
        acceleration[0] = 6.69606f;
        acceleration[1] = 3.9336548f;
        acceleration[2] = 5.469208f;

        int xExpectedTilt = 60;
        int yExpectedTilt = 30;

        AccelerationDegrees actual = AccelerationUtil.getDegreesFromAccelerationData(acceleration);

        assertEquals(xExpectedTilt, actual.getXTilt());
        assertEquals(yExpectedTilt, actual.getYTilt());
    }

    @Test
    public void testPortrait_90() {
        float[] acceleration = new float[3];
        acceleration[0] = 9.066681f;
        acceleration[1] = -0.05117798f;
        acceleration[2] = 3.7922668f;

        int xExpectedTilt = 90;
        int yExpectedTilt = 0;

        AccelerationDegrees actual = AccelerationUtil.getDegreesFromAccelerationData(acceleration);

        assertEquals(xExpectedTilt, actual.getXTilt());
        assertEquals(yExpectedTilt, actual.getYTilt());
    }

    @Test
    public void testPortrait_135() {
        float[] acceleration = new float[3];
        acceleration[0] = 6.638687f;
        acceleration[1] = -6.5649567f;
        acceleration[2] = 3.600235f;

        int xExpectedTilt = 135;
        int yExpectedTilt = -45;

        AccelerationDegrees actual = AccelerationUtil.getDegreesFromAccelerationData(acceleration);

        assertEquals(xExpectedTilt, actual.getXTilt());
        assertEquals(yExpectedTilt, actual.getYTilt());
    }

    @Test
    public void testPortrait_180() {
        float[] acceleration = new float[3];
        acceleration[0] = 0.029006958f;
        acceleration[1] = -9.12262f;
        acceleration[2] = 3.9163666f;

        int xExpectedTilt = 180;
        int yExpectedTilt = -90;

        AccelerationDegrees actual = AccelerationUtil.getDegreesFromAccelerationData(acceleration);

        assertEquals(xExpectedTilt, actual.getXTilt());
        assertEquals(yExpectedTilt, actual.getYTilt());
    }

    @Test
    public void testHorizontal_0() {
        float[] acceleration = new float[3];
        acceleration[0] = 7.8304596f;
        acceleration[1] = -0.05630493f;
        acceleration[2] = 5.808563f;

        int yExpectedTilt = 0;
        int xExpectedTilt = 90;

        AccelerationDegrees actual = AccelerationUtil.getDegreesFromAccelerationData(acceleration);

        assertEquals(xExpectedTilt, actual.getXTilt());
        assertEquals(yExpectedTilt, actual.getYTilt());
    }

    @Test
    public void testHorizontal_30() {
        float[] acceleration = new float[3];
        acceleration[0] = 7.5107574f;
        acceleration[1] = 4.355362f;
        acceleration[2] = 3.984314f;

        int yExpectedTilt = 30;
        int xExpectedTilt = 60;

        AccelerationDegrees actual = AccelerationUtil.getDegreesFromAccelerationData(acceleration);
        assertEquals(yExpectedTilt, actual.getYTilt());
        assertEquals(xExpectedTilt, actual.getXTilt());
    }

    @Test
    public void testHorizontal_45() {
        float[] acceleration = new float[3];
        acceleration[0] = 5.991516f;
        acceleration[1] = 5.9599915f;
        acceleration[2] = 4.246811f;

        int yExpectedTilt = 45;
        int xExpectedTilt = 45;

        AccelerationDegrees actual = AccelerationUtil.getDegreesFromAccelerationData(acceleration);
        assertEquals(yExpectedTilt, actual.getYTilt());
        assertEquals(xExpectedTilt, actual.getXTilt());
    }

    @Test
    public void testHorizontal_60() {
        float[] acceleration = new float[3];
        acceleration[0] = 4.1101227f;
        acceleration[1] = 7.200485f;
        acceleration[2] = 4.127533f;

        int yExpectedTilt = 60;
        int xExpectedTilt = 30;

        AccelerationDegrees actual = AccelerationUtil.getDegreesFromAccelerationData(acceleration);
        assertEquals(yExpectedTilt, actual.getYTilt());
        assertEquals(xExpectedTilt, actual.getXTilt());
    }

    @Test
    public void testHorizontal_90() {
        float[] acceleration = new float[3];
        acceleration[0] = 0.004333496f;
        acceleration[1] = 8.273331f;
        acceleration[2] = 3.719345f;

        int yExpectedTilt = 90;
        int xExpectedTilt = 0;

        AccelerationDegrees actual = AccelerationUtil.getDegreesFromAccelerationData(acceleration);
        assertEquals(yExpectedTilt, actual.getYTilt());
        assertEquals(xExpectedTilt, actual.getXTilt());
    }

    @Test
    public void testHorizontal_135() {
        float[] acceleration = new float[3];
        acceleration[0] = -5.3162994f;
        acceleration[1] = 5.226822f;
        acceleration[2] = 4.84552f;

        int yExpectedTilt = 135;
        int xExpectedTilt = -45;

        AccelerationDegrees actual = AccelerationUtil.getDegreesFromAccelerationData(acceleration);
        assertEquals(yExpectedTilt, actual.getYTilt());
        assertEquals(xExpectedTilt, actual.getXTilt());
    }

    @Test
    public void testHorizontal_180() {
        float[] acceleration = new float[3];
        acceleration[0] = -8.126541f;
        acceleration[1] = 0.06311035f;
        acceleration[2] = 3.8546753f;

        int yExpectedTilt = 180;
        int xExpectedTilt = -90;

        AccelerationDegrees actual = AccelerationUtil.getDegreesFromAccelerationData(acceleration);
        assertEquals(yExpectedTilt, actual.getYTilt());
        assertEquals(xExpectedTilt, actual.getXTilt());
    }

}
