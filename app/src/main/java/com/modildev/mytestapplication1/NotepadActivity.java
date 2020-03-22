package com.modildev.mytestapplication1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;


public class NotepadActivity extends Activity {

    Button newButton,saveButton;
    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notepad);

        newButton=(Button)findViewById(R.id.newButton);
        saveButton=(Button)findViewById(R.id.saveButton);
        text=(EditText)findViewById(R.id.text);
    }

    public void buttonAction(View v) {
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
    }
}