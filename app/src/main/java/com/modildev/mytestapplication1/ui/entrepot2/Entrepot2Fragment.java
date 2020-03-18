package com.modildev.mytestapplication1.ui.entrepot2;

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

public class Entrepot2Fragment extends Fragment {

    private Entrepot2ViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(Entrepot2ViewModel.class);
        View root = inflater.inflate(R.layout.fragment_entrepot2, container, false);
        final TextView textView = root.findViewById(R.id.text_entrepot2);
        slideshowViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}