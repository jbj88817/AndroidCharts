package us.bojie.androidcharts.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

import us.bojie.androidcharts.R;

/**
 * Created by bojiejiang on 9/9/17.
 */

public abstract class BaseView extends View {

    private Context mContext;
    private Paint mPaint;

    // View's width and height
    private int width;
    private int height;

    private int originalX = 100;
    private int originalY = 800;

    private String mGraphTitle;
    private String mXAxisName;
    private String mYAxisName;

    private float mAxisTextSize;
    private int mAxisTextColor;

    public BaseView(Context context) {
        this(context, null);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        // Get custom style
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.GraphStyle);

        mGraphTitle = typedArray.getString(R.styleable.GraphStyle_graphTitle);
        mXAxisName = typedArray.getString(R.styleable.GraphStyle_xAxisName);
        mYAxisName = typedArray.getString(R.styleable.GraphStyle_yAxisName);

        mAxisTextColor = typedArray.getColor(R.styleable.GraphStyle_axisTextColor,
                context.getResources().getColor(android.R.color.black));
        mAxisTextSize = typedArray.getDimension(R.styleable.GraphStyle_axisTextSize, 12);

        if (typedArray != null) {
            typedArray.recycle();
        }

        initPaint();
    }

    private void initPaint() {
        if (mPaint == null) {
            mPaint = new Paint();
            mPaint.setDither(true);
            mPaint.setAntiAlias(true);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        width = getWidth() - originalX;
        height = (originalY > getHeight() ? getHeight() : originalY) - 400;

        drawXAxis(canvas, mPaint);
        drawYAxis(canvas, mPaint);
        drawTitle(canvas, mPaint);
        drawXAxisScale(canvas, mPaint);
        drawXAxisScaleValue(canvas, mPaint);
        drawYAxisScale(canvas, mPaint);
        drawYAxisScaleValue(canvas, mPaint);
        drawXAxisArrow(canvas, mPaint);
        drawYAxisArrow(canvas, mPaint);
        drawColumn(canvas, mPaint);
    }

    protected abstract void drawColumn(Canvas canvas, Paint paint);

    private void drawYAxisArrow(Canvas canvas, Paint paint) {
        Path pathY = new Path();
        pathY.moveTo(originalX, originalY - height - 30);
        pathY.lineTo(originalX - 10, originalY - height);
        pathY.lineTo(originalX + 10, originalY - height);
        pathY.close();
        canvas.drawPath(pathY, mPaint);
        canvas.drawText(mYAxisName, originalX - 50, originalY - height - 30, mPaint);
    }

    private void drawXAxisArrow(Canvas canvas, Paint paint) {
        Path pathX = new Path();
        pathX.moveTo(originalX + width + 30, originalY);
        pathX.lineTo(originalX + width, originalY + 10);
        pathX.lineTo(originalX + width, originalY - 10);

        pathX.close();
        canvas.drawPath(pathX, mPaint);
        canvas.drawText(mXAxisName, originalX + width, originalY + 50, mPaint);
    }

    protected abstract void drawYAxisScaleValue(Canvas canvas, Paint paint);

    protected abstract void drawYAxisScale(Canvas canvas, Paint paint);

    /**
     * Draw X axis
     *
     * @param canvas
     * @param paint
     */
    protected abstract void drawXAxis(Canvas canvas, Paint paint);

    protected abstract void drawYAxis(Canvas canvas, Paint paint);

    private void drawTitle(Canvas canvas, Paint paint) {
        if (!TextUtils.isEmpty(mGraphTitle)) {
            mPaint.setTextSize(mAxisTextSize);
            mPaint.setColor(mAxisTextColor);
            mPaint.setFakeBoldText(true);

            canvas.drawText(mGraphTitle, (getWidth() / 2) - (mPaint.measureText(mGraphTitle)) / 2,
                    originalY + 40, mPaint);
        }
    }

    protected abstract void drawXAxisScale(Canvas canvas, Paint paint);

    protected abstract void drawXAxisScaleValue(Canvas canvas, Paint paint);
}
