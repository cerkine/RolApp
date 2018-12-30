package com.example.cerkine.dam07_app;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PartidaRecyclerAdapter extends RecyclerView.Adapter<PartidaRecyclerAdapter.PartidaViewHolder> {

    List<String> list;

    PartidaRecyclerAdapter(List<String> list){
        this.list = list;
    }

    @Override
    public PartidaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemPoem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_paritda, parent, false);
        return new PartidaViewHolder(itemPoem);
    }


    @Override
    public void onBindViewHolder(PartidaViewHolder holder, int position) {


        holder.partidaNombre.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return (list != null ? list.size() : 0);
    }

    class PartidaViewHolder extends RecyclerView.ViewHolder {
        private TextView partidaNombre;


        PartidaViewHolder(View itemPoem) {
            super(itemPoem);
            partidaNombre = itemPoem.findViewById(R.id.tvNombrePartida);

        }
    }
}
