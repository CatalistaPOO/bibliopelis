package com.cursogetafe.bibliopelis.repository;

import com.cursogetafe.bibliopelis.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPeliculaRepository extends JpaRepository<Pelicula, Integer> {

}


