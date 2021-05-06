package com.example.luvin.drawercero;

public class Dato {
    private String titulo;
    private String subtitulo;
    private int imagen;
    private String contenido;

    // Constructor de la clase
    public Dato(String titulo, String subtitulo, int imagen, String contenido) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.imagen = imagen;
        this.contenido = contenido;
    }

    // Metodos setter y getter
    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setContenido(String contenido){
        this.contenido = contenido;
    };

    public int getImagen() {
        return imagen;
    }

    public String getContenido() {
        return contenido;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

}