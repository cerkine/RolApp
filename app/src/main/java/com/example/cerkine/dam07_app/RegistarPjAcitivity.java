package com.example.cerkine.dam07_app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class RegistarPjAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registar_pj);

        Spinner spinner = findViewById(R.id.spClasePj);
        String[] clase = {"Guerrero","Mago","Cazador"};
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, clase));

        Spinner spinner2 = findViewById(R.id.spSexoPj);
        String[] sexo = {"Hombre","Mujer","Otro"};
        spinner2.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, sexo));

    }

}
