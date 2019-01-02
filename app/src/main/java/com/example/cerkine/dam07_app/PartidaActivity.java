package com.example.cerkine.dam07_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PartidaActivity extends AppCompatActivity {
    Clase clase;
    List<String> list = new ArrayList<>();

    static final String PARTIDA ="PARTIDA_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partida);
        GlideApp.with(this).load(R.drawable.fondoinicio).into((ImageView)findViewById(R.id.fondoPart));

        final RecyclerView recyclerView = findViewById(R.id.partda_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        BaseDatos.myRef.child(BaseDatos.USUARIOS).child(FirebaseAuth.getInstance().getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    String partida = snapshot.getKey();


//                    LinearLayout layout = new LinearLayout(PartidaActivity.this);
//                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.WRAP_CONTENT , LinearLayout.LayoutParams.WRAP_CONTENT );
//                    layoutParams.setMarginStart(50);
//                    layout.setLayoutParams(layoutParams);
//
//
//
//                    TextView tvPartida = new TextView(PartidaActivity.this);
//                    tvPartida.setText(partida);
//
//
//                    Button btnPartida = new Button(PartidaActivity.this);
//                    btnPartida.setHint("Entrar");
//
//                    layout.addView(tvPartida );
//                    layout.addView(btnPartida);
//
//                    addContentView(layout,layoutParams);

                    list.add(partida);

                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });

        findViewById(R.id.btnpartidanueva).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PartidaActivity.this, PartidaNuevaActivity.class);
                startActivity(intent);
            }
        });
        PartidaRecyclerAdapter adaptadorFirebase = new PartidaRecyclerAdapter(Partida.class,R.layout.item_paritda
                ,PartidaHolder.class,  BaseDatos.myRef.child(BaseDatos.USUARIOS).child(FirebaseAuth.getInstance().getUid()),PartidaActivity.this);
        recyclerView.setAdapter(adaptadorFirebase);

    }
}
