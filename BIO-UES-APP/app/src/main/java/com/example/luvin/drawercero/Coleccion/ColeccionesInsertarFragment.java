package com.example.luvin.drawercero.Coleccion;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.luvin.drawercero.R;
import com.google.android.material.textfield.TextInputLayout;
import com.android.volley.Response;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class ColeccionesInsertarFragment extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener {

    RequestQueue rq;
    JsonRequest jrq;
    EditText txtNombreColeccion;
    TextInputLayout tipoColeccion;
    AutoCompleteTextView colecciones = null;
    Button btnGuardar, btnCancelar;
    public static final int MY_DEFAULT_TIMEOUT = 50000;

    public ColeccionesInsertarFragment() {

        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.fragment_colecciones_insertar, container, false);
        txtNombreColeccion = (EditText) view.findViewById(R.id.edtNombreColeccion);
        colecciones = (AutoCompleteTextView) view.findViewById(R.id.autoCompleteTextViewColecciones);
        btnGuardar = (Button) view.findViewById(R.id.buttonIngresarColeccion);
        rq = Volley.newRequestQueue(getContext());

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrar_coleccion("http://198.168.1.18:80/BIO-UES-APP/guardarColeccion.php");
            }
        });
        ArrayList<String> arrayListColecciones;
        ArrayAdapter<String> arrayAdapterString ;
        String TipoColeccion[] = {"", "Humeda", "Seca"};
        tipoColeccion = (TextInputLayout) view.findViewById(R.id.tipoColecciones);
        colecciones = (AutoCompleteTextView) view.findViewById(R.id.autoCompleteTextViewColecciones);
        arrayListColecciones = new ArrayList<>();
        arrayListColecciones.add("Humeda");
        arrayListColecciones.add("Seca");

        // ArrayAdapter<String> arrayAdapter =new ArrayAdapter<String>(getActivity().getApplicationContext(),
        //       android.R.layout.activity_list_item,TipoColeccion);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item, arrayListColecciones);
        colecciones.setAdapter(arrayAdapter);
        colecciones.setThreshold(1);

        //Seleccion de los tipos de Coleccion
        colecciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0) {
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

    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getContext(), "No Se pudó registrar la coleccion " + error.toString() + txtNombreColeccion.getText().toString(),
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(getContext(), "Se ha registrado la coleccion " + txtNombreColeccion.getText().toString(),
                Toast.LENGTH_SHORT).show();
        limpiarCajas();
    }

    void limpiarCajas() {
        txtNombreColeccion.setText("");
        colecciones.setText("");

    }


    void registrar_coleccion(String URL) {
        //192.168.1.66(172.29.243.3
       /* String url = "http://192.168.1.18/BIO-UES-APP/guardarColeccion.php?nombreColeccion=" +txtNombreColeccion.getText().toString()+
                "&tipoColeccion="+ colecciones.getText().toString() ;

        jrq = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        rq.add(jrq);
    }*/
        StringRequest stringRequest=new StringRequest(Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getContext(), "Registro Guardado con Exito", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),error.toString(),Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String,String>  getParams() throws AuthFailureError{
                Map<String,String> parametros=new HashMap<String, String>();
                parametros.put("nombreColeccion",txtNombreColeccion.getText().toString());
                parametros.put("tipoColeccion",tipoColeccion.getEditText().toString());
                return parametros;
            }
        };
        rq=Volley.newRequestQueue(getContext());
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(

                MY_DEFAULT_TIMEOUT,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        rq.add(stringRequest);
    }

}


