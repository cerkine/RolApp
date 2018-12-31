package com.example.cerkine.dam07_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NotasFragment extends Fragment {

    private GeneralActivity application;

    public void setApplication(GeneralActivity application) {
        this.application = application;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View mView = inflater.inflate(R.layout.activity_notas, container, false);

        mView.findViewById(R.id.btnMensaje).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(application,EnviarMensajeActivity.class);
                startActivity(intent);
            }
        });

        return mView;
    }
}
