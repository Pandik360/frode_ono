package com.example.eto_ono;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian3d;
import com.anychart.core.cartesian.series.Area3d;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.anychart.enums.Anchor;
import com.anychart.enums.HoverMode;
import com.anychart.enums.Position;
import com.anychart.enums.TooltipPositionMode;
import com.anychart.graphics.vector.hatchfill.HatchFillType;


import java.util.ArrayList;
import java.util.List;


public class Graf_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graf_activity);

        AnyChartView anyChartView = findViewById(R.id.any_chart_view);

        Bundle extras = getIntent().getExtras();
        int[] results =extras.getIntArray("results");
        int k = extras.getInt("mass");

        Cartesian3d area3d = AnyChart.area3d();
        area3d.xAxis(0).labels().format("{%Value}");

        area3d.animation(true);

        area3d.yAxis(0).title("Удары");
        area3d.xAxis(0).title("Минуты");
        area3d.xAxis(0).labels().padding(5d, 5d, 0d, 5d);

        area3d.title("Изменение сердцебиения в течение времени.");

        area3d.title().useHtml(true);
        area3d.title().padding(0d, 0d, 20d, 0d);

        List<DataEntry> seriesData = new ArrayList<>();
        for (int i  = 0; i<k; i++)
        {
            seriesData.add(new CustomDataEntry(i, results[i]));
        }

        Set set = Set.instantiate();
        set.data(seriesData);
        Mapping series1Data = set.mapAs("{ x: 'x', value: 'value' }");

        Area3d series1 = area3d.area(series1Data);
        series1.name("Ударов");
        series1.hovered().markers(false);
        series1.hatchFill("diagonal", "#000", 0.6d, 10d);


        area3d.tooltip()
                .position(Position.CENTER_TOP)
                .positionMode(TooltipPositionMode.POINT)
                .anchor(Anchor.LEFT_BOTTOM)
                .offsetX(5d)
                .offsetY(5d);

        area3d.interactivity().hoverMode(HoverMode.BY_X);
        area3d.zAspect("100%");

        anyChartView.setChart(area3d);
    }

    private class CustomDataEntry extends ValueDataEntry {
        CustomDataEntry(Integer x, Number value) {
            super(x, value);
        }
    }
}
