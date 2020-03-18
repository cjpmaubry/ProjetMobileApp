package com.modildev.mytestapplication1.ui.entrepot1;

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

public class Entrepot1Fragment extends Fragment {

    private Entrepot1ViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(Entrepot1ViewModel.class);
        View root = inflater.inflate(R.layout.fragment_entrepot1, container, false);
        final TextView textView = root.findViewById(R.id.text_entrepot1);
        galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}