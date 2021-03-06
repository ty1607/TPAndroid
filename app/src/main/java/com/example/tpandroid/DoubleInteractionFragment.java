package com.example.tpandroid;


import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static android.content.Context.SENSOR_SERVICE;

public class DoubleInteractionFragment extends Fragment implements SensorEventListener {


    private SensorManager sensorManager;
    private Sensor accelerometerSensor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.double_interactions, container, false);
        sensorManager = (SensorManager) Objects.requireNonNull(getActivity()).getSystemService(SENSOR_SERVICE);
        // Accelerometer
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (accelerometerSensor == null) {
            System.out.println("No Accelerooooo");
        }
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        sensorManager.registerListener((SensorEventListener) this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onPause() {
        super.onPause();
        sensorManager.unregisterListener((SensorEventListener) this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onSensorChanged(SensorEvent event) {
        CustomDoubleIInteractionView doubleIView = (CustomDoubleIInteractionView) getView().findViewById(R.id.doubleInteraction);
        if (accelerometerSensor.equals(event.sensor)) {
            if (event.values[1] > 2) {
                getView().findViewById(R.id.doubleInteraction).setBackgroundResource((doubleIView.getNextImage(true)));
            }
            if (event.values[1] < -2) {
                getView().findViewById(R.id.doubleInteraction).setBackgroundResource((doubleIView.getNextImage(true)));
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}
