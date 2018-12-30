package com.example.cerkine.dam07_app;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Clase {

//    private String[] tipo= {"Guerrero","Mago","Cazador"};


    public Clase (){

    }

    public Clase(String partida, String nombre, String edad, String altura, String peso, String dinero, String vida, String ataque, String defensa, String agilidad, String fuerza, String espiritu, String destreza, String resistencia, String suerte, String intelecto, String sabiduria, String tipo) {
        this.partida = partida;
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
        this.dinero = dinero;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.agilidad = agilidad;
        this.fuerza = fuerza;
        this.espiritu = espiritu;
        this.destreza = destreza;
        this.resistencia = resistencia;
        this.suerte = suerte;
        this.intelecto = intelecto;
        this.sabiduria = sabiduria;
        this.tipo = tipo;
    }

    @PrimaryKey@NonNull
    private String key ;
    public void setKey(String nada) { key =partida+nombre;}

    public String getKey(){return key;}

    private String partida;
    private String nombre;


    private String tipo ;

    private String edad;
    private String altura;
    private String peso;
    private String dinero;
    private String vida;
    private String ataque;
    private String defensa;
    private String agilidad;
    private String fuerza;
    private String espiritu;
    private String destreza;
    private String resistencia;
    private String suerte;
    private String intelecto;
    private String sabiduria;
    private String sexo;
    private String honorifico;

//
//    public String[] getTipo() {
//        return tipo;
//    }
//
//    public void setTipo(String[] tipo) {
//        this.tipo = tipo;
//    }

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

    public String getVida() {
        return vida;
    }

    public void setVida(String vida) {
        this.vida = vida;
    }

    public String getAtaque() {
        return ataque;
    }

    public void setAtaque(String ataque) {
        this.ataque = ataque;
    }

    public String getDefensa() {
        return defensa;
    }

    public void setDefensa(String defensa) {
        this.defensa = defensa;
    }

    public String getAgilidad() {
        return agilidad;
    }

    public void setAgilidad(String agilidad) {
        this.agilidad = agilidad;
    }

    public String getFuerza() {
        return fuerza;
    }

    public void setFuerza(String fuerza) {
        this.fuerza = fuerza;
    }

    public String getEspiritu() {
        return espiritu;
    }

    public void setEspiritu(String espiritu) {
        this.espiritu = espiritu;
    }

    public String getDestreza() {
        return destreza;
    }

    public void setDestreza(String destreza) {
        this.destreza = destreza;
    }

    public String getResistencia() {
        return resistencia;
    }

    public void setResistencia(String resistencia) {
        this.resistencia = resistencia;
    }

    public String getSuerte() {
        return suerte;
    }

    public void setSuerte(String suerte) {
        this.suerte = suerte;
    }

    public String getIntelecto() {
        return intelecto;
    }

    public void setIntelecto(String intelecto) {
        this.intelecto = intelecto;
    }

    public String getSabiduria() {
        return sabiduria;
    }

    public void setSabiduria(String sabiduria) {
        this.sabiduria = sabiduria;
    }

    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public String getTipo(){ return tipo;}

    public void setTipo(String tipo){ this.tipo = tipo;}

    public String getSexo(){return sexo;}

    public void setSexo(String sexo){ this.sexo = sexo;}

    public String getHonorifico(){ return honorifico;}

    public void setHonorifico(String honorifico){ this.honorifico = honorifico;}




}
