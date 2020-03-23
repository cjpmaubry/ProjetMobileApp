package com.modildev.mytestapplication1;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StockAdapter extends RecyclerView.Adapter<StockViewHolder> {

    private List<Stock> stockList;
    private StockManager sm;
    private ParameterManager pm;

    public StockAdapter(List<Stock> stockList, StockManager stockManager, ParameterManager parameterManager) {
        this.stockList = stockList;
        this.sm = stockManager;
        this.pm = parameterManager;
    }

    @NonNull
    @Override
    public StockViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.stock_item, viewGroup, false);
        return new StockViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StockViewHolder stockViewHolder, final int position) {
        stockViewHolder.bind(stockList.get(position));

        /*stockViewHolder.edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pm.open();
                sm.open();
                int Id = stockList.get(position).getId();
                Stock s = sm.getStock(Id);
                pm.addParameter(new Parameter(Id,s.getWarehouseID()));
                pm.close();
                sm.close();
                //Intent EditIntent = new Intent(StockAdapter.this, EditActivity.class);
            }
        });*/

        stockViewHolder.remove_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sm.open();
                int Id = stockList.get(position).getId();
                sm.deleteStock(Id);
                stockList.remove(position);
                sm.close();
            }
        });
    }

    @Override
    public int getItemCount() {
        return stockList.size();
    }

    public void filterList(ArrayList<Stock> filteredList){
        stockList = filteredList;
        notifyDataSetChanged();
    }
}
