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

    public static void crearUsuario(Clase clase){
        clase.setKey("");
        myRef.child(USUARIOS).child(FirebaseAuth.getInstance().getUid()).child(clase.getKey()).child(clase.getNombre()).setValue(clase);

    }
}
