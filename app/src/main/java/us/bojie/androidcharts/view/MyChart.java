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
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        width = getWidth() - originalX;
        height = (originalY > getHeight() ? getHeight() : originalY) - 300;
    }

    @Override
    protected void drawColumn(Canvas canvas, Paint paint) {
        if (columnInfo != null) {
            float cellWidth = width / axisDividedSizeX;
            for (int i = 0; i < columnInfo.length; i++) {
                paint.setColor(columnInfo[i][1]);
                float leftTopY = originalY - height * (columnInfo[i][0]) / axisDividedSizeY;
                canvas.drawRect(originalX + cellWidth * (i + 1), leftTopY, originalX + cellWidth * (i + 2), originalY, paint);
            }
        }
    }

    @Override
    protected void drawYAxisScaleValue(Canvas canvas, Paint paint) {
        float cellHeight = height / axisDividedSizeY;
        float cellValue = maxAxisValueY / axisDividedSizeY;
        for (int i = 1; i < axisDividedSizeY; i++) {
            canvas.drawText(cellValue * i + "", originalX - 30,
                    originalY - cellHeight * i + 10, paint);
        }
    }

    @Override
    protected void drawYAxisScale(Canvas canvas, Paint paint) {
        float cellHeight = height / axisDividedSizeY;
        for (int i = 0; i < axisDividedSizeY - 1; i++) {
            canvas.drawLine(originalX, originalY - cellHeight * (i + 1),
                    originalX + 10, originalY - cellHeight * (i + 1), paint);
        }
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
        float cellWidth = width / axisDividedSizeX;
        for (int i = 0; i < axisDividedSizeX - 1; i++) {
            canvas.drawLine(cellWidth * (i + 1) + originalX, originalY,
                    cellWidth * (i + 1) + originalX, originalY - 10, paint);
        }
    }

    @Override
    protected void drawXAxisScaleValue(Canvas canvas, Paint paint) {
        paint.setColor(Color.GRAY);
        paint.setTextSize(24);
        paint.setFakeBoldText(true);

        float cellWidth = width / axisDividedSizeX;
        for (int i = 0; i < axisDividedSizeX; i++) {
            canvas.drawText(i + "", cellWidth * i + originalX - 35,
                    originalY + 30, paint);
        }
    }
}
