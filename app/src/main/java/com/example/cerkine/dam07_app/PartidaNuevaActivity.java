package com.example.cerkine.dam07_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

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

    public EditText getEtNombrePj() {
        return etNombrePj;
    }

    public TextView getTvCodigoPartida() {
        return tvCodigoPartida;
    }

    public Button getBtnCrearPartida() {
        return btnCrearPartida;
    }

    public Button getBtnUnirsePartida() {
        return btnUnirsePartida;
    }

    public RadioButton getRdbtnMaster() {
        return rdbtnMaster;
    }

    public RadioButton getRdbtnJugador() {
        return rdbtnJugador;
    }

    public EditText getEtCodigoPatida() {
        return etCodigoPatida;
    }
}
