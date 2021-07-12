package com.example.luvin.drawercero.Espamen;

public class Espamen {

    private Integer idEspamen;
    private Integer idRiesgo;
    private  String nombreEspamen;
    private String nombreComEspamen;
    private String catRiesgo;

    public Espamen(Integer idEspamen, Integer idRiesgo, String nombreEspamen, String nombreComEspamen) {
        this.idEspamen = idEspamen;
        this.idRiesgo = idRiesgo;
        this.nombreEspamen = nombreEspamen;
        this.nombreComEspamen = nombreComEspamen;
    }

    public Integer getIdEspamen() {
        return idEspamen;
    }

    public void setIdEspamen(Integer idEspamen) {
        this.idEspamen = idEspamen;
    }

    public Integer getIdRiesgo() {
        return idRiesgo;
    }

    public void setIdRiesgo(Integer idRiesgo) {
        this.idRiesgo = idRiesgo;
    }

    public String getCatRiesgo() {
        return catRiesgo;
    }

    public void setCatRiesgo(String catRiesgo) {
        this.catRiesgo = catRiesgo;
    }

    public String getNomEspamen() {
        return nombreEspamen;
    }

    public void setNomEspamen(String nombreEspamen) {
        this.nombreEspamen = nombreEspamen;
    }

    public Espamen() {
    }

    public String getNomComEspamen() {
        return nombreComEspamen;
    }

    public void setNomComEspamen(String nombreComEspamen) {
        this.nombreComEspamen = nombreComEspamen;
    }

}
