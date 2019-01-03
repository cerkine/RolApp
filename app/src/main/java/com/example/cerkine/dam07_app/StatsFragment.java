package com.example.cerkine.dam07_app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class StatsFragment extends Fragment {

    List<String> listKey;
    List<String> listValue;
    GeneralActivity application;
    String partida ="";

    public GeneralActivity getApplication() {
        return application;
    }

    public void setApplication(GeneralActivity application) {
        this.application = application;
    }

    public void setListKey(List<String> listKey) {
        this.listKey = listKey;
    }

    public void setListValue(List<String> listValue) {
        this.listValue = listValue;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View mView = inflater.inflate(R.layout.activity_stats, container, false);

        RecyclerView recyclerView = mView.findViewById(R.id.stats_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(application));





        StatsRecyclerAdapter statsRecyclerAdapter = new StatsRecyclerAdapter(listKey,listValue, application,partida);
        recyclerView.setAdapter(statsRecyclerAdapter);

        return mView;
    }

    public List<String> getListKey() {
        return listKey;
    }

    public List<String> getListValue() {
        return listValue;
    }

    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }
}
