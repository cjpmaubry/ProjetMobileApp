package com.modildev.mytestapplication1.ui.entrepot1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.modildev.mytestapplication1.MainActivity;
import com.modildev.mytestapplication1.Parameter;
import com.modildev.mytestapplication1.ParameterManager;
import com.modildev.mytestapplication1.R;
import com.modildev.mytestapplication1.Stock;
import com.modildev.mytestapplication1.StockManager;

public class AddActivity extends AppCompatActivity {
    private EditText add_type;
    private EditText add_quantity;
    //private EditText add_warehouse;
    private Button add_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        add_quantity = (EditText)findViewById(R.id.add_quantity);
        add_type = (EditText) findViewById(R.id.add_type);
        //add_warehouse = (EditText)findViewById(R.id.add_warehouse_name);
        add_submit = (Button)findViewById(R.id.add_submit);

        add_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParameterManager pm = new ParameterManager(getApplicationContext());
                pm.open();
                //Parameter p = pm.getLastP();
                int p = pm.getLastP();
                pm.close();

                String type = add_type.getText().toString();
                String q = add_quantity.getText().toString();

                //Toast.makeText(getApplicationContext(), "you cannot enter a null type or quantity ",Toast.LENGTH_LONG).show();
                if (type.equals("") || q.equals("")) {
                    Toast.makeText(getApplicationContext(), "you cannot enter a null type or quantity ",Toast.LENGTH_LONG).show();
                }
                else
                {
                    int quantity = Integer.parseInt(q);
                    if (quantity > 0) {
                        //int warehouseId = p.getParameter1();
                        Stock s = new Stock(type, quantity, p);
                        StockManager sm = new StockManager(getApplicationContext());
                        sm.open();
                        sm.addStock(s);
                        sm.close();
                        Intent backHomeIntent = new Intent(AddActivity.this, MainActivity.class);
                        startActivity(backHomeIntent);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "the quantity must be positive ",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
