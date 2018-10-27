package com.example.jonshard.sheikaslatesim;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

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
                dispatchTakePictureIntent();
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

    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_CAMERA = 1;
    static final int REQUSET_EXTERNAL_STORAGE = 2;
    static final int RESULT_SAVE_IMAGE = 3;

    String mCurrentPhotoPath;


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

