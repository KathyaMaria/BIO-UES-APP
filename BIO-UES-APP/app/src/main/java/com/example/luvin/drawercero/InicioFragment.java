package com.example.luvin.drawercero;

import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.luvin.drawercero.Inicio.InicioViewModel;

import java.util.ArrayList;



/**
 * A simple {@link Fragment} subclass.
 */
public class InicioFragment extends Fragment {
    private InicioViewModel inicioViewModel;


    public InicioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        inicioViewModel = new ViewModelProvider(this).get(InicioViewModel.class);
        // TODO: Use the ViewModel
    }
}
