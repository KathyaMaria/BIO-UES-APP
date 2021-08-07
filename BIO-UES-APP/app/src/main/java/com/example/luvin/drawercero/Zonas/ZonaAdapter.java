package com.example.luvin.drawercero.Zonas;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.luvin.drawercero.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ZonaAdapter extends RecyclerView.Adapter<ZonaAdapter.ZonaHolder> implements Filterable {

        private LayoutInflater mInflater;
        List<Zona> listaZona = null ;
        ArrayList<Zona> listaAll; // usada para la busqueda


    public ZonaAdapter(List<Zona> listaZona) {
            this.listaZona = listaZona;
            this.listaAll = new ArrayList<>();
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

      /*  public void filtrado(String txtBuscar){
       //int longitud = txtBuscar.length();
        if (txtBuscar.length()==0){
            listaZona.clear();
            listaZona.addAll(listaOriginal);
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                List<Zona> coleccion = listaZona.stream().filter(i -> i.getNombreZona().toLowerCase()
                        .contains(txtBuscar)).collect(Collectors.toList());
                listaZona.clear();
                listaZona.addAll(coleccion);
            }else{
                listaZona.clear();
                for (Zona z:listaOriginal){
                    if (z.getNombreZona().toLowerCase().contains(txtBuscar)){
                        listaZona.add(z);
                    }
                }
            }
        }notifyDataSetChanged();
        } */

        @Override
        public int getItemCount() {
            return listaZona.size();
        }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Zona> filteredList = new ArrayList<>();
            if (constraint.toString().isEmpty()){
                filteredList.addAll(listaAll);
            }else {
                for (Zona item : listaAll){
                    if (item.getNombreZona().toLowerCase().contains(constraint.toString().toLowerCase())){
                        filteredList.add(item);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values=filteredList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
           // listaZona.clear();
            listaAll.addAll((Collection<?extends Zona>)results.values);
            notifyDataSetChanged();
        }
    };


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
