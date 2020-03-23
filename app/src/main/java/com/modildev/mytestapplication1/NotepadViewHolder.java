package com.modildev.mytestapplication1;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class NotepadViewHolder extends RecyclerView.ViewHolder {
    public TextView comment;

    public NotepadViewHolder(View view){
        super(view);
        comment = (TextView)view.findViewById(R.id.comment);
    }

    public void bind(Notepad n){
        comment.setText(n.getComment());
    }
}
