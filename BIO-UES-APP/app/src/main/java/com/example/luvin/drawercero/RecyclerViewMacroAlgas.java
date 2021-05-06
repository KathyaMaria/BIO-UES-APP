package com.example.luvin.drawercero;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class RecyclerViewMacroAlgas extends RecyclerView.Adapter<RecyclerViewMacroAlgas.ViewHolder> {


    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView fotoMacroAlgas;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            fotoMacroAlgas=(ImageView)itemView.findViewById(R.id.imgMacroalgas);
        }
    }

    public List<ModeloMacroAlgas>MacroAlgasLista;

    public RecyclerViewMacroAlgas(List<ModeloMacroAlgas> MacroAlgasLista) {
        this.MacroAlgasLista  = MacroAlgasLista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_macroalgas,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.fotoMacroAlgas.setImageResource(MacroAlgasLista.get(position).getImgMacroAlgas());

    }

    @Override
    public int getItemCount() {
        return MacroAlgasLista.size();
    }
}
