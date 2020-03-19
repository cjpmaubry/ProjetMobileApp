package com.modildev.mytestapplication1.ui.home2;

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
import com.modildev.mytestapplication1.R;

public class HomeFragment2 extends Fragment {

    private HomeViewModel2 homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container2, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel2.class);
        View root = inflater.inflate(R.layout.fragment_home2, container2, false);

        initUI(root);
        return(root);
    }

    private void initUI(View v) {
        Button button = (Button) v.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Change the Activity
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }
        });


    }
}