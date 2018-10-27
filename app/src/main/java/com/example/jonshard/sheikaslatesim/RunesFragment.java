package com.example.jonshard.sheikaslatesim;

import android.content.Context;
import android.content.res.AssetManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.os.Debug;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.IOException;

public class RunesFragment extends Fragment {

    Button btn_bomb_round;
    Button btn_bomb_cube;
    Button btn_magnisis;
    Button btn_stasis;
    Button btn_cryosis;
    Button btn_camera;
    Button btn_moto_horse;

    boolean roundActivated = false;
    boolean cubeActivated = false;



    public RunesFragment() {
        // Required empty public constructor

    }

    public static RunesFragment newInstance() {
        RunesFragment fragment = new RunesFragment();

        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_runes, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btn_bomb_round = getView().findViewById(R.id.fragment_runes_button_bomb_round);
        btn_bomb_cube = getView().findViewById(R.id.fragment_runes_button_bomb_cube);
        btn_magnisis = getView().findViewById(R.id.fragment_runes_button_magnisis);
        btn_stasis = getView().findViewById(R.id.fragment_runes_button_stasis);
        btn_cryosis = getView().findViewById(R.id.fragment_runes_button_cryosis);
        btn_camera = getView().findViewById(R.id.fragment_runes_button_camera);
        btn_moto_horse = getView().findViewById(R.id.fragment_runes_button_moto_horse);

        btn_bomb_round.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (roundActivated) {
                    SoundPlayer.playSound((SoundPlayer.BOMB_EXPLODE));
                }
                else {
                    SoundPlayer.playSound(SoundPlayer.BOMB_SPAWN);
                }
                roundActivated = !roundActivated;
            }
        });

        btn_bomb_cube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cubeActivated) {
                    SoundPlayer.playSound((SoundPlayer.BOMB_EXPLODE));
                }
                else {
                    SoundPlayer.playSound(SoundPlayer.BOMB_SPAWN);
                }
                cubeActivated = !cubeActivated;
            }
        });

        btn_magnisis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SoundPlayer.playSound(SoundPlayer.RUNE_START);
            }
        });

        btn_stasis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SoundPlayer.playSound(SoundPlayer.RUNE_START);
            }
        });

        btn_cryosis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SoundPlayer.playSound(SoundPlayer.RUNE_START);
            }
        });

        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SoundPlayer.playSound(SoundPlayer.START);
            }
        });

        btn_moto_horse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SoundPlayer.playSound(SoundPlayer.START);
            }
        });
    }
}
