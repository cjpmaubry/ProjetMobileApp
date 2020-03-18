package com.modildev.mytestapplication1.ui.entrepot2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Entrepot2ViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public Entrepot2ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}