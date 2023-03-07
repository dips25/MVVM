package com.example.mvvm.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvvm.Activities.DescriptionActivity;
import com.example.mvvm.Models.Notes;
import com.example.mvvm.R;

import java.io.Serializable;
import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Notes> notesArrayList = new ArrayList<>();

    public NotesAdapter(Context context, ArrayList<Notes> notesArrayList) {

        this.context = context;
        this.notesArrayList = notesArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_notes , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Notes notes = notesArrayList.get(position);

        holder.title.setText(notes.getTitle());
        holder.description.setText(notes.getDescription());
        Glide.with(context)
                .load(notes.getImagename())
                .placeholder(R.drawable.picture)
                .into(holder.image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context , DescriptionActivity.class);
                intent.putExtra("notes" , (Serializable) notes);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return notesArrayList.size();
    }

    public void setData(ArrayList<Notes> notesArrayList) {

        this.notesArrayList.clear();
        this.notesArrayList = notesArrayList;
        notifyDataSetChanged();


    }

     static class ViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        TextView description;
        ImageView image;


        public ViewHolder(@NonNull View v) {
            super(v);

            title = (TextView) v.findViewById(R.id.title);
            description = (TextView) v.findViewById(R.id.description);
            image = (ImageView) v.findViewById(R.id.image);


        }
    }


}


