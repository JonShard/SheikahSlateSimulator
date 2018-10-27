package com.example.jonshard.sheikaslatesim;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class RunesFragment extends Fragment {

    TextView txt_title;
    TextView txt_subtitle;
    TextView txt_description;

    ImageButton btn_bomb_round;
    ImageButton btn_bomb_cube;
    ImageButton btn_magnesis;
    ImageButton btn_stasis;
    ImageButton btn_cryonis;
    ImageButton btn_camera;
    ImageButton btn_moto_horse;

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

        txt_title =         getView().findViewById(R.id.fragment_runes_textView_title);
        txt_subtitle =      getView().findViewById(R.id.fragment_runes_textView_subtitle);
        txt_description =   getView().findViewById(R.id.ffragment_runes_textView_description);

        btn_bomb_round =    getView().findViewById(R.id.fragment_runes_btn_bomb_round);
        btn_bomb_cube =     getView().findViewById(R.id.fragment_runes_btn_bomb_cube);
        btn_magnesis =      getView().findViewById(R.id.fragment_runes_btn_magnesis);
        btn_stasis =        getView().findViewById(R.id.fragment_runes_btn_stasis);
        btn_cryonis =       getView().findViewById(R.id.fragment_runes_btn_cryonis);
        btn_camera =        getView().findViewById(R.id.fragment_runes_btn_camera);
        btn_moto_horse =    getView().findViewById(R.id.fragment_runes_btn_moto_horse);

        btn_bomb_round.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (roundActivated) {
                    txt_title.setText(R.string.rune_bomb_title);
                    txt_subtitle.setText(R.string.rune_bomb_subtitle);
                    txt_description.setText(R.string.rune_bomb_description);
                    SoundPlayer.playSound((SoundPlayer.BOMB_EXPLODE));
                }
                else {
                    deselectAll();
                    btn_bomb_round.setBackgroundColor(getResources().getColor(R.color.buttonSelectedBackground));
                    SoundPlayer.playSound(SoundPlayer.BOMB_SPAWN);

                }
                roundActivated = !roundActivated;
            }
        });

        btn_bomb_cube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cubeActivated) {
                    txt_title.setText(R.string.rune_bomb_title);
                    txt_subtitle.setText(R.string.rune_bomb_subtitle);
                    txt_description.setText(R.string.rune_bomb_description);
                    SoundPlayer.playSound((SoundPlayer.BOMB_EXPLODE));
                }
                else {
                    deselectAll();
                    btn_bomb_cube.setBackgroundColor(getResources().getColor(R.color.buttonSelectedBackground));
                    SoundPlayer.playSound(SoundPlayer.BOMB_SPAWN);
                }
                cubeActivated = !cubeActivated;
            }
        });                    txt_title.setText(R.string.rune_bomb_title);
                    txt_subtitle.setText(R.string.rune_bomb_subtitle);
                    txt_description.setText(R.string.rune_bomb_description);


        btn_magnesis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deselectAll();
                btn_magnesis.setBackgroundColor(getResources().getColor(R.color.buttonSelectedBackground));
                txt_title.setText(R.string.rune_magnesis_title);
                txt_subtitle.setText(R.string.rune_magnesis_subtitle);
                txt_description.setText(R.string.rune_magnesis_description);
                SoundPlayer.playSound(SoundPlayer.RUNE_START);
            }
        });

        btn_stasis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deselectAll();
                btn_stasis.setBackgroundColor(getResources().getColor(R.color.buttonSelectedBackground));
                txt_title.setText(R.string.rune_stasis_title);
                txt_subtitle.setText(R.string.rune_stasis_subtitle);
                txt_description.setText(R.string.rune_stasis_description);
                SoundPlayer.playSound(SoundPlayer.RUNE_START);
            }
        });

        btn_cryonis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deselectAll();
                btn_cryonis.setBackgroundColor(getResources().getColor(R.color.buttonSelectedBackground));
                txt_title.setText(R.string.rune_cryonis_title);
                txt_subtitle.setText(R.string.rune_cryonis_subtitle);
                txt_description.setText(R.string.rune_cryonis_description);
                SoundPlayer.playSound(SoundPlayer.RUNE_START);
            }
        });

        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deselectAll();
                btn_camera.setBackgroundColor(getResources().getColor(R.color.buttonSelectedBackground));
                txt_title.setText(R.string.rune_camera_title);
                txt_subtitle.setText(R.string.rune_camera_subtitle);
                txt_description.setText(R.string.rune_camera_description);
                SoundPlayer.playSound(SoundPlayer.START);
//                Intent start camera for result()
            }
        });

        btn_moto_horse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deselectAll();
                btn_moto_horse.setBackgroundColor(getResources().getColor(R.color.buttonSelectedBackground));
                txt_title.setText(R.string.rune_moto_horse_title);
                txt_subtitle.setText(R.string.rune_moto_horse_subtitle);
                txt_description.setText(R.string.rune_moto_horse_description);
                SoundPlayer.playSound(SoundPlayer.START);
            }
        });
    }

    private void deselectAll() {
        btn_bomb_round.setBackgroundColor(getResources().getColor(R.color.buttonBackground));
        btn_bomb_cube.setBackgroundColor(getResources().getColor(R.color.buttonBackground));
        btn_magnesis.setBackgroundColor(getResources().getColor(R.color.buttonBackground));
        btn_stasis.setBackgroundColor(getResources().getColor(R.color.buttonBackground));
        btn_cryonis.setBackgroundColor(getResources().getColor(R.color.buttonBackground));
        btn_camera.setBackgroundColor(getResources().getColor(R.color.buttonBackground));
        btn_moto_horse.setBackgroundColor(getResources().getColor(R.color.buttonBackground));

    }
}
