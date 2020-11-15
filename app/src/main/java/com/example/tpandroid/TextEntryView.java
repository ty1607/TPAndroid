package com.example.tpandroid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class TextEntryView extends View {

    public TextEntryView(Context context) {
        super(context);
    }

    public TextEntryView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextEntryView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @SuppressLint({"ClickableViewAccessibility", "SetTextI18n"})
    private void init () {
        setWillNotDraw(false);
    }

    @Override
    public void onDraw(Canvas canvas){
    }
}
