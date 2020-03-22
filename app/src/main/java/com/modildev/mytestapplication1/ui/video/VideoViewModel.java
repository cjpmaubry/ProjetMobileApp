package com.modildev.mytestapplication1.ui.video;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class VideoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public VideoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Welcome to video module. If you click to the button you could see some video about good practice for storage");
    }

    public LiveData<String> getText() {
        return mText;
    }
}