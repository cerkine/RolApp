package com.example.cerkine.dam07_app;

import android.content.Context;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;

public class AdaptadorFirebase extends FirebaseRecyclerAdapter<Mensaje, MensajeHolder> {

    Context context;

    public AdaptadorFirebase(Class<Mensaje> modelClass, int modelLayout, Class<MensajeHolder> viewHolderClass, DatabaseReference ref, Context c)
    {
        super(modelClass, modelLayout, viewHolderClass, ref);
        context = c;
    }

    @Override
    protected void populateViewHolder(final MensajeHolder viewHolder, final Mensaje model, int position) {
        viewHolder.origen.setText(model.getOrigen());
        viewHolder.titulo.setText(model.getTitulo());
    }


}