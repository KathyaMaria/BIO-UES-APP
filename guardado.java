package com.example.luvin.drawercero.interfaces;


import com.example.luvin.drawercero.fragments.BienvenidaFragment;
import com.example.luvin.drawercero.fragments.ConsultaListaUsuarioImagenUrlFragment;
import com.example.luvin.drawercero.fragments.ConsultaUsuarioUrlFragment;
import com.example.luvin.drawercero.fragments.ConsultarListaUsuariosFragment;
import com.example.luvin.drawercero.fragments.ConsultarUsuarioFragment;
import com.example.luvin.drawercero.fragments.ConsutarListausuarioImagenFragment;
import com.example.luvin.drawercero.fragments.DesarrolladorFragment;
import com.example.luvin.drawercero.fragments.RegistrarUsuarioFragment;

/**
 * Created by CHENAO on 5/08/2017.
 */

public interface IFragments extends BienvenidaFragment.OnFragmentInteractionListener,DesarrolladorFragment.OnFragmentInteractionListener,
        RegistrarUsuarioFragment.OnFragmentInteractionListener,ConsultarUsuarioFragment.OnFragmentInteractionListener,
        ConsultarListaUsuariosFragment.OnFragmentInteractionListener,ConsutarListausuarioImagenFragment.OnFragmentInteractionListener,
        ConsultaUsuarioUrlFragment.OnFragmentInteractionListener,ConsultaListaUsuarioImagenUrlFragment.OnFragmentInteractionListener{
}
