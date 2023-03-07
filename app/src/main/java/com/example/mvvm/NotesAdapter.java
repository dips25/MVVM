package com.example.mvvm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mvvm.Models.Notes;

import java.util.ArrayList;

public class NotesAdapter extends BaseAdapter {

    Context context;
    ArrayList<Notes> notesArrayList;

    public NotesAdapter(Context context , ArrayList<Notes> notes) {

        this.context = context;
        this.notesArrayList = notes;
    }

    @Override
    public int getCount() {
        return notesArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return notesArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Notes notes = notesArrayList.get(position);

        View view = convertView;
        ViewHolder viewHolder;

        if (view == null) {

            view = LayoutInflater.from(context).inflate(R.layout.single_item_notes , parent , false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);

        } else {

            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.title.setText(notes.getTitle());
        viewHolder.description.setText(notes.getDescription());
        return view;
    }

    public class ViewHolder {

        TextView title;
        TextView description;

        public ViewHolder(View view) {

            title = (TextView) view.findViewById(R.id.title);
            description = (TextView) view.findViewById(R.id.description);
        }


    }
}
