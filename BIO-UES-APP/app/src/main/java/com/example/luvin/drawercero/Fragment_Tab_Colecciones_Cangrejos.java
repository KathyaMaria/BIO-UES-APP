package com.example.luvin.drawercero;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.luvin.drawercero.ModeloCangrejos;
import com.example.luvin.drawercero.R;
import com.example.luvin.drawercero.RecyclerViewCangrejos;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Tab_Colecciones_Cangrejos extends Fragment {


    private RecyclerView RecyclerViewCangrejos;
    private com.example.luvin.drawercero.RecyclerViewCangrejos adaptadorCangrejos;
    private LinearLayoutManager layoutManager;
    private ModeloCangrejos adaptador;

    public Fragment_Tab_Colecciones_Cangrejos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_tab_colecciones_cangrejos, container, false);

        RecyclerViewCangrejos=(RecyclerView)view.findViewById(R.id.RecyclerCangrejos);
        layoutManager= new LinearLayoutManager(getActivity());
        RecyclerViewCangrejos.setLayoutManager(layoutManager);

        adaptadorCangrejos=new RecyclerViewCangrejos(obtenerCangrejos());
        RecyclerViewCangrejos.setAdapter(adaptadorCangrejos);

        return view;
    }

    public List<ModeloCangrejos> obtenerCangrejos() {
        List<ModeloCangrejos> cangrejos=new ArrayList<>();
        cangrejos.add(new ModeloCangrejos(R.drawable.cangrejo1));
        cangrejos.add(new ModeloCangrejos(R.drawable.cangrejo2));

        return cangrejos;
    }

}
