package com.example.customchartbar;

import android.content.Context;
import android.widget.TextView;

import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;

import java.text.DecimalFormat;

public class CustomMarkerView extends MarkerView {

    private String yearData = "99";
    private  TextView txtDownload,txtDate;
    private  IAxisValueFormatter xAxisValueFormatter;

    public CustomMarkerView(Context context, IAxisValueFormatter xAxisValueFormatter) {
        super(context, R.layout.custom_marker_view);

        this.xAxisValueFormatter = xAxisValueFormatter;
        txtDownload = findViewById(R.id.txt_download);
        txtDate = findViewById(R.id.txt_date);
    }

    @Override
    public void refreshContent(Entry e, Highlight highlight) {

        int valx = (int) e.getX();
        txtDownload.setText(String.format("%s", xAxisValueFormatter.getFormattedValue(e.getX(), null), ""));
        txtDate.setText(String.format("%s.%s",yearData,valx));

        super.refreshContent(e, highlight);
    }

    @Override
    public MPPointF getOffset() {
        return new MPPointF(-(getWidth() / 2), -getHeight());
    }
}