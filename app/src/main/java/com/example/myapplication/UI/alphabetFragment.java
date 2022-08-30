package com.example.myapplication.UI;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.myapplication.Adapter.AlphabetAdapter;
import com.example.myapplication.R;
import com.example.myapplication.data.Animallist;



public class alphabetFragment extends Fragment {
Intent intent;
AlphabetAdapter alphabetAdapter;
    String[] alpha;



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
        Animallist alphabetlist = (Animallist) requireActivity().getApplication();
        alpha=alphabetlist.getAlpha();
        GridView gv =v.findViewById(R.id.grid);
        alphabetAdapter=new AlphabetAdapter(getContext(),alpha);

        gv.setAdapter(alphabetAdapter);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent=new Intent(getContext(), alphabet_activity.class);
                intent.putExtra("char", alpha[position]);
                startActivity(intent);
            }
        });
        return v;

    }
}