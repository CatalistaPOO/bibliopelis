package com.cursogetafe.bibliopelis.model;

import jakarta.persistence.*;

@Entity
public class Pelicula {

    public Pelicula(){};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private String urlThumbnail;
    private String urlVideo;
    @ManyToOne
    @JoinColumn(name = "id_genero")
    private Genero genero;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrlThumbnail() {
        return urlThumbnail;
    }

    public void setUrlThumbnail(String urlThumbnail) {
        this.urlThumbnail = urlThumbnail;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", urlThumnail='" + urlThumbnail + '\'' +
                ", urlVideo='" + urlVideo + '\'' +
                ", genero=" + genero +
                '}';
    }

}
