package us.bojie.androidcharts.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import us.bojie.androidcharts.R;

/**
 * Created by bojiejiang on 9/9/17.
 */

public class BaseView extends View {
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
    }
}
