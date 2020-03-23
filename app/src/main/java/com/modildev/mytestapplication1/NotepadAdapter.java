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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notepad_item,parent,false);
        return new NotepadViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotepadViewHolder holder, int position) {
        holder.comment.setText(noteList.get(position).getComment());
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }
}
