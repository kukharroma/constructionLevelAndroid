package com.cooksdev.constructionleveladnroid.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by roma on 03.09.16.
 */
public class ConstructionLevelView extends View {

    private Paint paint = new Paint();
    private int angle;

    public ConstructionLevelView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ConstructionLevelView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(10);

        // center
        canvas.drawLine(getWidth() / 2, getHeight() / 2 - 50, getWidth() / 2, getHeight() / 2 + 50, paint);
        canvas.drawLine(getWidth() / 2 - 50, getHeight() / 2, getWidth() / 2 + 50, getHeight() / 2, paint);

        // left
        canvas.drawLine(0, getHeight() / 2, 50, getHeight() / 2, paint);

        // right
        canvas.drawLine(getWidth() - 50, getHeight() / 2, getWidth(), getHeight() / 2, paint);

        // top
        canvas.drawLine(getWidth() / 2, 0, getWidth() / 2, 50, paint);

        // bottom
        canvas.drawLine(getWidth() / 2, getHeight() - 50, getWidth() / 2, getHeight(), paint);


        Paint paint2 = new Paint();
        paint2.setColor(Color.RED);
        paint2.setStrokeWidth(6);
        canvas.save();
        canvas.rotate(angle, getWidth() / 2, getHeight() / 2);
        canvas.drawLine(getWidth() / 2, getHeight() / 2, getWidth(), getHeight() / 2, paint2);
        canvas.drawLine(getWidth() / 2, getHeight() / 2, 0, getHeight() / 2, paint2);
        canvas.restore();
    }


    public void updateView(int angle) {
        this.angle = angle;
        invalidate();
    }

}
