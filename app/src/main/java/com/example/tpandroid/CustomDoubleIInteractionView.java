package com.example.tpandroid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.util.AttributeSet;
import android.view.View;

import java.util.Objects;

import androidx.annotation.Nullable;

import static android.content.Context.SENSOR_SERVICE;

public class CustomDoubleIInteractionView extends View {

    public CustomDoubleIInteractionView(Context context) {
        super(context);
    }

    public CustomDoubleIInteractionView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomDoubleIInteractionView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void init () {
    }

    @Override public void onDraw(Canvas canvas){
    }

}
