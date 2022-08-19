package com.example.myapplication;

import android.media.MediaPlayer;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


import java.util.Locale;


public class MainActivity extends AppCompatActivity {
ImageView img;
Button button ,button2;
EditText Animal;
String Animalia;
MediaPlayer media;

    private final MediaPlayer.OnCompletionListener mCompletionListener = mediaPlayer -> {
        // Now that the sound file has finished playing, release the media player resources.
        releaseMediaPlayer();
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=findViewById(R.id.img);
        Animal =findViewById(R.id.editTextTextPersonName);
        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);



        button.setOnClickListener(view -> display(Animalia = Animal.getText().toString()));

    }





    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (media != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            media.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            media = null;
        }
    }


    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    public void display (String animal){
        switch(animal.toLowerCase(Locale.ROOT)){
            case "lion":
                releaseMediaPlayer();
                    img.setImageResource(R.drawable.lion);
                    Toast.makeText(MainActivity.this, R.string.lion2 ,Toast.LENGTH_SHORT).show();
                    media= MediaPlayer.create(this, R.raw.lion);
                media.start();
                media.setOnCompletionListener(mCompletionListener);
                break;
            case "monkey":
                releaseMediaPlayer();
                img.setImageResource(R.drawable.moncky);
                    Toast.makeText(MainActivity.this, R.string.monkey,Toast.LENGTH_SHORT).show();
                    media= MediaPlayer.create(this, R.raw.monkey2);
                    media.start();
                media.setOnCompletionListener(mCompletionListener);

                break;
            case "elephant":
                releaseMediaPlayer();
                img.setImageResource(R.drawable.elphant);
                    Toast.makeText(MainActivity.this, R.string.elephant,Toast.LENGTH_SHORT).show();
                    media= MediaPlayer.create(this, R.raw.elephant);
                    media.start();
                media.setOnCompletionListener(mCompletionListener);
                break;
            default:Toast.makeText(MainActivity.this,"please write animal name correct",Toast.LENGTH_SHORT).show();
                break;



        }

    }
}