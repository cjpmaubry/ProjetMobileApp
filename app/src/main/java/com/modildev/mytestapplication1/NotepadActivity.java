package com.modildev.mytestapplication1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;


public class NotepadActivity extends Activity {

    Button newButton,saveButton;
    EditText text;
    SharedPreference sharedpref;
    NotepadManager nm;
    RecyclerView recyclerView;
    ArrayList<Notepad> noteList;
    RecyclerView.LayoutManager layoutManager;
    NotepadAdapter adapter;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedpref = new SharedPreference(this);
        if(sharedpref.loadNightModeState()==true) {
            setTheme(R.style.darktheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notepad);

        newButton=(Button)findViewById(R.id.newButton);
        saveButton=(Button)findViewById(R.id.saveButton);
        text=(EditText)findViewById(R.id.text);


        initrecyclerView();

        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("");
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nm.open();
                nm.addComment(new Notepad(text.getText().toString()));
                nm.close();
                Toast.makeText(getApplicationContext(), "Comment saved",Toast.LENGTH_LONG).show();
                text.setText("");
            }
        });
    }

    private void initrecyclerView(){
        nm = new NotepadManager(getApplicationContext());
        nm.open();
        noteList = nm.getAll();
        nm.close();
        newButton.setText(Integer.toString(noteList.size()));
        recyclerView = (RecyclerView)findViewById(R.id.notepadRecyclerView);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new NotepadAdapter(noteList);
        linearLayoutManager = new LinearLayoutManager(NotepadActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    /*public void buttonAction(View v) {
        final EditText fileName=new EditText(this);
        AlertDialog.Builder ad=new AlertDialog.Builder(this);
        ad.setView(fileName);

        if (v.getId() == R.id.saveButton) {
            ad.setMessage("Save File");

            ad.setPositiveButton("Save",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    try {
                        FileOutputStream fout=openFileOutput(fileName.getText().toString()+".txt",MODE_WORLD_READABLE);
                        fout.write(text.getText().toString().getBytes());
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "Error Occured: "+e,Toast.LENGTH_LONG).show();
                    }
                }
            });

            ad.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            ad.show();

        }


        if(v.getId()==R.id.newButton) {
            text.setText("");
        }
    }*/
}