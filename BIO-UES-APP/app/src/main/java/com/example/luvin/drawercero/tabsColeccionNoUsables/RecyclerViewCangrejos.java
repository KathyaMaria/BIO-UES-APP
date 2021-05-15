package com.example.luvin.drawercero.tabsColeccionNoUsables;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.luvin.drawercero.R;


import java.util.List;

public class RecyclerViewCangrejos extends RecyclerView.Adapter<RecyclerViewCangrejos.ViewHolder> {


    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView fotoCangrejos;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            fotoCangrejos=(ImageView)itemView.findViewById(R.id.imgCangrejos);
        }
    }

    public List<ModeloCangrejos>CangrejosLista;

    public RecyclerViewCangrejos(List<ModeloCangrejos> camasLista) {
        this.CangrejosLista = camasLista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cangrejos,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.fotoCangrejos.setImageResource(CangrejosLista.get(position).getImgCangrejos());

    }

    @Override
    public int getItemCount() {
        return CangrejosLista.size();
    }
}
