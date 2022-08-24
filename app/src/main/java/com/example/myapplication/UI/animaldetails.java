package com.example.myapplication.UI;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;


public class animaldetails extends AppCompatActivity {
ImageView animal;
TextView animal_name,animaldetails;
Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        animal_name=findViewById(R.id.textView);
        animaldetails=findViewById(R.id.textView2);
        animal=findViewById(R.id.imageView);
        bundle =getIntent().getExtras();
        if (bundle!=null){
            int resimage=bundle.getInt("animalimage");
            String name=bundle.getString("animalname");
            String detials=bundle.getString("details");
            animaldetails.setText(detials);
            animal.setImageResource(resimage);
            animal_name.setText(name);


        }


    }
}