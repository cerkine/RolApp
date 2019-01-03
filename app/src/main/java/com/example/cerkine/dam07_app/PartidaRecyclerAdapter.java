package com.example.cerkine.dam07_app;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PartidaRecyclerAdapter extends FirebaseRecyclerAdapter<Partida, PartidaHolder>  {

    public  Context context;
    public  List<String> partida = new ArrayList<>();


    public PartidaRecyclerAdapter(Class<Partida> modelClass, int modelLayout, Class<PartidaHolder> viewHolderClass, DatabaseReference ref, Context c){
        super(modelClass, modelLayout, viewHolderClass, ref);
        context = c;
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    partida.add(snapshot.getKey());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void populateViewHolder(final PartidaHolder viewHolder, final Partida model, final int position) {
        if (partida.size()!=position){
        viewHolder.partidaNombre.setText(partida.get(position));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreId =partida.get(position).split(",")[1];
                String partidaId =partida.get(position).split(",")[0];
                BaseDatos.primerMensaje(partidaId,nombreId);
                Intent intent = new Intent(context,GeneralActivity.class);
                intent.putExtra(PartidaActivity.PARTIDA,partida.get(position));
                context.startActivity(intent);
            }
        });
        }
    }

    public Context getContext() {
        return context;
    }

    public List<String> getPartida() {
        return partida;
    }
}
