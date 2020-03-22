package com.modildev.mytestapplication1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StockAdapter extends RecyclerView.Adapter<StockViewHolder> implements Filterable {

    private List<Stock> stockList;
    private List<Stock> stockListFull;


    public StockAdapter(List<Stock> stockList) {
        this.stockList = stockList;
        this.stockListFull = new ArrayList<>(stockList);
    }

    @NonNull
    @Override
    public StockViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.stock_item, viewGroup, false);
        return new StockViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StockViewHolder studentViewHolder, int position) {
        studentViewHolder.bind(stockList.get(position));
    }

    @Override
    public int getItemCount() {
        return stockList.size();
    }

    @Override
    public Filter getFilter() {
        return StockFilter;
    }

    private Filter StockFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Stock> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(stockListFull);
            }
            else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Stock stock: stockListFull){
                    if (stock.getType().toLowerCase().contains(filterPattern)){
                        filteredList.add(stock);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            stockList.clear();
            stockList.addAll((ArrayList)results.values);
            notifyDataSetChanged();
        }
    };
}
