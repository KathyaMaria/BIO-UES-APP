package com.example.luvin.drawercero;


import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.fragment.app.FragmentManager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ColeccionesInsertarFragment extends Fragment {

    public ColeccionesInsertarFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.fragment_colecciones_insertar, container, false);

        TextInputLayout tipoColeccion;
        AutoCompleteTextView colecciones = null;
        ArrayList<String> arrayListColecciones;
        ArrayAdapter<String> arrayAdapterColecciones;
        String TipoColeccion[] = {"","Humeda","Seca"};


        tipoColeccion=(TextInputLayout) view.findViewById(R.id.tipoColecciones);
        colecciones=(AutoCompleteTextView)view.findViewById(R.id.autoCompleteTextViewColecciones);
        arrayListColecciones=new ArrayList<>();
        arrayListColecciones.add("Humeda");
        arrayListColecciones.add("Seca");

       // ArrayAdapter<String> arrayAdapter =new ArrayAdapter<String>(getActivity().getApplicationContext(),
         //       android.R.layout.activity_list_item,TipoColeccion);
        ArrayAdapter<String> arrayAdapter =new ArrayAdapter<String>(getActivity().getApplicationContext(),
                  android.R.layout.simple_spinner_dropdown_item,arrayListColecciones);
        colecciones.setAdapter(arrayAdapter);
        colecciones.setThreshold(1);

       //Seleccion de los tipos de Coleccion
       colecciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if(position==0)
                {
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,
                            new ColeccionesInsertarFragment()).commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return view;

    }
}

