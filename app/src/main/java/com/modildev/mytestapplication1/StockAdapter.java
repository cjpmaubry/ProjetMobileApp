package com.modildev.mytestapplication1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StockAdapter extends RecyclerView.Adapter<StockAdapter.StockViewHolder> {
    private ArrayList<Stock> stockList;

    public static class StockViewHolder extends RecyclerView.ViewHolder{
        public TextView type;
        public TextView quantity;

        public StockViewHolder(@NonNull View itemView) {
            super(itemView);
            type = itemView.findViewById(R.id.type);
            quantity = itemView.findViewById(R.id.quantity);
        }
    }

    public StockAdapter(ArrayList<Stock> stockList) {
        this.stockList = stockList;
    }

    @NonNull
    @Override
    public StockViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        StockViewHolder svh = new StockViewHolder(v);
        return svh;
    }

    @Override
    public void onBindViewHolder(@NonNull StockViewHolder holder, int position) {
        Stock currentItem = stockList.get(position);
        holder.type.setText(currentItem.getType());
        holder.quantity.setText(currentItem.getQuantity());
    }

    @Override
    public int getItemCount() {
        return stockList.size();
    }
}
