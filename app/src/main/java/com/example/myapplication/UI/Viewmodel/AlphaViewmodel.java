package com.example.myapplication.UI.Viewmodel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.data.Repo;

import java.util.Arrays;
import java.util.List;

public class AlphaViewmodel extends ViewModel {
Repo repo;
    MutableLiveData<List<String>> alphaMutableLiveData = new MutableLiveData<>();

    public LiveData<List<String>> getalphamutablelivedata() {
        getalpha();
        return alphaMutableLiveData;
    }
    private void getalpha(){
        if (repo==null){
            repo =new Repo();
        }
        alphaMutableLiveData.setValue(Arrays.asList(repo.setAlpha()));
    }
}
