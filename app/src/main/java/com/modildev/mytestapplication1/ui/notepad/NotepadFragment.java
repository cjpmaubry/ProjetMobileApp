package com.modildev.mytestapplication1.ui.notepad;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.modildev.mytestapplication1.MainActivity;
import com.modildev.mytestapplication1.MainActivity2;
import com.modildev.mytestapplication1.NotepadActivity;
import com.modildev.mytestapplication1.R;

public class NotepadFragment extends Fragment {

    private NotepadViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(NotepadViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notepad, container, false);

        initUI(root);
        return(root);
    }

    private void initUI(View v) {
        Button button = (Button) v.findViewById(R.id.button_notepad);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Change the Activity
                Intent intent = new Intent(getActivity(), NotepadActivity.class);
                startActivity(intent);

            }
        });


    }
}