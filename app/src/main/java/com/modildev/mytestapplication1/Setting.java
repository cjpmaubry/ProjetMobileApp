package com.modildev.mytestapplication1;

import android.content.Intent;
import android.os.Bundle;

import android.widget.CompoundButton;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.AppCompatActivity;


public class Setting extends AppCompatActivity {
    private Switch myswitch;
    SharedPreference sharedpref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedpref = new SharedPreference(this);
        if(sharedpref.loadNightModeState()==true) {
            setTheme(R.style.darktheme);
        }
        else  setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        myswitch=(Switch)findViewById(R.id.myswitch);
        if (sharedpref.loadNightModeState()==true) {
            myswitch.setChecked(true);
        }
        myswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    sharedpref.setNightModeState(true);
                    restartApp();
                }
                else {
                    sharedpref.setNightModeState(false);
                    restartApp();
                }
            }
        });
    }
    public void restartApp () {
        Intent i = new Intent(getApplicationContext(),Setting.class);
        startActivity(i);
        finish();
    }
}