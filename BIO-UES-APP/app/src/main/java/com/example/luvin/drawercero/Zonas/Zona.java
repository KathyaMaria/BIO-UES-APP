package com.example.luvin.drawercero.Zonas;

import androidx.lifecycle.ViewModel;

public class Zona extends ViewModel {

    private Integer id;
    private String nombreZona;
    private String descripcionZona;
    private String lugarZona;
    private Integer idDpto;
    private Integer idMunicipio;
    private String nombreMuniciio;
    private  String nombreDepto;
    private Double latitudZona;
    private Double longitudZona;
    private String habitatZona;

    public Zona() {
    }

    public Zona(int id, String nombreZona, String descripcionZona, String lugarZona, int idDpto, int idMunicipio,
                Double latitudZona, Double longitudZona, String habitatZona) {
        this.id = id;
        this.nombreZona = nombreZona;
        this.descripcionZona = descripcionZona;
        this.lugarZona = lugarZona;
        this.idDpto = idDpto;
        this.idMunicipio = idMunicipio;
        this.latitudZona = latitudZona;
        this.longitudZona = longitudZona;
        this.habitatZona = habitatZona;
    }

    public Integer getIdZona() {
        return id;
    }

    public void setIdZona(Integer id) {
        this.id = id;
    }

    public String getNombreZona() {
        return nombreZona;
    }

    public void setNombreZona(String nombreZona) {
        this.nombreZona = nombreZona;
    }

    public String getDescripcionZona() {
        return descripcionZona;
    }

    public void setDescripcionZona(String descripcionZona) {
        this.descripcionZona = descripcionZona;
    }

    public String getLugarZona() {
        return lugarZona;
    }

    public void setLugarZona(String lugarZona) {
        this.lugarZona = lugarZona;
    }

    public String getNombreMuniciio() {
        return nombreMuniciio;
    }

    public void setNombreMuniciio(String nombreMuniciio) {
        this.nombreMuniciio = nombreMuniciio;
    }

    public String getNombreDepto() {
        return nombreDepto;
    }

    public void setNombreDepto(String nombreDepto) {
        this.nombreDepto = nombreDepto;
    }

    public Integer getIdDpto() {
        return idDpto;
    }

    public void setIdDpto(Integer idDpto) {
        this.idDpto = idDpto;
    }

    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public Double getLatitudZona() {
        return latitudZona;
    }

    public void setLatitudZona(Double latitudZona) {
        this.latitudZona = latitudZona;
    }

    public Double getLongitudZona() {
        return longitudZona;
    }

    public void setLongitudZona(Double longitudZona) {
        this.longitudZona = longitudZona;
    }

    public String getHabitatZona() {
        return habitatZona;
    }

    public void setHabitatZona(String habitatZona) {
        this.habitatZona = habitatZona;
    }

    @Override
    public String toString() {
        return "Zona{" +
                "id=" + id +
                ", nombreZona='" + nombreZona + '\'' +
                ", descripcionZona='" + descripcionZona + '\'' +
                ", lugarZona='" + lugarZona + '\'' +
                ", idDpto=" + idDpto +
                ", idMunicipio=" + idMunicipio +
                ", latitudZona=" + latitudZona +
                ", longitudZona=" + longitudZona +
                ", habitatZona='" + habitatZona + '\'' +
                '}';
    }
}
