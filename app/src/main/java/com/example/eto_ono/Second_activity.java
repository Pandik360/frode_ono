package com.example.eto_ono;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Second_activity extends AppCompatActivity {
    TextView view_heart = findViewById(R.id.textView);
    TextView view_temp = findViewById(R.id.textView4);
    @Override

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);
        Button butgraf = findViewById(R.id.button5);
        butgraf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        view_heart.setText("0");
        view_temp.setText("0°C");


    }

    private void setValues() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                int result_heart = 80 + (int) ((Math.random() * 61) - 20);
                view_heart.setText(result_heart);
                double result_temp = 36 + (int) ((Math.random() * 39) - 36);
                String stringdouble = Double.toString(result_temp);
                view_temp.setText(stringdouble + "°C");
            }
        }, 0, 3500);
    }
}