package com.modildev.mytestapplication1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotepadAdapter extends RecyclerView.Adapter<NotepadViewHolder> {
    private ArrayList<Notepad> noteList;
    private NotepadManager nm;

    public NotepadAdapter(ArrayList<Notepad> noteList, NotepadManager nm) {
        this.noteList = noteList;
        this.nm = nm;
    }

    @NonNull
    @Override
    public NotepadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notepad_item,parent,false);
        return new NotepadViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotepadViewHolder holder, final int position) {
        holder.bind(noteList.get(position));

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nm.open();
                int Id = noteList.get(position).getId();
                nm.deleteComment(Id);
                noteList.remove(position);
                nm.close();
            }
        });
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }
}
