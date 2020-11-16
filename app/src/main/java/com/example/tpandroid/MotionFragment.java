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

public class MotionFragment extends Fragment implements SensorEventListener{

    private SensorManager sensorManager;
    private Sensor gyroscopeSensor;
    private Sensor accelerometerSensor;
    private Sensor magnetometerSensor;
    private Sensor rotationSensor;

    public MotionFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.motion_fragment, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sensorManager = (SensorManager) Objects.requireNonNull(getActivity()).getSystemService(SENSOR_SERVICE);
        // Gyro
        gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        if (gyroscopeSensor == null) {
            System.out.println("No Gyrooooooooo");
        }
        // Accelerometer
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (accelerometerSensor == null) {
            System.out.println("No Accelerooooo");
        }
        //Magnetometer
        magnetometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        if (magnetometerSensor == null) {
            System.out.println("No Megnetoooooo");
        }
        //Magnetometer
        rotationSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
        if (rotationSensor == null) {
            System.out.println("No Rotatioooooo");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        sensorManager.registerListener(this, gyroscopeSensor, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, magnetometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, rotationSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (gyroscopeSensor.equals(event.sensor)) {
            TextView txGyro = (TextView) Objects.requireNonNull(this.getView()).findViewById(R.id.textViewGyroVal);
            if (txGyro != null) {
                txGyro.setText("Gyroscope value is: " + event.values[2]);
            } else {
                System.out.println("txGyro in MotionFragmnt is null");
            }
        } else if (accelerometerSensor.equals(event.sensor)) {
            TextView txAcc = (TextView) Objects.requireNonNull(this.getView()).findViewById(R.id.textViewAccVal);
            if (txAcc != null) {
                txAcc.setText("Accelerometer value is: X: " + event.values[0] + " Y: " + event.values[1] + " Z: " + event.values[2]);
            } else {
                System.out.println("txAcc in MotionFragmnt is null");
            }
        } else if (magnetometerSensor.equals(event.sensor)) {
            TextView txMagn = (TextView) Objects.requireNonNull(this.getView()).findViewById(R.id.textViewMgnVal);
            if (txMagn != null) {
                txMagn.setText("Magnetometer value is: X: " + event.values[0] + " Y: " + event.values[1] + " Z: " + event.values[2]);
            } else {
                System.out.println("txMagn in MotionFragmnt is null");
            }
        } else if (rotationSensor.equals(event.sensor)) {
            TextView txRot = (TextView) Objects.requireNonNull(this.getView()).findViewById(R.id.textViewRotVal);
            if (txRot != null) {
                txRot.setText("Rotation value is: X: " + event.values[0] + " Y: " + event.values[1] + " Z: " + event.values[2]);
            } else {
                System.out.println("txRot in MotionFragmnt is null");
            }
        }
        // MAYBE Put into View
        //TextView gyroText = (TextView) getView().findViewById(R.id.textFragmentView);
        //gyroText.setText((int) event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
