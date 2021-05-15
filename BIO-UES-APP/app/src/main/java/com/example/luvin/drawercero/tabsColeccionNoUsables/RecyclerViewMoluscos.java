package com.example.luvin.drawercero.tabsColeccionNoUsables;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.luvin.drawercero.R;


import java.util.List;

public class RecyclerViewMoluscos extends RecyclerView.Adapter<RecyclerViewMoluscos.ViewHolder> {


    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView fotoMoluscos;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            fotoMoluscos=(ImageView)itemView.findViewById(R.id.imgMoluscos);
        }
    }

    public List<ModeloMoluscos>moluscosLista;

    public RecyclerViewMoluscos(List<ModeloMoluscos> moluscosLista) {
        this.moluscosLista  = moluscosLista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_moluscos,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.fotoMoluscos.setImageResource(moluscosLista.get(position).getImgMoluscos());

    }

    @Override
    public int getItemCount() {
        return moluscosLista.size();
    }
}
