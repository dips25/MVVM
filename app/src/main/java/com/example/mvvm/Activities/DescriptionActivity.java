package com.example.mvvm.Activities;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.mvvm.Models.Notes;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;



import com.example.mvvm.R;

public class DescriptionActivity extends AppCompatActivity {

    TextView desc_title;
    TextView desc_description;
    ImageView desc_image;
    Intent intent;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        intent = getIntent();
        Notes notes = (Notes) intent.getSerializableExtra("notes");

        desc_title = (TextView) findViewById(R.id.desc_title);
        desc_description = (TextView) findViewById(R.id.desc_description);
        desc_image = (ImageView) findViewById(R.id.desc_image);

        Glide.with(DescriptionActivity.this).load(notes.getImagename())
                .placeholder(R.drawable.picture)
                .into(desc_image);

        desc_title.setText(notes.getTitle());
        desc_description.setText(notes.getDescription());

    }


}