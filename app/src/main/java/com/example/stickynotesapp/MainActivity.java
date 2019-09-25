package com.example.stickynotesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.stickynotesapp.Adapters.NotesRecyclerAdapter;
import com.example.stickynotesapp.Models.Note;
import com.example.stickynotesapp.Util.VerticalSpacingItemDecorator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;

    private ArrayList<Note> noteArrayList = new ArrayList<>();
    private NotesRecyclerAdapter notesRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.notes_recycler);
        initRecyclerView();
        fakeNodes();
    }

    private void fakeNodes(){
            for (int i=0; i<100; i++){
                Note note = new Note();
                note.setTitle("title# " + i);
                note.setContent("Content# " + i);
                note.setTimestamp("Sept 2019");
                noteArrayList.add(note);
            }
            notesRecyclerAdapter.notifyDataSetChanged();
    }

    private void initRecyclerView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        VerticalSpacingItemDecorator decorator = new VerticalSpacingItemDecorator(10);
        recyclerView.addItemDecoration(decorator);
        notesRecyclerAdapter = new NotesRecyclerAdapter(noteArrayList);
        recyclerView.setAdapter(notesRecyclerAdapter);
    }
}
