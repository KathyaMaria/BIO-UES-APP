package com.example.luvin.drawercero.Dominios;
public class Dominio {

    private Integer id;
    private String nombreDominio;

    public Dominio() {
    }

    public Dominio(Integer id, String nombreDominio) {
        this.id = id;
        this.nombreDominio = nombreDominio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getnombreDominio() {
        return nombreDominio;
    }

    public void setnombreDominio(String nombreDominio) {
        this.nombreDominio = nombreDominio;
    }

    @Override
    public String toString() {
        return "Dominio{" +
                "id=" + id +
                ", nombreDominio='" + nombreDominio + '\'' +
                '}';
    }
}
