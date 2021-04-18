package com.example.customchartbar;

import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

public class MyBarDataSet extends BarDataSet {

    ArrayList<BarEntry> yVals;

    public MyBarDataSet(ArrayList<BarEntry> yVals, String label) {
        super(yVals, label);
        this.yVals =yVals;
    }
    @Override
    public int getColor(int index) {
        if(yVals.get(index).getX()==8)
            return mColors.get(2);
        else if(yVals.get(index).getY() >= 5)
            return mColors.get(0);
        else if(yVals.get(index).getY() < 5)
            return mColors.get(1);
        else
            return 0;
    }
}