package com.example.cerkine.dam07_app;

public class Mensaje {
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

}
