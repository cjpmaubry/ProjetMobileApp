package com.modildev.mytestapplication1.ui.entrepot3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.modildev.mytestapplication1.R;

public class Entrepot3Fragment extends Fragment {

    private Entrepot3ViewModel toolsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel =
                ViewModelProviders.of(this).get(Entrepot3ViewModel.class);
        View root = inflater.inflate(R.layout.fragment_entrepot3, container, false);
        final TextView textView = root.findViewById(R.id.text_entrepot3);
        toolsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}