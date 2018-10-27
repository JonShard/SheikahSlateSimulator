package com.example.jonshard.sheikaslatesim;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.util.Log;

public class SoundPlayer {
    static String TAG = "SoundPlayer";


    static final int START =            1;
    static final int CAMERA_CAPTURE =   2;
    static final int BOMB_SPAWN =       3;
    static final int BOMB_EXPLODE =     4;
    static final int RUNE_START =       5;


    private static SoundPool soundPool;
    private static int[] soundID = {0,0,0,0,0};


    private static final SoundPlayer ourInstance = new SoundPlayer();

    public static SoundPlayer getInstance() {
        return ourInstance;
    }

    private SoundPlayer() {
    }


    public static void init(Context context) {
        Log.d(TAG, "init()");

        if (soundPool == null) {

            AudioAttributes attributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(5)
                    .setAudioAttributes(attributes)
                    .build();


            // Load sounds:
            soundID[0] = soundPool.load(context, R.raw.start,               1);
            soundID[1] = soundPool.load(context, R.raw.camera_capture,   1);
            soundID[2] = soundPool.load(context, R.raw.spawn_bomb,       1);
            soundID[3] = soundPool.load(context, R.raw.bomb_explode,     1);
            soundID[4] = soundPool.load(context, R.raw.rune_start,       1);

        }

    }

    public static void unInit() {
        Log.d(TAG, "unInit()");

        if (soundPool != null) {
            soundPool.release();
            soundPool = null;
        }
    }





     public static void playSound(int id) {
        if (soundPool != null) {
            if (id != 0) {

                Log.d(TAG, "Playing sound " + id);

                soundPool.play(id, 1, 1, 1, 0, 1f);

            }
            else {
                Log.w(TAG, "SoundID is 0!!");
            }
        }
        else {
            Log.w(TAG, "SoundPlayer not initialized!!");

        }


    }

}
