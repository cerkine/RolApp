package com.example.cerkine.dam07_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PartidaNuevaActivity extends AppCompatActivity {
    EditText etNombrePj;
    TextView tvCodigoPartida;
    Button btnCrearPartida;
    Button btnUnirsePartida;
    RadioButton rdbtnMaster;
    RadioButton rdbtnJugador;
    EditText etCodigoPatida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partida_nueva);
        GlideApp.with(this).load(R.drawable.fondoinicio).into((ImageView)findViewById(R.id.fondoPN));


        etNombrePj = findViewById(R.id.etnombrePj);

        etCodigoPatida = findViewById(R.id.etnumeroPartida);
        tvCodigoPartida = findViewById(R.id.tvnumeroPartida);

        btnCrearPartida = findViewById(R.id.btnCrearPartida);
        btnUnirsePartida = findViewById(R.id.btnUnirsePartida);

        rdbtnMaster = findViewById(R.id.btnMaster);
        rdbtnJugador = findViewById(R.id.btnJugador);

        if(rdbtnMaster.isChecked()){
            etNombrePj.setVisibility(View.INVISIBLE);
            btnUnirsePartida.setVisibility(View.INVISIBLE);
            etCodigoPatida.setVisibility(View.INVISIBLE);
        }

        findViewById(R.id.btnMaster).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                etNombrePj.setVisibility(View.INVISIBLE);
                btnUnirsePartida.setVisibility(View.INVISIBLE);
                btnCrearPartida.setVisibility(View.VISIBLE);
                etCodigoPatida.setVisibility(View.INVISIBLE);
                tvCodigoPartida.setVisibility(View.VISIBLE);

            }
        });

        findViewById(R.id.btnJugador).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etNombrePj.setVisibility(View.VISIBLE);
                btnUnirsePartida.setVisibility(View.VISIBLE);
                btnCrearPartida.setVisibility(View.INVISIBLE);
                etCodigoPatida.setVisibility(View.VISIBLE);
                tvCodigoPartida.setVisibility(View.INVISIBLE);

            }
        });

        findViewById(R.id.btnCrearPartida).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PartidaNuevaActivity.this, EleccionJugdorActivity.class);

                intent.putExtra("keyPartida",tvCodigoPartida.getText().toString());
                startActivity(intent);
            }
        });

        findViewById(R.id.btnUnirsePartida).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PartidaNuevaActivity.this, RegistarPjAcitivity.class);

                intent.putExtra("keyPartida",etCodigoPatida.getText().toString());
                intent.putExtra("nombrePj",etNombrePj.getText().toString());
                startActivity(intent);
            }
        });
    }
}
