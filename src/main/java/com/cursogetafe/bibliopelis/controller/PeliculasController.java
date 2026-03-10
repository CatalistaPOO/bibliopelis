package com.cursogetafe.bibliopelis.controller;

import com.cursogetafe.bibliopelis.model.Genero;
import com.cursogetafe.bibliopelis.model.Pelicula;
import com.cursogetafe.bibliopelis.services.GeneroService;
import com.cursogetafe.bibliopelis.services.PeliculaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class PeliculasController {
    private GeneroService gs;
    private PeliculaService ps;

    public PeliculasController(GeneroService gs, PeliculaService ps) {
        this.gs = gs;
        this.ps = ps;
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
        this.ps.createPeli(peli);
        return "redirect:/";
    }

    @GetMapping("/detalle/{id}") // Verifica que tenga el /{id}
    public String detallepeli(@PathVariable("id") int id, Model model) {
        Pelicula pelidetalle = this.ps.getPeliById(id);
        if (pelidetalle == null) {
            return "redirect:/"; // Si la peli no existe, vuelve al index
        }
        model.addAttribute("peli", pelidetalle);
        return "detalle";
    }

    @PostMapping("deletePeli")
    public String deletePeli(@ModelAttribute Pelicula peli) {
        this.ps.deletePeli(peli);
        return "redirect:/";
    }

    @PostMapping("buscarpeli")
    public String buscarPeli(@RequestParam String buscarTitulo, @RequestParam int buscarGenero, Model model) {
        List<Genero> generoList = gs.getAllGeneros();
        List<Pelicula> peliculaList = ps.findByTitleAndGenre(buscarTitulo, buscarGenero);
        model.addAttribute("generos", generoList);
        model.addAttribute("peliculas", peliculaList);
        model.addAttribute("numeroResultados", peliculaList.size());
        return "index";
    }

}
