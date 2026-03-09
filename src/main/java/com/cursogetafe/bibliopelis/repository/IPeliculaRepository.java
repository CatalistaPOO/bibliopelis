package com.cursogetafe.bibliopelis.repository;

import com.cursogetafe.bibliopelis.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPeliculaRepository extends JpaRepository<Pelicula, Integer> {
    List<Pelicula> findByTituloContaining(String titulo);
    List<Pelicula> findByTituloContainingAndGeneroIdGenero(String titulo, Integer idGenero);
}


