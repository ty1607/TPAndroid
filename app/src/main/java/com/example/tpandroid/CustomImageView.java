package com.example.tpandroid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomImageView extends View {

    private float x = -100;
    private float y = -100;
    private int width;
    private int currentPos = 0;

    private int[] images = {
            R.drawable.d5b,
            R.drawable.confused,
            R.drawable.fine,
            R.drawable.mike,
            R.drawable.confused2

    };


    public CustomImageView(Context context) {

        super(context);
        init();
    }

    public CustomImageView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    public CustomImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init (){
        setWillNotDraw(false);
        findViewById(R.id.imageViewer).setBackgroundResource(images[0]);
        setOnTouchListener((v, event) -> {
            invalidate();
            x = event.getX();
            y = event.getY();
            System.out.println();
            width = v.getWidth();

            if (event.getAction() == 0) {
                if (x > width / 2) {
                    findViewById(R.id.imageViewer).setBackgroundResource(getNextImage(true));
                } else {
                    findViewById(R.id.imageViewer).setBackgroundResource(getNextImage(false));
                }
            }

            return true;
        });


    }



    private int getNextImage(boolean next){

        if (next){
            currentPos = (currentPos+1) % images.length;
            return images[currentPos];
        }else {
            if (currentPos == 0)
                currentPos = images.length-1;
            else
                currentPos--;
            return images[currentPos];
        }
    }

}
