package com.example.cerkine.dam07_app;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class ModificarStatActivity extends AppCompatActivity {
    String partida ="";
    TextView tvMod;
    String valorStat;

    public String getPartida() {
        return partida;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_stat);



        Bundle bundle = getIntent().getExtras();

        String nombreStat = bundle.getString("nombre");
        valorStat = bundle.getString("valor");
        partida = bundle.getString(PartidaActivity.PARTIDA);


        final TextView tvNombre = findViewById(R.id.tvStatGrande);
        final TextView tvValor = findViewById(R.id.tvValorStatGrande);
        tvMod = findViewById(R.id.tvModStatGrande);
        final TextView tvExp = findViewById(R.id.tvValorExp);
        BaseDatos.myRef.child(BaseDatos.USUARIOS).child(FirebaseAuth.getInstance().getUid()).child(partida).child(BaseDatos.NOSTATS).child("puntos").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                tvExp.setText(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        tvMod.setText(String.valueOf(((Integer.parseInt(valorStat))-10)/2));

        tvNombre.setText(nombreStat);
        tvValor.setText(valorStat);

        findViewById(R.id.plusStat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(tvValor.getText().toString());
                int punt= Integer.parseInt(tvExp.getText().toString());
                if(num<30 && punt>0) {
                    String result = String.valueOf(num + 1);
                    String punResult = String.valueOf(punt-1);
                    String stat = tvNombre.getText().toString().toLowerCase();

                    BaseDatos.myRef.child(BaseDatos.USUARIOS).child(FirebaseAuth.getInstance().getUid()).child(partida).child(BaseDatos.STATS).child(stat).setValue(result);
                    tvValor.setText(result);
                    BaseDatos.myRef.child(BaseDatos.USUARIOS).child(FirebaseAuth.getInstance().getUid()).child(partida).child(BaseDatos.NOSTATS).child("puntos").setValue(punResult);
                    tvMod.setText(String.valueOf(((Integer.parseInt(tvValor.getText().toString()))-10)/2));
                }
            }
        });

        findViewById(R.id.minusStat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int punt= Integer.parseInt(tvExp.getText().toString());

                int num = Integer.parseInt(tvValor.getText().toString());
                if (num >0) {
                    String result = String.valueOf(num - 1);
                    String punResult = String.valueOf(punt+1);
                    String stat = tvNombre.getText().toString().toLowerCase();

                    BaseDatos.myRef.child(BaseDatos.USUARIOS).child(FirebaseAuth.getInstance().getUid()).child(partida).child(BaseDatos.STATS).child(stat).setValue(result);
                    tvValor.setText(result);
                    BaseDatos.myRef.child(BaseDatos.USUARIOS).child(FirebaseAuth.getInstance().getUid()).child(partida).child(BaseDatos.NOSTATS).child("puntos").setValue(punResult);
                    tvMod.setText(String.valueOf(((Integer.parseInt(tvValor.getText().toString()))-10)/2));
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ModificarStatActivity.this,GeneralActivity.class);
        intent.putExtra(PartidaActivity.PARTIDA,partida);
        startActivity(intent);
    }
}
