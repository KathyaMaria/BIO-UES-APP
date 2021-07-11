package com.example.luvin.drawercero.Zonas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.luvin.drawercero.R;

import java.util.List;

public class ZonaAdapter extends RecyclerView.Adapter<ZonaAdapter.ZonaHolder>{

        List<Zona> listaZona;

    public ZonaAdapter(List<Zona> listaZona) {
            this.listaZona = listaZona;
        }

        @Override
        public ZonaAdapter.ZonaHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType) {
            View vista= LayoutInflater.from(parent.getContext()).inflate(R.layout.zonas_list,parent,false);
            RecyclerView.LayoutParams layoutParams=new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            vista.setLayoutParams(layoutParams);
            return new ZonaAdapter.ZonaHolder(vista);
        }

        @Override
        public void onBindViewHolder(@NonNull ZonaHolder holder, int position) {
         //   holder.txtIdZona.setText(listaZona.get(position).getIdZona().toString());
            holder.txtNombreZona.setText(listaZona.get(position).getNombreZona().toString());
            holder.txtDescripcionZona.setText(listaZona.get(position).getDescripcionZona().toString());
            holder.txtLugarZona.setText(listaZona.get(position).getLugarZona().toString());
            holder.txtIdDepto.setText(listaZona.get(position).getNombreDepto().toString());
            holder.txtIdMunicicio.setText(listaZona.get(position).getNombreMuniciio().toString());
            holder.txtLatitud.setText(listaZona.get(position).getLatitudZona().toString());
            holder.txtLongitud.setText(listaZona.get(position).getLongitudZona().toString());
            holder.txtHabitat.setText(listaZona.get(position).getHabitatZona().toString());

        }

        @Override
        public int getItemCount() {
            return listaZona.size();
        }

        public class ZonaHolder extends RecyclerView.ViewHolder{

            TextView txtIdZona,txtNombreZona,txtDescripcionZona, txtLugarZona,txtIdDepto,txtIdMunicicio,
                    txtLatitud,txtLongitud,txtHabitat;

            public ZonaHolder(@NonNull View itemView) {
                super(itemView);
               // txtIdZona=(TextView) itemView.findViewById(R.id.txtIdZona);
                txtNombreZona=(TextView) itemView.findViewById(R.id.txtNombreZona);
                txtDescripcionZona=(TextView)itemView.findViewById(R.id.txtDescripcionZona);
                txtLugarZona= (TextView) itemView.findViewById(R.id.txtLugarZona);
                txtIdDepto=(TextView) itemView.findViewById(R.id.txtIdDpto);
                txtIdMunicicio=(TextView) itemView.findViewById(R.id.txtIdMunicipio);
                txtLatitud=(TextView)itemView.findViewById(R.id.txtLatitudZona);
                txtLongitud= (TextView) itemView.findViewById(R.id.txtLongitudZona);
                txtHabitat= (TextView) itemView.findViewById(R.id.txtHabitatZona);

            }
        }
}
