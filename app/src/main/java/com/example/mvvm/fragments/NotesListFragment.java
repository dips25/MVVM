package com.example.mvvm.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


import com.example.mvvm.MainActivity;
import com.example.mvvm.Models.Notes;
import com.example.mvvm.R;
import com.example.mvvm.ViewModel.NotesViewModel;
import com.example.mvvm.adapters.NotesAdapter;

import java.util.ArrayList;

public class NotesListFragment extends Fragment {

    RecyclerView notesList;
    NotesAdapter notesAdapter;
    ArrayList<Notes> notesArrList = new ArrayList<>();
    NotesViewModel viewModel;
    Context context;
    private static final String TAG = NotesListFragment.class.getSimpleName();





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_list, container, false);
        notesList = (RecyclerView) view.findViewById(R.id.notes_list);
        notesAdapter = new NotesAdapter(getActivity() , notesArrList);
        notesList.setLayoutManager(new LinearLayoutManager(getActivity()));
        notesList.setHasFixedSize(true);
        notesList.setAdapter(notesAdapter);

        viewModel = new ViewModelProvider(getActivity()).get(NotesViewModel.class);
        //viewModel.init();

        viewModel.getNotes().observe(getActivity(), new Observer<ArrayList<Notes>>() {
            @Override
            public void onChanged(ArrayList<Notes> notesArrayList) {

                notesAdapter.setData(notesArrayList);

            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        Log.d(TAG, "onAttach: Attached");

        this.context =  context;


    }
}