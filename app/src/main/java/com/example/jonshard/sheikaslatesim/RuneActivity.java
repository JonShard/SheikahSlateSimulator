package com.example.jonshard.sheikaslatesim;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class RuneActivity extends AppCompatActivity {


    public static int MAGNESIS =    0;
    public static int STASIS =      1;
    public static int CRYONIS =     2;

    SensorManager sensorManager;
    Sensor accelerometer;
    AccelerationListener listener;
    ImageView imageView;

    ImageView effectA;
    ImageView effectB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rune);

        Intent intent = getIntent();

        int runeID = intent.getIntExtra("runeID", 0);

        imageView = findViewById(R.id.activity_rune_imageView);
        effectA = findViewById(R.id.activity_rune_imageView_effectA);
        effectB = findViewById(R.id.activity_rune_imageView_effectB);

        if (runeID == MAGNESIS) {
            imageView.setImageResource(R.color.runeMagnesis);
            effectA.setColorFilter(ContextCompat.getColor(this, R.color.runeMagnesisTint), android.graphics.PorterDuff.Mode.MULTIPLY);
            effectB.setColorFilter(ContextCompat.getColor(this, R.color.runeMagnesisTint), android.graphics.PorterDuff.Mode.MULTIPLY);
        }
        else if (runeID == STASIS) {
            imageView.setImageResource(R.color.runeStasis);
            effectA.setColorFilter(ContextCompat.getColor(this, R.color.runeStasisTint), android.graphics.PorterDuff.Mode.MULTIPLY);
            effectB.setColorFilter(ContextCompat.getColor(this, R.color.runeStasisTint), android.graphics.PorterDuff.Mode.MULTIPLY);
        }
        else if (runeID == CRYONIS) {
            imageView.setImageResource(R.color.runeCryonis);
            effectA.setColorFilter(ContextCompat.getColor(this, R.color.runeCryonisTint), android.graphics.PorterDuff.Mode.MULTIPLY);
            effectB.setColorFilter(ContextCompat.getColor(this, R.color.runeCryonisTint), android.graphics.PorterDuff.Mode.MULTIPLY);
        }



        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;


        RotateAnimation rotateA = new RotateAnimation(0,360,1250,1250);
        rotateA.setDuration(25000);
        rotateA.setRepeatCount(Animation.INFINITE);
        rotateA.setInterpolator(new Interpolator() {
            @Override
            public float getInterpolation(float v) {
                return v;
            }
        });

        effectA.setAnimation(rotateA);
        rotateA.start();


        RotateAnimation rotateB = new RotateAnimation(180,-180,1250,1250);
        rotateB.setDuration(15000);
        rotateB.setRepeatCount(Animation.INFINITE);
        rotateB.setInterpolator(new Interpolator() {
            @Override
            public float getInterpolation(float v) {
                return v;
            }
        });

        effectB.setAnimation(rotateB);
        rotateB.start();

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
