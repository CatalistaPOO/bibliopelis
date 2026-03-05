package com.cursogetafe.bibliopelis.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGenero;
    private String nombre;
    @OneToMany(mappedBy = "genero")
    private  Set<Pelicula> peliculas;

    public Genero(){};

    public Genero(String nombre) {
        this.nombre = nombre;
    }

    public Genero(int idGenero, String name){
        this.idGenero = idGenero;
        this.nombre = nombre;
    };

    public Genero(int idGenero, String nombre, Set<Pelicula> peliculas) {
        this.idGenero = idGenero;
        this.nombre = nombre;
        this.peliculas = peliculas;
    }


    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Genero{" +
                "idgenero=" + idGenero +
                ", nombre='" + nombre + '\'' +
                ", peliculas=" + peliculas +
                '}';
    }
}
