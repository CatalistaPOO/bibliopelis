package com.cursogetafe.bibliopelis.controller;

import com.cursogetafe.bibliopelis.model.Genero;
import com.cursogetafe.bibliopelis.services.GeneroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    private GeneroService gs;
    public MainController(GeneroService gs){
        this.gs = gs;
    }

    @GetMapping("/")
    public String getMainPage(Model model)  {
        List<Genero> genresList = gs.getAllGeneros();
        model.addAttribute("genreList", genresList);
        return "index";
    }

    @GetMapping("/creargeneros")
    public String createGeneros(Model model)  {
        for (int i=0;i<10;i++){
            this.gs.createGenero(new Genero("Genero" + i));
        }
        return "creargeneros";
    }

}
