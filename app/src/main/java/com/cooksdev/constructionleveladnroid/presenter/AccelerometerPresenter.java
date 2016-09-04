package com.cooksdev.constructionleveladnroid.presenter;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import com.cooksdev.constructionleveladnroid.model.AccelerationAngle;
import com.cooksdev.constructionleveladnroid.ui.activity.AccelerometerActivity;
import com.cooksdev.constructionleveladnroid.ui.activity.IAccelerometerView;
import com.cooksdev.constructionleveladnroid.util.AccelerationUtil;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by roma on 03.09.16.
 */
public class AccelerometerPresenter {

    private IAccelerometerView view;

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
        sensorManager = (SensorManager) ((AccelerometerActivity) view).getSystemService(Context.SENSOR_SERVICE);
        sensorAccelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(accelerometerListener, sensorAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);

        if (accelerometerTimer != null) {
            accelerometerTimer.cancel();
        }
        accelerometerTimer = new Timer();
        accelerometerTask = new AccelerometerTask();
        accelerometerTimer.schedule(accelerometerTask, AccelerometerTask.START_NOW, AccelerometerTask.ACCELEROMETER_DELAY);
    }

    public void unregisterAccelerometer() {
        sensorManager.unregisterListener(accelerometerListener);
        accelerometerTimer.cancel();
    }

    float[] sensorValues = new float[3];

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

        public static final int ACCELEROMETER_DELAY = 500;
        public static final int START_NOW = 0;

        @Override
        public void run() {
            ((AccelerometerActivity) view).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    AccelerationAngle accelerationAngle = AccelerationUtil.getAnglesFromAccelerationData(sensorValues);
                    view.updateDegreesInfo(accelerationAngle);
                }
            });
        }
    }

}
