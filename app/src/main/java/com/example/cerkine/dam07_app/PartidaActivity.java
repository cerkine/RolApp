package com.example.cerkine.dam07_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PartidaActivity extends AppCompatActivity {
    Clase clase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partida);
        GlideApp.with(this).load(R.drawable.fondoinicio).into((ImageView)findViewById(R.id.fondoPart));

        findViewById(R.id.btnpartida).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PartidaActivity.this, GeneralActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btnpartidanueva).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(PartidaActivity.this,PartidaNuevaActivity.class);
                startActivity(intent);
            }
        });
    }
}
