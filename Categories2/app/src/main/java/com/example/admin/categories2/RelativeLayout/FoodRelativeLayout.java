package com.example.admin.categories2.RelativeLayout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by Admin on 10/25/2016.
 */

public class FoodRelativeLayout extends RelativeLayout {
    public FoodRelativeLayout(Context context) {
        super(context);
    }

    public FoodRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FoodRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heighSize = widthSize / 2;
        int heighMode = MeasureSpec.EXACTLY;
        int newHeightMeasureSpec = MeasureSpec.makeMeasureSpec(heighSize, heighMode);
        super.onMeasure(widthMeasureSpec, newHeightMeasureSpec);
    }
}
