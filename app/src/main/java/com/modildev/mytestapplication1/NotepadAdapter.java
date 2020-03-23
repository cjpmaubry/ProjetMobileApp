package com.modildev.mytestapplication1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotepadAdapter extends RecyclerView.Adapter<NotepadViewHolder> {
    private ArrayList<Notepad> noteList;

    public NotepadAdapter(ArrayList<Notepad> noteList) {
        this.noteList = noteList;
    }

    @NonNull
    @Override
    public NotepadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.);
        return null;
    }
}
