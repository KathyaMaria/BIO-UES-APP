package com.example.luvin.drawercero.Especimenes;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EspecimenesViewModel extends ViewModel{

    private  MutableLiveData<String> mText;

    public EspecimenesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Especimen fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
