package com.example.sensorapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SensorEventListener {
    private Button sensorButton;
    private EditText edittextx,edittexty,edittextz;
    private float accx=0,accy=0,accz=0;
    private SensorManager sensormanager;
    private Sensor accelerometer;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensormanager= (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer=(Sensor) sensormanager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        edittextx=(EditText) findViewById(R.id.editTextX);
        edittexty=(EditText) findViewById(R.id.editTextY);
        edittextz=(EditText) findViewById(R.id.editTextZ);
        sensorButton=(Button) findViewById(R.id.sensorbutton);

        sensorButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sensorbutton:
                sensormanager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_FASTEST);
                break;
        }

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            accx=event.values[0];
            accy=event.values[1];
            accz=event.values[2];

            Log.d("DEBUG", new Float(accx).toString());

            edittextx.setText(new Float(accx).toString());
            edittexty.setText(new Float(accy).toString());
            edittextz.setText(new Float(accz).toString());
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}