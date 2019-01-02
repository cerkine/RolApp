package com.example.cerkine.dam07_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andexert.library.RippleView;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class NotasFragment extends Fragment {

    private GeneralActivity application;
    private Clase clase;
    private List<String> listDest = new ArrayList<>();
    String[] listDestArray ;
    RecyclerView recyclerView;
    static RippleView rippleView ;

    View.OnDragListener onDragListener ;



    public void setApplication(GeneralActivity application) {
        this.application = application;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View mView = inflater.inflate(R.layout.activity_notas, container, false);


        listDestArray = new String[listDest.size()];

        for (int i = 0; i < listDest.size(); i++) {
            listDestArray[i] = listDest.get(i);
        }

        mView.findViewById(R.id.btnMensaje).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(application,EnviarMensajeActivity.class);
                intent.putExtra("clase",clase.getNombre());
                intent.putExtra("listDest",listDestArray);
                intent.putExtra(PartidaActivity.PARTIDA,clase.getPartida());
                startActivity(intent);
            }
        });

        recyclerView = mView.findViewById(R.id.rvMensaje);




        AdaptadorFirebase adaptadorFirebase = new AdaptadorFirebase(Mensaje.class,R.layout.item_mensaje
                ,MensajeHolder.class,  BaseDatos.myRef.child(BaseDatos.PARTIDAS).child(clase.getPartida()).child(clase.getNombre()).child(BaseDatos.MENSAJE),application);
        adaptadorFirebase.setKeyPartida(clase.getPartida());


        recyclerView.setAdapter(adaptadorFirebase);
        recyclerView.setLayoutManager( new LinearLayoutManager(application));
        onDragListener=adaptadorFirebase.getOnDragListener();

        mView.findViewById(R.id.btnEliminar).setOnDragListener(onDragListener);

        return mView;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public void setListDest(List<String> listDest) {
        this.listDest = listDest;
    }
}
