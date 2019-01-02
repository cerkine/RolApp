package com.example.cerkine.dam07_app;

import android.os.Parcel;
import android.os.Parcelable;

public class Mensaje implements Parcelable {
    private String origen;
    private String dest;
    private String texto;
    private String titulo;
    private String id;

    public Mensaje(){}

    public Mensaje (String origen, String dest, String texto, String titulo){
        this.dest = dest;
        this.texto = texto;
        this.titulo = titulo;
        this.origen = origen;
    }

    public Mensaje(Parcel in) {
        this.origen = in.readString();
        this.dest = in.readString();
        this.texto = in.readString();
        this.titulo = in.readString();
        this.id = in.readString();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrigen() { return origen; }

    public String getDest() {
        return dest;
    }

    public String getTexto() {
        return texto;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Mensaje{" +
                "origen='" + origen + '\'' +
                ", dest='" + dest + '\'' +
                ", id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", texto=" + texto +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString (this.origen);
        parcel.writeString(this.dest);
        parcel.writeString(this.texto);
        parcel.writeString(this.titulo);
        parcel.writeString(this.id);


    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Mensaje createFromParcel(Parcel in) {
            return new Mensaje(in);
        }

        public Mensaje[] newArray(int size) {
            return new Mensaje[size];
        }
    };
}
