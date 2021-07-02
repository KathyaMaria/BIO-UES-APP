package com.example.luvin.drawercero.Espamen;


import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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
import com.example.luvin.drawercero.Espamen.Espamen;
import java.util.ArrayList;
import java.util.List;

public class EspamenAdapter extends RecyclerView.Adapter<EspamenAdapter.EspamenHolder>{

    List<Espamen> listaEspamen;

    public EspamenAdapter(List<Espamen> listaEspamen) {
        this.listaEspamen = listaEspamen;
    }

    @Override
    public EspamenHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType) {
        View vista= LayoutInflater.from(parent.getContext()).inflate(R.layout.espamen_list,parent,false);
        RecyclerView.LayoutParams layoutParams=new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        vista.setLayoutParams(layoutParams);
        return new EspamenHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull EspamenHolder holder, int position) {
        holder.txtId.setText(listaEspamen.get(position).getIdEspamen().toString());
        holder.txtIdRiesgo.setText(listaEspamen.get(position).getIdRiesgo().toString());
        holder.txtNombreCientifico.setText(listaEspamen.get(position).getNomEspamen().toString());
        holder.txtNombreComun.setText(listaEspamen.get(position).getNomComEspamen().toString());

    }

    @Override
    public int getItemCount() {
        return listaEspamen.size();
    }

    public class EspamenHolder extends RecyclerView.ViewHolder{

        TextView txtNombreComun,txtNombreCientifico,txtId,txtIdRiesgo;

        public EspamenHolder(@NonNull View itemView) {
            super(itemView);
            txtId=(TextView) itemView.findViewById(R.id.txtIdEspAmen);
            txtIdRiesgo=(TextView) itemView.findViewById(R.id.txtIdRiesgos);
            txtNombreCientifico=(TextView)itemView.findViewById(R.id.txtNombreCientificos);
            txtNombreComun= (TextView) itemView.findViewById(R.id.txtNombreComunes);

        }
    }
}
