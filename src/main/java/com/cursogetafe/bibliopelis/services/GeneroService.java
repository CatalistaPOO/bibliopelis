package com.cursogetafe.bibliopelis.services;

import com.cursogetafe.bibliopelis.model.Genero;
import com.cursogetafe.bibliopelis.repository.IGeneroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService {
    private IGeneroRepository iGRepo;
    public GeneroService(IGeneroRepository iGRepo) {
        this.iGRepo = iGRepo;
    }

    public List<Genero> getAllGeneros(){
        return iGRepo.findAll();
    }

    public void createGenero(Genero genero){
        iGRepo.save(genero);
        System.out.println("Creado: " + genero.toString());
    }

    public void deleteGenero(Genero genero){
        iGRepo.delete(genero);
        System.out.println("Borrado: " + genero.toString());
    }

}
