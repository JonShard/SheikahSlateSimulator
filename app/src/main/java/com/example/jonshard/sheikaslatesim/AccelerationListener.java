package com.example.jonshard.sheikaslatesim;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;

public class AccelerationListener extends Activity implements SensorEventListener {

    static final String TAG = "Acceleromete Listener";
    static final float SENSITIVIEY = 0.0001f;

    float[] read;

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        read = sensorEvent.values;

        float magnitude = read[0]*read[0] + read[1]*read[1] + read[2]*read[2];

        float pitch = (magnitude - 90) * SENSITIVIEY;
        SoundPlayer.update(pitch);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }


}
