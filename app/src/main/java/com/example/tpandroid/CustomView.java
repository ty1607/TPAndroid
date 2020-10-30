package com.example.tpandroid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomView extends View {

    private Paint paint = new Paint();
    private float x = -100;
    private float y = -100;


    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomView(Context context) {
        super(context);
        init();
    }

    private void init (){
        setWillNotDraw(false);
        setOnTouchListener((v, event) -> {
            x = event.getX();
            y = event.getY();
            invalidate();
            return true;
        });
    }

    @Override public void onDraw(Canvas canvas){
        paint.setColor(Color.RED);
        canvas.drawCircle(x, y, 30, paint);
    }
}
