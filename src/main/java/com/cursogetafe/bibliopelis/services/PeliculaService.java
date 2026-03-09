package com.cursogetafe.bibliopelis.services;

import com.cursogetafe.bibliopelis.model.Pelicula;
import com.cursogetafe.bibliopelis.repository.IPeliculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {
    private IPeliculaRepository iPeliRepo;

    //inyeccion de IPeliculaRepository(herencia de JPARepository)
    public PeliculaService(IPeliculaRepository iPeliRepo) {
        this.iPeliRepo = iPeliRepo;
    }

    public List<Pelicula> getAllPeliculas() {
        return iPeliRepo.findAll();
    }

    public Pelicula createPeli(Pelicula peli) {
        return iPeliRepo.save(peli);
    }

    public void deletePeli(Pelicula peli) {
        iPeliRepo.deleteById(peli.getId());
    }

    public Pelicula getPeliById(int id) {
        return iPeliRepo.findById(id).orElse(null);
    }

    public List<Pelicula> findByTitleAndGenre(String titulo, int idGenero) {
        List<Pelicula> pelis;
        if (idGenero == 0) {
            pelis = iPeliRepo.findByTituloContaining(titulo);
        } else {
            pelis = iPeliRepo.findByTituloContainingAndGeneroIdGenero(titulo, idGenero);
        }
        return pelis;
    }

}

