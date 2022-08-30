package com.example.myapplication.UI;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.myapplication.Adapter.AnimalAdapter;
import com.example.myapplication.R;
import com.example.myapplication.data.Animal;
import com.example.myapplication.data.Animallist;

import java.util.ArrayList;


public class animalFragment extends Fragment implements AnimalAdapter.OnItemClickListener {

    MediaPlayer media;
    ImageView imageplay;
    ArrayList<Animal> animal;
    AnimalAdapter adapter;
    RecyclerView recyclerView;
    View view;
    FragmentActivity c;

    private final MediaPlayer.OnCompletionListener mCompletionListener = mediaPlayer -> {
        // Now that the sound file has finished playing, release the media player resources.
        releaseMediaPlayer();


    };


    public animalFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_animal, container, false);
        Animallist animallist = (Animallist) getActivity().getApplication();
        animal = animallist.getAnimallist();
        c = getActivity();
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(c);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new AnimalAdapter(animal, this);
        recyclerView.setAdapter(adapter);

        return view;

    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (media != null) {
            media.release();
            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            if (imageplay != null) {
                imageplay.setImageResource(R.drawable.baseline_play_arrow_white_48);
            }

            media = null;
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
        }


    }


    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }


    @Override
    public void onItemClick(int position) {
        Animal animalobject = animal.get(position);
        int image = animalobject.getmImageResourceId();
        String details = animalobject.getDetails();
        Intent intent = new Intent(getContext(), animaldetails.class);
        intent.putExtra("animalimage", image);
        intent.putExtra("details", details);
        getContext().startActivity(intent);

    }

    @Override
    public void onimageplayclick(int position, View view) {
        imageplay = (ImageView) view;
        Animal animal_postion = animal.get(position);
        if (media!=null){
            releaseMediaPlayer();
        }else{
            releaseMediaPlayer();
            media = MediaPlayer.create(c, animal_postion.getmAudioResourceId());
            media.start();
            imageplay.setImageResource(R.drawable.baseline_stop_white_48);
            media.setOnCompletionListener(mCompletionListener);

        }


    }
}

