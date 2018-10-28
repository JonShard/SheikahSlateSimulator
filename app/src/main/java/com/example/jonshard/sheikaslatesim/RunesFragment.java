package com.example.jonshard.sheikaslatesim;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static android.app.Activity.RESULT_OK;

public class RunesFragment extends Fragment {

    static final String TAG = "RunesFragment";

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

    private static final int BOMB_ROUND =   0;
    private static final int BOMB_CUBE =    1;
    private static final int MAGNESIS =     2;
    private static final int STASIS =       3;
    private static final int CRYONIS =      4;
    private static final int CAMERA =       5;
    private static final int MOTO_HORSE =   6;




    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_CAMERA = 1;
    static final int REQUSET_EXTERNAL_STORAGE = 2;
    static final int RESULT_SAVE_IMAGE = 3;

    String mCurrentPhotoPath;
    boolean[] states = {false, false, false, false, false, false, false};



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

        txt_title.setText(R.string.rune_bomb_title);
        txt_subtitle.setText(R.string.rune_bomb_subtitle);
        txt_description.setText(R.string.rune_bomb_description);
        deselectAll();
        btn_bomb_round.setBackgroundColor(getResources().getColor(R.color.buttonSelectedBackground));

        btn_bomb_round.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!states[BOMB_ROUND]) {
                    select(BOMB_ROUND);
                    SoundPlayer.playSound(SoundPlayer.BOMB_SPAWN);
                }
                else {
                    SoundPlayer.playSound((SoundPlayer.BOMB_EXPLODE));

                }
                states[BOMB_ROUND] = !states[BOMB_ROUND];
            }
        });

        btn_bomb_cube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!states[BOMB_CUBE]) {
                    select(BOMB_CUBE);
                    SoundPlayer.playSound(SoundPlayer.BOMB_SPAWN);
                }
                else {
                    SoundPlayer.playSound((SoundPlayer.BOMB_EXPLODE));
                }
                states[BOMB_CUBE] = !states[BOMB_CUBE];
            }
        });


        btn_magnesis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!states[MAGNESIS]) {
                    select(MAGNESIS);
                    states[MAGNESIS] = true;
                }
                else {
                    states[MAGNESIS] = false;
                    Intent intent = new Intent(getContext(), RuneActivity.class);
                    intent.putExtra("runeID", RuneActivity.MAGNESIS);
                    startActivity(intent);
                }
            }
        });

        btn_stasis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!states[STASIS]) {
                    select(STASIS);
                    states[STASIS] = true;
                }
                else {
                    states[STASIS] = false;
                    Intent intent = new Intent(getContext(), RuneActivity.class);
                    intent.putExtra("runeID", RuneActivity.STASIS);
                    startActivity(intent);
                }
            }
        });

        btn_cryonis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!states[CRYONIS]) {
                    select(CRYONIS);
                    states[CRYONIS] = true;
                }
                else {
                    states[CRYONIS] = false;
                    Intent intent = new Intent(getContext(), RuneActivity.class);
                    intent.putExtra("runeID", RuneActivity.CRYONIS);
                    startActivity(intent);
                }
            }
        });

        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!states[CAMERA]) {
                    select(CAMERA);
                    states[CAMERA] = true;
                }
                else {
                    SoundPlayer.playSound(SoundPlayer.START);                   // CHANGE SOUND??
                    dispatchTakePictureIntent();
                }
            }
        });

        btn_moto_horse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!states[MOTO_HORSE]) {
                    select(MOTO_HORSE);
                    states[MOTO_HORSE] = true;
                }
                else  {
                    SoundPlayer.playSound(SoundPlayer.MOTO_CYCLE_ZERO);                   // REPLACE WITH MOTOT HORSE SOUND.
                }
            }
        });
    }

    private void select(int rune) {
        deselectAll();
        SoundPlayer.playSound(SoundPlayer.SELECTION_MADE);
        switch (rune) {
            case BOMB_ROUND:
                btn_bomb_round.setBackgroundColor(getResources().getColor(R.color.buttonSelectedBackground));
                txt_title.setText(R.string.rune_bomb_title);
                txt_subtitle.setText(R.string.rune_bomb_subtitle);
                txt_description.setText(R.string.rune_bomb_description);
                break;
            case BOMB_CUBE:
                btn_bomb_cube.setBackgroundColor(getResources().getColor(R.color.buttonSelectedBackground));
                txt_title.setText(R.string.rune_bomb_title);
                txt_subtitle.setText(R.string.rune_bomb_subtitle);
                txt_description.setText(R.string.rune_bomb_description);
                break;
            case MAGNESIS:
                btn_magnesis.setBackgroundColor(getResources().getColor(R.color.buttonSelectedBackground));
                txt_title.setText(R.string.rune_magnesis_title);
                txt_subtitle.setText(R.string.rune_magnesis_subtitle);
                txt_description.setText(R.string.rune_magnesis_description);
                break;
            case STASIS:
                btn_stasis.setBackgroundColor(getResources().getColor(R.color.buttonSelectedBackground));
                txt_title.setText(R.string.rune_stasis_title);
                txt_subtitle.setText(R.string.rune_stasis_subtitle);
                break;
            case CRYONIS:
                btn_cryonis.setBackgroundColor(getResources().getColor(R.color.buttonSelectedBackground));
                txt_title.setText(R.string.rune_cryonis_title);
                txt_subtitle.setText(R.string.rune_cryonis_subtitle);
                break;
            case CAMERA:
                btn_camera.setBackgroundColor(getResources().getColor(R.color.buttonSelectedBackground));
                txt_title.setText(R.string.rune_camera_title);
                txt_subtitle.setText(R.string.rune_camera_subtitle);
                txt_description.setText(R.string.rune_camera_description);
                break;
            case MOTO_HORSE:
                btn_moto_horse.setBackgroundColor(getResources().getColor(R.color.buttonSelectedBackground));
                txt_title.setText(R.string.rune_moto_horse_title);
                txt_subtitle.setText(R.string.rune_moto_horse_subtitle);
                txt_description.setText(R.string.rune_moto_horse_description);
                break;
        }
    }

    private void deselectAll() {
        btn_bomb_round.setBackgroundColor(getResources().getColor(R.color.buttonBackground));
        btn_bomb_cube.setBackgroundColor(getResources().getColor(R.color.buttonBackground));
        btn_magnesis.setBackgroundColor(getResources().getColor(R.color.buttonBackground));
        btn_stasis.setBackgroundColor(getResources().getColor(R.color.buttonBackground));
        btn_cryonis.setBackgroundColor(getResources().getColor(R.color.buttonBackground));
        btn_camera.setBackgroundColor(getResources().getColor(R.color.buttonBackground));
        btn_moto_horse.setBackgroundColor(getResources().getColor(R.color.buttonBackground));
        for (int i = 2; i < states.length; i++) {   // Starts at 2 because the bomb states should not be reset by pressing any of the other runes.
            states[i] = false;
        }

    }



    private void dispatchTakePictureIntent() {
        // Get camera permission:
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            Log.w(TAG, "Missing camera permission, asking now");

            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA);

            return;
        }
        // Get storage permission:
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            Log.w(TAG, "Missing storage permission, asking now");

            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUSET_EXTERNAL_STORAGE);

            return;
        }


        // Start camera for result:

        try {       // Attempt to create image file. Can fail. Try catch.
            createImageFile();
        } catch (IOException e) {
            Log.e(TAG, "Failed to create image file");
            e.printStackTrace();
        }

        // Create and launch intent to camera that saves image to the newly created file we made:
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File

            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(getActivity(),
                        "com.example.android.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {

            Intent intent = new Intent(getContext(), ImageActivity.class);
            intent.putExtra("imagePath", mCurrentPhotoPath);
            startActivityForResult(intent, RESULT_SAVE_IMAGE);
        }
        if (requestCode == RESULT_SAVE_IMAGE) {
            if (resultCode == RESULT_OK) {

                galleryAddPic();
                Log.d(TAG, "Saving image to gallery.");
            }
            else {
                Log.d(TAG, "Image was discarded.");
            }
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CAMERA: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    dispatchTakePictureIntent();
                } else {
                    Log.e(TAG, "Missing camera permission, request was declined.");
                }
                return;
            }
            case REQUSET_EXTERNAL_STORAGE: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    dispatchTakePictureIntent();
                } else {
                    Log.e(TAG, "Missing external storage permission, request was declined.");
                }
                return;
            }
        }
    }


    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        Log.d(TAG, "Created Image file: "+mCurrentPhotoPath);
        return image;
    }

    private void galleryAddPic() {      // Adds the picture to the android gallery.
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(mCurrentPhotoPath);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        getActivity().sendBroadcast(mediaScanIntent);
    }
}

