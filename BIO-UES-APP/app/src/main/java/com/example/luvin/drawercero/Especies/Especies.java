package com.example.luvin.drawercero.Especies;

import androidx.lifecycle.ViewModel;

public class Especies extends ViewModel {

    private String  nombreEspecie;
    private String idEspecie;
    private String  nombreGenero;
    private Integer idGenero;
    private String  nombreFamilia;
    private Integer idFamilia;
    private String nombreOrden;
    private Integer idOrden;
    private String nombreClase;
    private Integer idClase;
    private String nombreFilum;
    private Integer idFilum;
    private  String nombreReino;
    private Integer idReino;
    private String nombreDominio;
    private Integer idDominio;

    public Especies(String nombreEspecie, String idEspecie, String nombreGenero, Integer idGenero, String nombreFamilia,
                           Integer idFamilia, String nombreOrden, Integer idOrden, String nombreClase, Integer idClase,
                           String nombreFilum, Integer idFilum, String nombreReino, Integer idReino, String nombreDominio,
                           Integer idDominio) {
        this.nombreEspecie = nombreEspecie;
        this.idEspecie = idEspecie;
        this.nombreGenero = nombreGenero;
        this.idGenero = idGenero;
        this.nombreFamilia = nombreFamilia;
        this.idFamilia = idFamilia;
        this.nombreOrden = nombreOrden;
        this.idOrden = idOrden;
        this.nombreClase = nombreClase;
        this.idClase = idClase;
        this.nombreFilum = nombreFilum;
        this.idFilum = idFilum;
        this.nombreReino = nombreReino;
        this.idReino = idReino;
        this.nombreDominio = nombreDominio;
        this.idDominio = idDominio;
    }

    public Especies() {
    }

    public String getNombreEspecie() {
        return nombreEspecie;
    }

    public void setNombreEspecie(String nombreEspecie) {
        this.nombreEspecie = nombreEspecie;
    }

    public String getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(String idEspecie) {
        this.idEspecie = idEspecie;
    }

    public String getNombreGenero() {
        return nombreGenero;
    }

    public void setNombreGenero(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }

    public Integer getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public String getNombreFamilia() {
        return nombreFamilia;
    }

    public void setNombreFamilia(String nombreFamilia) {
        this.nombreFamilia = nombreFamilia;
    }

    public Integer getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(Integer idFamilia) {
        this.idFamilia = idFamilia;
    }

    public String getNombreOrden() {
        return nombreOrden;
    }

    public void setNombreOrden(String nombreOrden) {
        this.nombreOrden = nombreOrden;
    }

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public String getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }

    public Integer getIdClase() {
        return idClase;
    }

    public void setIdClase(Integer idClase) {
        this.idClase = idClase;
    }

    public String getNombreFilum() {
        return nombreFilum;
    }

    public void setNombreFilum(String nombreFilum) {
        this.nombreFilum = nombreFilum;
    }

    public Integer getIdFilum() {
        return idFilum;
    }

    public void setIdFilum(Integer idFilum) {
        this.idFilum = idFilum;
    }

    public String getNombreReino() {
        return nombreReino;
    }

    public void setNombreReino(String nombreReino) {
        this.nombreReino = nombreReino;
    }

    public Integer getIdReino() {
        return idReino;
    }

    public void setIdReino(Integer idReino) {
        this.idReino = idReino;
    }

    public String getNombreDominio() {
        return nombreDominio;
    }

    public void setNombreDominio(String nombreDominio) {
        this.nombreDominio = nombreDominio;
    }

    public Integer getIdDominio() {
        return idDominio;
    }

    public void setIdDominio(Integer idDominio) {
        this.idDominio = idDominio;
    }
}
