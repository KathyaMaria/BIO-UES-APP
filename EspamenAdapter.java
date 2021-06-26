
public class DominiosAdapter extends RecyclerView.Adapter<DominiosAdapter.DominiosHolder>{

    List<Dominio> listaDominios;

    public DominiosAdapter(List<Dominio> listaDominios) {
        this.listaDominios = listaDominios;
    }

    @Override
    public DominiosHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista= LayoutInflater.from(parent.getContext()).inflate(R.layout.dominios_list,parent,false);
        RecyclerView.LayoutParams layoutParams=new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        vista.setLayoutParams(layoutParams);
        return new DominiosHolder(vista);
    }

    @Override
    public void onBindViewHolder(DominiosHolder holder, int position) {
        holder.txtid.setText(listaDominios.get(position).getId().toString());
        holder.txtnombreDominio.setText(listaDominios.get(position).getnombreDominio().toString());
       //holder.txtProfesion.setText(listaDominios.get(position).getProfesion().toString());
    }

    @Override
    public int getItemCount() {
        return listaDominios.size();
    }

    public class DominiosHolder extends RecyclerView.ViewHolder{

        TextView txtId,txtnombreDominio,txtProfesion;

        public DominiosHolder(View itemView) {
            super(itemView);
            txtId= (TextView) itemView.findViewById(R.id.txtId);
            txtnombreDominio= (TextView) itemView.findViewById(R.id.txtnombreDominio);
           // txtProfesion= (TextView) itemView.findViewById(R.id.txtProfesion);

        }
    }
}
