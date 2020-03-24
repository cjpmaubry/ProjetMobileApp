package com.modildev.mytestapplication1.ui.entrepot3;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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
import com.modildev.mytestapplication1.ui.entrepot1.AddActivity;

import java.util.ArrayList;

public class Entrepot3Fragment extends Fragment {

    private Entrepot3ViewModel toolsViewModel;
    private EditText searchView;
    private ArrayList<Stock> stockList = new ArrayList<Stock>();
    private RecyclerView recyclerView;
    private StockAdapter adapter;
    private Button addButton;
    private Button updateButton;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel = ViewModelProviders.of(this).get(Entrepot3ViewModel.class);
        View root = inflater.inflate(R.layout.fragment_entrepot3, container, false);
        final TextView textView = root.findViewById(R.id.text_entrepot3);
        searchView = root.findViewById(R.id.search_bar3);
        addButton = root.findViewById(R.id.add_button3);
        updateButton = root.findViewById(R.id.update_button3);
        initRecyclerView(root);

        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParameterManager pm = new ParameterManager(getContext());
                pm.open();
                pm.addParameter(new Parameter(3));
                pm.close();
                Intent AddStockIntent = new Intent(getActivity(), AddActivity.class);
                startActivity(AddStockIntent);
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().recreate();
            }
        });

        searchView = root.findViewById(R.id.search_bar3);

        toolsViewModel.getText().observe(this, new Observer<String>() {
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
        stockList = sm.getAll(3);
        sm.close();
        ParameterManager pm = new ParameterManager(getContext());
        recyclerView = root.findViewById(R.id.recyclerView3);
        adapter = new StockAdapter(stockList, sm, pm);
        recyclerView.setAdapter(adapter);
    }

    private void filter(String text){
        ArrayList<Stock> filteredList = new ArrayList<>();
        for (Stock stock: stockList){
            if (stock.getType().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(stock);
            }
        }

        adapter.filterList(filteredList);
    }
}