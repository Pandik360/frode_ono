package com.example.eto_ono;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Button but1 = findViewById(R.id.button);
        Button but2 = findViewById(R.id.button2);
        Button but3 = findViewById(R.id.button3);
        Button but4 = findViewById(R.id.button4);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Команда отправлена!", Toast.LENGTH_LONG).show();
            }
        });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Команда отправлена!", Toast.LENGTH_LONG).show();
            }
        });
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Команда отправлена!", Toast.LENGTH_LONG).show();
            }
        });
        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Команда отправлена!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
