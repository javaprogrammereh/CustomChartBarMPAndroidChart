package com.example.customchartbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnChartValueSelectedListener {

    /**/
    private BarChart chart;
    ArrayList<BarEntry> chartData;
    final String[] month = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chart = findViewById(R.id.chartbar);
        setChartElement();
        chartData = generateBarEntries();
        setchartView();
    }
    /**/
    private void setChartElement() {
        chart.setDrawBarShadow(false);
        chart.setDrawValueAboveBar(true);
        chart.getDescription().setEnabled(false);
        chart.setMaxVisibleValueCount(100);
        chart.setPinchZoom(false);
        chart.setTouchEnabled(true);
        chart.setDragEnabled(true);
        chart.setScaleEnabled(false);
        chart.setDrawGridBackground(false);
        chart.getDescription().setEnabled(false);
        chart.getLegend().setEnabled(false);
        chart.getAxisRight().setDrawGridLines(false);
        chart.getAxisLeft().setDrawGridLines(false);
        chart.getXAxis().setDrawGridLines(false);
        chart.setHorizontalScrollBarEnabled(true);
        /**/
        IAxisValueFormatter xAxisFormatter = new DayAxisValueFormatter(chart);
        /**/
        XAxis xAxis = chart.getXAxis();
        xAxis.setTextColor(Color.GRAY);
        xAxis.setAxisLineColor(Color.GRAY);
        xAxis.setAxisLineWidth(2);
        xAxis.setDrawAxisLine(true);
        xAxis.setTextSize(5f);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(0f);
        xAxis.setLabelCount(12);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(month));
        /**/
        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setLabelCount(0, false);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setSpaceTop(30f);
        leftAxis.setAxisMinimum(0f);
        leftAxis.setTextSize(0f);
        leftAxis.setTextColor(Color.TRANSPARENT);
        leftAxis.setAxisLineColor(Color.TRANSPARENT);
        leftAxis.setAxisLineWidth(0);
        /**/
        YAxis rightAxis = chart.getAxisRight();
        rightAxis.setDrawGridLines(false);
        rightAxis.setLabelCount(0, false);
        rightAxis.setSpaceTop(30f);
        rightAxis.setAxisMinimum(0f);
        rightAxis.setTextSize(0f);
        rightAxis.setTextColor(Color.TRANSPARENT);
        rightAxis.setAxisLineColor(Color.TRANSPARENT);
        rightAxis.setAxisLineWidth(0);
        /**/
        CustomMarkerView mv = new CustomMarkerView(this, xAxisFormatter);
        mv.setChartView(chart);
        chart.setMarker(mv);
        /**/
        CustomBarChartRender barChartRender = new CustomBarChartRender(chart, chart.getAnimator(), chart.getViewPortHandler());
        barChartRender.setRadius(20);
        chart.setRenderer(barChartRender);
        chart.setOnChartValueSelectedListener(this);
    }
    /**/
    private ArrayList<BarEntry> generateBarEntries() {
        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int i = 1; i <= 24; i++) {
            entries.add(new BarEntry(i, (float) (Math.random() * (i + 1))));
        }
        return entries;
    }
    /**/
    private void setchartView() {
        MyBarDataSet set = new MyBarDataSet(chartData, "");
        set.setColors(new int[]{
                        (ContextCompat.getColor(this, R.color.teal_200))
                , (ContextCompat.getColor(this, R.color.black)),
                (ContextCompat.getColor(this, R.color.purple_200))});
        set.setHighLightColor(ContextCompat.getColor(this, R.color.white));
        set.setDrawIcons(false);
        set.setValueTextColor(Color.WHITE);
        set.setDrawValues(false);
        BarData data = new BarData( set);
        data.setValueTextSize(0f);
        data.setBarWidth(0.4f);
        chart.setData(data);
        chart.setVisibleXRangeMaximum(12);
        chart.moveViewToX(13);
        chart.invalidate();
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {
        Log.d("onValueSelected........", String.valueOf(e.getX()));
    }

    @Override
    public void onNothingSelected() {
    }
}