package com.example.admin.turn3;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;

import static android.content.ContentValues.TAG;

/**
 * Created by Admin on 10/2/2016.
 */

public class LayoutRelative extends RelativeLayout {
    public LayoutRelative(Context context) {
        super(context);
    }

    public LayoutRelative(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LayoutRelative(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec) / 2;
//         widthSize = widthSize / 2;
        int heighSize = MeasureSpec.getSize(heightMeasureSpec);
        int heighMode = MeasureSpec.EXACTLY;
        int widthMode = MeasureSpec.EXACTLY;

        int newHeighMeasureSpec =  MeasureSpec.makeMeasureSpec(heighSize,heighMode);
        int newWidthMeasureSpec = MeasureSpec.makeMeasureSpec(widthSize,widthMode);
        super.onMeasure(newWidthMeasureSpec, newHeighMeasureSpec);
    }
}
