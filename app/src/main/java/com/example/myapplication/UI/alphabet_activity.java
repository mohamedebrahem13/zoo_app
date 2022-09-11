package com.example.myapplication.UI;


import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;


public class alphabet_activity extends AppCompatActivity {
ImageView alphabet;
MediaPlayer media;
ImageView english;
ImageView arabic;
ConstraintLayout constraintLayout;
    Uri uri1;
    Uri uri2;


    private final MediaPlayer.OnCompletionListener mCompletionListener = mediaPlayer -> {
        // Now that the sound file has finished playing, release the media player resources.
        releaseMediaPlayer();
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphapet);
        alphabet =findViewById(R.id.alphabet);

        english=findViewById(R.id.imageplay);
        arabic=findViewById(R.id.englishsound);
        constraintLayout=findViewById(R.id.constraintlayout);
        String name =getIntent().getStringExtra("char");
        String arabicname=name+"arabic";
        String uriPath1 = "android.resource://" + getPackageName() + "/raw/" + arabicname.toLowerCase();
        uri1 = Uri.parse(uriPath1);
        int imagid =getResources().getIdentifier(name.toLowerCase(),"drawable",getPackageName());
        Glide.with(this).load(imagid).into(alphabet);
        String uriPath2 = "android.resource://" + getPackageName() + "/raw/" + name.toLowerCase();
        uri2 = Uri.parse(uriPath2);
        changebac(name.toLowerCase());
        arabicclick();
        englishclick();


    }


    public void englishclick(){

        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (media!=null){
                    releaseMediaPlayer();
                }else{
                    media = MediaPlayer.create(getApplication(), uri2);
                    try {
                        media.start();
                        english.setImageResource(R.drawable.baseline_stop_white_48);
                    }
                    catch (Exception e) {}

                    media.setOnCompletionListener(mCompletionListener);

                }

            }
        });

    }


    public void arabicclick(){

        arabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (media!=null){
                    releaseMediaPlayer();
                }else{
                    media = MediaPlayer.create(getApplication(), uri1);
                    try {
                        media.start();
                        arabic.setImageResource(R.drawable.baseline_stop_white_48);
                    }
                    catch (Exception e) {}

                    media.setOnCompletionListener(mCompletionListener);

                }

            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
    @SuppressLint("ResourceAsColor")
    private void changebac(String name){
        switch(name){
            case "t":
            case "w":
            case "o":
            case "f":
            case "h":
            case "n":
                constraintLayout.setBackgroundColor(android.R.color.holo_blue_bright);
            break;
            case "c":
            case "k":
            case "i":
            case "l":
            case "s":
            case "a":
            case "e":
            case"r":
                constraintLayout.setBackgroundColor(android.R.color.holo_orange_light);
                break;

            default:
                break;



        }
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (media != null ) {
            media.release();
            if (english!=null){
                english.setImageResource(R.drawable.baseline_play_arrow_white_48);
            }
            if (arabic!=null){

                arabic.setImageResource(R.drawable.baseline_play_arrow_white_48);
            }

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            media = null;
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
        }


    }


}