package com.modildev.mytestapplication1;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


class StockViewHolder extends RecyclerView.ViewHolder {

    private TextView type;
    private TextView quantity;
    private Button edit_button;
    private Button remove_button;


    public StockViewHolder(@NonNull View itemView) {
        super(itemView);
        type = itemView.findViewById(R.id.type);
        quantity = itemView.findViewById(R.id.quantity);
        edit_button = itemView.findViewById(R.id.edit_button);
        remove_button = itemView.findViewById(R.id.remove_button);
    }

    public void bind(Stock s) {
        type.setText(s.getType());
        quantity.setText(Integer.toString(s.getQuantity()));

        remove_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
