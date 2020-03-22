package com.modildev.mytestapplication1.ui.entrepot1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.modildev.mytestapplication1.R;
import com.modildev.mytestapplication1.Stock;
import com.modildev.mytestapplication1.StockManager;
import com.modildev.mytestapplication1.WarehouseManager;

public class AddActivity extends AppCompatActivity {
    private EditText add_type;
    private EditText add_quantity;
    private EditText add_warehouse;
    private Button add_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        add_quantity = (EditText)findViewById(R.id.add_quantity);
        add_type = (EditText) findViewById(R.id.add_type);
        add_warehouse = (EditText)findViewById(R.id.add_warehouse_name);
        add_submit = (Button)findViewById(R.id.add_submit);

        add_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WarehouseManager wm = new WarehouseManager(getApplicationContext());
                wm.open();
                int warehouseId = 0;
                
                wm.getId(add_warehouse.getText().toString());
                wm.close();
                StockManager sm = new StockManager(getApplicationContext());
                sm.open();
                sm.addStock(new Stock(add_type.getText().toString(), Integer.parseInt(add_quantity.getText().toString()), warehouseId));
                sm.close();
                Intent backToWarehouse;

            }
        });
    }
}
