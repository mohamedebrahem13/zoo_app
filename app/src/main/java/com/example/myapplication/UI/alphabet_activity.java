package com.example.myapplication.UI;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;



import com.example.myapplication.R;

public class alphabet_activity extends AppCompatActivity {
ImageView alphabet;
    MediaPlayer media;


    private final MediaPlayer.OnCompletionListener mCompletionListener = mediaPlayer -> {
        // Now that the sound file has finished playing, release the media player resources.
        releaseMediaPlayer();



    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphapet);
        alphabet =findViewById(R.id.alphabet);
        String name =getIntent().getStringExtra("char");
        int imagid =getResources().getIdentifier(name.toLowerCase(),"drawable",getPackageName());
        String uriPath = "android.resource://" + getPackageName() + "/raw/" + name.toLowerCase();
        Uri uri = Uri.parse(uriPath);
        alphabet.setImageResource(imagid);
        alphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (media!=null){
                    releaseMediaPlayer();
                }else{
                    media = MediaPlayer.create(getApplication(), uri);
                   try {
                       media.start();
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

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (media != null ) {
            media.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            media = null;
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
        }


    }


}