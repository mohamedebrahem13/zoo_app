package com.example.myapplication.Adapter;

import android.annotation.SuppressLint;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;


import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.data.Animal;
import com.example.myapplication.R;
import com.example.myapplication.data.appcontext;


import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder> {
    private List<Animal> AnimalList;

    private OnItemClickListener mListener;
    int selectedPosition=-1;


    public void setlist (List<Animal> animalmodels) {
        this.AnimalList = animalmodels;
        notifyDataSetChanged();

    }

    public AnimalAdapter( OnItemClickListener Listener) {
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
            Glide.with(appcontext.getAppContext()).load(animal.getmImageResourceId()).into( holder.img);
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
        if (AnimalList!=null){

            return AnimalList.size();
        }
        return -1;
    }


    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private OnItemClickListener mListener;
        public ImageView img;
        public  ImageView imageplay;
        public ImageView englishsound;



        public ViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            this.mListener=listener;
            img = itemView.findViewById(R.id.img);
            imageplay =itemView.findViewById(R.id.imageplay);
            imageplay.setImageResource(R.drawable.baseline_play_arrow_white_48);
            englishsound =itemView.findViewById(R.id.englishsound);
            englishsound.setImageResource(R.drawable.baseline_play_arrow_white_48);
            englishsound.setOnClickListener(this);
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
                case R.id.englishsound:
                    int positions=getAdapterPosition();
                    mListener.englishsound(positions,v);
                    selectedPosition=positions;
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
        void englishsound(int position,View view);



    }
}
