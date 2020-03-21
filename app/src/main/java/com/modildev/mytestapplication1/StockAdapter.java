package com.modildev.mytestapplication1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StockAdapter extends RecyclerView.Adapter<StockViewHolder> {

    private final List<Stock> studentList;

    public StockAdapter(@NonNull List<Stock> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StockViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.stock_item, viewGroup, false);
        return new StockViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StockViewHolder studentViewHolder, int position) {
        studentViewHolder.bind(studentList.get(position));
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }
}
