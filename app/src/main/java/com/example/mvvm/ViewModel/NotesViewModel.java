package com.example.mvvm.ViewModel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;


import com.example.mvvm.Models.Notes;
import com.example.mvvm.Repo.Repo;

import java.util.ArrayList;

public class NotesViewModel extends ViewModel {

    MutableLiveData<ArrayList<Notes>> mutableLiveData = new MutableLiveData<>();

    public void init() {



        //mutableLiveData = Repo.getInstance().getNotes();


    }




    public LiveData<ArrayList<Notes>> getNotes() {

        return Repo.getInstance().getItems();
    }




}
