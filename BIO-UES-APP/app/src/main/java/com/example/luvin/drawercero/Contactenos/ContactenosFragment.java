package com.example.luvin.drawercero.Contactenos;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.luvin.drawercero.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactenosFragment extends Fragment {
    ContactenosViewModel contactenosViewModel;

    public ContactenosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contactenos, container, false);
    }
    public void onActivityCreated ( @Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        contactenosViewModel = new ViewModelProvider(this).get(ContactenosViewModel.class);

    }
}
