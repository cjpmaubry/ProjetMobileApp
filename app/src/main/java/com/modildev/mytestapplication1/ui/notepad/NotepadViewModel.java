package com.modildev.mytestapplication1.ui.notepad;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NotepadViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NotepadViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}