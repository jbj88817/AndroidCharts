package us.bojie.androidcharts;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import us.bojie.androidcharts.view.MyChart;

public class MainActivity extends AppCompatActivity {

    private MyChart mMyChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMyChart = (MyChart) findViewById(R.id.myChartView);

        int[][] columnInfo = new int[][]{
                {6, Color.BLUE},
                {5, Color.GREEN},
                {9, Color.RED},
                {2, Color.GRAY},
                {1, Color.MAGENTA},
                {3, Color.CYAN},
                {8, Color.YELLOW},
        };
        mMyChart.setColumnInfo(columnInfo);
        mMyChart.setXAxisiScaleValue(100, 9);
        mMyChart.setYAxisiScaleValue(10, 7);
    }
}
