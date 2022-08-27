package com.example.myapplication.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;

import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.data.Animal;
import com.example.myapplication.R;
import com.example.myapplication.UI.animaldetails;

import java.util.ArrayList;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder> {
    private ArrayList<Animal> AnimalList;
    private final Context context;
    private OnItemClickListener mListener;
    int selectedPosition=-1;



    public  interface  OnItemClickListener {
        void onItemClick(int position);


    }


    public AnimalAdapter(ArrayList<Animal> animalList, Context context) {
        this.AnimalList = animalList;
        this.context = context;
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
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
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Animal animal = AnimalList.get(position);
              int image=  animal.getmImageResourceId();
                String details =animal.getDetails();
                Intent intent=new Intent(v.getContext(), animaldetails.class);
                intent.putExtra("animalimage", image);
                intent.putExtra("details", details);

                v.getContext().startActivity(intent);
            }
        });


        holder.imageplay.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"UseCompatLoadingForDrawables", "NotifyDataSetChanged"})
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                // call listener
                mListener.onItemClick(position);
                // update position
                selectedPosition=position;
                // notify
                notifyDataSetChanged();

            }
        });
        if (position==selectedPosition){

        }else {
            holder.imageplay.setImageResource(R.drawable.baseline_play_arrow_white_48);
        }
    }





    @Override
    public int getItemCount() {

        return AnimalList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView img;
        public  ImageView imageplay;



        public ViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            imageplay =itemView.findViewById(R.id.imageplay);
            imageplay.setImageResource(R.drawable.baseline_play_arrow_white_48);



        }
    }
}
