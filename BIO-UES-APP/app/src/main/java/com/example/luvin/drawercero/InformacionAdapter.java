package com.example.luvin.drawercero;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class InformacionAdapter extends RecyclerView.Adapter<InformacionAdapter.ViewHolder> {
    // Una lista de objetos "Dato"
    private List<Dato> datos;
    // id del layout list_item_informacion
    private int layout;
    private OnItemClickListener itemClickListener;
    private Context context;
    private static final int DURATION = 250;
       public InformacionAdapter(List<Dato> datos, int layout, OnItemClickListener listener) {
        this.datos = datos;
        this.layout = layout;
        this.itemClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        context = parent.getContext();
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        holder.bind(datos.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public  class ViewHolder extends  RecyclerView.ViewHolder{
        // Elementos de diseño de list_item_informacion.xml
        public ImageView imageViewPoster;
        public ViewGroup linearLayoutDetails;
        public Toolbar toolbarCard;
        public LinearLayout unlinearl;
        public ImageView imageViewExpand;
        public TextView textViewInfo;

        public ViewHolder(View itemView){
            super(itemView);
            // Enlazamos los elementos de la vista
            imageViewPoster = itemView.findViewById(R.id.imageViewPoster);
            linearLayoutDetails =  itemView.findViewById(R.id.linearLayoutDetails);
            toolbarCard =  itemView.findViewById(R.id.toolbarCard);
            unlinearl =  itemView.findViewById(R.id.unlinearl);
            imageViewExpand =  itemView.findViewById(R.id.imageViewExpand);
            textViewInfo =  itemView.findViewById(R.id.textViewInfo);
        }


        public void bind(final Dato dato, final OnItemClickListener listener){
            // Sustituimos los elementos por su valor dentro de la lista de datos
            toolbarCard.setTitle(dato.getTitulo());
            toolbarCard.setSubtitle(dato.getSubtitulo());
            // Cree un menu dentro de res->layout->menu con el nombre card_menu
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
                        case R.id.action_option3:
                            Toast.makeText(context, "op3", Toast.LENGTH_SHORT).show();
                            break;
                    }
                    return true;
                }
            });
            textViewInfo.setText(dato.getContenido());
            // Mostrar y ocultar la información
            unlinearl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (linearLayoutDetails.getVisibility() == View.GONE) {
                        // Cree la clase ExpandAndCollpaseViewUtil
                        ExpandAndCollapseViewUtil.expand(linearLayoutDetails, DURATION);
                        imageViewExpand.setImageResource(R.drawable.more);
                        // Rotamos el icono de flecha 180 grados
                        Animation animation = new RotateAnimation(0.0f, -180.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                        animation.setFillAfter(true);
                        animation.setDuration(DURATION);
                        imageViewExpand.startAnimation(animation);

                    } else {
                        ExpandAndCollapseViewUtil.collapse(linearLayoutDetails, DURATION);
                        imageViewExpand.setImageResource(R.drawable.less);
                        Animation animation = new RotateAnimation(0.0f, 180.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                        animation.setFillAfter(true);
                        animation.setDuration(DURATION);
                        imageViewExpand.startAnimation(animation);

                    }
                }
            });


            // Picasso mejora el uso de imagenes
            // square.github.io/picasso

            Picasso.with(context).load(dato.getImagen())
                    .into(imageViewPoster);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(dato, getAdapterPosition());
                }
            });
        }
    }


    public interface OnItemClickListener{
        void onItemClick(Dato dato, int position);
    }
}