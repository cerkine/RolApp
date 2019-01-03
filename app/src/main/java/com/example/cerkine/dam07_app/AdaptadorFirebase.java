package com.example.cerkine.dam07_app;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.view.DragEvent;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;

public class AdaptadorFirebase extends FirebaseRecyclerAdapter<Mensaje, MensajeHolder> {

    Context context;
    String keyPartida = "";
    View.OnDragListener onDragListener;

    public View.OnDragListener getOnDragListener() {
        return onDragListener;
    }

    public void setKeyPartida(String keyPartida) {
        this.keyPartida = keyPartida;
    }

    public AdaptadorFirebase(Class<Mensaje> modelClass, int modelLayout, Class<MensajeHolder> viewHolderClass, DatabaseReference ref, Context c)
    {
        super(modelClass, modelLayout, viewHolderClass, ref);
        context = c;
    }

    @Override
    protected void populateViewHolder(final MensajeHolder viewHolder, final Mensaje model, final int position) {
        viewHolder.origen.setText(model.getOrigen());
        viewHolder.titulo.setText(model.getTitulo());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,VerMensajeActivity.class);
                intent.putExtra("mensaje",  model);
                context.startActivity(intent);

            }
        });

        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ClipData data = ClipData.newPlainText("","");
                View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data,myShadowBuilder,view,0);


                BaseDatos.myRef.child(BaseDatos.PARTIDAS).child(keyPartida).child(model.getDest()).child(BaseDatos.MENSAJE).child(model.getId()).getRef().removeValue();

                onDragListener =new View.OnDragListener() {
                    @Override
                    public boolean onDrag(View view, DragEvent event) {

                        int dragEvent = event.getAction();
                        final View v = (View) event.getLocalState();
                        switch (dragEvent) {
                            case DragEvent.ACTION_DRAG_ENTERED:
                                break;
                            case DragEvent.ACTION_DRAG_EXITED:
                                break;
                            case DragEvent.ACTION_DROP:

                                return true;
                        }

                        return true;
                    }
                };

                return true;
            }
        });
    }

    public Context getContext() {
        return context;
    }

    public String getKeyPartida() {
        return keyPartida;
    }
}