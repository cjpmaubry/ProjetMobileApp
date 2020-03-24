package com.modildev.mytestapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {
    private EditText newType;
    private EditText newQuantity;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        newType = (EditText)findViewById(R.id.new_type);
        newQuantity = (EditText)findViewById(R.id.new_quantity);
        submitButton = (Button) findViewById(R.id.edit_submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParameterManager pm = new ParameterManager(getApplicationContext());
                pm.open();
                pm.close();

                String NewType = newType.getText().toString();
                int NewQuantity = Integer.parseInt(newQuantity.getText().toString());
                StockManager sm = new StockManager(getApplicationContext());
                sm.open();
                sm.close();
                Intent backHomeIntent= new Intent(EditActivity.this, MainActivity.class);
                startActivity(backHomeIntent);

            }
        });
    }
}
