package com.example.myapplication.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapplication.UI.BlankFragment;
import com.example.myapplication.UI.BlankFragment2;
import com.example.myapplication.UI.alphabetFragment;
import com.example.myapplication.UI.animalFragment;

public class viewpageradapter extends FragmentStateAdapter {
    private String[]FragmentsName={"Sound","ALPHAPET","BLANK","BLANK2"};

    public viewpageradapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new animalFragment();
            case 1: return new alphabetFragment();
            case 2:return new BlankFragment();
            case 3:return new BlankFragment2();
        }
        return new animalFragment();
    }

    @Override
    public int getItemCount() {
        return FragmentsName.length;
    }
}