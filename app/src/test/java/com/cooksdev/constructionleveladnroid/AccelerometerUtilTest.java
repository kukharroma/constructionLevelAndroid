package com.cooksdev.constructionleveladnroid;

import com.cooksdev.constructionleveladnroid.model.AccelerationAngle;
import com.cooksdev.constructionleveladnroid.util.AccelerationUtil;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by roma on 04.09.16.
 * <p/>
 * Tests AccelerometerUtil in different various
 * of angles in portrait and horizontal orientation.
 * Angles : 0˚, 30˚, 45˚, 60˚, 90˚, 135˚, 180˚.
 */
public class AccelerometerUtilTest {

    @Test
    public void testPortrait_0() {
        float[] acceleration = new float[3];
        acceleration[0] = -0.008972168f;
        acceleration[1] = 8.689789f;
        acceleration[2] = 2.704071f;

        int xExpectedAngle = 0;
        int yExpectedAngle = 90;

        AccelerationAngle actual = AccelerationUtil.getAnglesFromAccelerationData(acceleration);

        assertEquals(xExpectedAngle, actual.getXAngle());
        assertEquals(yExpectedAngle, actual.getYAngle());
    }

    @Test
    public void testPortrait_30() {
        float[] acceleration = new float[3];
        acceleration[0] = 4.205353f;
        acceleration[1] = 7.2865753f;
        acceleration[2] = 4.0505676f;

        int xExpectedAngle = 30;
        int yExpectedAngle = 60;

        AccelerationAngle actual = AccelerationUtil.getAnglesFromAccelerationData(acceleration);

        assertEquals(xExpectedAngle, actual.getXAngle());
        assertEquals(yExpectedAngle, actual.getYAngle());
    }

    @Test
    public void testPortrait_45() {
        float[] acceleration = new float[3];
        acceleration[0] = 5.991516f;
        acceleration[1] = 5.9599915f;
        acceleration[2] = 4.246811f;

        int xExpectedAngle = 45;
        int yExpectedAngle = 45;

        AccelerationAngle actual = AccelerationUtil.getAnglesFromAccelerationData(acceleration);

        assertEquals(xExpectedAngle, actual.getXAngle());
        assertEquals(yExpectedAngle, actual.getYAngle());
    }

    @Test
    public void testPortrait_60() {
        float[] acceleration = new float[3];
        acceleration[0] = 6.69606f;
        acceleration[1] = 3.9336548f;
        acceleration[2] = 5.469208f;

        int xExpectedAngle = 60;
        int yExpectedAngle = 30;

        AccelerationAngle actual = AccelerationUtil.getAnglesFromAccelerationData(acceleration);

        assertEquals(xExpectedAngle, actual.getXAngle());
        assertEquals(yExpectedAngle, actual.getYAngle());
    }

    @Test
    public void testPortrait_90() {
        float[] acceleration = new float[3];
        acceleration[0] = 9.066681f;
        acceleration[1] = -0.05117798f;
        acceleration[2] = 3.7922668f;

        int xExpectedAngle = 90;
        int yExpectedAngle = 0;

        AccelerationAngle actual = AccelerationUtil.getAnglesFromAccelerationData(acceleration);

        assertEquals(xExpectedAngle, actual.getXAngle());
        assertEquals(yExpectedAngle, actual.getYAngle());
    }

    @Test
    public void testPortrait_135() {
        float[] acceleration = new float[3];
        acceleration[0] = 6.638687f;
        acceleration[1] = -6.5649567f;
        acceleration[2] = 3.600235f;

        int xExpectedAngle = 135;
        int yExpectedAngle = -45;

        AccelerationAngle actual = AccelerationUtil.getAnglesFromAccelerationData(acceleration);

        assertEquals(xExpectedAngle, actual.getXAngle());
        assertEquals(yExpectedAngle, actual.getYAngle());
    }

    @Test
    public void testPortrait_180() {
        float[] acceleration = new float[3];
        acceleration[0] = 0.029006958f;
        acceleration[1] = -9.12262f;
        acceleration[2] = 3.9163666f;

        int xExpectedAngle = 180;
        int yExpectedAngle = -90;

        AccelerationAngle actual = AccelerationUtil.getAnglesFromAccelerationData(acceleration);

        assertEquals(xExpectedAngle, actual.getXAngle());
        assertEquals(yExpectedAngle, actual.getYAngle());
    }

    @Test
    public void testHorizontal_0() {
        float[] acceleration = new float[3];
        acceleration[0] = 7.8304596f;
        acceleration[1] = -0.05630493f;
        acceleration[2] = 5.808563f;

        int yExpectedAngle = 0;
        int xExpectedAngle = 90;

        AccelerationAngle actual = AccelerationUtil.getAnglesFromAccelerationData(acceleration);
        assertEquals(yExpectedAngle, actual.getYAngle());
        assertEquals(xExpectedAngle, actual.getXAngle());
    }

    @Test
    public void testHorizontal_30() {
        float[] acceleration = new float[3];
        acceleration[0] = 7.5107574f;
        acceleration[1] = 4.355362f;
        acceleration[2] = 3.984314f;

        int yExpectedAngle = 30;
        int xExpectedAngle = 60;

        AccelerationAngle actual = AccelerationUtil.getAnglesFromAccelerationData(acceleration);
        assertEquals(yExpectedAngle, actual.getYAngle());
        assertEquals(xExpectedAngle, actual.getXAngle());
    }

    @Test
    public void testHorizontal_45() {
        float[] acceleration = new float[3];
        acceleration[0] = 5.991516f;
        acceleration[1] = 5.9599915f;
        acceleration[2] = 4.246811f;

        int yExpectedAngle = 45;
        int xExpectedAngle = 45;

        AccelerationAngle actual = AccelerationUtil.getAnglesFromAccelerationData(acceleration);
        assertEquals(yExpectedAngle, actual.getYAngle());
        assertEquals(xExpectedAngle, actual.getXAngle());
    }

    @Test
    public void testHorizontal_60() {
        float[] acceleration = new float[3];
        acceleration[0] = 4.1101227f;
        acceleration[1] = 7.200485f;
        acceleration[2] = 4.127533f;

        int yExpectedAngle = 60;
        int xExpectedAngle = 30;

        AccelerationAngle actual = AccelerationUtil.getAnglesFromAccelerationData(acceleration);
        assertEquals(yExpectedAngle, actual.getYAngle());
        assertEquals(xExpectedAngle, actual.getXAngle());
    }

    @Test
    public void testHorizontal_90() {
        float[] acceleration = new float[3];
        acceleration[0] = 0.004333496f;
        acceleration[1] = 8.273331f;
        acceleration[2] = 3.719345f;

        int yExpectedAngle = 90;
        int xExpectedAngle = 0;

        AccelerationAngle actual = AccelerationUtil.getAnglesFromAccelerationData(acceleration);
        assertEquals(yExpectedAngle, actual.getYAngle());
        assertEquals(xExpectedAngle, actual.getXAngle());
    }

    @Test
    public void testHorizontal_135() {
        float[] acceleration = new float[3];
        acceleration[0] = -5.3162994f;
        acceleration[1] = 5.226822f;
        acceleration[2] = 4.84552f;

        int yExpectedAngle = 135;
        int xExpectedAngle = -45;

        AccelerationAngle actual = AccelerationUtil.getAnglesFromAccelerationData(acceleration);
        assertEquals(yExpectedAngle, actual.getYAngle());
        assertEquals(xExpectedAngle, actual.getXAngle());
    }

    @Test
    public void testHorizontal_180() {
        float[] acceleration = new float[3];
        acceleration[0] = -8.126541f;
        acceleration[1] = 0.06311035f;
        acceleration[2] = 3.8546753f;

        int yExpectedAngle = 180;
        int xExpectedAngle = -90;

        AccelerationAngle actual = AccelerationUtil.getAnglesFromAccelerationData(acceleration);
        assertEquals(yExpectedAngle, actual.getYAngle());
        assertEquals(xExpectedAngle, actual.getXAngle());
    }

}
