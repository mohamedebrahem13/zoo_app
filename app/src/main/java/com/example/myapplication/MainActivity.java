package com.example.myapplication;

import android.media.MediaPlayer;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;



import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

MediaPlayer media;
ImageView imageplay,imagStop;
Animallist animallist = (Animallist) this.getApplication();
ArrayList<Animal>  animal;
AnimalAdapter adapter;
    ViewHolder holder;
RecyclerView recyclerView;





    private final MediaPlayer.OnCompletionListener mCompletionListener = mediaPlayer -> {
        // Now that the sound file has finished playing, release the media player resources.
        releaseMediaPlayer();
        imagStop.setVisibility(View.INVISIBLE);
        imageplay.setVisibility(View.VISIBLE);


    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animal= Animallist.getAnimallist();
        setRecyclerview();
        setadpterwithlistener();
    }





    private void setadpterwithlistener(){

        adapter.setOnItemClickListener(new AnimalAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                releaseMediaPlayer();
                Animal animal_postion= animal.get(position);
                media = MediaPlayer.create(MainActivity.this, animal_postion.getmAudioResourceId());
                media.start();
                media.setOnCompletionListener(mCompletionListener);

            }


            @Override
            public void onItemClickpouse(int position) {
                 holder= recyclerView.findViewHolderForAdapterPosition(position);
                imagStop= holder.itemView.findViewById(R.id.imagestop);
                imageplay= holder.itemView.findViewById(R.id.imageplay);
                releaseMediaPlayer();
            }


        });

    }


    private void setRecyclerview(){
    recyclerView = findViewById(R.id.recyclerView);
    recyclerView.setHasFixedSize(true);
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
    recyclerView.setLayoutManager(layoutManager);
    adapter = new AnimalAdapter(animal, getApplicationContext());
    recyclerView.setAdapter(adapter);

}


    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (media != null ) {
            imagStop.setVisibility(View.INVISIBLE);
            imageplay.setVisibility(View.VISIBLE);
            media.release();
            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            media = null;
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
        }

    }


    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }






}
