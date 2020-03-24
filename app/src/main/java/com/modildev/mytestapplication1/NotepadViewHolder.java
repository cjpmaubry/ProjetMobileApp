package com.modildev.mytestapplication1;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class NotepadViewHolder extends RecyclerView.ViewHolder {
    public TextView comment;
    public Button delete;

    public NotepadViewHolder(View view){
        super(view);
        comment = (TextView)view.findViewById(R.id.comment);
        delete = (Button)view.findViewById(R.id.delete_notepad_button);
    }

    public void bind(Notepad n){
        comment.setText(n.getComment());
    }
}
