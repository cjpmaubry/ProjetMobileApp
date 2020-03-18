package com.modildev.mytestapplication1.ui.entrepot3;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Entrepot3ViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public Entrepot3ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is tools fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}