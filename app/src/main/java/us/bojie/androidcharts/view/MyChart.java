package us.bojie.androidcharts.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by bojiejiang on 9/11/17.
 */

public class MyChart extends BaseView {
    public MyChart(Context context) {
        super(context);
    }

    public MyChart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyChart(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void drawColumn(Canvas canvas, Paint paint) {

    }

    @Override
    protected void drawYAxisScaleValue(Canvas canvas, Paint paint) {

    }

    @Override
    protected void drawYAxisScale(Canvas canvas, Paint paint) {

    }

    @Override
    protected void drawXAxis(Canvas canvas, Paint paint) {
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);
        canvas.drawLine(originalX, originalY, originalX + width, originalY, paint);
    }

    @Override
    protected void drawYAxis(Canvas canvas, Paint paint) {
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(5);
        canvas.drawLine(originalX, originalY, originalX, originalY - height, paint);
    }

    @Override
    protected void drawXAxisScale(Canvas canvas, Paint paint) {

    }

    @Override
    protected void drawXAxisScaleValue(Canvas canvas, Paint paint) {

    }
}
