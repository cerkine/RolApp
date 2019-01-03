package com.example.cerkine.dam07_app;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class StatsRecyclerAdapter extends RecyclerView.Adapter<StatsRecyclerAdapter.StatsViewHolder>  {

    List<String> listKey;
    List<String> listValue;
    GeneralActivity activity;
    String partida ="";


    StatsRecyclerAdapter(List<String> listKey,List<String> listValue, GeneralActivity application,String partida){
        this.listKey = listKey;
        this.activity = application;
        this.listValue = listValue;
        this.partida = partida;
    }

    @Override
    public StatsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemStat = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_stat, parent, false);
        return new StatsViewHolder(itemStat);
    }


    @Override
    public void onBindViewHolder(final StatsViewHolder holder, final int position) {


        holder.statNombre.setText(listKey.get(position));
        holder.statValor.setText(listValue.get(position));

        holder.statMod.setText(String.valueOf((Integer.parseInt(listValue.get(position))-10)/2));

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View view) {

                Intent intent = new Intent(activity,ModificarStatActivity.class);
                intent.putExtra("nombre",holder.statNombre.getText().toString());
                intent.putExtra("valor", holder.statValor.getText().toString());
                intent.putExtra(PartidaActivity.PARTIDA,partida);
                activity.startActivity(intent);
                return true;
            }
        });



    }

    @Override
    public int getItemCount() {
        return (listKey != null ? listKey.size() : 0);
    }

    class StatsViewHolder extends RecyclerView.ViewHolder {
        private TextView statNombre;
        private TextView statValor;
        private TextView statMod;


        StatsViewHolder(View itemStat) {
            super(itemStat);
            statNombre = itemStat.findViewById(R.id.tvStatNombre);
            statValor= itemStat.findViewById(R.id.tvStatValor);
            statMod = itemStat.findViewById(R.id.tvStatMod);

        }

        public TextView getStatNombre() {
            return statNombre;
        }

        public TextView getStatValor() {
            return statValor;
        }

        public TextView getStatMod() {
            return statMod;
        }
    }

    public List<String> getListKey() {
        return listKey;
    }

    public List<String> getListValue() {
        return listValue;
    }

    public GeneralActivity getActivity() {
        return activity;
    }

    public String getPartida() {
        return partida;
    }
}
