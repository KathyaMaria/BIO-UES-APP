package com.example.luvin.drawercero.Investigaciones;

import java.util.Date;

public class Investigacion {

    private int idColeccion;
    private int idUsuario;
    private int idTipo;
    private int idZona;
    private String nombreInv;
    private Date fechaIngreso;
    private String lugarInv;
    private String responsableInv;
    private String objetivo;
    private String contacto;
    private String unidadEnc;
    private String otrasInst;
    private String doc;
    private String descripcionInv;
    private String correo;



    public Investigacion() {
    }

    public Investigacion(int idColeccion, int idUsuario, int idTipo, int idZona,
                         String nombreInv, Date fechaIngreso, String lugarInv, String responsableInv,
                         String objetivo, String contacto, String unidadEnc, String otrasInst, String doc,
                         String descripcionInv, String correo) {
        this.idColeccion = idColeccion;
        this.idUsuario = idUsuario;
        this.idTipo = idTipo;
        this.idZona = idZona;
        this.nombreInv = nombreInv;
        this.fechaIngreso = fechaIngreso;
        this.lugarInv = lugarInv;
        this.responsableInv = responsableInv;
        this.objetivo = objetivo;
        this.contacto = contacto;
        this.unidadEnc = unidadEnc;
        this.otrasInst = otrasInst;
        this.doc = doc;
        this.descripcionInv = descripcionInv;
        this.correo = correo;
    }

    public int getIdColeccion() {
        return idColeccion;
    }

    public void setIdColeccion(int idColeccion) {
        this.idColeccion = idColeccion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public int getIdZona() {
        return idZona;
    }

    public void setIdZona(int idZona) {
        this.idZona = idZona;
    }

    public String getNombreInv() {
        return nombreInv;
    }

    public void setNombreInv(String nombreInv) {
        this.nombreInv = nombreInv;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getLugarInv() {
        return lugarInv;
    }

    public void setLugarInv(String lugarInv) {
        this.lugarInv = lugarInv;
    }

    public String getResponsableInv() {
        return responsableInv;
    }

    public void setResponsableInv(String responsableInv) {
        this.responsableInv = responsableInv;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getUnidadEnc() {
        return unidadEnc;
    }

    public void setUnidadEnc(String unidadEnc) {
        this.unidadEnc = unidadEnc;
    }

    public String getOtrasInst() {
        return otrasInst;
    }

    public void setOtrasInst(String otrasInst) {
        this.otrasInst = otrasInst;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getDescripcionInv() {
        return descripcionInv;
    }

    public void setDescripcionInv(String descripcionInv) {
        this.descripcionInv = descripcionInv;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Investigacion{" +
                "nombreInv='" + nombreInv + '\'' +
                '}';
    }
}
