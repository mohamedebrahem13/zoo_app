package com.example.myapplication.UI.Viewmodel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.data.Animal;
import com.example.myapplication.data.Repo;
import java.util.List;

public class Animalviewmodel extends ViewModel {
    Repo repo;



    MutableLiveData<List<Animal>> AnimalMutableLiveData= new MutableLiveData<>();



    public LiveData<List<Animal>> getAnimalMutableLiveData() {
            getanimals();
        return AnimalMutableLiveData;
    }



    private void getanimals() {
        if (repo==null){
            repo =new Repo();
        }

        AnimalMutableLiveData.setValue(repo.setanimals());

    }




    }
