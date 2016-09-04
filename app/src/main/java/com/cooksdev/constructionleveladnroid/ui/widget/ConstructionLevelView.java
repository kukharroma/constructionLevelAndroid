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

    private int WIDTH;
    private int HEIGHT;
    private int CENTER_X;
    private int CENTER_Y;
    private static int CENTERED_LINE_LENGTH = 50;
    private static int SIDE_LINE_LENGTH = 50;
    private static int START_ZERO = 0;
    private int levelLineAngle;

    private Paint centeredLinesPaint = new Paint();
    private Paint sideLinesPaint = new Paint();
    private Paint levelLinePaint = new Paint();

    public ConstructionLevelView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaints();
        initSize();
    }

    public ConstructionLevelView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaints();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        initSize();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawCenteredLines(canvas);
        drawSideLines(canvas);
        drawLevelLine(canvas);
    }

    private void initPaints() {
        final int CENTERED_LINE_WIDTH = 10;
        final int SIDE_LINE_WIDTH = 10;
        final int LEVEL_LINE_WIDTH = 6;

        centeredLinesPaint.setStrokeWidth(CENTERED_LINE_WIDTH);
        centeredLinesPaint.setColor(Color.BLUE);

        sideLinesPaint.setStrokeWidth(SIDE_LINE_WIDTH);
        sideLinesPaint.setColor(Color.BLUE);

        levelLinePaint.setStrokeWidth(LEVEL_LINE_WIDTH);
        levelLinePaint.setColor(Color.RED);
    }

    private void initSize() {
        CENTER_X = getWidth() / 2;
        CENTER_Y = getHeight() / 2;
        WIDTH = getWidth();
        HEIGHT = getHeight();
    }

    public void updateView(int angle) {
        this.levelLineAngle = angle;
        invalidate();
    }

    private void drawLevelLine(Canvas canvas) {
        canvas.save();
        canvas.rotate(levelLineAngle, CENTER_X, CENTER_Y);
        canvas.drawLine(CENTER_X, CENTER_Y, WIDTH, CENTER_Y, levelLinePaint);
        canvas.drawLine(CENTER_X, CENTER_Y, START_ZERO, CENTER_Y, levelLinePaint);
        canvas.restore();
    }

    private void drawCenteredLines(Canvas canvas) {
        canvas.drawLine(CENTER_X, CENTER_Y - CENTERED_LINE_LENGTH, CENTER_X, CENTER_Y + CENTERED_LINE_LENGTH, centeredLinesPaint);
        canvas.drawLine(CENTER_X - CENTERED_LINE_LENGTH, CENTER_Y, CENTER_X + CENTERED_LINE_LENGTH, CENTER_Y, centeredLinesPaint);
    }

    private void drawSideLines(Canvas canvas) {
        // left
        canvas.drawLine(START_ZERO, CENTER_Y, CENTERED_LINE_LENGTH, CENTER_Y, sideLinesPaint);
        // right
        canvas.drawLine(WIDTH - CENTERED_LINE_LENGTH, CENTER_Y, WIDTH, CENTER_Y, sideLinesPaint);
        // top
        canvas.drawLine(CENTER_X, START_ZERO, CENTER_X, SIDE_LINE_LENGTH, sideLinesPaint);
        // bottom
        canvas.drawLine(CENTER_X, HEIGHT - SIDE_LINE_LENGTH, CENTER_X, HEIGHT, sideLinesPaint);
    }


}
