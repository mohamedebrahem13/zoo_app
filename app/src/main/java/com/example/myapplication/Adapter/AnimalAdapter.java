package com.example.myapplication.Adapter;

import android.annotation.SuppressLint;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;


import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.data.Animal;
import com.example.myapplication.R;


import java.util.ArrayList;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder> {
    private ArrayList<Animal> AnimalList;

    private OnItemClickListener mListener;
    int selectedPosition=-1;



    public AnimalAdapter(ArrayList<Animal> animalList, OnItemClickListener Listener) {
        this.AnimalList = animalList;
        this.mListener=Listener;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout, parent, false);
        return new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Animal animal = AnimalList.get(position);
        if (animal.hasImage()) {
            holder.img.setImageResource(animal.getmImageResourceId());
            holder.img.setScaleType(ImageView.ScaleType.CENTER_CROP);
            holder.img.setVisibility(View.VISIBLE);
        }else {
            holder.img.setVisibility(View.GONE);
        }
        if (position==selectedPosition){

        }else {
            holder.imageplay.setImageResource(R.drawable.baseline_play_arrow_white_48);
        }

    }


    @Override
    public int getItemCount() {
        return AnimalList.size();
    }


    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private OnItemClickListener mListener;
        public ImageView img;
        public  ImageView imageplay;



        public ViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            this.mListener=listener;
            img = itemView.findViewById(R.id.img);
            imageplay =itemView.findViewById(R.id.imageplay);
            imageplay.setImageResource(R.drawable.baseline_play_arrow_white_48);
            img.setOnClickListener(this);
            imageplay.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.img:
                    mListener.onItemClick(this.getAdapterPosition());
                    break;
                case R.id.imageplay:
                    int position=getAdapterPosition();
                    mListener.onimageplayclick(position,v);
                    // call listener
                    // update position
                    selectedPosition=position;
                    // notify
                    notifyDataSetChanged();
                    break;
                default:
                    break;
            }


        }

    }


    public  interface  OnItemClickListener {
        void onItemClick(int position);
        void onimageplayclick(int position,View view);


    }
}
