package com.example.cerkine.dam07_app;


import android.support.annotation.NonNull;

import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BaseDatos {

     FirebaseDatabase database = FirebaseDatabase.getInstance();
     DatabaseReference myRef = database.getReference();
     final String USUARIOS = "Usuarios";

    public void crearUsuario( ){

        Clase clase = new Clase();

        myRef.child(USUARIOS).child(FirebaseAuth.getInstance().getUid()).setValue(clase);
    }
}
