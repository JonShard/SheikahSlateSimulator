package com.example.jonshard.sheikaslatesim;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class RuneActivity extends AppCompatActivity {


    public static int MAGNESIS =    0;
    public static int STASIS =      1;
    public static int CRYONIS =     2;

    SensorManager sensorManager;
    Sensor accelerometer;
    AccelerationListener listener;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rune);

        Intent intent = getIntent();

        int runeID = intent.getIntExtra("runeID", 0);

        imageView = findViewById(R.id.activity_rune_imageView);
        if (runeID == MAGNESIS) imageView.setImageResource(R.color.runeMagnesis);
        if (runeID == STASIS) imageView.setImageResource(R.color.runeStasis);
        if (runeID == CRYONIS) imageView.setImageResource(R.color.runeCryonis);
        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                finish();
                return false;
            }
        });

        sensorManager = (SensorManager) this.getSystemService(SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        listener = new AccelerationListener();
        sensorManager.registerListener(listener, accelerometer, SensorManager.SENSOR_DELAY_FASTEST);


        SoundPlayer.playSound(SoundPlayer.RUNE_START);
        SoundPlayer.playSound(SoundPlayer.RUNE_CONTINUES);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sensorManager.unregisterListener(listener);
        SoundPlayer.stopRune();
    }
}
