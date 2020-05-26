package com.example.eto_ono;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.charts.Cartesian3d;


public class Graf_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graf_activity);

        AnyChartView anyChartView = findViewById(R.id.any_chart_view);
        //anyChartView.setProgressBar(findViewById(R.id.progress_bar));

        Cartesian3d area3d = AnyChart.area3d();
        area3d.xAxis(0).labels().format("${%Value}");

        area3d.animation(true);

        area3d.yAxis(0).title("Ударов в минуту");
        area3d.xAxis(0).title("Year/Month/Day");
        area3d.xAxis(0).labels().padding(5d, 5d, 0d, 5d);

        area3d.title("Изменение сердцебиения в течение времени.");

        area3d.title().useHtml(true);
        area3d.title().padding(0d, 0d, 20d, 0d);
    }
}
