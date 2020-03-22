package com.modildev.mytestapplication1.ui.entrepot1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.modildev.mytestapplication1.Parameter;
import com.modildev.mytestapplication1.ParameterManager;
import com.modildev.mytestapplication1.R;
import com.modildev.mytestapplication1.Stock;
import com.modildev.mytestapplication1.StockAdapter;
import com.modildev.mytestapplication1.StockManager;

import java.util.ArrayList;

public class Entrepot1Fragment extends Fragment {

    private Entrepot1ViewModel galleryViewModel;
    private SearchView searchView;
    private ArrayList<Stock> stockList = new ArrayList<Stock>();
    private RecyclerView recyclerView;
    private StockAdapter adapter;
    private Button addButton;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        galleryViewModel = ViewModelProviders.of(this).get(Entrepot1ViewModel.class);
        View root = inflater.inflate(R.layout.fragment_entrepot1, container, false);
        final TextView textView = root.findViewById(R.id.text_entrepot1);
        searchView = root.findViewById(R.id.search_bar1);
        addButton = root.findViewById(R.id.add_button1);

        initRecyclerView(root);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParameterManager pm = new ParameterManager(getContext());
                pm.open();
                pm.addParameter(new Parameter(1));
                pm.close();
                Intent AddStockIntent = new Intent(getActivity(), AddActivity.class);
                startActivity(AddStockIntent);
            }
        });

        searchView = root.findViewById(R.id.search_bar1);


        galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    private void initRecyclerView(View root){
        StockManager sm = new StockManager(getContext());
        sm.open();
        stockList = sm.getAll(1);
        sm.close();
        ParameterManager pm = new ParameterManager(getContext());
        recyclerView = root.findViewById(R.id.recyclerView1);
        adapter = new StockAdapter(stockList, sm, pm);
        recyclerView.setAdapter(adapter);
    }
}