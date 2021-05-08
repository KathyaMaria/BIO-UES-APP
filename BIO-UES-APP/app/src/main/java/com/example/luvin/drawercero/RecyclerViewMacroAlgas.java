package com.example.luvin.drawercero;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;

import androidx.fragment.app.FragmentManager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
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
