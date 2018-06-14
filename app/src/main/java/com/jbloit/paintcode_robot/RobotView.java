package com.jbloit.paintcode_robot;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * TODO: document your custom view class.
 */
public class RobotView extends View {

    private float mAngle;
    private int mRed;

    public RobotView(Context context) {
        super(context);
        init(null, 0);
    }

    public RobotView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public RobotView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.RobotView, defStyle, 0);

        mAngle = a.getFloat(R.styleable.RobotView_armAngle, 0);
        mRed = a.getInt(R.styleable.RobotView_red, 0);

        a.recycle();

        // Update TextPaint and text measurements from attributes

    }

    private void invalidateTextPaintAndMeasurements() {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        RobotStyleKit.drawRobot(canvas,
                new RectF(0, 0, getWidth(), getHeight()),
                RobotStyleKit.ResizingBehavior.AspectFit,
                Color.rgb(mRed, 150, 57),
                mAngle);
    }

    public void setAngle(float angle){
        mAngle = angle;
        invalidate();
    }

    public void setARed(int red){
        mRed = red;
        invalidate();
    }
}
