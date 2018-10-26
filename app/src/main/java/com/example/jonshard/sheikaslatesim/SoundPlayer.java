package com.example.jonshard.sheikaslatesim;

public class SoundPlayer {
    private static final SoundPlayer ourInstance = new SoundPlayer();

    public static SoundPlayer getInstance() {
        return ourInstance;
    }

    private SoundPlayer() {
    }
}
