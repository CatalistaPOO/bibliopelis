package com.cursogetafe.bibliopelis.controller;

import com.cursogetafe.bibliopelis.model.Genero;
import com.cursogetafe.bibliopelis.model.Pelicula;
import com.cursogetafe.bibliopelis.services.GeneroService;
import com.cursogetafe.bibliopelis.services.PeliculaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {
    private GeneroService gs;
    private PeliculaService ps;

    public MainController(GeneroService gs, PeliculaService ps) {
        this.gs = gs;
        this.ps = ps;
    }

    @GetMapping("/")
    public String getMainPage(Model model) {

        List<Genero> genresList = gs.getAllGeneros();
        model.addAttribute("listaGeneros", genresList);

        List<Pelicula> todasLasPelis = ps.getAllPeliculas(); // Asegurar de que este método existe en el service
        model.addAttribute("peliculas", todasLasPelis);
        model.addAttribute("generosexistentes",gs.getAllGeneros());

        return "index"; // según se llame el archivo html
    }

    //este mapping es un apaño rapido para crear los generos, debería hacerse de otra manera
    @GetMapping("/creargeneros")
    public String createGeneros(Model model) {
        for (int i = 0; i < 10; i++) {
            this.gs.createGenero(new Genero("Genero" + i));
        }
        return "creargeneros";
    }

}
