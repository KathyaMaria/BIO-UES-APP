package com.example.luvin.drawercero.Especies;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.luvin.drawercero.Especies.Especies;
import com.example.luvin.drawercero.Especies.EspeciesAdapter;
import com.example.luvin.drawercero.R;

import java.util.List;

public class EspeciesAdapter extends RecyclerView.Adapter<EspeciesAdapter.EspeciesHolder>{

    List<Especies> listaEspecies;

    public EspeciesAdapter(List<Especies> listaEspecies) {
        this.listaEspecies = listaEspecies;
    }

    @Override
    public EspeciesAdapter.EspeciesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista= LayoutInflater.from(parent.getContext()).inflate(R.layout.especies_list,parent,false);
        RecyclerView.LayoutParams layoutParams=new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        vista.setLayoutParams(layoutParams);
        return new EspeciesAdapter.EspeciesHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull EspeciesAdapter.EspeciesHolder holder, int position) {
        //holder.txtId.setText(listaEspecies.get(position).getIdEspecies().toString());
        holder.txtNombreDominio.setText(listaEspecies.get(position).getNombreDominio().toString());
        holder.txtNombreReino.setText(listaEspecies.get(position).getNombreReino().toString());
        holder.txtNombreFilum.setText(listaEspecies.get(position).getNombreFilum().toString());
        holder.txtNombreClase.setText(listaEspecies.get(position).getNombreClase().toString());
        holder.txtNombreOrden.setText(listaEspecies.get(position).getNombreOrden().toString());
        holder.txtNombreFamilia.setText(listaEspecies.get(position).getNombreFamilia().toString());
        holder.txtNombreGenero.setText(listaEspecies.get(position).getNombreGenero().toString());
        holder.txtNombreEspecie.setText(listaEspecies.get(position).getNombreEspecie().toString());

    }

    @Override
    public int getItemCount() {
        return listaEspecies.size();
    }

    public class EspeciesHolder extends RecyclerView.ViewHolder{

        TextView txtNombreDominio,txtNombreReino,txtNombreFilum,txtNombreClase,
                txtNombreOrden,txtNombreFamilia,txtNombreGenero,txtNombreEspecie;


        public EspeciesHolder(@NonNull View itemView) {
            super(itemView);
            //  txtId=(TextView) itemView.findViewById(R.id.txtIdEspAmen);
            txtNombreDominio=(TextView) itemView.findViewById(R.id.txtIdDominios);
            txtNombreReino=(TextView)itemView.findViewById(R.id.txtReino);
            txtNombreFilum= (TextView) itemView.findViewById(R.id.txtFilum);
            txtNombreClase=(TextView) itemView.findViewById(R.id.txtClase);
            txtNombreOrden=(TextView)itemView.findViewById(R.id.txtOrden);
            txtNombreFamilia= (TextView) itemView.findViewById(R.id.txtFamilia);
            txtNombreGenero=(TextView) itemView.findViewById(R.id.txtGenero);
            txtNombreEspecie=(TextView)itemView.findViewById(R.id.txtEspecie);


        }
    }

    
}
