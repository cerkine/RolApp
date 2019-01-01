package com.example.cerkine.dam07_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EnviarMensajeActivity extends AppCompatActivity {
    String[] listDest = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar_mensaje);
        Bundle  bundle = getIntent().getExtras();

        TextView et = findViewById(R.id.tvmens_ori);
        et.setText(bundle.getString("clase"));
        listDest = bundle.getStringArray("listDest");

        Spinner spinner = findViewById(R.id.spOpcDest);


        ArrayAdapter<String > arrayAdapter = new ArrayAdapter<String >(this, R.layout.spinner_item_msndest,R.id.spdestmns, listDest);

        spinner.setAdapter(arrayAdapter);
    }


}
