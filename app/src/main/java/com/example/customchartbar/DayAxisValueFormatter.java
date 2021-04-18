package com.example.customchartbar;

import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;

public class DayAxisValueFormatter extends ValueFormatter implements IAxisValueFormatter
{
    private final BarLineChartBase<?> chart;

    public DayAxisValueFormatter(BarLineChartBase<?> chart) {
        this.chart = chart;
    }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {

        String title = "دانلود";
        int culomn = (int) value;
//            String appendix = "0";
            String appendix = String.valueOf(culomn);
//            switch (culomn) {
//                case 1:
//                    appendix = "1";
//                    break;
//                case 2:
//                    appendix = "2";
//                    break;
//                case 3:
//                    appendix = "3";
//                    break;
//                case 4:
//                    appendix = "4";
//                    break;
//                case 5:
//                    appendix = "5";
//                    break;
//                case 6:
//                    appendix = "6";
//                    break;
//                case 7:
//                    appendix = "7";
//                    break;
//                case 8:
//                    appendix = "8";
//                    break;
//                case 9:
//                    appendix = "9";
//                    break;
//                case 10:
//                    appendix = "10";
//                    break;
//                case 11:
//                    appendix = "11";
//                    break;
//                case 12:
//                    appendix = "12";
//                    break;
//            }
        return appendix+" % "+title;

    }
}
