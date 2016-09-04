package com.cooksdev.constructionleveladnroid.presenter;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import com.cooksdev.constructionleveladnroid.model.AccelerationDegrees;
import com.cooksdev.constructionleveladnroid.ui.activity.AccelerometerActivity;
import com.cooksdev.constructionleveladnroid.util.AccelerationUtil;

/**
 * Created by roma on 03.09.16.
 */
public class AccelerometerPresenter {

    private AccelerometerActivity view;

    private SensorManager sensorManager;
    private Sensor sensorAccelerometer;
    private AccelerometerListener accelerometerListener;

    public AccelerometerPresenter(AccelerometerActivity view) {
        this.view = view;
    }

    public void registerAccelerometer() {
        accelerometerListener = new AccelerometerListener();
        sensorManager = (SensorManager) view.getSystemService(Context.SENSOR_SERVICE);
        sensorAccelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(accelerometerListener, sensorAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void unregisterAccelerometer() {
        sensorManager.unregisterListener(accelerometerListener);
    }

    class AccelerometerListener implements SensorEventListener {
        @Override
        public void onSensorChanged(SensorEvent event) {
            AccelerationDegrees accelerationDegrees = AccelerationUtil.getDegreesFromAccelerationData(event.values);
            view.updateDegreesInfo(accelerationDegrees);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    }

}
