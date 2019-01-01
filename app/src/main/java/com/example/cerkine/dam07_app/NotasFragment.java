package com.example.cerkine.dam07_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class NotasFragment extends Fragment {

    private GeneralActivity application;
    private Clase clase;
    private List<String> listDest = new ArrayList<>();
    String[] listDestArray ;


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
                startActivity(intent);
            }
        });

        return mView;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public void setListDest(List<String> listDest) {
        this.listDest = listDest;
    }
}
