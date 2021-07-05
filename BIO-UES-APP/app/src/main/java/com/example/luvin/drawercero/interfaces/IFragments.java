package com.example.luvin.drawercero.interfaces;


import com.example.luvin.drawercero.Coleccion.ColeccionesConsultarFragment;
import com.example.luvin.drawercero.Coleccion.InformacionFragment;
import com.example.luvin.drawercero.Dominios.ConsultarListaDominiosFragment;
import com.example.luvin.drawercero.Espamen.ConsultarListaEspamen;
import com.example.luvin.drawercero.InicioFragment;
import com.example.luvin.drawercero.MainActivity;
import com.example.luvin.drawercero.Zonas.ConsultarListaZonasFragment;


public interface IFragments extends InicioFragment.OnFragmentInteractionListener,
        ConsultarListaDominiosFragment.OnFragmentInteractionListener, ConsultarListaEspamen.OnFragmentInteractionListener ,
        ConsultarListaZonasFragment.OnFragmentInteractionListener {
}
