package com.cooksdev.constructionleveladnroid.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.cooksdev.constructionleveladnroid.R;
import com.cooksdev.constructionleveladnroid.acceleration.model.AccelerationAngle;

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
    private final int HALF_STROKE_WIDTH = 8;
    private final int X_Y_RADIUS = 12;

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

    private AccelerationAngle accelerationAngles;

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
        drawAcceleratorDegrees(canvas, accelerationAngles);
    }

    private void initPaints() {
        final int CENTERED_LINE_WIDTH = 14;
        final int SIDE_LINE_WIDTH = 14;
        final int LEVEL_LINE_WIDTH = 14;

        final int CENTER_LINES_COLOR = ContextCompat.getColor(getContext(), R.color.centered_lines_color);
        final int SIDE_LINES_COLOR = ContextCompat.getColor(getContext(), R.color.side_lines_color);
        final int LEVEL_LINE_COLOR = ContextCompat.getColor(getContext(), R.color.level_line_color);
        final int TEXT_COLOR = ContextCompat.getColor(getContext(), R.color.text_color);

        centeredLinesPaint.setStrokeWidth(CENTERED_LINE_WIDTH);
        centeredLinesPaint.setColor(CENTER_LINES_COLOR);

        sideLinesPaint.setStrokeWidth(SIDE_LINE_WIDTH);
        sideLinesPaint.setColor(SIDE_LINES_COLOR);

        levelLinePaint.setStrokeWidth(LEVEL_LINE_WIDTH);
        levelLinePaint.setColor(LEVEL_LINE_COLOR);

        textOrientationPaint.setColor(TEXT_COLOR);
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

    public void updateView(AccelerationAngle degrees) {
        this.accelerationAngles = degrees;
        invalidate();
    }

    private void drawLevelLine(Canvas canvas) {
        canvas.save();
        canvas.rotate(accelerationAngles.getXAngle(), CENTER_X, CENTER_Y);
        canvas.drawLine(
                -HALF_SIZE_OF_LEVEL_LINE,
                CENTER_Y,
                WIDTH + HALF_SIZE_OF_LEVEL_LINE,
                CENTER_Y,
                levelLinePaint
        );
        canvas.restore();
    }

    private void drawCenteredLines(Canvas canvas) {
        RectF rectPortrait = new RectF(
                CENTER_X - HALF_STROKE_WIDTH,
                CENTER_Y - CENTERED_LINE_LENGTH,
                CENTER_X + HALF_STROKE_WIDTH,
                CENTER_Y + CENTERED_LINE_LENGTH
        );

        RectF rectHorizontal = new RectF(
                CENTER_X - CENTERED_LINE_LENGTH,
                CENTER_Y - HALF_STROKE_WIDTH,
                CENTER_X + CENTERED_LINE_LENGTH,
                CENTER_Y + HALF_STROKE_WIDTH
        );

        canvas.drawRoundRect(rectPortrait, X_Y_RADIUS, X_Y_RADIUS, centeredLinesPaint);
        canvas.drawRoundRect(rectHorizontal, X_Y_RADIUS, X_Y_RADIUS, centeredLinesPaint);
    }

    private void drawSideLines(Canvas canvas) {
        // left
        RectF leftRectF = new RectF(
                START_ZERO,
                CENTER_Y - HALF_STROKE_WIDTH,
                CENTERED_LINE_LENGTH,
                CENTER_Y + HALF_STROKE_WIDTH
        );
        canvas.drawRoundRect(leftRectF, X_Y_RADIUS, X_Y_RADIUS, sideLinesPaint);

        // right
        RectF rightRectF = new RectF(
                WIDTH - CENTERED_LINE_LENGTH,
                CENTER_Y - HALF_STROKE_WIDTH,
                WIDTH,
                CENTER_Y + HALF_STROKE_WIDTH
        );
        canvas.drawRoundRect(rightRectF, X_Y_RADIUS, X_Y_RADIUS, sideLinesPaint);

        // top
        RectF topRectF = new RectF(
                CENTER_X - HALF_STROKE_WIDTH,
                START_ZERO,
                CENTER_X + HALF_STROKE_WIDTH,
                SIDE_LINE_LENGTH
        );
        canvas.drawRoundRect(topRectF, X_Y_RADIUS, X_Y_RADIUS, sideLinesPaint);

        // bottom
        RectF bottomRectF = new RectF(
                CENTER_X - HALF_STROKE_WIDTH,
                HEIGHT - SIDE_LINE_LENGTH,
                CENTER_X + HALF_STROKE_WIDTH,
                HEIGHT
        );
        canvas.drawRoundRect(bottomRectF, X_Y_RADIUS, X_Y_RADIUS, sideLinesPaint);
    }

    private void drawAcceleratorDegrees(Canvas canvas, AccelerationAngle degrees) {
        String tiltX = String.valueOf(degrees.getXAngle());
        String tiltY = String.valueOf(degrees.getYAngle());

        String portrait = String.format(PORTRAIT_ORIENTATION, tiltX);
        String horizontal = String.format(HORIZONTAL_ORIENTATION, tiltY);

        canvas.drawText(portrait, TEXT_MARGIN, TEXT_MARGIN, textOrientationPaint);

        canvas.save();
        canvas.rotate(RIGHT_ANGLE, WIDTH - TEXT_MARGIN, TEXT_MARGIN);
        canvas.drawText(horizontal, WIDTH - TEXT_MARGIN, TEXT_MARGIN, textOrientationPaint);
        canvas.restore();
    }

}
