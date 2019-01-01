package com.example.cerkine.dam07_app;


import android.support.annotation.NonNull;

import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public  class BaseDatos {


    static FirebaseDatabase database = FirebaseDatabase.getInstance();
    static DatabaseReference myRef = database.getReference();
    final static String USUARIOS = "Usuarios";
    final static String NOSTATS = "!nostats";
    final static String STATS = "stats";
    final static String PARTIDAS = "partidas";
    final static String MENSAJE = "mensajes";

    public static void crearUsuario(Clase clase){
        clase.setKey("");
        myRef.child(USUARIOS).child(FirebaseAuth.getInstance().getUid()).child(clase.getKey()).child(NOSTATS).setValue(clase);
        myRef.child(USUARIOS).child(FirebaseAuth.getInstance().getUid()).child(clase.getKey()).child(STATS).setValue(new Estadistica());
        myRef.child(PARTIDAS).child(clase.getPartida()).child(clase.getNombre()).child(MENSAJE).setValue("nada");

    }

    public static void mandarMensaje(String partida, String nombre, Mensaje mensaje){

        myRef.child(PARTIDAS).child(partida).child(nombre).child(MENSAJE).child(mensaje.getId()).setValue(mensaje);


    }
}
