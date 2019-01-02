package com.example.cerkine.dam07_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class VerMensajeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_mensaje);

        Mensaje mensaje = (Mensaje) getIntent().getExtras().get("mensaje");

        TextView tvOrigen = findViewById(R.id.tvmens_ori2);
        tvOrigen.setText(mensaje.getOrigen());

        TextView tvDest = findViewById(R.id.tvOpcDest2);
        tvDest.setText(mensaje.getDest());

        TextView tvTitulo = findViewById(R.id.tvmens_titulo2);
        tvTitulo.setText(mensaje.getTexto());

        TextView tvTexto = findViewById(R.id.tvmens_texto2);
        tvTexto.setText(mensaje.getTexto());
    }
}
