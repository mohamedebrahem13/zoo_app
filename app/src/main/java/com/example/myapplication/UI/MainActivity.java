package com.example.myapplication.UI;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.myapplication.Adapter.AnimalAdapter;
import com.example.myapplication.R;
import com.example.myapplication.data.Animal;
import com.example.myapplication.data.Animallist;

import java.util.ArrayList;
import java.util.Objects;


public class MainActivity extends AppCompatActivity {

MediaPlayer media;
ImageView imageplay;
Animallist animallist = (Animallist) this.getApplication();
ArrayList<Animal>  animal;
AnimalAdapter adapter;
    ViewHolder holder;
RecyclerView recyclerView;





    private final MediaPlayer.OnCompletionListener mCompletionListener = mediaPlayer -> {
        // Now that the sound file has finished playing, release the media player resources.
        releaseMediaPlayer();
        if(imageplay !=null){
         imageplay.setImageResource(R.drawable.baseline_play_arrow_white_48);
    }


    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animal= animallist.getAnimallist();
        setRecyclerview();
        setadpterwithlistener();
    }





    private void setadpterwithlistener(){

        adapter.setOnItemClickListener(new AnimalAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                holder= recyclerView.findViewHolderForAdapterPosition(position);
                imageplay= Objects.requireNonNull(holder).itemView.findViewById(R.id.imageplay);
                Animal animal_postion= animal.get(position);
                if(media!=null){
                    media.release();
                    media = null;
                    imageplay.setImageResource(R.drawable.baseline_play_arrow_white_48);

                }else{
                    releaseMediaPlayer();
                    media = MediaPlayer.create(MainActivity.this, animal_postion.getmAudioResourceId());
                    media.start();
                    imageplay.setImageResource(R.drawable.baseline_stop_white_48);
                    media.setOnCompletionListener(mCompletionListener);

                }

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
