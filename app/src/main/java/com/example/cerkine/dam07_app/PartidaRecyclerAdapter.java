package com.example.cerkine.dam07_app;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PartidaRecyclerAdapter extends RecyclerView.Adapter<PartidaRecyclerAdapter.PartidaViewHolder>  {

    List<String> list;
    PartidaActivity activity;
    String partida;

    PartidaRecyclerAdapter(List<String> list,PartidaActivity application){
        this.list = list;
        this.activity = application;
    }

    @Override
    public PartidaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemPoem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_paritda, parent, false);
        return new PartidaViewHolder(itemPoem);
    }


    @Override
    public void onBindViewHolder(final PartidaViewHolder holder, final int position) {


        holder.partidaNombre.setText(list.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                partida = holder.partidaNombre.getText().toString();
                Intent intent = new Intent(activity,GeneralActivity.class);
                intent.putExtra(PartidaActivity.PARTIDA,partida);
                activity.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return (list != null ? list.size() : 0);
    }

    class PartidaViewHolder extends RecyclerView.ViewHolder {
        private TextView partidaNombre;


        PartidaViewHolder(View itemPartida) {
            super(itemPartida);
            partidaNombre = itemPartida.findViewById(R.id.tvNombrePartida);

        }
    }
}
