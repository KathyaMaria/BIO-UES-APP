package com.example.luvin.drawercero;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.luvin.drawercero.ModeloMoluscos;
import com.example.luvin.drawercero.R;
import com.example.luvin.drawercero.RecyclerViewMoluscos;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Tab_Colecciones_Moluscos extends Fragment {

    private RecyclerView RecyclerViewMoluscos;
    private com.example.luvin.drawercero.RecyclerViewMoluscos adaptadorMoluscos;
    private LinearLayoutManager layoutManager;
    private ModeloMoluscos adaptador;



    public Fragment_Tab_Colecciones_Moluscos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_tab_colecciones_moluscos, container, false);

        RecyclerViewMoluscos=(RecyclerView)view.findViewById(R.id.RecyclerMoluscos);
        layoutManager= new LinearLayoutManager(getActivity());
        RecyclerViewMoluscos.setLayoutManager(layoutManager);

        adaptadorMoluscos=new RecyclerViewMoluscos(obtenermoluscos());
        RecyclerViewMoluscos.setAdapter(adaptadorMoluscos);

        return view;
    }

    public List<ModeloMoluscos> obtenermoluscos() {
        List<ModeloMoluscos> moluscos=new ArrayList<>();
        moluscos.add(new ModeloMoluscos(R.drawable.moluscos1));
        moluscos.add(new ModeloMoluscos(R.drawable.moluscos2));
        moluscos.add(new ModeloMoluscos(R.drawable.moluscos3));
        moluscos.add(new ModeloMoluscos(R.drawable.moluscos4));
        return moluscos;
    }
}
