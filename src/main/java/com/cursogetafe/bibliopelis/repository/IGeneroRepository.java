package com.cursogetafe.bibliopelis.repository;

import com.cursogetafe.bibliopelis.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//Añade Genero, de la clase y Integer que apunta al id
public interface IGeneroRepository extends JpaRepository<Genero, Integer> {
}
