package com.cooksdev.constructionleveladnroid.presenter;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import com.cooksdev.constructionleveladnroid.model.AccelerationDegrees;
import com.cooksdev.constructionleveladnroid.ui.activity.AccelerometerActivity;
import com.cooksdev.constructionleveladnroid.util.AccelerationUtil;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by roma on 03.09.16.
 */
public class AccelerometerPresenter {

    private AccelerometerActivity view;

    private SensorManager sensorManager;
    private Sensor sensorAccelerometer;
    private AccelerometerListener accelerometerListener;

    private AccelerometerTask accelerometerTask;
    private Timer accelerometerTimer;

    public AccelerometerPresenter(AccelerometerActivity view) {
        this.view = view;
    }

    public void registerAccelerometer() {
        accelerometerListener = new AccelerometerListener();
        sensorManager = (SensorManager) view.getSystemService(Context.SENSOR_SERVICE);
        sensorAccelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(accelerometerListener, sensorAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);

        if (accelerometerTimer != null) {
            accelerometerTimer.cancel();
        }
        accelerometerTimer = new Timer();
        accelerometerTask = new AccelerometerTask();
        accelerometerTimer.schedule(accelerometerTask, 0, 400);
    }

    public void unregisterAccelerometer() {
        sensorManager.unregisterListener(accelerometerListener);
        accelerometerTimer.cancel();
    }

    float[] sensorValues = new float[3];
    float[] mGravity;
    float[] mGeomagnetic;

    class AccelerometerListener implements SensorEventListener {
        @Override
        public void onSensorChanged(SensorEvent event) {
            for (int i = 0; i < 3; i++) {
                sensorValues[i] = event.values[i];
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    }


    class AccelerometerTask extends TimerTask {

        @Override
        public void run() {
            view.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    AccelerationDegrees accelerationDegrees = AccelerationUtil.getDegreesFromAccelerationData(sensorValues);
                    view.updateDegreesInfo(accelerationDegrees);
                }
            });
        }
    }

}
