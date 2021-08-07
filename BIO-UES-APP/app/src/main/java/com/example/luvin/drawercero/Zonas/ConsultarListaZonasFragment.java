package com.example.luvin.drawercero.Zonas;

import android.net.Uri;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.luvin.drawercero.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ConsultarListaZonasFragment  extends Fragment implements Response.Listener<JSONObject>,Response.ErrorListener, SearchView.OnQueryTextListener {
// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private static final String ARG_PARAM1 = "param1";
private static final String ARG_PARAM2 = "param2";
private static final String ARG_PARAM3 = "param3";
private static final String ARG_PARAM4 = "param4";
private static final String ARG_PARAM5 = "param5";
private static final String ARG_PARAM6 = "param6";
private static final String ARG_PARAM7 = "param7";
private static final String ARG_PARAM8 = "param8";
private static final String ARG_PARAM9 = "param9";
ZonaAdapter adapter;

// TODO: Rename and change types of parameters
private String mParam1;
private String mParam2;
private String mParam3;
private String mParam4;
private String mParam5;
private String mParam6;
private String mParam7;
private String mParam8;
private String mParam9;

private OnFragmentInteractionListener mListener;

        SearchView txtBuscarZona;
        RecyclerView recyclerZona;
        ArrayList<Zona> listaZona;

        ProgressDialog progress;

        // RequestQueue request;
        JsonObjectRequest jsonObjectRequest;


public ConsultarListaZonasFragment() {
        // Required empty public constructor
        }

/**
 * Use this factory method to create a new instance of
 * this fragment using the provided parameters.
 *
 * @param param1 Parameter 1.
 * @param param2 Parameter 2.
 * @return A new instance of fragment ConsultarListaZonaFragment.
 */
// TODO: Rename and change types and number of parameters
public static ConsultarListaZonasFragment newInstance(String param1, String param2,String param3, String param4,
                                                      String param5, String param6, String param7, String param8, String param9) {
        ConsultarListaZonasFragment fragment = new ConsultarListaZonasFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3,param3);
        args.putString(ARG_PARAM4,param4);
        args.putString(ARG_PARAM5, param5);
        args.putString(ARG_PARAM6, param6);
        args.putString(ARG_PARAM7,param7);
        args.putString(ARG_PARAM8,param8);
       // args.putString(ARG_PARAM9,param9);
        fragment.setArguments(args);
        return fragment;
        }

@Override
public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        mParam1 = getArguments().getString(ARG_PARAM1);
        mParam2 = getArguments().getString(ARG_PARAM2);
        mParam3 = getArguments().getString(ARG_PARAM3);
        mParam4 = getArguments().getString(ARG_PARAM4);
        mParam5 = getArguments().getString(ARG_PARAM5);
        mParam6 = getArguments().getString(ARG_PARAM6);
        mParam7 = getArguments().getString(ARG_PARAM7);
        mParam8 = getArguments().getString(ARG_PARAM8);
     //   mParam9 = getArguments().getString(ARG_PARAM9);
        }

        }

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        View vista=inflater.inflate(R.layout.fragment_consultar_lista_zonas, container, false);
        setHasOptionsMenu(true);
        listaZona=new ArrayList<>();
        adapter = new ZonaAdapter(listaZona);
        recyclerZona= (RecyclerView) vista.findViewById(R.id.idRecyclerListaZonas);
        recyclerZona.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerZona.setHasFixedSize(true);

        cargarWebService();

        return vista;

        }

private void cargarWebService() {

        progress=new ProgressDialog(getContext());
        progress.setMessage("Consultando...");
        progress.show();

        String ip=getString(R.string.ip2);

        String url=ip+"/BIO-UES-APP/ConsultarZonas.php";

        jsonObjectRequest=new JsonObjectRequest(Request.Method.GET,url, (String) null,this,this);
        // request.add(jsonObjectRequest);
        com.example.luvin.drawercero.VolleySingleton.getIntanciaVolley(getContext()).addToRequestQueue(jsonObjectRequest);
        }

@Override
public void onErrorResponse(VolleyError error) {
        Toast.makeText(getContext(), "No se puede conectar "+error.toString(), Toast.LENGTH_LONG).show();
        System.out.println();
        Log.d("ERROR: ", error.toString());
        progress.hide();
        }

@Override
public void onResponse(JSONObject response) {
        Zona espamen=null;

        JSONArray json=response.optJSONArray("zonas");

        try {

        for (int i=0;i<json.length();i++){
        espamen=new Zona();
        JSONObject jsonObject=null;
        jsonObject=json.getJSONObject(i);

     //   espamen.setIdZona(jsonObject.optInt("id"));
        espamen.setNombreZona(jsonObject.optString("nombreZona"));
        espamen.setDescripcionZona(jsonObject.optString("descripcionZona1"));
        espamen.setLugarZona(jsonObject.optString("lugarZona"));
        espamen.setNombreDepto(jsonObject.optString("nombreDepto"));
        espamen.setNombreMuniciio(jsonObject.optString("nombreMunicipio"));
        espamen.setLatitudZona(jsonObject.optDouble("latitudZona"));
        espamen.setLongitudZona(jsonObject.optDouble("longitudZona"));
        espamen.setHabitatZona(jsonObject.optString("habitatZona"));
        listaZona.add(espamen);
        }
        progress.hide();
        ZonaAdapter adapter=new ZonaAdapter(listaZona);
        recyclerZona.setAdapter(adapter);

        } catch (JSONException e) {
        e.printStackTrace();
        Toast.makeText(getContext(), "No se ha podido establecer conexión con el servidor" +
        " "+response, Toast.LENGTH_LONG).show();
        progress.hide();
        }

        }

// TODO: Rename method, update argument and hook method into UI event
public void onButtonPressed(Uri uri) {
        if (mListener != null) {
        mListener.onFragmentInteraction(uri);
        }
        }

@Override
public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
        mListener = (OnFragmentInteractionListener) context;
        } else {
        throw new RuntimeException(context.toString()
        + " must implement OnFragmentInteractionListener");
        }
        }

@Override
public void onDetach() {
        super.onDetach();
        mListener = null;
        }

        @Override
        public boolean onQueryTextSubmit(String query) {
                return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
                return false;
        }


        /**
 * This interface must be implemented by activities that contain this   fragment to allow an interaction in this fragment to be communicated
 * to the activity and potentially other fragments contained in that  activity. */

        public interface OnFragmentInteractionListener {
    // TODO: Update argument type and name
    void onFragmentInteraction(Uri uri);
}
}

