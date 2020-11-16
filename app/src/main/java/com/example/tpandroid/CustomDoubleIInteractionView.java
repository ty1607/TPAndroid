package com.example.tpandroid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomDoubleIInteractionView extends View {

    private float x = -100;
    private float y = -100;
    private int width;
    private int currentPos = 0;
    float originX = 0f;

    private int[] images = {
            R.drawable.d5b,
            R.drawable.confused,
            R.drawable.fine,
            R.drawable.mike,
            R.drawable.confused2

    };
    public CustomDoubleIInteractionView(Context context) {
        super(context);
        init();
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
    private void init (){
        setWillNotDraw(false);
        findViewById(R.id.doubleInteraction).setBackgroundResource(images[0]);

        setOnTouchListener((v, event) -> {
            invalidate();
            x = event.getX();
            y = event.getY();
            System.out.println();
            width = v.getWidth();
            //Tests if the action was a press rather than movement or release
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                originX = event.getX();


            } else if (event.getAction() == MotionEvent.ACTION_UP){
                //Tests if the event was triggered on the right or left side of the screen
                if (originX > event.getX()) {
                    findViewById(R.id.doubleInteraction).setBackgroundResource(getNextImage(true));
                } else if (originX < event.getX()) {
                    findViewById(R.id.doubleInteraction).setBackgroundResource(getNextImage(false));
                }
            }

            return true;
        });
    }

    /*
    returns the image to show
     */
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
