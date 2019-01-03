package com.example.cerkine.dam07_app;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class PartidaHolder extends RecyclerView.ViewHolder {

    public  TextView partidaNombre;


       public  PartidaHolder(View itemPartida) {
            super(itemPartida);
            partidaNombre = itemPartida.findViewById(R.id.tvNombrePartida);

        }

    public TextView getPartidaNombre() {
        return partidaNombre;
    }
}
