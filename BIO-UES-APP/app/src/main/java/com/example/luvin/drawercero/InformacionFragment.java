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
            add(new Dato("¿Qué es el sobrepeso?","Y en qué es diferente de la obesidad",  R.drawable.cangrejo1, "La obesidad se define como un aumento de composición de grasa corporal. Este aumento se traduce en un incremento del peso y aunque no todo incremento del peso corporal es debido a un aumento del tejido adiposo, en la práctica médica el concepto de obesidad está relacionado con el peso corporal. La obesidad debe ser entendida como una enfermedad crónica, de forma semejante que lo es la diabetes mellitus o la hipertensión arterial. (Fuente: Infosalus.com)\n" +
                    "\n "));
            add(new Dato("¿Qué es el IMC?", "Por qué es importante saberlo",R.drawable.cangrejo2, ""));
            add(new Dato("¿Cómo medir la cintura?", "Cómo saber si tienes la medida correcta",R.drawable.macroalga1, ""));
            add(new Dato("Alimentos que acumulan grasa abdominal", "Y que debes evitar",R.drawable.macroalga2, ""));


        }};
    }
}