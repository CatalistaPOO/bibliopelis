package com.cursogetafe.bibliopelis.services;

import com.cursogetafe.bibliopelis.model.Pelicula;
import com.cursogetafe.bibliopelis.repository.IPeliculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService {
    private IPeliculaRepository iPeliRepo;
    public PeliculaService(IPeliculaRepository iPeliRepo) {
        this.iPeliRepo = iPeliRepo;
    }

    public List<Pelicula> getAllPeliculas(){
        return iPeliRepo.findAll();
    }
}

