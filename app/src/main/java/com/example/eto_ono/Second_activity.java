package com.example.eto_ono;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Second_activity extends AppCompatActivity {
    TextView view_heart;
    TextView view_temp;
    private Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);
        handler = new Handler();
        view_heart = findViewById(R.id.textView);
        view_temp = findViewById(R.id.textView4);
        Button butgraf = findViewById(R.id.button5);
        butgraf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        view_heart.setText("0");
        view_temp.setText("0°C");
        startTimer();




    }

    private void setValue(TextView textView, String str){
        textView.setText(str);
    }

    private void startTimer() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                handler.post(
                        new Runnable() {
                            @Override
                            public void run() {
                                int result_heart = 80 + (int) ((Math.random() * 61) - 20);
                                setValue(view_heart,Integer.toString(result_heart));
                                double result_temp = 36 + (int) ((Math.random() * 39) - 36);
                                String stringdouble = Double.toString(result_temp);
                                setValue(view_temp,stringdouble + "°C");
                            }
                        }
                );
            }
        }, 0, 3500);
    }
}