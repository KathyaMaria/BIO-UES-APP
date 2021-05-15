package com.example.luvin.drawercero.Especimenes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.luvin.drawercero.R;



/**
 * A simple {@link Fragment} subclass.
 */
public class EspecimenesConsultarFragment extends Fragment {

    private EspecimenesViewModel especimenesViewModel;

    public EspecimenesConsultarFragment() {
        // Required empty public constructor
    }

    public EspecimenesConsultarFragment newInstance(){
        return new EspecimenesConsultarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container,
                             @NonNull Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_especimenes, container, false);
    }

    @Override
    public void onActivityCreated ( @Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        especimenesViewModel = new ViewModelProvider(this).get(EspecimenesViewModel.class);
        // TODO: Use the ViewModel


    }

}
