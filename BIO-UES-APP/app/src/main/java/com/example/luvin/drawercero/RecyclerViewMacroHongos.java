package com.example.luvin.drawercero;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class RecyclerViewMacroHongos extends RecyclerView.Adapter<RecyclerViewMacroHongos.ViewHolder> {


    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView fotoMacroHongos;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            fotoMacroHongos =(ImageView)itemView.findViewById(R.id.imgMacroHongos);
        }
    }

    public List<ModeloMacroHongos>MacroHongosLista;

    public RecyclerViewMacroHongos(List<ModeloMacroHongos> MacroHongosLista) {
        this.MacroHongosLista = MacroHongosLista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_macrohongos,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.fotoMacroHongos.setImageResource(MacroHongosLista.get(position).getImgMacroHongos());

    }

    @Override
    public int getItemCount() {
        return MacroHongosLista.size();
    }
}
