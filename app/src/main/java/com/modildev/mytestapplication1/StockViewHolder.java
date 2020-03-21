package com.modildev.mytestapplication1;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class StockViewHolder extends RecyclerView.ViewHolder {

    private TextView type;
    private TextView quantity;

    public StockViewHolder(@NonNull View itemView) {
        super(itemView);
        type = itemView.findViewById(R.id.type);
        quantity = itemView.findViewById(R.id.quantity);
    }

    public void bind(Stock student) {
        type.setText(student.getType());
        quantity.setText(Integer.toString(student.getQuantity()));
    }
}
