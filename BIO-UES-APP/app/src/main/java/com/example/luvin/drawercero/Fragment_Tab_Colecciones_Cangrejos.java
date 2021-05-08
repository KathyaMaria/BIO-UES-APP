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
