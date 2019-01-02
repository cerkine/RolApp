package com.example.cerkine.dam07_app;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public  class MensajeHolder extends RecyclerView.ViewHolder {


    TextView origen,titulo;

    public MensajeHolder(View itemView) {
        super(itemView);
        origen = itemView.findViewById(R.id.tvOrigenMensaje);
        titulo = itemView.findViewById(R.id.tvTituloMensaje);
    }
}