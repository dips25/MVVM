package com.example.mvvm.Repo;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvm.MainActivity;
import com.example.mvvm.Models.Notes;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.core.View;

import java.util.ArrayList;

public class Repo {

    static Repo instance;
    public MutableLiveData<ArrayList<Notes>> liveData = new MutableLiveData<>();
    public ArrayList<Notes> notesArrayList = new ArrayList<>();
    public FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String TAG = Repo.class.getSimpleName();
    //DataLoadListener dataLoadListener;


    public static Repo getInstance() {

        if (instance == null) {

            return  new Repo();
        }

        return instance;

    }


    public MutableLiveData<ArrayList<Notes>> getItems() {

        FirebaseFirestore.getInstance().collection("Notes")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                        if (error != null) {

                            return;
                        }

                        if (value != null) {

                            if (!value.isEmpty()) {

                               notesArrayList.addAll(value.toObjects(Notes.class));

//                                for (DocumentChange documentChange : value.getDocumentChanges()) {
//
//                                    switch (documentChange.getType()) {
//
//                                        case ADDED:
//
//                                            notesArrayList.add(documentChange.getDocument().toObject(Notes.class));
//                                            break;
//
//                                        case REMOVED:
//                                            notesArrayList.remove(documentChange.getDocument().toObject(Notes.class));
//                                            break;
//                                    }
//                                }


                                liveData.postValue(notesArrayList);
                            }
                        }


                    }
                });


        return liveData;







    }






}
