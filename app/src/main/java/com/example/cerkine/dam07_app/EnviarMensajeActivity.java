package com.example.cerkine.dam07_app;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EnviarMensajeActivity extends AppCompatActivity {
    String[] listDest = null;
    String partida ="";
    TextView et ;
    Spinner spinnerDest;
    EditText etTitulo;
    EditText etText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar_mensaje);
        Bundle  bundle = getIntent().getExtras();

        et = findViewById(R.id.tvmens_ori);
        etTitulo = findViewById(R.id.etmens_titulo);
        etText  = findViewById(R.id.etmens_texto);

        et.setText(bundle.getString("clase"));
        listDest = bundle.getStringArray("listDest");
        partida = bundle.getString(PartidaActivity.PARTIDA);

        spinnerDest = findViewById(R.id.spOpcDest);


        ArrayAdapter<String > arrayAdapter = new ArrayAdapter<String >(this, R.layout.spinner_item_msndest,R.id.spdestmns, listDest);

        spinnerDest.setAdapter(arrayAdapter);



        findViewById(R.id.btn_enviarmensaje).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Mensaje mensaje = new Mensaje(et.getText().toString(),spinnerDest.getSelectedItem().toString(),etText.getText().toString(),etTitulo.getText().toString());

                BaseDatos.mandarMensaje(partida,et.getText().toString(),mensaje);

               onBackPressed();
            }
        });
    }


}
