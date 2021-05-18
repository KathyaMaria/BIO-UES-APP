package com.example.luvin.drawercero.Coleccion;

import androidx.lifecycle.ViewModel;

public class Coleccion extends ViewModel {

    private int id_coleccion;
    private String nombre_coleccion;
    private String Tipo_coleccion;



    public Coleccion() {
    }

    public Coleccion(int id_coleccion, String nombre_coleccion, String Tipo_coleccion) {
        this.id_coleccion = id_coleccion;
        this.nombre_coleccion = nombre_coleccion;
        this.Tipo_coleccion = Tipo_coleccion;

    }

    public int getId_coleccion() {
        return id_coleccion;
    }

    public void setId_coleccion(int id_coleccion) {
        this.id_coleccion = id_coleccion;
    }

    public String getNombre_coleccion() {
        return nombre_coleccion;
    }

    public void setNombre_coleccion(String nombre_coleccion) {
        this.nombre_coleccion = nombre_coleccion;
    }

    public String getTipo_coleccion() {
        return Tipo_coleccion;
    }

    public void setTipo_coleccion(String Tipo_coleccion) {
        this.Tipo_coleccion = Tipo_coleccion;
    }


    @Override
    public String toString() {
        return nombre_coleccion;
    }
}
