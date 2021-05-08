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
public class Fragment_Tab_Colecciones_MacroHongos extends Fragment {

    private RecyclerView RecyclerViewMacroHongos;
    private com.example.luvin.drawercero.RecyclerViewMacroHongos adaptadorMacroHongos;
    private LinearLayoutManager layoutManager;
    private ModeloMacroHongos adaptador;

    public Fragment_Tab_Colecciones_MacroHongos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_tab_colecciones_macrohongos, container, false);

        RecyclerViewMacroHongos=(RecyclerView)view.findViewById(R.id.RecyclerMacroHongos);
        layoutManager= new LinearLayoutManager(getActivity());
        RecyclerViewMacroHongos.setLayoutManager(layoutManager);

        adaptadorMacroHongos=new RecyclerViewMacroHongos(obtenermacroHongos());
        RecyclerViewMacroHongos.setAdapter(adaptadorMacroHongos);

        return view;
    }

    public List<ModeloMacroHongos> obtenermacroHongos() {
        List<ModeloMacroHongos> hongos=new ArrayList<>();
        hongos.add(new ModeloMacroHongos(R.drawable.macrohongo1));
        hongos.add(new ModeloMacroHongos(R.drawable.macrohongo2));
        return hongos;
    }
}
