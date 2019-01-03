package com.example.cerkine.dam07_app;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class PjFragment extends Fragment {

    private Clase clase;
    private String key;
    CheckBox ch;
    Button btAdd ;
    Button btSubd ;
    TextView tvNivel;
    TextView tvExp;
    int tmp;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        final View mView = inflater.inflate(R.layout.activity_pj, container, false);

        final TextView tvNombre =mView.findViewById(R.id.tvNombreJugador);
        final TextView tvHonorifico =mView.findViewById(R.id.tvHonorificoJugador);
        final TextView tvEdad =mView.findViewById(R.id.tvEdadJugador);
        final TextView tvSexo =mView.findViewById(R.id.tvSexoJugador);
        final TextView tvRaza =mView.findViewById(R.id.tvRazaJugador);
        final TextView tvClase =mView.findViewById(R.id.tvClaseJugador);
        tvNivel= mView.findViewById(R.id.tvNivelJugador);
        tvExp = mView.findViewById(R.id.tvExpJugador);
        final TextView tvAltura =mView.findViewById(R.id.tvAlturaJugador);
        final TextView tvPeso =mView.findViewById(R.id.tvPesoJugador);

        BaseDatos.myRef.child(BaseDatos.USUARIOS).child(FirebaseAuth.getInstance().getUid()).child(key).child(BaseDatos.NOSTATS).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                clase = dataSnapshot.getValue(Clase.class);

                tvNombre.setText(clase.getNombre());
                tvHonorifico.setText(clase.getHonorifico());
                tvEdad.setText(clase.getEdad());
                tvSexo.setText(clase.getSexo());
                tvRaza.setText(clase.getRaza());
                tvClase.setText(clase.getClase());
                tvNivel.setText(clase.getNivel());
                tvExp.setText(clase.getPuntos());
                tvAltura.setText(clase.getAltura());
                tvPeso.setText(clase.getPeso());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ch = mView.findViewById(R.id.chPjEdit);
        btAdd = mView.findViewById(R.id.addLvl);
        btSubd = mView.findViewById(R.id.subLvl);
        ch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (ch.isChecked()){
                    btSubd.setVisibility(View.VISIBLE);
                    btAdd.setVisibility(View.VISIBLE);
                    tmp = Integer.parseInt(tvNivel.getText().toString());
                }else{
                    btAdd.setVisibility(View.INVISIBLE);
                    btSubd.setVisibility(View.INVISIBLE);
                }
            }
        });
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvNivel.setText(String.valueOf(Integer.parseInt(tvNivel.getText().toString()) + 1));
                BaseDatos.myRef.child(BaseDatos.USUARIOS).child(FirebaseAuth.getInstance().getUid()).child(key).child(BaseDatos.NOSTATS).child("nivel").setValue(tvNivel.getText().toString());
                BaseDatos.myRef.child(BaseDatos.USUARIOS).child(FirebaseAuth.getInstance().getUid()).child(key).child(BaseDatos.NOSTATS).child("puntos").setValue(String.valueOf(Integer.parseInt(tvExp.getText().toString())+20));

            }
        });
        btSubd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(tvNivel.getText().toString())>tmp){
                tvNivel.setText(String.valueOf(Integer.parseInt(tvNivel.getText().toString()) -1));
                BaseDatos.myRef.child(BaseDatos.USUARIOS).child(FirebaseAuth.getInstance().getUid()).child(key).child(BaseDatos.NOSTATS).child("nivel").setValue(tvNivel.getText().toString());
                BaseDatos.myRef.child(BaseDatos.USUARIOS).child(FirebaseAuth.getInstance().getUid()).child(key).child(BaseDatos.NOSTATS).child("puntos").setValue(String.valueOf(Integer.parseInt(tvExp.getText().toString())-20));
                }
            }
        });



        return mView;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public Clase getClase() {
        return clase;
    }
}
