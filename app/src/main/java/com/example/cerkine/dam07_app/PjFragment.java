package com.example.cerkine.dam07_app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PjFragment extends Fragment {

    private Clase clase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View mView = inflater.inflate(R.layout.activity_pj, container, false);




        return mView;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }
}
