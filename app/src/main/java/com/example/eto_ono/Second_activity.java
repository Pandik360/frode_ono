package com.example.eto_ono;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.util.Timer;
import java.util.TimerTask;

public class Second_activity extends AppCompatActivity {
    TextView view_heart;
    TextView view_temp;
    private Handler handler;
    int k = 0;
    int i = 0;
    int [] results = new int [10];
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
                if((k!=5)&(k<5))
                {
                    Toast.makeText(getApplicationContext(), "Не хватает записей для графика, ждите.", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Intent intent = new Intent(Second_activity.this, Graf_activity.class);
                    intent.putExtra("mass", k);
                    intent.putExtra("results", results);
                    startActivity(intent);
                }
            }
        });
        view_heart.setText("0");
        view_temp.setText("0°C");
        startTimer();

    }
    protected void onPause() {
        super.onPause();
        i = 0;
        k = 0;
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
                                int result_heart =(int) (Math.random() * 41 + 80);
                                setValue(view_heart,Integer.toString(result_heart));
                                float result_temp =(float) (Math.random() * 3.5 + 36);
                                view_temp.setText(roundUp(result_temp, 1)+"°C");
                                writting(result_heart);
                            }
                        }
                );
            }
        }, 0, 1500);
    }
    public static BigDecimal roundUp(float value, int digits){
        return new BigDecimal("" + value).setScale(digits, BigDecimal.ROUND_HALF_UP);
    }
    public void writting (int res) {
        if (i <10)
        {
            results[i] = res;
            k++;
            i++;
        }
    }
}
