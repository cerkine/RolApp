package com.example.cerkine.dam07_app;

class Clase {


    public Clase (){

    }

    public Clase(String partida, String nombre, String edad, String altura, String peso, String dinero, String clase, String nivel, String puntos) {
        this.partida = partida;
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
        this.dinero = dinero;
        this.clase = clase;
        this.nivel = nivel;
        this.puntos = puntos;
    }

    private String key ;
    public void setKey(String nada) { key =partida+","+nombre;}

    public String getKey(){return key;}

    private String partida;
    private String nombre;




    private String clase;

    private String edad;
    private String altura;
    private String peso;
    private String dinero;
    private String raza;
    private String sexo;
    private String honorifico;
    private String nivel;
    private String puntos ="20";

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getPuntos() {
        return puntos;
    }

    public void setPuntos(String puntos) {
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getDinero() {
        return dinero;
    }

    public void setDinero(String dinero) {
        this.dinero = dinero;
    }



    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public String getClase(){ return clase;}

    public void setClase(String clase){ this.clase = clase;}

    public String getSexo(){return sexo;}

    public void setSexo(String sexo){ this.sexo = sexo;}

    public String getHonorifico(){ return honorifico;}

    public void setHonorifico(String honorifico){ this.honorifico = honorifico;}




}
