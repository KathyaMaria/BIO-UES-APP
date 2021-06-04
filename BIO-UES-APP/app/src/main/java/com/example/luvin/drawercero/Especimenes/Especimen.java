package com.example.luvin.drawercero.Especimenes;

import androidx.lifecycle.ViewModel;

import java.sql.Time;
import java.util.Date;

public class Especimen extends ViewModel {

    private int id;
    private int idTipoInvestigacion;
    private String lugarColecta;
    private Date fechaColecta;
    private Time horaColecta;
    private String colector;
    private String reino;
    private Float latitud;
    private Float longitud;
    private String tecnicaRecoleccion;
    private String cantidadEsp;
    private String tipoMuestra;
    private String caracteristicas;
    private Float peso;
    private Float tamano;
    private String habitat;


    public Especimen(int id, int idTipoInvestigacion, String lugarColecta, Date fechaColecta, Time horaColecta,
                     String colector, String reino, Float latitud, Float longitud, String tecnicaRecoleccion,
                     String cantidadEsp, String tipoMuestra, String caracteristicas, Float peso, Float tamano,
                     String habitat) {
        this.id=id;
        this.idTipoInvestigacion = idTipoInvestigacion;
        this.lugarColecta = lugarColecta;
        this.fechaColecta = fechaColecta;
        this.horaColecta = horaColecta;
        this.colector = colector;
        this.reino = reino;
        this.latitud = latitud;
        this.longitud = longitud;
        this.tecnicaRecoleccion = tecnicaRecoleccion;
        this.cantidadEsp = cantidadEsp;
        this.tipoMuestra = tipoMuestra;
        this.caracteristicas = caracteristicas;
        this.peso = peso;
        this.tamano = tamano;
        this.habitat = habitat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTipoInvestigacion() {
        return idTipoInvestigacion;
    }

    public void setIdTipoInvestigacion(int idTipoInvestigacion) {
        this.idTipoInvestigacion = idTipoInvestigacion;
    }

    public String getLugarColecta() {
        return lugarColecta;
    }

    public void setLugarColecta(String lugarColecta) {
        this.lugarColecta = lugarColecta;
    }

    public Date getFechaColecta() {
        return fechaColecta;
    }

    public void setFechaColecta(Date fechaColecta) {
        this.fechaColecta = fechaColecta;
    }

    public Time getHoraColecta() {
        return horaColecta;
    }

    public void setHoraColecta(Time horaColecta) {
        this.horaColecta = horaColecta;
    }

    public String getColector() {
        return colector;
    }

    public void setColector(String colector) {
        this.colector = colector;
    }

    public String getReino() {
        return reino;
    }

    public void setReino(String reino) {
        this.reino = reino;
    }

    public Float getLatitud() {
        return latitud;
    }

    public void setLatitud(Float latitud) {
        this.latitud = latitud;
    }

    public Float getLongitud() {
        return longitud;
    }

    public void setLongitud(Float longitud) {
        this.longitud = longitud;
    }

    public String getTecnicaRecoleccion() {
        return tecnicaRecoleccion;
    }

    public void setTecnicaRecoleccion(String tecnicaRecoleccion) {
        this.tecnicaRecoleccion = tecnicaRecoleccion;
    }

    public String getCantidadEsp() {
        return cantidadEsp;
    }

    public void setCantidadEsp(String cantidadEsp) {
        this.cantidadEsp = cantidadEsp;
    }

    public String getTipoMuestra() {
        return tipoMuestra;
    }

    public void setTipoMuestra(String tipoMuestra) {
        this.tipoMuestra = tipoMuestra;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Float getTamano() {
        return tamano;
    }

    public void setTamano(Float tamano) {
        this.tamano = tamano;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

}