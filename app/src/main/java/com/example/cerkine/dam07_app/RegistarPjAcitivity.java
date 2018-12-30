package com.example.cerkine.dam07_app;

import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RegistarPjAcitivity extends AppCompatActivity {

    private final Executor executor = Executors.newFixedThreadPool(2);


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registar_pj);
        GlideApp.with(this).load(R.drawable.fondoinicio).into((ImageView)findViewById(R.id.fondoRegPj));

        final Bundle bundle = getIntent().getExtras();

        Spinner spinner = findViewById(R.id.spClasePj);
        String[] clase = {"Guerrero","Mago","Cazador"};
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, clase));

        Spinner spinner2 = findViewById(R.id.spSexoPj);
        String[] sexo = {"Hombre","Mujer","Otro"};
        spinner2.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, sexo));




        findViewById(R.id.btnAceptarPj).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(RegistarPjAcitivity.this, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(RegistarPjAcitivity.this);
                }
                builder.setTitle("Confirmar Personaje")
                        .setMessage("Una vez confirmado no se podran cambiar los datos")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                EditText et;
                                Spinner sp;
                                final Clase clase = new Clase();

                                et = findViewById(R.id.ethonorificoPjregistrar);
                                clase.setHonorifico(et.getText().toString());

                                et = findViewById(R.id.etalturaPj);
                                clase.setAltura(et.getText().toString());

                                et = findViewById(R.id.etPesoPj);
                                clase.setPeso(et.getText().toString());

                                sp = findViewById(R.id.spClasePj);
                                clase.setTipo(sp.getSelectedItem().toString());

                                sp = findViewById(R.id.spSexoPj);
                                clase.setSexo(sp.getSelectedItem().toString());

                                clase.setNombre(bundle.get("nombrePj").toString());
                                clase.setPartida(bundle.get("keyPartida").toString());

                                BaseDatos.crearUsuario(clase);

                                Intent intent = new Intent(RegistarPjAcitivity.this, GeneralActivity.class);
                                startActivity(intent);

                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();

            }
        });

    }

}
