package com.example.cerkine.dam07_app;

import android.support.annotation.Keep;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
@Keep
public class Partida {

    String nombre;

    public String getNombre() {
        return nombre;
    }


}
