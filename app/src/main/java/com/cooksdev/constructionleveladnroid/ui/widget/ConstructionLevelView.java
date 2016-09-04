package com.cooksdev.constructionleveladnroid.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

import com.cooksdev.constructionleveladnroid.R;
import com.cooksdev.constructionleveladnroid.model.AccelerationDegrees;

/**
 * Created by roma on 03.09.16.
 */
public class ConstructionLevelView extends View {

    private int WIDTH;
    private int HEIGHT;
    private int CENTER_X;
    private int CENTER_Y;
    private int HALF_SIZE_OF_LEVEL_LINE;

    private final int CENTERED_LINE_LENGTH = 50;
    private final int SIDE_LINE_LENGTH = 50;
    private final int START_ZERO = 0;

    private final int TEXT_SIZE = 35;
    private final int RIGHT_ANGLE = 90;
    private final int TEXT_MARGIN = 50;

    private final int BINARY_POWER = 2;

    private final Paint centeredLinesPaint = new Paint();
    private final Paint sideLinesPaint = new Paint();
    private final Paint levelLinePaint = new Paint();
    private final Paint textOrientationPaint = new Paint();

    private String PORTRAIT_ORIENTATION;
    private String HORIZONTAL_ORIENTATION;

    private AccelerationDegrees degrees;

    public ConstructionLevelView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaints();
        initStringResources();
    }

    public ConstructionLevelView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaints();
        initStringResources();
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
        drawAcceleratorDegrees(canvas, degrees);
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

        textOrientationPaint.setColor(Color.WHITE);
        textOrientationPaint.setTextSize(TEXT_SIZE);
        textOrientationPaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
    }

    private void initStringResources() {
        Resources resources = getResources();
        PORTRAIT_ORIENTATION = resources.getString(R.string.orientation_portrait);
        HORIZONTAL_ORIENTATION = resources.getString(R.string.orientation_horizontal);
    }

    private void initSize() {
        CENTER_X = getWidth() / 2;
        CENTER_Y = getHeight() / 2;
        WIDTH = getWidth();
        HEIGHT = getHeight();
        HALF_SIZE_OF_LEVEL_LINE = (int) Math.sqrt(Math.pow(CENTER_X, BINARY_POWER) + Math.pow(CENTER_Y, BINARY_POWER));
    }

    public void updateView(AccelerationDegrees degrees) {
        this.degrees = degrees;
        invalidate();
    }

    private void drawLevelLine(Canvas canvas) {
        canvas.save();
        canvas.rotate(degrees.getXTilt(), CENTER_X, CENTER_Y);
        canvas.drawLine(-HALF_SIZE_OF_LEVEL_LINE, CENTER_Y, WIDTH + HALF_SIZE_OF_LEVEL_LINE, CENTER_Y, levelLinePaint);
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

    private void drawAcceleratorDegrees(Canvas canvas, AccelerationDegrees degrees) {
        String tiltX = String.valueOf(degrees.getXTilt());
        String tiltY = String.valueOf(degrees.getYTilt());

        String portrait = String.format(PORTRAIT_ORIENTATION, tiltX);
        String horizontal = String.format(HORIZONTAL_ORIENTATION, tiltY);

        canvas.drawText(portrait, TEXT_MARGIN, TEXT_MARGIN, textOrientationPaint);

        canvas.save();
        canvas.rotate(RIGHT_ANGLE, WIDTH - TEXT_MARGIN, TEXT_MARGIN);
        canvas.drawText(horizontal, WIDTH - TEXT_MARGIN, TEXT_MARGIN, textOrientationPaint);
        canvas.restore();
    }

}
