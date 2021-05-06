package com.example.luvin.drawercero;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class InformacionFragment extends Fragment {
    private List<Dato> datos;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;

    public InformacionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_informacion, container, false);
        datos = this.getAllData();
        mRecyclerView =  view.findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new InformacionAdapter(datos, R.layout.list_item_informacion,
                new InformacionAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(Dato dato, int position) {


                    }
                });
        mRecyclerView.setHasFixedSize(true);
        // Añade un efecto por defecto, si le pasamos null lo desactivamos por completo
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        // Enlazamos el layout manager y adaptador directamente al recycler view
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


        return view;
    }

    private List<Dato> getAllData(){
        return new ArrayList<Dato>() {{
            add(new Dato("Colección Cangrejos","Nueva Coleccion Cangrejo",  R.drawable.cangrejo1, "Los crustáceos constituyen un enorme y diverso grupo del reino animal, con grandes utilidades ecológicas, alimenticias y económicas; lo que ha permitido en muchas partes del mundo despertar un interés en el campo de la investigación. Uno de los subgrupos más importantes de Crustáceos Decápodos, lo constituyen los cangrejos tanto marinos como de agua dulce, los cuales se distribuyen desde mar adentro, costas ,playas, baja marea, esteros, zonas dulces, terrestres, ríos,  lagos, lagunas y  otros cuerpos de agua de menor volumen.\n" +
                    "\n "));
            add(new Dato("Colección Macrohongos", "Por qué es importante saberlo",R.drawable.cangrejo2, ""));
            add(new Dato("Colección MacroAlgas", "¿Que son las MacroAlgas?",R.drawable.macroalga1, ""));
            add(new Dato("Colección Moluscos", "¿Que son los Moluscos?'",R.drawable.moluscos1, ""));


        }};
    }
}