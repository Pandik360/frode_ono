package com.example.eto_ono;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class First_activity extends AppCompatActivity
{
    BluetoothAdapter bluetooth = BluetoothAdapter.getDefaultAdapter();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Button but1 = (Button) findViewById(R.id.but1);
        but1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(First_activity.this, Second_activity.class);
                startActivity(intent);
            }

        });
        Button but2 = findViewById(R.id.but2);
        but2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(bluetooth.isEnabled())
                {
                    Toast.makeText(getApplicationContext(), "Bluetooth is off!", Toast.LENGTH_LONG).show();
                    bluetooth.disable();
                }
                else
                {
                    bluetooth.enable();
                    Toast.makeText(getApplicationContext(), "Bluetooth is on!", Toast.LENGTH_LONG).show();
                }

            }
        });
        Button but3 = findViewById(R.id.but3);
        but3.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(First_activity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }
}
