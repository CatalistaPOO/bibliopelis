package com.cursogetafe.bibliopelis.controller;

import com.cursogetafe.bibliopelis.model.Genero;
import com.cursogetafe.bibliopelis.model.Pelicula;
import com.cursogetafe.bibliopelis.services.GeneroService;
import com.cursogetafe.bibliopelis.services.PeliculaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    //    @GetMapping("/")
//    public String getMainPage(Model model) {
//        List<Genero> genresList = gs.getAllGeneros();
//        model.addAttribute("genreList", genresList);
//        return "index";
//    }
    @GetMapping("/")
    public String getMainPage(Model model) {
        // 1. Cargamos los géneros para el buscador
        List<Genero> genresList = gs.getAllGeneros();
        model.addAttribute("genreList", genresList);

        // 2. Cargamos las películas para la cuadrícula (PASO FALTANTE)
        List<Pelicula> todasLasPelis = ps.getAllPeliculas(); // Asegúrate de que este método existe en tu service
        model.addAttribute("peliculas", todasLasPelis);

        return "index"; // O "main" según se llame tu archivo html
    }

    @GetMapping("/creargeneros")
    public String createGeneros(Model model) {
        for (int i = 0; i < 10; i++) {
            this.gs.createGenero(new Genero("Genero" + i));
        }
        return "creargeneros";
    }

    @GetMapping("/crearpeli")
    public String crearpelicula(Model model) {
        model.addAttribute("peli", new Pelicula());
        // Enviamos todos los géneros que hay en la base de datos
        model.addAttribute("listaGeneros", gs.getAllGeneros());
        return "crearpeli";
    }

    @PostMapping("/crearpeli")
    public String creapeli(@ModelAttribute Pelicula peli, Model model) {
        this.ps.createpeli(peli);
        return "redirect:/";
    }


}
