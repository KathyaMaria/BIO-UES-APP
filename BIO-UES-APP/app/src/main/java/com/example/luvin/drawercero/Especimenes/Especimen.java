package com.example.luvin.drawercero.Especimenes;

import java.sql.Time;
import java.util.Date;

public class Especimen {

    private int idEspecimen;
    private int idTaxonomia;
    private int idSecuencia;
    private int idEspecie;
    private Date fechaColecta;
    private Time horaSec;
    private String colector;
    private String codigoEspecimen;
    private Float latitud;
    private Float longitud;
    private String tecnicaRecoleccion;
    private String cantidadEsp;
    private String tipoMuestra;
    private String caracteristicas;
    private Float peso;
    private Float tamano;
    private String habitat;


    public Especimen() {
    }

    public Especimen(int idEspecimen, int idTaxonomia, int idSecuencia, int idEspecie, Date fechaColecta, Time horaSec, String colector,
                     String codigoEspecimen, Float latitud, Float longitud, String tecnicaRecoleccion,
                     String cantidadEsp, String tipoMuestra, String caracteristicas, Float peso, Float tamano, String habitat) {
        this.idEspecimen = idEspecimen;
        this.idTaxonomia = idTaxonomia;
        this.idSecuencia = idSecuencia;
        this.idEspecie = idEspecie;
        this.fechaColecta = fechaColecta;
        this.horaSec = horaSec;
        this.colector = colector;
        this.codigoEspecimen = codigoEspecimen;
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

    public int getIdEspecimen() {
        return idEspecimen;
    }

    public void setIdEspecimen(int idEspecimen) {
        this.idEspecimen = idEspecimen;
    }

    public int getIdTaxonomia() {
        return idTaxonomia;
    }

    public void setIdTaxonomia(int idTaxonomia) {
        this.idTaxonomia = idTaxonomia;
    }

    public int getIdSecuencia() {
        return idSecuencia;
    }

    public void setIdSecuencia(int idSecuencia) {
        this.idSecuencia = idSecuencia;
    }

    public int getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(int idEspecie) {
        this.idEspecie = idEspecie;
    }

    public Date getFechaColecta() {
        return fechaColecta;
    }

    public void setFechaColecta(Date fechaColecta) {
        this.fechaColecta = fechaColecta;
    }

    public Time getHoraSec() {
        return horaSec;
    }

    public void setHoraSec(Time horaSec) {
        this.horaSec = horaSec;
    }

    public String getColector() {
        return colector;
    }

    public void setColector(String colector) {
        this.colector = colector;
    }

    public String getCodigoEspecimen() {
        return codigoEspecimen;
    }

    public void setCodigoEspecimen(String codigoEspecimen) {
        this.codigoEspecimen = codigoEspecimen;
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