package us.bojie.androidcharts.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import us.bojie.androidcharts.R;

/**
 * Created by bojiejiang on 9/9/17.
 */

public class BaseView extends View {

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
    }
}
