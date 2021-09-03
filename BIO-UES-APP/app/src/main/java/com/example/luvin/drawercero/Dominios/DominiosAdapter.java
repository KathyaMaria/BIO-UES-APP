package com.example.luvin.drawercero.Dominios;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.example.luvin.drawercero.Coleccion.DatoConsultarColeccionPrueba;
import com.example.luvin.drawercero.Coleccion.InformacionAdapter;
import com.example.luvin.drawercero.ExpandAndCollapseViewUtil;
import com.example.luvin.drawercero.R;
import com.squareup.picasso.Picasso;

import java.util.List;
public class DominiosAdapter extends RecyclerView.Adapter<DominiosAdapter.DominiosHolder>{

    List<Dominio> listaDominios;
    private Context context;
    //private int layout;
   // private InformacionAdapter.OnItemClickListener itemClickListener;

    public DominiosAdapter(List<Dominio> listaDominios) {

        this.listaDominios = listaDominios;
    }
/*
 public DominiosAdapter(List<Dominio> listaDominios, int layout, InformacionAdapter.OnItemClickListener listener) {
        this.layout = layout;
        this.itemClickListener = listener;
        this.listaDominios = listaDominios;
    }

 */
    @Override
    public DominiosHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista= LayoutInflater.from(parent.getContext()).inflate(R.layout.dominios_list,parent,false);
        RecyclerView.LayoutParams layoutParams=new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
       // context = parent.getContext();
        vista.setLayoutParams(layoutParams);
        return new DominiosHolder(vista);
    }

    @Override
    public void onBindViewHolder(DominiosHolder holder, int position) {
       holder.txtId.setText(listaDominios.get(position).getId().toString());
        holder.txtnombreDominio.setText(listaDominios.get(position).getnombreDominio().toString());
       //holder.txtProfesion.setText(listaDominios.get(position).getProfesion().toString());
    //    holder.bind(listaDominios.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return listaDominios.size();
    }

    public class DominiosHolder extends RecyclerView.ViewHolder{
        public Toolbar toolbarCard;
        TextView txtId,txtnombreDominio,txtProfesion;

        public DominiosHolder(View itemView) {
            super(itemView);
            txtId= (TextView) itemView.findViewById(R.id.txId);
            txtnombreDominio= (TextView) itemView.findViewById(R.id.txtNombreDominio);
            toolbarCard =  itemView.findViewById(R.id.toolbarCard);
           // txtProfesion= (TextView) itemView.findViewById(R.id.txtProfesion);
        }

        public void bind(final Dominio dominio, final InformacionAdapter.OnItemClickListener listener){

            toolbarCard.inflateMenu(R.menu.card_menu);
            toolbarCard.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.action_option1:
                            Toast.makeText(context, "op1", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.action_option2:
                            Toast.makeText(context, "op2", Toast.LENGTH_SHORT).show();
                            break;
                    }
                    return true;
                }
            });

        }
    }

}
