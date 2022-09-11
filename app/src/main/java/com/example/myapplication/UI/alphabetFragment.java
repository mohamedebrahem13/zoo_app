package com.example.myapplication.UI;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.myapplication.Adapter.AlphabetAdapter;
import com.example.myapplication.R;
import com.example.myapplication.UI.Viewmodel.AlphaViewmodel;


import java.util.ArrayList;
import java.util.List;


public class alphabetFragment extends Fragment {
Intent intent;
AlphabetAdapter alphabetAdapter;
    List<String> alpha;
    AlphaViewmodel alphaViewmodel;



    public alphabetFragment() {
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
        View v = inflater.inflate(R.layout.fragment_alphpet, container, false);
       alphaViewmodel= ViewModelProviders.of(this).get(AlphaViewmodel.class);
        GridView gv =v.findViewById(R.id.grid);
        alphabetAdapter=new AlphabetAdapter(getContext());
        gv.setAdapter(alphabetAdapter);


        alphaViewmodel.getalphamutablelivedata().observe(getViewLifecycleOwner(), new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
              alphabetAdapter.setlist(strings);
               alpha=new ArrayList<>(strings);
         }
        });

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent=new Intent(getContext(), alphabet_activity.class);
                intent.putExtra("char", alpha.get(position));
                startActivity(intent);
            }
        });
        return v;

    }
}