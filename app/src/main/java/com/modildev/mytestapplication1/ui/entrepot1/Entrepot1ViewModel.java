package com.modildev.mytestapplication1.ui.entrepot1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Entrepot1ViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public Entrepot1ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}