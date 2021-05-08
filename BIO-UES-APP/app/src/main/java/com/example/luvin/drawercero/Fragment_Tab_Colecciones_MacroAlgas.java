package com.example.luvin.drawercero;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Tab_Colecciones_MacroAlgas extends Fragment {


    private RecyclerView RecyclerViewMacroAlgas;
    private com.example.luvin.drawercero.RecyclerViewMacroAlgas adaptadorMacroAlgas;
    private LinearLayoutManager layoutManager;
    private ModeloMacroAlgas adaptador;

    public Fragment_Tab_Colecciones_MacroAlgas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_tab_colecciones_macroalgas, container, false);

        RecyclerViewMacroAlgas=(RecyclerView)view.findViewById(R.id.RecyclerMacroAlgas);
        layoutManager= new LinearLayoutManager(getActivity());
        RecyclerViewMacroAlgas.setLayoutManager(layoutManager);

        adaptadorMacroAlgas=new RecyclerViewMacroAlgas(obteneralgas());
        RecyclerViewMacroAlgas.setAdapter(adaptadorMacroAlgas);

        return view;
    }

    public List<ModeloMacroAlgas> obteneralgas() {
        List<ModeloMacroAlgas> algas=new ArrayList<>();
        algas.add(new ModeloMacroAlgas(R.drawable.macroalga1));
        algas.add(new ModeloMacroAlgas(R.drawable.macroalga2));
        algas.add(new ModeloMacroAlgas(R.drawable.macroalga3));

        return algas;
    }

}
